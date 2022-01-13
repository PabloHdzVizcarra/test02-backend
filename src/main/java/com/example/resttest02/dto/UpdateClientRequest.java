package com.example.resttest02.dto;

import javax.validation.constraints.Min;
import lombok.Data;

@Data
public class UpdateClientRequest {

  @Min(value = 0, message = "la edad no puede ser menor a 0")
  private Integer edad;

  @Min(value = 0, message = "la estatura no puede ser menor a 0")
  private Double estatura;

  @Min(value = 0, message = "el peso no puede ser menor a 0")
  private Double peso;

  @Min(value = 0, message = "el geb no puede ser menor a 0")
  private Integer geb;
}
