package roulette;

import javax.xml.bind.annotation.XmlElement;

public class Player {
	private String name;
	private String password;
	private int balance;
	
	public Player(String name, String password){
		this.name = name;
		this.password = password;
		balance = 1;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getWachtwoord() {
		return password;
	}

	public void setWachtwoord(String wachtwoord) {
		this.password = wachtwoord;
	}
	
	@XmlElement
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
