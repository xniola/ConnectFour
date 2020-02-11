package it.unicam.cs.pa.forza4.model;

import java.util.ArrayList;

import it.unicam.cs.pa.forza4.view.View;

public class Match implements Game{
	
	private int turno;
	
	private View view;
	
	private GameOptions options;
	
	private Field gameBoard;

	private ArrayList<View> gameObservers; // lista degli Observers
	
	private ConcreteFactory player;

	private Player[] players;

	private boolean isGameEnded;
	
	public Match(View view,GameOptions options){
		this.view = view;
		this.options = options;
		this.turno = 0;
		gameBoard = new GameField();
		gameObservers = new ArrayList<View>();
		gameObservers.add(view);
		createPlayers();
	}
	
	private void createPlayers() {
		players = new Player[2];
		player = new ConcreteFactory();
		setPlayers();
	}	
	
	private void setPlayers() {
		players[0] = player.createInteractivePlayer(Coin.PLAYER1,options.getPlayer1());
		if (options.getModality() == GameMode.PvB) {
			players[1] = player.createRandomPlayer(Coin.PLAYER2);
		} else {
			players[1] = player.createInteractivePlayer(Coin.PLAYER2,options.getPlayer2());
		}
    }
	
	/* Gestisce un turno di gioco */
	private void playTurn() {
		int columns;		
			notifyObservers();
			do {
				if(players[getTurn()] instanceof InteractivePlayer)
					view.printMessage(players[getTurn()].getName()+" dove vuoi mettere la moneta?");
			columns = players[getTurn()].askColumn();
			}
			while(!gameBoard.isValid(columns));			
			updatePlayersBoards(columns, players[getTurn()]);
			view.printOpponentMove(columns);
			gameBoard.addChip(columns,players[getTurn()]); //inserisce la moneta nel campo
			turno = changeTurn();
		}
	
	private void updatePlayersBoards(int column, Player current) {
		players[0].opponentMove(column, current);
		players[1].opponentMove(column, current);
	}

	
	public GameOptions getOptions() {
		return this.options;
	}
	
	/** Inizio del gioco. */
	public void start() {
		view.initGame(); // si segnala ai giocatori l'inizio del gioco
		while (!(gameBoard.existsWinner(Coin.PLAYER1) || gameBoard.existsWinner(Coin.PLAYER2))) {
		playTurn();
		}
		if(gameBoard.boardFull()) {
			view.printTie(); // pareggio
			notifyObservers();
		}else {
			view.printWinner(players[changeTurn()].getName()); // il gioco notifica il vincitore ai players 
			notifyObservers();
		}
	}
	

	
	/**
	 * turno della partita corrente
	 */
	public int getTurn() {
		return turno;
	}
		
	/**
	 * cambia il turno di gioco
	 */
	public int changeTurn() {
		return (turno+1)%2;
	}

	@Override
	public boolean isGameEnded() {
		return isGameEnded;
	}

	@Override
	public Field getField() {
		return this.gameBoard;
	}
	
	public void reset() {
		gameBoard.resetBoard();
	}

	// -------OBSERVER PATTERN -----------///

	@Override
	public void notifyObservers() {
		for (View obs : this.gameObservers) {
			obs.update(getField());
		}
	}

	@Override
	public void addObserver(View obs) {
		this.gameObservers.add(obs);
	}

	@Override
	public void removeObserver(View obs) {
		this.gameObservers.remove(obs);
	}
	// ----------------  //
}
