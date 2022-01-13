package com.example.resttest02.service;

import com.example.resttest02.domain.Client;
import com.example.resttest02.dto.ClientDto;
import com.example.resttest02.dto.ClientRequest;
import com.example.resttest02.mapper.ClientMapper;
import com.example.resttest02.repository.ClientRepository;
import java.util.Optional;
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
  public ClientDto create(ClientRequest request) {
    Client client = createUser(request);
    Client savedClient = repository.save(client);
    return mapper.clientToClientDto(savedClient);
  }

  private Client createUser(ClientRequest request) {
    verifyUserExists(request);
    Client client = new Client();

    client.setNombre_usuario(request.getNombre_usuario());
    client.setApellidos(request.getApellidos());
    client.setNombre(request.getNombre());
    client.setCorreo_electronico(request.getCorreo_electronico());
    client.setContraseña(hashPassword(request));

    return client;
  }

  private void verifyUserExists(ClientRequest request) {
    String email = request.getCorreo_electronico();
    Optional<Client> optionalClient = repository.getClientByCorreo(email);

    if (optionalClient.isPresent()){
      throw new RuntimeException(
          "el cliente con el email: "
              + email
              + " ya fue registrado anteriormente, ingresa un email diferente");
    }
  }

  private String hashPassword(ClientRequest request) {
    return passwordEncoder.encode(request.getContraseña());
  }
}
