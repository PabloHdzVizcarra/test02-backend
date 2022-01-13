package com.example.resttest02.mapper;

import com.example.resttest02.domain.Client;
import com.example.resttest02.dto.ClientDto;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  @Mapping(
      target = "fechaCreacion",
      expression = "java(dateISOFormat(client.getFechaCreacion()))")
  @Mapping(
      target = "fechaActualizacion",
      expression = "java(dateISOFormat(client.getFechaActualizacion()))")
  ClientDto clientToClientDto(Client client);

  default String dateISOFormat(Long date) {
    TimeZone timeZone = TimeZone.getDefault();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
    dateFormat.setTimeZone(timeZone);
    return dateFormat.format(new Date(date));
  }
}
