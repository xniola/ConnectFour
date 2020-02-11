package it.unicam.cs.pa.forza4.model;

public interface Field {
	
	int getBoardWidth();
	int getBoardHeight();
	
	void resetBoard();
	void addChip(int col, Player current);
	boolean boardFull();
	boolean columnFull(int col);
	boolean isValid(int column);
	boolean existsWinner(Coin player);
	Coin[][] getSlots();
	
}
