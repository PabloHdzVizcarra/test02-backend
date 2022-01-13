package com.example.resttest02.api;

import com.example.resttest02.dto.ClientRequest;
import com.example.resttest02.service.ClientService;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/NutriNet/Cliente")
@Validated
@AllArgsConstructor
public class ClienteResource {

  private final ClientService clientService;

  @PostMapping
  public ResponseEntity<ClientRequest> create(@Valid @RequestBody ClientRequest request) {
    clientService.create(request);
    return ResponseEntity.ok(request);
  }

  @GetMapping("/{clientID}")
  public ResponseEntity<Integer> get(@PathVariable("clientID") @Valid @Min(1) Integer clientID ) {
    return ResponseEntity.ok(clientID);
  }

  @GetMapping
  public ResponseEntity<String> getAll() {
    return ResponseEntity.ok("get all");
  }

  @PutMapping("/{clientID}")
  public ResponseEntity<String> update(@PathVariable("clientID") @Valid @Min(1) Integer clientID) {
    return ResponseEntity.ok("update client");
  }

}
