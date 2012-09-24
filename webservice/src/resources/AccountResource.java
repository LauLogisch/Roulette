package resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import roulette.GameRoulette;
import roulette.Player;

@Path("/account")
public class AccountResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayer(@PathParam("name") String name) {
		Player Player = GameRoulette.getInstance().getPlayer(name);
		return Player;
	}
}
