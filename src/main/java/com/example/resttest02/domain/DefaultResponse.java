package com.example.resttest02.domain;

import com.example.resttest02.dto.ClientDto;
import com.example.resttest02.dto.ClientFullDto;
import java.util.Collection;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class DefaultResponse {
  private ClientFullDto dto;
  private ClientFullDto clientUpdated;
  private String CVE_Error;
  private String CVE_Mensaje;
  private Collection<ClientFullDto> clientList;
}
