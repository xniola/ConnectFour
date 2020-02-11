package it.unicam.cs.pa.forza4.model;

import it.unicam.cs.pa.forza4.view.View;

/**Gestisce una singola partita. Implementa i metodi Observable*/

public interface Game {
	boolean isGameEnded();
	int getTurn();
	int changeTurn();
	void start();
	Field getField();
	GameOptions getOptions();
	void reset();
	
	
	//metodi Observable
	void addObserver(View obs);
	void removeObserver(View obs);
	void notifyObservers();
}
