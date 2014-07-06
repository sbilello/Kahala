package com.test.model;


public class KalahaBoard {
		private Pit  []  pits;
		
		private static final int   PLAYING_PITS = 6;
		private static final int   TOTAL_PITS  =  2*(PLAYING_PITS+1);
		private static final int   STONES = 6;

		public KalahaBoard()  {
	        pits  =  new  Pit[TOTAL_PITS];
	        for  (int  pitIndex  =  0;  pitIndex  <  TOTAL_PITS;  pitIndex++)
	        	pits[pitIndex]  =  new Pit();
	    }
		
		public  void  emptyStonesIntoKalaha()  {
	        for  (int  player  =  0;  player  <  2;  player++)
	           for  (int  pitIndex  =  0;  pitIndex  <=  PLAYING_PITS;  pitIndex++)  {
	               int  stones  =  pits[getPitNum(player,pitIndex)].removeStones(); 
	               pits[getKalaha(player)].addStones(stones);
	           }
	    }
		public  boolean  gameOver()  {
			for  (int  player  =  0;  player  <  2;  player++)  {
		        int  stones  =  0;
			    for  (int  pitIndex  =  1;  pitIndex  <=  PLAYING_PITS; pitIndex++)
					stones  +=  pits[getPitNum(player, pitIndex)].getStones();
				if  (stones  ==  0)
	                 return  true;
	        }
	        return  false;
	    }
	    
		public int  getKalaha(int  playerNum)  {
	        return  playerNum  *  (PLAYING_PITS+1);
	    }


	    public  int  getPitNum(int  playerNum, int  pitIndex) {
	        return  playerNum  *  (PLAYING_PITS+1)  +  pitIndex;
	    }

	    public Pit[] getPits() {
			return pits;
		}

	    public int getPlayingpits() {
			return PLAYING_PITS;
		}

		private  boolean  isKalaha(int  pitIndex)  {
	        return  pitIndex  %  (PLAYING_PITS+1)  ==  0;
	    }
		
		/* @param  currentPlayerNum - 0 or 1 to identify the player
		 * @param  chosenPitNum -  pit has been selected by the player
		 * @return boolean - true means the current player has to play another turn
		 *                 - false means the other player has to play 
		 */
		public  boolean  move(int  currentPlayerNum,  int  chosenPitNum)  {
			int  pitIndex  =  getPitNum(currentPlayerNum, chosenPitNum);
	        int  stones  =  pits[pitIndex].removeStones();
	        while  (stones  !=  0)  {
	           pitIndex--;
	           if  (pitIndex  <  0)
	                   pitIndex  =  TOTAL_PITS  -  1;
	           if  (pitIndex  !=  getKalaha(otherPlayerIndex(currentPlayerNum)))  {
		               pits[pitIndex].addStones(1);
		               stones--;
	           }
	        }
	        if  (pitIndex  ==  getKalaha(currentPlayerNum))
	           return  true;
	        if  (pitOwner(pitIndex)  ==  currentPlayerNum  && pits[pitIndex].getStones()  ==  1)  {
				stones  =  pits[oppositePitIndex(pitIndex)].removeStones();
				pits[getKalaha(currentPlayerNum)].addStones(stones);
	        }
		    return false;
		}

	    public  int  oppositePitIndex(int  pitIndex)  {
			return  TOTAL_PITS  -  pitIndex;
		}

	    public  int  otherPlayerIndex(int  playerNum)  {
			if  (playerNum  ==  0)
				return  1;
			else
				return  0;
		}

		public  int  pitOwner(int  pitIndex)  {
	        return  pitIndex  /  (PLAYING_PITS+1);
		}

		public void setPits(Pit[] pits) {
			this.pits = pits;
		}

		public  void  setUpForPlay()  {
	        for  (int  pitIndex  =  0;  pitIndex  <  TOTAL_PITS;  pitIndex++)
	               if  (!isKalaha(pitIndex))
	                   pits[pitIndex].addStones(STONES);
	    }

		public  int  stonesInKalaha(int  playerNum)  {
			return  pits[getKalaha(playerNum)].getStones();
	    }

	    public  int  stonesInPit(int  playerNum, int pitIndex)  {
	        return  pits[getPitNum(playerNum, pitIndex)].getStones();
	    }
}

