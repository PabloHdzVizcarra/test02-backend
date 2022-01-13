package com.example.resttest02.domain;

import com.example.resttest02.dto.ClientDto;
import java.util.Collection;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DefaultResponse {
  private ClientDto dto;
  private String CVE_Error;
  private String CVE_Mensaje;
  private Collection<ClientDto> clientList;
}
