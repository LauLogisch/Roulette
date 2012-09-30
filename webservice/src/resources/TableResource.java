package resources;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import roulette.GameRoulette;
import roulette.Table;

@Path("/table/{tableId}")
public class TableResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Table getTable(@PathParam("tableId") int tableId) {
		return new Table();
	}
	
	@GET @Path("/turn")
	@Produces(MediaType.TEXT_PLAIN)
	public String TakeTurn() {
		return "Hello Turn!";
	}
	
	@GET @Path("/players")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<String> getPlayers(@PathParam("tableid") int tableId) {
		ConcurrentHashMap<Integer, Table> tables = (ConcurrentHashMap<Integer, Table>) GameRoulette.getInstance().getTables();
		
		return tables.get(tableId).getPlayers();
	}
	
	@GET @Path("/bet")
	public void placeBet() {
		
	}
	
	@GET @Path("/bets")
	public void getBets() {
		
	}
	
	@GET @Path("player/{playerid}")
	public void getPlayer(@PathParam("playerid") String playerId, @PathParam("tableid") int tableId) {
		
	}
	
	@POST @Path("player/{playerid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String addPlayer(@PathParam("playerid") String playerId, @PathParam("tableid") int tableId) {
		ConcurrentHashMap<Integer, Table> tables = (ConcurrentHashMap<Integer, Table>) GameRoulette.getInstance().getTables();
		
		tables.get(tableId).addPlayer(playerId);

		JSONObject json = new JSONObject();
		json.put("Success", "True");
		
		return json.toString();
	}
	
	@DELETE @Path("player/{playerid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String removePlayer(@PathParam("playerid") String playerId, @PathParam("tableid") int tableId) {
		ConcurrentHashMap<Integer, Table> tables = (ConcurrentHashMap<Integer, Table>) GameRoulette.getInstance().getTables();
		
		tables.get(tableId).removePlayer(playerId);
		
		JSONObject json = new JSONObject();
		json.put("Success", "True");
		
		return json.toString();
	}
	
}
