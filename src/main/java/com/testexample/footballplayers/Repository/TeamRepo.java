package com.testexample.footballplayers.Repository;

import com.testexample.footballplayers.Entity.Team;

import java.util.Optional;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

// @Repository
public interface TeamRepo extends CrudRepository<Team, Long> {

    List<Team> findByName(String name);

    List<Team> findAll();
}
