package it.unicam.cs.pa.forza4.model;

/**
 * Classe del giocatore Random.
 * Ha la sola responsabilit√† di indicare un numero di colonna valido(random).
 * 
 * @author Stefano Perinola.
 */

public class RandomPlayer extends Player{

	/**
	 * Crea un giocatore Random con la propria moneta.
	 * @param coin la moneta del giocatore.
	 * @param col colonne del campo da gioco.
	 */
	public RandomPlayer(Coin coin) {
		super(coin);
	}
	
	
		/**
		 * Genera un numero random tra due valori con estremi inclusi.
		 * @param min il valore minore
		 * @param max il valore maggiore
		 * @return un numero random tra min e max.
		 */
	private int getRandomNumber(int min, int max) {
		  min = (int) Math.ceil(min);
		  max = (int) Math.floor(max);
		  return (int) (Math.floor(Math.random() * (max - min + 1)) + min); //Il max Ë incluso e il min Ë incluso 
		}
	
	/** Scelta della colonna random. 
	 * Il numero scelto √® compreso fra 1 e il numero massimo di colonne del campo. */
	public int askColumn() {		
		int numero = getRandomNumber(1, super.gameBoard.getBoardWidth());
		return numero;
	}
	

}
