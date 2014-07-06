package com.test.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.model.KalahaGame;

@Controller
public class KahalaController extends AbstractController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(KahalaController.class);
    
    protected static final String DISPLAY_BOARD = "displayboard";
    protected static final String KAHALA_DISPLAY = "kalahagame/display.htm";
    protected static final String WINNER = "feedback.message.winner";

    
    @RequestMapping(value = "kalahagame/display.htm", method = RequestMethod.GET) 
    public String createKahala(HttpSession session) {
        return DISPLAY_BOARD;
    }
    
    @RequestMapping(value = "kalahagame/start.htm", method = RequestMethod.POST) 
    public String createKahala(HttpSession session, @RequestParam String player1, @RequestParam String player2) {
        
    	KalahaGame kalahagame = new KalahaGame(player1, player2);
    	
    	LOGGER.info("INFO: kahalaGame created with two players: "+player1+" and "+player2);
    	
    	session.setAttribute("gameStatus", kalahagame);
    	
    	return createRedirectViewPath(KAHALA_DISPLAY);
    }
    
    @RequestMapping(value = "kalahagame/play.htm", method = RequestMethod.POST) 
    public String play(HttpSession session, RedirectAttributes attributes, Model model, @RequestParam Integer pitIndex) {
        
    	KalahaGame kalahagame = (KalahaGame) session.getAttribute("gameStatus");
    	
    	kalahagame.play(pitIndex);
    	
    	if (kalahagame.getBoard().gameOver()){
    		LOGGER.info("GAME OVER Winner is "+kalahagame.getWinner());
    		addFeedbackMessage(attributes, WINNER, kalahagame.getWinner());
    	}
    	
    	return createRedirectViewPath(KAHALA_DISPLAY);
    }
}