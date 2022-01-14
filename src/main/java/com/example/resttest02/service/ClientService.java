package com.example.resttest02.service;

import com.example.resttest02.dto.ClientFullDto;
import com.example.resttest02.dto.ClientRequest;
import com.example.resttest02.dto.UpdateClientRequest;
import java.util.List;

public interface ClientService {
  ClientFullDto create(ClientRequest clientRequest);

  ClientFullDto get(String id);

  List<ClientFullDto> getAll();

  ClientFullDto update(UpdateClientRequest request, String id);
}
