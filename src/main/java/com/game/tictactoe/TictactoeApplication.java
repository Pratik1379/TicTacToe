package com.game.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TictactoeApplication {

	public static void main(String[] args) {
		Player player1 = new Player(1, "Pratik", 'X');
		Player player2 = new Player(2, "Hardik", 'O');

		GameBoard gameBoard = new GameBoard(3);
		PlayGame game = new PlayGame(gameBoard, player1, player2, GameStatus.NOT_STARTED);

		game.startGame();
		if(game.getWinner() != null)
			System.out.println("The winner of the game is " + game.getWinner().getName());
		System.out.println();
		for(char[] row : gameBoard.getBoard()) {
			for(char c: row) {
				System.out.print(c + "  ");
			}
			System.out.println();
		}
		//SpringApplication.run(TictactoeApplication.class, args);


	}

}
