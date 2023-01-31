package com.testexample.footballplayers.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.testexample.footballplayers.Constants;
import com.testexample.footballplayers.Entity.Player;

import com.testexample.footballplayers.Service.PlayerService;
import com.testexample.footballplayers.Service.TeamService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
// @RequestMapping("/")
public class PlayerController {

    private TeamService teamService;
    private PlayerService playerService;

    @GetMapping("/")
    public String getPlayerPage(Model model) {
        model.addAttribute("playersList", playerService.findAll());
        return "player-list-en";
    }

    @GetMapping("/form-en")
    public String getFormPage(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("teamNameList", teamService.getTeamNameList());
        model.addAttribute("countries", Constants.countries);
        model.addAttribute("blankPlayer", playerService.findByIdOrReturnNew(id));
        return "form-en";
    }

    @PostMapping("/submitPlayer")
    public String handleSubmit(Player player, @RequestParam(required = false) Long id) {
        playerService.save(player);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deletePlayer(@PathVariable("id") Long id) {
        playerService.deleteById(id);
        return "redirect:/";
    }
}