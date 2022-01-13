package com.example.resttest02.service;

import com.example.resttest02.dto.ClientDto;
import com.example.resttest02.dto.ClientFullDto;
import com.example.resttest02.dto.ClientRequest;
import com.example.resttest02.dto.UpdateClientRequest;
import java.util.Collection;

public interface ClientService {
  ClientDto create(ClientRequest clientRequest);

  ClientDto get(String id);

  Collection<ClientDto> getAll();

  ClientFullDto update(UpdateClientRequest request, String id);
}
