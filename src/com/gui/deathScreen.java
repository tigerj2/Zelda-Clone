package com.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.control.Game;
/*
Death screen which appears when the player loses all their health. Will allow the player to go back to
the main menu
 */


public class deathScreen {

    public Rectangle optionsframe = new Rectangle(0,0,Game.WIDTH,Game.HEIGHT);

    private BufferedImage image;
    Game game;

    public final Button[] titleButton;

    private String score;
    private int yshift = 100;
    private int yspacing = 370;


    public deathScreen(Game game) {
        titleButton = new Button [1];
        Font font = new Font("Arial", Font.PLAIN, 50);
        titleButton[0] = new Button ("Return to title", (optionsframe.width / 2), (optionsframe.height / 2 + yspacing ) + 200, font, Color.white );
        this.game = game;
    }


    public void render (Graphics g)  {

        Font text = new Font ("Comic Sans MS", Font.PLAIN, 40);
        g.setColor(Color.black);
        g.fillRect(0,0,game.WIDTH, game.HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(text);

        g.drawString("Oh dear, you weren't able to find me...", 90,400);
        titleButton[0].render(g);
        score = Integer.toString(game.playerScore);
        g.setColor(Color.white);
        g.drawString("Your score for this session is: " + score, 90, 500);

        try{
            image = ImageIO.read(getClass().getResource("sadd_bear.png"));

        } catch(IOException e){
            e.printStackTrace();
        }
        g.drawImage(image,400,100,null);

        g.drawString("Thanks for playing " + game.playerName + "!", 120, 800);

    }


}
