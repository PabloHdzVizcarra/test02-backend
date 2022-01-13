package com.example.resttest02.domain;

import com.example.resttest02.dto.ClientDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DefaultResponse {
  private ClientDto dto;
  private String cveMessage;
  private String cveError;
}
