package it.unicam.cs.pa.forza4.controller;

import it.unicam.cs.pa.forza4.model.Game;
import it.unicam.cs.pa.forza4.model.GameMode;
import it.unicam.cs.pa.forza4.model.GameOptions;
import it.unicam.cs.pa.forza4.model.Match;
import it.unicam.cs.pa.forza4.view.ConsoleView;
import it.unicam.cs.pa.forza4.view.View;

/**
 * Classe che rappresenta il Controller dell'MVC 
 * 
 * @author Stefano Perniola.
 *
 */
public class Controller {
	private Game game; 
	private View view;  

	private GameMode modality;
	private String player1;
	private String player2;
	
	
	public Controller(View view) {
		this.view = view;
	}

	
	public Controller() {
		this(new ConsoleView());
	}
	

	public int askColumn() {
		int numero = 0;
		try {			
			numero = view.getIntInput();								
		}catch(Exception error){   //l'errore viene visualizzato nella view
			this.view.printMessage(error.getMessage());
		}	
		return numero;
	}
	
	private void chooseGameMode() {
		int numero;
		do {
			view.printMessage("Scegli modalità: \n"+
		                                 "1) Player vs Player\n"+
					                     "2) Player vs Bot");
			numero = view.getIntInput();
		} while (numero < 1 || numero > 2);
		switch(numero) {
		case 1:
			modality = GameMode.PvP;
			break;
		case 2:
			modality = GameMode.PvB;
			break;
		default: System.exit(0);			
	}
		
	}
		
		private void chooseNames() {
			view.printMessage("Inserire nome giocatore 1: ");
			player1 = view.getStringInput();
			if (modality == GameMode.PvB) {
				player2 = "Bot";
			} else {
				view.printMessage("Inserire nome giocatore 2: ");
				player2 = view.getStringInput();
			}
		}
	
		private boolean revenge() {
			String choose;
			do {
				view.printMessage("Rivincita?(S/N): ");
				choose = view.getStringInput();
			} while (!(choose.toUpperCase().equals("S")||choose.toUpperCase().equals("N")));
			if(choose.toUpperCase().equals("S"))
				return true;
			else 
				return false;
		}
	
	
	
	
	public void start() {
		boolean revenge = false;
		chooseGameMode();
		chooseNames();
		GameOptions options = new GameOptions(modality, player1,player2);
	    this.game = new Match(view,options);		
		do {
			this.game.start();
			revenge = revenge();
				if(revenge) {
					game.reset();
				}
			}
			while(revenge);		
	}
	
}
