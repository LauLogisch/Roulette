package roulette;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "table")
public class Table {
	private int id;
	private int turn;
	private Calendar turntime;
	private int minutes = 1;
	private int seconds = 0;
	private ArrayList<String> curPlayers;
	private ArrayList<Turn> turns;
	private final int min = 0, max = 36;
	
	public Table() {
		turntime = Calendar.getInstance();
		setTurn();
		curPlayers = new ArrayList<String>();
		turns = new ArrayList<Turn>();
    }
	
	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public ArrayList<String> getPlayers() {
		return curPlayers;
	}

	@XmlElement
	public int getTurn() {	
		setTurn();
		return turn;
	}

	@XmlElement
	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@XmlElement
	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	private void setTurn() {
		//Set the time for the next turn
		Calendar nextTurn = turntime;
		nextTurn.set(Calendar.MINUTE, nextTurn.get(Calendar.MINUTE) + minutes);
		nextTurn.set(Calendar.MINUTE, nextTurn.get(Calendar.SECOND) + seconds);
		
		//Check if it is time for the next turn
		if (Calendar.getInstance().after(nextTurn) || Calendar.getInstance().equals(nextTurn)){
			//Set random number between 0 and 36
			//then set the time to now
			Random random = new Random();
			turn = random.nextInt(max - min + 1) + min;
			turntime = Calendar.getInstance();
		}	
	}
	
	public void removePlayer(String name) {
		for (String p: curPlayers){
			if (p.equalsIgnoreCase(name)) {
				curPlayers.remove(name);
			}
		}		
	}
	
	public void addPlayer(String name) {
		boolean found = false;
		for (String p: curPlayers){
			if (p.equalsIgnoreCase(name)) found = true;
		}
		if (found == false) curPlayers.add(name);
	}
	
	public void addTurn() {
		turns.add(new Turn());
	}
	
	public void addBet(Player player, int amount, int number) {
		Bet b = new Bet();
		b.setPlayer(player);
		b.setAmount(amount);
		b.setNumber(number);
	
		getLastTurn().addBet(b);
	}
	
	public Turn getLastTurn() {
		return turns.get(turns.size() - 1);
	}
}
