package com.example.resttest02.api;

import com.example.resttest02.domain.DefaultResponse;
import com.example.resttest02.dto.ClientDto;
import com.example.resttest02.dto.ClientRequest;
import com.example.resttest02.service.ClientService;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
  public ResponseEntity<DefaultResponse> create(@Valid @RequestBody ClientRequest request) {
    ClientDto dto = clientService.create(request);
    DefaultResponse response = DefaultResponse.builder().dto(dto)
        .CVE_Mensaje("el cliente se creo con exito").build();
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping("/{clientID}")
  public ResponseEntity<DefaultResponse> get(@PathVariable("clientID") @Valid @NotBlank String clientID) {
    ClientDto dto = clientService.get(clientID);
    return ResponseEntity.ok(DefaultResponse.builder()
        .dto(dto)
        .CVE_Mensaje("cliente encontrado con exito")
        .build());
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
