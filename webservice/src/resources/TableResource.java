package resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import roulette.GameRoulette;
import roulette.Player;
import roulette.Table;

@Path("/table/{tableId}")
public class TableResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Table getTable(@PathParam("tableId") String tableId) {
		return new Table();
	}
	
	@GET @Path("/Turn")
	@Produces(MediaType.TEXT_PLAIN)
	public String TakeTurn() {
		return "Hallo Turn!";
	}
	
	@GET @Path("/Players")
	public void getPlayers() {
		
	}
	
	@GET @Path("/Bet")
	public void placeBet() {
		
	}
	
	@GET @Path("/Bets")
	public void getBets() {
		
	}
	
	@GET @Path("Player")
	public void getPlayer() {
		
	}
}
