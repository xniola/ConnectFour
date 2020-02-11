package it.unicam.cs.pa.forza4.view;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import it.unicam.cs.pa.forza4.model.Coin;
import it.unicam.cs.pa.forza4.model.Field;


	public class ConsoleView implements View {
	
	/** Stream di input */
	private BufferedReader in;
	
	/** Stream di output */
	private PrintStream out;
	
	/**
	 * 
	 * @param in 	Oggetto per input da tastiera.
	 * @param out 	Oggetto per stampa a video.
	 */
	public ConsoleView(InputStream in, OutputStream out){
		this.in = new BufferedReader(new InputStreamReader(in));
		this.out = new PrintStream(out);
	}
	
	public ConsoleView() {
		this(System.in,System.out);
		
	}
	
	
	private void printSlotContent(Coin state) {
		if (state == Coin.PLAYER1) {
			System.out.print("[o]");
		} else if (state == Coin.PLAYER2) {
			System.out.print("[x]");
		} else {
			System.out.print("[ ]");
		}
	}

	// --------Observer pattern------------//
	@Override
	public void update(Field currentBoard) {
		printMessage("\n");
		printGameField(currentBoard);
	}

	
	public void printGameField(Field field) {

		for (int row = 0; row < field.getBoardHeight(); row++) {
			for (int col = 0; col < field.getBoardWidth(); col++) {
				printSlotContent(field.getSlots()[row][col]);
			}
			System.out.println();
		}
		printMessage(" 1  2  3  4  5  6  7");

	}



	@Override
	public void printWinner(String winner) {
		printMessage(winner+" ha vinto!");
	}

	@Override
	public void printTie() {
		System.out.println("Pareggio, nessun vincitore.");
	}

	@Override
	public void printMessage(String message) {
		System.out.println(message);
	}
	
	public int getIntInput() {
			while(true) {
				try {
					String s = in.readLine();
					return Integer.parseInt(s.trim());
				}
				catch(NumberFormatException e) 
				{
					out.print("inserire un numero\n");
				}
				catch(IOException e)
				{
					e.printStackTrace();	
				}
				
			}
		}
	
	public String getStringInput() {
		while(true) {
			try {
				String s = in.readLine();
				if(s.trim().length() == 0)
					out.print("Impossibile stringa vuota\n");
				else return s.trim();	
			}
			catch(IOException e) {
				e.printStackTrace();
			}
	    }
	}
	
	public void printOpponentMove(int col) {
		printMessage("L'avversario ha messo la moneta in posizione: "+col);
	}
	
	public void initGame() {
		printMessage("Il gioco ha inzizio!");
	}
}