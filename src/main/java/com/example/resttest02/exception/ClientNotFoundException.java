package com.example.resttest02.exception;

public class ClientNotFoundException extends RuntimeException{

  public ClientNotFoundException(String id) {
    super("el cliente con el id: " + id + " no existe");
  }
}
