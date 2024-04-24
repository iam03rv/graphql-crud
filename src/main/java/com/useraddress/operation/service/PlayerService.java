package com.useraddress.operation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.useraddress.operation.model.Player;
import com.useraddress.operation.model.Team;


import graphql.schema.idl.errors.DirectiveIllegalArgumentTypeError;
import jakarta.annotation.PostConstruct;

@Service
public class PlayerService {
	
	private List<Player> players = new ArrayList<Player>();	
	
	private final AtomicInteger  id = new AtomicInteger(0);
	
	public List<Player> findAll(){
		return players;
	}
	
	public Optional<Player> findOne(Integer id){
		return players.stream()
				.filter(player -> player.id() == id).findFirst();
	}
	
	public Player create(String name, Team team) {
		Player player = new Player(id.incrementAndGet(),name,team);
		players.add(player);
		return player;
	}
	
	public Player delete(Integer id) {
		Player player = players.stream().filter(c -> c.id() == id)
				.findFirst().orElseThrow(() -> new IllegalArgumentException("Id not found"));
		players.remove(player);
		return player;
	}
	
	public Player update(Integer id, String name, Team team) {
		Player updatePlayer = new Player(id,name,team);
		Optional<Player> optional = players.stream().filter( c -> c.id() == id).findFirst();
		if(optional.isPresent()) {
			Player  player = optional.get();
			int index = players.indexOf(player);
			players.set(index,updatePlayer);
			
		}else {
			throw new IllegalArgumentException("Invalid Palyer!!!");
		}
		return updatePlayer;
	}
	
	@PostConstruct
	private void init() {
		players.add(new Player(id.incrementAndGet(),"MS Dhoni",Team.CSK));
		players.add(new Player(id.incrementAndGet(),"Rohit Sharma",Team.MI));
		players.add(new Player(id.incrementAndGet(),"Narayein",Team.KKR));
		players.add(new Player(id.incrementAndGet(),"David",Team.SRH));
	}

}


