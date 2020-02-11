package it.unicam.cs.pa.forza4.model;


public class ConcreteFactory implements AbstractFactory{

	@Override
	public Player createInteractivePlayer(Coin coin,String name) {
		return new InteractivePlayer(coin,name);
	}

	
	@Override
	public Player createRandomPlayer(Coin coin) {
		return new RandomPlayer(coin);
	}
}
