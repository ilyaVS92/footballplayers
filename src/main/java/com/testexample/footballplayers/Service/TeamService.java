package com.testexample.footballplayers.Service;

import com.testexample.footballplayers.Entity.*;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface TeamService {
    List<Team> findAll();

    List<Team> findByName(String name);

    Team findById(Long id);

    void deleteById(Long id);

    Object getTeamNameList();

    Team save(Team team);
}
