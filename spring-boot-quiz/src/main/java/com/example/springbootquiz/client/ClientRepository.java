package com.example.springbootquiz.client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT p FROM Client p WHERE p.id = :id")
    Optional<Client> findClientById(Long id);

}
