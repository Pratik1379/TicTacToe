package com.game.tictactoe;


import java.util.LinkedList;
import java.util.Queue;

public class PlayGame {
    GameBoard board;
    Player player1;
    Player player2;
    GameStatus gameStatus;
    Player winner;

    public PlayGame(GameBoard board, Player player1, Player player2, GameStatus gameStatus) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.gameStatus = gameStatus;
        this.winner = null;
    }



    public GameBoard getBoard() {
        return board;
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    public Player getWinner() {
        if(winner == null) {
            if(this.gameStatus == GameStatus.NOT_STARTED) {
                System.out.println("Game not started!");
            }
            else if(this.gameStatus == GameStatus.ENDED) {
                System.out.println("Game is drawn!");
            }
        }
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    void startGame() {
        this.gameStatus = GameStatus.IN_PROGRESS;
        Queue<Player> queue = new LinkedList<>();
        Player winner = null;
        queue.offer(player1);
        queue.offer(player2);

        int numCellsMarked = 0;
        int N = this.board.getBoardSize();

        int [][] visited = new int[N][N];
        int [] row = new int[N];
        int [] col = new int[N];
        int diag = 0;
        int revDiag = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                visited[i][j] = 0;
            }
        }

        System.out.println("Game Started with board size " + N);

        boolean flag = true;

        while(flag && numCellsMarked < N*N) {

            int x = (int)Math.floor(Math.random()*(N));
            int y = (int) Math.floor(Math.random()*(N));



            if(visited[x][y] == 0) {
                Player currentPlayer = queue.poll();
                System.out.println(currentPlayer.getName() + " -> " + x + "  " + y);
                visited[x][y] = 1;
                board.getBoard()[x][y] = currentPlayer.getSymbol();

                if(currentPlayer == player1) {
                    row[x] += 1;
                    col[y] += 1;
                    if(x == y) {
                        diag += 1;
                    }
                    if(x == N-1-y) {
                        revDiag += 1;
                    }
                    if(row[x] == N || col[y] == N || diag == N || revDiag == N) {
                        this.winner = player1;
                        break;
                    }
                }

                if(currentPlayer == player2) {
                    row[x] += -1;
                    col[y] += -1;
                    if(x == y) {
                        diag -= 1;
                    }
                    if(x == N+1-y) {
                        revDiag -= 1;
                    }
                    if(row[x] == -N || col[y] == -N || diag == -N || revDiag == -N) {
                        this.winner = player2;
                        break;
                    }
                }

                numCellsMarked++;
                visited[x][y] = 1;
                queue.offer(currentPlayer);
            }
        }
        this.gameStatus = GameStatus.ENDED;
    }

}
