package com.testexample.footballplayers.Service;

import java.util.List;

import com.testexample.footballplayers.Entity.Player;
import org.springframework.stereotype.Service;

@Service
public interface PlayerService {
    List<Player> findAll();

    List<Player> findByFirstName(String firstName);

    List<Player> findByLastName(String lastName);

    Player findById(Long id);

    void deleteById(Long id);

    Player save(Player player);

    Player findByIdOrReturnNew(Long id);

    boolean playerExists(Long id);
}
