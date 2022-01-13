package com.example.resttest02.service;

import com.example.resttest02.domain.Client;
import com.example.resttest02.dto.ClientDto;
import com.example.resttest02.dto.ClientRequest;
import com.example.resttest02.mapper.ClientMapper;
import com.example.resttest02.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
  private final ClientRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final ClientMapper mapper;

  @Override
  public ClientDto create(ClientRequest request) {
    Client client = new Client();

    client.setNombre_usuario(request.getNombre_usuario());
    client.setApellidos(request.getApellidos());
    client.setNombre(request.getNombre());
    client.setCorreo_electronico(request.getCorreo_electronico());
    client.setContraseña(passwordEncoder.encode(request.getContraseña()));

    Client savedClient = repository.save(client);
    return mapper.clientToClientDto(savedClient);

  }
}
