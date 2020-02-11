package it.unicam.cs.pa.forza4.model;


public interface AbstractFactory {

	public Player createInteractivePlayer(Coin coin,String name);
	public Player createRandomPlayer(Coin coin);
	
}
