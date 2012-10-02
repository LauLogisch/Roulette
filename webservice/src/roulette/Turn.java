package roulette;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "turn")
public class Turn {
	private ArrayList<Bet> bets;
	
	public Turn() {
		bets = new ArrayList<Bet>();
	}
	
	public void addBet(Bet bet) {
		bets.add(bet);
	}
	
	@XmlAttribute
	public ArrayList<Bet> getBets() {
		return bets;
	}
}


