package com.example.resttest02.service;

import com.example.resttest02.domain.Client;
import com.example.resttest02.dto.ClientFullDto;
import com.example.resttest02.dto.ClientRequest;
import com.example.resttest02.dto.UpdateClientRequest;
import com.example.resttest02.exception.ClientAlreadyRegistered;
import com.example.resttest02.exception.ClientNotFoundException;
import com.example.resttest02.mapper.ClientMapper;
import com.example.resttest02.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {
  private final ClientRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final ClientMapper mapper;

  @Override
  public ClientFullDto create(ClientRequest request) {
    verifyClientByEmail(request);
    verifyClientByUsername(request.getNombre_usuario());
    Client savedClient = saveClientDatabase(request);
    log.info("success client creation");
    return mapper.clientToClientFullDto(savedClient);
  }

  @Override
  public ClientFullDto get(String id) {
    Client optionalClient =
        repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));

    log.info("get client with id: {}", id);
    return mapper.clientToClientFullDto(optionalClient);
  }

  @Override
  public List<ClientFullDto> getAll() {
    log.info("get all clients");
    List<Client> clientList = repository.findAll();
    return clientList.stream()
        .map(mapper::clientToClientFullDto)
        .collect(Collectors.toUnmodifiableList());
  }

  @Override
  public ClientFullDto update(UpdateClientRequest request, String id) {
    Client client = repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    Client updatedClient = updateClient(request, client);
    log.info("the client with id: " + id + " was be updated");
    return mapper.clientToClientFullDto(updatedClient);
  }

  private Client updateClient(UpdateClientRequest request, Client client) {
    client.updateClient(client, request);
    return repository.save(client);
  }

  private void verifyClientByUsername(String username) {
    Optional<Client> optionalClient = repository.getClientByUsername(username);
    if (optionalClient.isPresent()) {
      throw new ClientAlreadyRegistered(username);
    }
  }

  private Client saveClientDatabase(ClientRequest request) {
    Client client = createUser(request);
    return repository.save(client);
  }

  private Client createUser(ClientRequest request) {
    Client client = new Client();

    client.setNombre_usuario(request.getNombre_usuario());
    client.setApellidos(request.getApellidos());
    client.setNombre(request.getNombre());
    client.setCorreo_electronico(request.getCorreo_electronico());
    client.setContraseña(hashPassword(request));

    return client;
  }

  private void verifyClientByEmail(ClientRequest request) {
    String email = request.getCorreo_electronico();
    Optional<Client> optionalClient = repository.getClientByCorreo(email);

    if (optionalClient.isPresent()) {
      throw new ClientAlreadyRegistered(email);
    }
  }

  private String hashPassword(ClientRequest request) {
    return passwordEncoder.encode(request.getContraseña());
  }
}
