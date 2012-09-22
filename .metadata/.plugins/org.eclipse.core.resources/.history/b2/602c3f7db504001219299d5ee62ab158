package roulette;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "roulette")
public class GameRoulette {
	private static GameRoulette instance = null;
	private Map<Integer, Table> tables;
	private AtomicInteger idTables;
	
	protected GameRoulette() {
    	idTables = new AtomicInteger(2);
    	
    	//Create tables
    	//TODO: create 10 tables
    	tables = new ConcurrentHashMap<Integer, Table>();
    	Table table1 = new Table(1, 0);
    	table1.setId(1);
    	tables.put(1, table1);    
    	
    	tables = new ConcurrentHashMap<Integer, Table>();
    	Table table2 = new Table(1, 0);
    	table2.setId(2);
    	tables.put(2, table2);
    }
	
	public static GameRoulette getInstance() {
      if(instance == null) {
         instance = new GameRoulette();
      }
      return instance;
    }
}
