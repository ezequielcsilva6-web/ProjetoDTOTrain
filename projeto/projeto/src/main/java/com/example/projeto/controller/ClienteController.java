package com.example.projeto.controller;

import com.example.projeto.dto.ClienteRequestDTO;
import com.example.projeto.dto.ClienteResponseDTO;
import com.example.projeto.entity.ClienteEntity;
import com.example.projeto.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodos() {
        return ResponseEntity
                .ok()
                .body(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<?,?>> salvar(
            @Valid
            @RequestBody ClienteRequestDTO dto) {
        service.salvar(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cliente salvo com sucesso!"));

    }

    @PutMapping
    public ResponseEntity<Map<?,?>> atualizar(
            @PathVariable Long Id,
            @Valid @RequestBody ClienteRequestDTO dto) {
        service.atualizar(Id, dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente atualizado com sucesso!"));
    }

    @DeleteMapping
    public ResponseEntity<Map<?,?>> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente removido com sucesso!"));
    }
}
