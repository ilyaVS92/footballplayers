package com.testexample.footballplayers.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.testexample.footballplayers.Entity.Player;
import com.testexample.footballplayers.Entity.Team;
import com.testexample.footballplayers.Repository.PlayerRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepo playerRepo;
    private TeamService teamService;

    public List<Player> findAll() {
        return playerRepo.findAll();
    }

    @Override
    public List<Player> findByFirstName(String firstName) {
        return playerRepo.findByFirstName(firstName);
    }

    @Override
    public List<Player> findByLastName(String lastName) {
        return playerRepo.findByLastName(lastName);
    }

    @Override
    public Player findByIdOrReturnNew(Long id) {
        if (id == null) {
            return new Player();
        } else if (!playerExists(id)) {
            return new Player();
        } else {
            Player player = unwrapPlayer(playerRepo.findById(id));
            // if(player.getTeamName()==null || player.getTeamName().isBlank()){
            //     player.setTeamName(player.getTeam().getName());
            // }
            return player;
        }
    }

    @Override
    public void deleteById(Long id) {
        playerRepo.deleteById(id);
    }

    @Override
    public Player save(Player player) {
        return playerRepo.save(setPlayerTeam(player.getTeamName(), player));
    }

    public Player setPlayerTeam(String teamName, Player player) {
        for (Team team : teamService.findAll()) {
            if (player.getTeamName().equals(team.getName())) {
                player.setTeam(team);
                return player;
            }
        }

        player.setTeam(teamService.save(new Team(teamName)));
        return player;
    }

    @Override
    public Player findById(Long id) {
        Player player = unwrapPlayer(playerRepo.findById(id));
        player.setTeamName(player.getTeam().getName());
        return player;
    }

    @Override
    public boolean playerExists(Long id) {
        if (playerRepo.findById(id).isPresent()) {
            return true;
        }
        return false;
    }

    public Player unwrapPlayer(Optional<Player> player) {
        if (player.isPresent()) {
            return player.get();
        } else {
            throw new RuntimeException("No such player exists");
        }
    }

}
