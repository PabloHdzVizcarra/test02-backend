package com.example.resttest02.exception;

public class ClientAlreadyRegistered extends RuntimeException {

  public ClientAlreadyRegistered(String email) {
    super(
        "el cliente con el email: "
            + email
            + " ya fue registrado anteriormente, ingresa un email diferente");
  }
}
