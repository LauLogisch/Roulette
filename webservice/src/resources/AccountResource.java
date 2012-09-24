package resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import roulette.*;

@Path("/account")
public class AccountResource {
	
	@GET
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayer(@PathParam("name") String name) {
		Player Player = GameRoulette.getInstance().getPlayer(name);
		return Player;
	}
	
	@POST	
	@Consumes(MediaType.APPLICATION_XML)
	public void createEmployees(Player player){
		GameRoulette.getInstance().addPlayer(player);
		
		//return Response.created(URI.create("/account/" + player.getName()))
		//		.build();
	}
}
