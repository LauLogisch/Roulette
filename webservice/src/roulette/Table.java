package roulette;


import java.util.Calendar;
import java.util.Random;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "table")
public class Table {
	private int id;
	private int turn;
	private Calendar  turntime;
	private int minutes;
	private int seconds;
	private final int min = 0, max = 36;
	
	public Table(int minutes, int seconds) {
		turntime = Calendar.getInstance();
		this.minutes = minutes;
		this.seconds = seconds;
		setTurn();
    }

    @XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public int getTurn() {	
		setTurn();
		return turn;
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
}
