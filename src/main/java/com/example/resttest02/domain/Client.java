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
  private Double IMC;
  private Double GEB;
  private Double ETA;
  private Long fechaCreacion;
  private Long fechaActualizacion;

  public Client() {
    setDateCreated();
  }

  protected void setDateCreated() {
    if (this.fechaCreacion == null) fechaCreacion = new Date().getTime();
    if (this.fechaActualizacion == null) fechaActualizacion = new Date().getTime();
  }

  protected void setDateUpdated() {
    this.fechaActualizacion = new Date().getTime();
  }
}