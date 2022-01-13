package com.example.resttest02.service;

import com.example.resttest02.dto.ClientDto;
import com.example.resttest02.dto.ClientRequest;
import java.util.Collection;

public interface ClientService {
  ClientDto create(ClientRequest clientRequest);

  ClientDto get(String id);

  Collection<ClientDto> getAll();
}
