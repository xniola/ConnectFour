package it.unicam.cs.pa.forza4.model;

/**
 * Classe responsabile di tutto ciò che riguarda il campo da gioco:
 * -Inserimento monete;
 * -Controllo di una possibile vincita o pareggio;
 * -Validità  di un numero di colonna scelto da un player;
 * -Svuotare il campo.
 * 
 * @author Stefano Perniola.
 */
public class GameField implements Field{

	private final int rows;
	private final int columns;

	private Coin[][] field;

	public GameField() {

		this.columns = 7;
		this.rows = 6;

		this.field = new Coin[this.columns][this.rows]; 

		for (int row = 0; row < this.columns; row++) {
			for (int col = 0; col < this.rows; col++) {
				field[row][col] = Coin.EMPTY; 
			}
		}

		resetBoard();
	}


	public Coin[][] getSlots() {
		return this.field;
	}

	public int getBoardWidth() {
		return this.rows;
	}

	public int getBoardHeight() {
		return this.columns;
	}

	public void resetBoard() {
		for (int row = 0; row < this.columns; row++) {
			for (int col = 0; col < this.rows; col++) {
				this.field[row][col] = Coin.EMPTY; 
			}
		}
	}


	public void addChip(int activeColumn, Player player) {

		for (int row = (this.columns - 1); row >= 0; row--) {
			if (this.field[row][activeColumn-1] == Coin.EMPTY) {
				this.field[row][activeColumn-1] = player.getCoin(); // viene inserita la moneta associata al giocatore
																		
				break;
			}
		}
	}

	

	public boolean boardFull() {
		for (int row = 0; row < this.columns; row++) {
			for (int col = 0; col < this.rows; col++) {
				if (this.field[row][col] == Coin.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean columnFull(int column) {
		for (int row = 5; row >= 0; row--) {
			if (this.field[row][column-1] == Coin.EMPTY) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isValid(int col) {
		if((col>columns+1 || col<1))
				return false;
		if(columnFull(col))
			return false;
	 return true;
	}


	public boolean existsWinner(Coin player) {
		if (horizontalWin(player))
			return true;
		if (verticalWin(player))
			return true;
		if (diagonalLowerRightWin(player))
			return true;
		if (diagonalLowerLeftWin(player))
			return true;

		return false;
	}

	private boolean horizontalWin(Coin player) {
		for (int col = 0; col < this.columns - 3; col++)
			for (int row = 0; row < this.rows; row++)
				if (this.field[col][row] == player && this.field[col + 1][row] == player
						&& this.field[col + 2][row] == player
						&& this.field[col + 3][row] == player)
					return true;
		return false;
	}

	private boolean verticalWin(Coin player) {
		for (int col = 0; col < columns; col++)
			for (int row = 0; row < rows - 3; row++)
				if (this.field[col][row] == player && this.field[col][row + 1] == player
						&& this.field[col][row + 2] == player
						&& this.field[col][row + 3] == player)
					return true;

		return false;
	}

	private boolean diagonalLowerRightWin(Coin player) {
		for (int col = 0; col < columns - 3; col++)
			for (int row = 0; row < rows - 3; row++)
				if (this.field[col][row] == player && this.field[col + 1][row + 1] == player
						&& this.field[col + 2][row + 2] == player
						&& this.field[col + 3][row + 3] == player)
					return true;

		return false;
	}

	private boolean diagonalLowerLeftWin(Coin player) {
		for (int col = 0; col < columns - 3; col++)
			for (int row = 3; row < rows; row++)
				if (this.field[col][row] == player && this.field[col + 1][row - 1] == player
						&& this.field[col + 2][row - 2] == player
						&& this.field[col + 3][row - 3] == player)
					return true;

		return false;
	}

}
