package com.testexample.footballplayers.Service;

import com.testexample.footballplayers.Entity.Team;
import com.testexample.footballplayers.Repository.TeamRepo;

import java.util.Optional;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

    private TeamRepo teamRepo;

    public Team save(Team team) {
        return teamRepo.save(team);
    }

    public String[] getTeamNameList() {
        List<Team> teamList = findAll();
        String[] teamNameList = new String[teamList.size()];

        for (int i = 0; i < teamNameList.length; i++) {
            teamNameList[i] = teamList.get(i).getName();
        }

        return teamNameList;
    }

    public boolean teamExists(List<Team> teamList, String searchTerm) {
        String[] teamNameList = getTeamNameList();
        for (String s : teamNameList) {
            if (s.equalsIgnoreCase(searchTerm)) {
                return true;
            }
        }
        return false;
    }

    public Team getTeam(Long id) {
        return unwrapTeam(teamRepo.findById(id));
    }

    @Override
    public void deleteById(Long id) {
        teamRepo.deleteById(id);
    }

    @Override
    public List<Team> findByName(String name) {
        return teamRepo.findByName(name);
    }

    @Override
    public Team findById(Long id) {
        return unwrapTeam(teamRepo.findById(id));
    }

    @Override
    public List<Team> findAll() {
        return teamRepo.findAll();
    }

    public Team unwrapTeam(Optional<Team> optionalTeam) {
        if (optionalTeam.isPresent()) {
            return optionalTeam.get();
        } else {
            throw new RuntimeException("Team does not exist");
        }
    }
}
