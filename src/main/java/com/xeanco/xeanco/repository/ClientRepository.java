package com.xeanco.xeanco.repository;

import com.xeanco.xeanco.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findById(long id);

    @Override
    List<Client> findAll();

}
