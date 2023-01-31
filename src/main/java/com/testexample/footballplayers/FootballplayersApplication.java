package com.testexample.footballplayers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.testexample.footballplayers.Entity.Player;
import com.testexample.footballplayers.Entity.Team;
import com.testexample.footballplayers.Repository.PlayerRepo;
import com.testexample.footballplayers.Repository.TeamRepo;

@SpringBootApplication
public class FootballplayersApplication implements CommandLineRunner {

    @Autowired
    PlayerRepo playerRepo;

    @Autowired
    TeamRepo teamRepo;

    public static void main(String[] args) {
        SpringApplication.run(FootballplayersApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Team[] teams = new Team[]{
                new Team("Canterberry Haulers"),
                new Team("Martian Space Navy"),
                new Team("Baltimore Suns"),
                new Team("Rocinante")
        };

        for (int i = 0; i < teams.length; i++) {
            teamRepo.save(teams[i]);
        }

        Player[] players = new Player[]{
                new Player("James", "Holden", "M", LocalDate.of(2319, 12, 12), "USA", teams[3]),
                new Player("Alex", "Kamal", "M", LocalDate.of(2319, 10, 1), "USA", teams[3]),
                new Player("Amos", "Burton", "M", LocalDate.of(2319, 9, 12), "USA", teams[3])
        };

        for (int i = 0; i < players.length; i++) {
            playerRepo.save(players[i]);
        }

    }

}
