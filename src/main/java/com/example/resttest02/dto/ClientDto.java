package com.example.resttest02.dto;

import lombok.Data;

@Data
public class ClientDto {
  private String client_id;
  private String nombre_usuario;
  private String nombre;
  private String apellidos;
  private String correo_electronico;
  private String fecha_creacion;
  private String fecha_actualizacion;
}
