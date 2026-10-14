package com.example.projeto.service;

import com.example.projeto.dto.ClienteRequestDTO;
import com.example.projeto.dto.ClienteResponseDTO;
import com.example.projeto.entity.ClienteEntity;
import com.example.projeto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@org.springframework.stereotype.Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<ClienteResponseDTO> listarTodos() {
        return repository
                .findAll()
                .stream()
                .map(clienteEntity -> new ClienteResponseDTO(
                        clienteEntity.getNome(),
                        clienteEntity.getEmail(),
                        clienteEntity.getTelefone()))
                .toList();
    }

    public ClienteEntity salvar(ClienteRequestDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Cliente já cadastrado!");
        }
            ClienteEntity novoCliente = new ClienteEntity();
            novoCliente.setNome(dto.getNome());
            novoCliente.setEmail(dto.getEmail());
            novoCliente.setTelefone(dto.getTelefone());

            return repository.save(novoCliente);
        }

    public ClienteEntity atualizar(Long id, ClienteRequestDTO dto) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Cliente não cadastrado!");

        ClienteEntity novoCliente = new ClienteEntity();
        novoCliente.setNome(dto.getNome());
        novoCliente.setEmail(dto.getEmail());
        novoCliente.setTelefone(dto.getTelefone());

        return repository.save(novoCliente);
        }

        public void excluir(Long id) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Cliene não encontrado!");

        repository.deleteById(id);

    }

}
