package it.unicam.cs.pa.forza4.view;

import it.unicam.cs.pa.forza4.model.Field;

	//Observer
public interface View {
	
	/**observer*/
	void update(Field field);
	
	void printGameField(Field field);
	void printWinner(String winner);
	void printTie();
	void printMessage(String message);
	int getIntInput();
	String getStringInput();
	void initGame();
	void printOpponentMove(int col);
	}
