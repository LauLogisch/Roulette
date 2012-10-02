package roulette;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bet")
public class Bet {
	private int amount;
	private int number;
	private Player player;
	
	public Bet() {
	}
	
	@XmlAttribute
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@XmlAttribute
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@XmlAttribute
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
