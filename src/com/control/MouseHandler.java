package com.control;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter  {

	private Handler handler;
	private Game game;
	private static int x = -1, y = -1;
	
     public MouseHandler (Handler handler, Game game){
         this.handler = handler;
         this.game = game;

     }
     
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		if (Game.state == States.TitleScreen) {
		//To start the game in single player
			if (x >= 150 && x <= 450 && y >= 300 && y <= 380) {
				Game.state = States.Game;
				System.out.println("Single Player");
			}
		
		//To start the game in multiplayer
			if (x >= 150 && x <= 450 && y >= 400 && y <= 480) {
				System.out.println("Multi Player");

			}
		//Option Menu for the game
			if (x >= 150 && x <= 450 && y >= 500 && y <= 580) {
				Game.state = States.Options;
				System.out.println("Option");

			}
		//To exit the game
			if (x >= 150 && x <= 450 && y >= 600 && y <= 680) {
				System.exit(1);
			}
		}else if (Game.state == States.Options) {
			if (x>= 800 && x <= 950 && y >= 50 && y <= 130) {
				Game.state = States.TitleScreen;
			}
		}else if (Game.state == States.Game) {
			 for (int i = 0; i < handler.object.size(); i++){
                 Object tempObject= handler.object.get(i);
                 if(tempObject.getId() == IDs.player){
                 	if (game.arrowsRemaining > 0) {
						handler.addObject(new Arrow(tempObject.getXpos() + 12, tempObject.getYpos() + 22, IDs.Arrow, handler, x, y));
						game.arrowsRemaining--;
					}
                 }
			 }
		}else if (Game.state == States.Pause) {			
			if (x >= 390 && x <= 630 && y >= 410 && y <= 460) {
				Game.state = States.Game;
			}
			if (x >= 390 && x <= 630 && y >= 480 && y <= 530) {
				Game.state = States.Options;
			}
			if (x >= 390 && x <= 630 && y >= 570 && y <= 620) {
				Game.state = States.TitleScreen;
			}	
			
		}
	}
 
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public static int getX() {
		return x;
	}
	public static int getY() {
		return y;
	}

}
