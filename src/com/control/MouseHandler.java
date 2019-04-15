package com.control;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter  {

	
	private Handler handler;
	private Game game;
	private SpriteSheet ss;
	
	private static int x = -1, y = -1;
	
     public MouseHandler (Handler handler, Game game, SpriteSheet ss){
         this.handler = handler;
         this.game = game;
         this.ss = ss;

     }
     
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		if (Game.state == States.TitleScreen) {
		//To start the game in single player
			if (x >= 150 && x <= 450 && y >= 300 && y <= 380) {
				Game.state = States.Load;
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
			if (x>= 100 && x <= 400 && y >= 190 && y <= 300) {
				System.out.println("Sound");
			}
			if (x>= 100 && x <= 400 && y >= 370 && y <=480) {
				System.out.println("Controls");
			}
			if (x>= 100 && x <= 400 && y >= 550 && y <= 660) {
				System.out.println("Credits");
			}
			if (x>= 100 && x <= 400 && y >= 730 && y <= 840) {
				System.out.println("Back");
				Game.state = States.TitleScreen;
			}
			
			
			
			
		}else if (Game.state == States.Game || Game.state == States.level2) {
			 for (int i = 0; i < handler.object.size(); i++){
                 Object tempObject= handler.object.get(i);
                 if(tempObject.getId() == IDs.player){
					if (e.getButton() == MouseEvent.BUTTON3) {
						if (game.arrowsRemaining > 0) {
							handler.addObject(new Arrow(tempObject.getXpos() + 24, tempObject.getYpos() + 24, IDs.Arrow, handler, x, y, ss));
							game.arrowsRemaining--;
						}
					}
//					if (e.getButton() == MouseEvent.BUTTON1){
//						handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, x,y,ss));
//
//					}
                 }
			 }
		}else if (Game.state == States.Pause) {			
			if (x >= 390 && x <= 630 && y >= 410 && y <= 460) {
				Game.state = States.Game;
			}
			if (x >= 390 && x <= 630 && y >= 480 && y <= 530) {
				Game.state = States.pauseOptions;
			}
			if (x >= 390 && x <= 630 && y >= 570 && y <= 620) {
				Game.state = States.TitleScreen;

			}
		}else if (Game.state == States.pauseOptions) {
			if (x >= 390 && x <= 630 && y >= 570 && y <= 620) {
				Game.state = States.Pause;

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
