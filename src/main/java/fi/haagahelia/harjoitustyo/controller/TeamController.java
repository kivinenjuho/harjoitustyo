package fi.haagahelia.harjoitustyo.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.harjoitustyo.domain.Player;
import fi.haagahelia.harjoitustyo.domain.PlayerRepository;
import fi.haagahelia.harjoitustyo.domain.Team;
import fi.haagahelia.harjoitustyo.domain.TeamRepository;

@Controller

public class TeamController {
	@Autowired
	private TeamRepository repository;
	@Autowired
	private PlayerRepository prepository;

	@RequestMapping(value= {"/", "/teamlist"})
	public String teamList(Model model) {
model.addAttribute("teams", repository.findAll());
return "teamlist";
}
	
	@RequestMapping(value= {"/playerlist"})
	public String playerList(Model model) {
model.addAttribute("players", prepository.findAll());
return "playerlist";
}
	
	@RequestMapping(value= "/team/{id}")
	public String players(@PathVariable("id") Long teamId, Model model) {
		model.addAttribute("players", prepository.findAll());
		model.addAttribute("teams", repository.findAll());
		return "team";

}
	
	@RequestMapping(value="/add")
	public String addTeam(Model model) {
		model.addAttribute("team", new Team());
		return "addteam";
	}
	
	@RequestMapping(value="/addplayer")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		model.addAttribute("teams", repository.findAll());
		return "addplayer";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
	public String deleteTeam(@PathVariable("id") Long teamId, Model model) {
		repository.deleteById(teamId);
		return "redirect:../teamlist";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Team team) {
		repository.save(team);
		return "redirect:teamlist";
	}
	
	@RequestMapping(value = "/saveplayer", method = RequestMethod.POST)
	public String saveplayer(Player player) {
		prepository.save(player);
		return "redirect:playerlist";
	}
}
