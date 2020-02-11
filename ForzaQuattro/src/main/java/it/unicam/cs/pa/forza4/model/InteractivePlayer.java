package it.unicam.cs.pa.forza4.model;


import it.unicam.cs.pa.forza4.controller.Controller;

/**
 * Giocatore interattivo (reale).
 * Ha la sola responsabilità di indicare un numero di colonna per la moneta.
 * 
 * @author Stefano Perniola.
 */
public class InteractivePlayer extends Player{
	private Controller controller;	
	
	
	public InteractivePlayer(Coin coin,String name) {
		super(coin,name);
		controller = new Controller();
	}
	
	public int askColumn() {
		return controller.askColumn();
	}
}
