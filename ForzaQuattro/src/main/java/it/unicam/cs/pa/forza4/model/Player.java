package it.unicam.cs.pa.forza4.model;

/**
 * Interfaccia per i giocatori.
 * 
 * @author Stefano Perniola.
 */
public abstract class Player {
	protected Coin coin;
	protected String name;
	protected Field gameBoard;
	
	public Player(Coin coin, String name) {
		this.coin = coin;
		this.name = name;
		this.gameBoard = new GameField();
	}
	
	public Player(Coin coin) {
		this.coin = coin;
		this.gameBoard = new GameField();
	}
	
	/**Nome del giocatore.*/
	public String getName() {
		return name;
	}
	
	/**Moneta associata al giocatore.*/
	public Coin getCoin() {
		return coin;
	}
	
	/**Aggiorna il campo da gioco dei giocatori*/
	void opponentMove(int column, Player current) {
		gameBoard.addChip(column, current);
	}

	/**Stabilisce il numero di colonna da giocare*/
	public abstract int askColumn();
}
