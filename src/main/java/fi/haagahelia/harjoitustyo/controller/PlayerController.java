package fi.haagahelia.harjoitustyo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.harjoitustyo.domain.Player;
import fi.haagahelia.harjoitustyo.domain.PlayerRepository;

@Controller


public class PlayerController {

	@Autowired
	private PlayerRepository prepository;
	
	@RequestMapping(value="/addplayer", method = RequestMethod.POST)
    public @ResponseBody Player savePlayerRest(@RequestBody Player player) {	
    	return prepository.save(player);
    }
	
	@RequestMapping(value= "/deleteplayer/{id}", method = RequestMethod.GET)
	public String deleteTeam(@PathVariable("id") Long id, Model model) {
		prepository.deleteById(id);
		return "redirect:../playerlist";
	}


}
