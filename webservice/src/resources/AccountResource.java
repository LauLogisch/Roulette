package resources;

import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import roulette.GameRoulette;
import roulette.Player;
import roulette.Table;

@Path("/account")
public class AccountResource {
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public int getPlayer(@PathParam("name") String name, @PathParam("password") String password) {
		int playerid = GameRoulette.getInstance().getAccount(name, password);
		return playerid;
	}
	
	@POST	
	@Consumes(MediaType.APPLICATION_XML)
	public void createEmployees(Player player){
		GameRoulette.getInstance().addPlayer(player);
		
		//return Response.created(URI.create("/account/" + player.getName()))
		//		.build();
	}
	
	@GET @Path("bank/")
	@Produces(MediaType.TEXT_PLAIN)
	public String getBalance(@PathParam("playerid") String playerId) {
		ConcurrentHashMap<Integer, Player> players = (ConcurrentHashMap<Integer, Player>) GameRoulette.getInstance().getPlayers();
		
		Player player = players.get(playerId);
		
		return "Balance: " + player.getBalance();
	}
	
	@POST @Path("bank/")
	@Produces(MediaType.TEXT_PLAIN)
	public void setBalance(@PathParam("playerid") String playerId, @PathParam("amount") int amount) {
		ConcurrentHashMap<Integer, Player> players = (ConcurrentHashMap<Integer, Player>) GameRoulette.getInstance().getPlayers();
		
		Player player = players.get(playerId);
		
		player.setBalance(player.getBalance() + amount);
	}
}
