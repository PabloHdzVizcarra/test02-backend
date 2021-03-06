package com.example.resttest02.mapper;

import com.example.resttest02.domain.Client;
import com.example.resttest02.dto.ClientDto;
import com.example.resttest02.dto.ClientFullDto;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  @Mapping(
      target = "fecha_creacion",
      expression = "java(dateISOFormat(client.getFecha_creacion()))")
  @Mapping(
      target = "fecha_actualizacion",
      expression = "java(dateISOFormat(client.getFecha_actualizacion()))")
  ClientDto clientToClientDto(Client client);

  @Mapping(
      target = "fecha_creacion",
      expression = "java(dateISOFormat(client.getFecha_creacion()))")
  @Mapping(
      target = "fecha_actualizacion",
      expression = "java(dateISOFormat(client.getFecha_actualizacion()))")
  ClientFullDto clientToClientFullDto(Client client);

  default String dateISOFormat(Long date) {
    TimeZone timeZone = TimeZone.getDefault();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
    dateFormat.setTimeZone(timeZone);
    return dateFormat.format(new Date(date));
  }
}
