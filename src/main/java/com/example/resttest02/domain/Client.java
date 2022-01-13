package com.example.resttest02.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "client")
public class Client {
  @Id private String client_id;

  @Indexed(unique = true)
  private String nombre_usuario;

  private String nombre;
  private String apellidos;
  private String contraseña;

  @Indexed(unique = true)
  private String correo_electronico;

  private Integer edad;
  private Double estatura;
  private Double peso;
  private Integer GEB;
  private Double IMC;
  private Double ETA;
  private Long fecha_creacion;
  private Long fecha_actualizacion;

  public Client() {
    setDateCreated();
  }

  protected void setDateCreated() {
    if (this.fecha_creacion == null) fecha_creacion = new Date().getTime();
    if (this.fecha_actualizacion == null) fecha_actualizacion = new Date().getTime();
  }

  protected void setDateUpdated() {
    this.fecha_actualizacion = new Date().getTime();
  }
}
