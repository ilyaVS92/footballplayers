package com.testexample.footballplayers.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.testexample.footballplayers.Entity.Player;
import com.testexample.footballplayers.Entity.Team;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
@Component
public class ArrayRepo {
    // private List<Team> teamList = Arrays.asList(
    //     new Team(1L, "Brooklyn Knights", null),
    //     new Team(2L, "Ottawa Senators", null),
    //     new Team(3L, "Jamestown Hurricanes",null)
    // );
    // private List<FootballPlayer> playersList = Arrays.asList(
    //     new FootballPlayer(1L,"Ilia","Konovalenko","M",LocalDate.of(1991,8,9),"USA",new Team(1L, "Brooklyn Knights", null), "Brooklyn Knights"),
    //     new FootballPlayer(2L,"James","Qurry","M",LocalDate.of(1993,1,4), "Canada",teamList.get(1), "Brooklyn Knights")
    // );

    private List<Team> teamList = new ArrayList<>();
    private List<Player> playersList = new ArrayList<>();


}
