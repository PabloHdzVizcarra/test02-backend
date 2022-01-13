package com.example.resttest02.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/NutriNet/Cliente")
public class ClienteResource {

  @PostMapping
  public ResponseEntity<String> create() {
    return ResponseEntity.ok("create new client");
  }

  @GetMapping("/{clientID}")
  public ResponseEntity<String> get(@PathVariable Integer clientID) {
    return ResponseEntity.ok("get by id");
  }

  @GetMapping
  public ResponseEntity<String> getAll() {
    return ResponseEntity.ok("get all");
  }

  @PutMapping("/{clientID}")
  public ResponseEntity<String> update(@PathVariable Integer clientID) {
    return ResponseEntity.ok("update client");
  }

}
