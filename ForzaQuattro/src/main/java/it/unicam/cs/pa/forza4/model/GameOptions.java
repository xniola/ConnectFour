package it.unicam.cs.pa.forza4.model;

public class GameOptions {
	
	private GameMode modality;
	private String player1;
	private String player2;

	
	/**
	 * Crea un un oggeto GameOptions
	 * @param modality ,la modalita di gioco
	 * @param player1
	 * @param player2
	 */
	public GameOptions(GameMode modality,String player1, String player2) {
		this.modality = modality;	
		this.player1 = player1;
		this.player2 = player2;
	}

	/**
	 * Ottiene la modalità di gioco.
	 * 
	 */
	public GameMode getModality() {
		return modality;
	}
	
	public void setModality(GameMode mode) {
		this.modality = mode;
	}

	/**
	 * Restituisce il nome del Player1
	 * 
	 */
	public String getPlayer1() {
		return player1;
	}

	/**
	 * 
	 * Restituisce il nome del Player2
	 */
	public String getPlayer2() {
		return player2;
	}

	public void setPlayer1(String name) {
		this.player1 = name;
	}
	
	public void setPlayer2(String name) {
		this.player2 = name;
	}
}
