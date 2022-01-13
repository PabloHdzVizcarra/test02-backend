package com.example.resttest02.repository;

import com.example.resttest02.domain.Client;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

  @Query("{correo_electronico:?0}")
  Optional<Client> getClientByCorreo(String correo_electronico);
}
