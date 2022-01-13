package com.example.resttest02.service;

import com.example.resttest02.dto.ClientDto;
import com.example.resttest02.dto.ClientRequest;

public interface ClientService {
  ClientDto create(ClientRequest clientRequest);
}
