package com.test.model;


public class KalahaGame {
	
	private int  currentPlayer  =  0;

	private KalahaBoard  board;

	private Player  []  players;
	
	/* Initialize the game
	 * @param name0 - Player 0
	 * @param name1 - Player 1
	 */
	public KalahaGame(String  name0,  String  name1)  {
        board  =  new KalahaBoard();
        board.setUpForPlay();
        players  =  new Player[2];
        players[0]  =  new Player(name0,  0);
        players[1]  =  new Player(name1,  1);
        currentPlayer  =  0;
    }

	public KalahaBoard getBoard() {
		return board;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}
	public Player[] getPlayers() {
		return players;
	}

	/*
	 * 
	 */
	public void play(int pitIndex)  {
        
	    boolean  checkTurn  =  board.move(currentPlayer, pitIndex); 
		
		if  (!checkTurn)         			
			if  (currentPlayer  ==  0)
					currentPlayer  =  1;
			else
				currentPlayer  =  0;
		
	}
	
	/*
	 * @return Winner's Name or Tie 
	 *
	 */
	public String getWinner(){
		board.emptyStonesIntoKalaha();    
		if  (board.stonesInKalaha(0)  > board.stonesInKalaha(1)){	
			return players[0].getName();
		}
		else 
			if (board.stonesInKalaha(0)  <  board.stonesInKalaha(1)){
				return players[1].getName();
			}
		else
			return "Tie";
	}

    public void setBoard(KalahaBoard board) {
		this.board = board;
	}

    public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

    public void setPlayers(Player[] players) {
		this.players = players;
	}
}
