package fi.haagahelia.harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Team {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long teamid;

@NotNull
public String name;

@NotNull
public String city;
public String year;


@OneToMany(cascade = CascadeType.ALL, mappedBy ="team")
	private List<Player> players;


public Team() {}

public Team(String name, String city, String year) {
	super();
	this.name = name;
	this.city = city;
	this.year = year;
	
	
}

public Long getId() {
	return teamid;
}
public void setId(Long teamid) {
	this.teamid = teamid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}

public List<Player> getPlayers() {
	return players;
}
public void setPlayers(List<Player> players) {
	this.players = players;
}


}
