package com.testexample.footballplayers.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.testexample.footballplayers.Entity.Player;

@Repository
public interface PlayerRepo extends CrudRepository<Player, Long> {
    List<Player> findAll();

    List<Player> findByLastName(String lastName);

    List<Player> findByFirstName(String firstName);

    Optional<Player> findById(Long id);
}
