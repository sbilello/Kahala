# Kahala or Kalaha or Mancala Game #

This is an example of how I implemented the code by reading the requirements.
It doesn't use WebSockets and there is not a beautiful front-end.
This exercise is focused on the algorithm and OOP designing.

## Getting Started ##

You can create the war project by typing:

`mvn package` 

## Run on tomcat 7

`mvn tomcat7:run` 

It's also possible deploy on tomcat if you configure your tomcat-users.xml and maven settings.xml.

`mvn tomcat:deploy`

### Kalaha Game 

Home URL `http://localhost:8080/mancala/` 

### Board Setup 

Each of the two players has his six pits in front of him. To the right of the six pits, each player has a larger pit, his Kalaha. In each of the six round pits are put six stones when the game starts.

### Kalaha Rules 

Game Play
The player who begins with the first move picks up all the stones in anyone of his own six pits, and sows the stones on to the right, one in each of the following pits, including his own Kalaha. No stones are put in the opponents' Kalaha. If the player's last stone lands in his own Kalaha, he gets another turn. This can be repeated several times before it's the other player's turn.


Capturing Stones
During the game the pits are emptied on both sides. Always when the last stone lands in an own empty pit, the player captures his own stone and all stones in the opposite pit (the other players' pit) and puts them in his own Kalaha.


The Game Ends
The game is over as soon as one of the sides run out of stones. The player who still has stones in his pits keeps them and puts them in his/hers Kalaha. Winner of the game is the player who has the most stones in his Kalaha
