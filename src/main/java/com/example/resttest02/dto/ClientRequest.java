package com.example.resttest02.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientRequest {

  @NotEmpty(message = "el nombre es requerido")
  @Size(min = 3, max = 55, message = "el nombre debe ser mayor a 3 caracteres")
  private String nombre;

  @NotEmpty(message = "los apellidos son requeridos")
  @Size(min = 3, max = 55, message = "el apellido debe ser mayor a 3 caracteres")
  private String apellidos;

  @NotEmpty(message = "el nombre de usuario es requerido")
  @Size(min = 1, max = 55, message = "el nombre de usuario debe ser mayor o igual a 1 caracter")
  private String nombre_usuario;

  @NotEmpty(message = "la direccion de correo es requerida.")
  @Email(message = "el email debe ser valido ej:example@example.com")
  private String correo_electronico;

  @NotEmpty(message = "la contraseña es requerido")
  @Size(
      min = 8,
      max = 55,
      message = "la contraseña de usuario debe ser mayor o igual a 8 " + "caracteres")
  private String contraseña;

}
