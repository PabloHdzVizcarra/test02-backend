package com.example.resttest02.exception;

public class ClientAlreadyRegistered extends RuntimeException {

  public ClientAlreadyRegistered(String email) {
    super(
        "el cliente con el campo: "
            + email
            + " ya fue registrado anteriormente, ingresa un email o nombre de usuario diferente");
  }
}
