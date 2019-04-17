package com.control;

import java.awt.*;
import java.util.*;

public class Ghost extends Object{

    //Second enemy
    /*
    This enemy follows the player when the player comes near it. It is a ghost enemy so the 
    interaction with the objects in the canvas is transparent to it. 
     */
	
    public Ghost(int xpos, int ypos, IDs id, SpriteSheet ss) {
		super(xpos, ypos, id, ss);
		// TODO Auto-generated constructor stub
	}

	private Handler handler;
    Game game;
    Random r = new Random();
    Random p = new Random();
    int score = 0;
    int speed = 3;
    int hp = 100;
    boolean hitX = true;
    boolean hitY = true;
    int maxSpeed = 4;
    
    public Ghost(int xpos, int ypos, IDs id, Handler handler, Game game, SpriteSheet ss) {

        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.game = game;
        
        
        
    }
    
    
    
    public void tick() {  	   	
    	ypos += Yspeed;
        xpos += Xspeed;

        for (int i = 0; i < handler.object.size(); i++) {
            Object player = handler.object.get(i);
            if (player.getId() == IDs.player) {
            	 if (xpos < player.getXpos()) {
            		Xspeed = speed;
                 }
            	 if (xpos > player.getXpos()) {
            		 Xspeed = -speed;
            	 }
            	 if (ypos < player.getYpos()) {
            		 Yspeed = speed;
            	 }
            	 if (ypos > player.getYpos()) {
            		 Yspeed = -speed;
            	 }
            }
        }
    	
        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.sword || tempObject.getId() == IDs.Arrow) {
                if (getBounds().intersects((tempObject.getBounds()))) {
                    handler.removeObject(tempObject);
                    handler.removeObject(this);
                }
            }

        }
    	
   }


    public void render(Graphics g) {
       
        g.setColor(Color.pink);
        g.fillRect(xpos, ypos, 16, 16);
    }

    //collision with arrow
    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,16,16);
    }

    //collision with wall
    public Rectangle getXYBounds(){
        return new Rectangle (xpos - 16, ypos - 16, 32, 32);
    }
}