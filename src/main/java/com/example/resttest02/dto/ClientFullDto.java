package com.example.resttest02.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientFullDto {
  private String client_id;
  private String nombre_usuario;
  private String nombre;
  private String apellidos;
  private String correo_electronico;
  private String fecha_creacion;
  private String fecha_actualizacion;
  private Integer edad;
  private Double estatura;
  private Double peso;
  private Integer GEB;
}
