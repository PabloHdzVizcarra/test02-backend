package com.example.resttest02.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.resttest02.dto.ClientDto;
import com.example.resttest02.dto.ClientRequest;
import com.example.resttest02.mapper.ClientMapper;
import com.example.resttest02.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {
  private ClientService service;
  @Mock private ClientRepository repository;
  @Mock private BCryptPasswordEncoder encoder;
  @Mock private ClientMapper mapper;

  @BeforeEach
  void setUp() {
    service = new ClientServiceImpl(repository, encoder, mapper);
  }

  @Test
  void mustBeCreateUser() {
    ClientRequest clientRequest = new ClientRequest();
    clientRequest.setApellidos("connor");
    clientRequest.setNombre("john");
    clientRequest.setContraseña("admin123");
    clientRequest.setNombre_usuario("king19");
    clientRequest.setCorreo_electronico("example@example.com");

    ClientDto dto = service.create(clientRequest);

    assertNotNull(dto.getApellidos());
  }
}
