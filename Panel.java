package com.mycompany.snackgame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;

public class Panel extends JPanel implements ActionListener {

    final int screenWidth = 600;
    final int screenHeight = 600;
    final int unit = 25;
    final int gameUnits = (screenWidth * screenHeight) / unit;
    final int x[] = new int[gameUnits];
    final int y[] = new int[gameUnits];
    int applex;
    int appley;
    Random random;
    Timer timer;
    int bodyparts = 6;
    int delay = 75;
    int appleEaten;
    char direction = 'R';
    boolean running = false;

    public Panel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
         random = new Random();
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        draw(G);
    }

       public void startGame() {
        running = true;
        random = new Random();
      
    
        timer = new Timer(delay, this);
        timer.start();
        newApple();
    }
    public void newApple() {
        applex = random.nextInt((int) (screenWidth / unit)) * unit;
        appley = random.nextInt((int) (screenHeight / unit)) * unit;

    }

 

    public void move() {
        for (int i = bodyparts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'U':
                y[0] -= unit;
                break;
            case 'D':
                y[0] += unit;
                break;
            case 'L':
                x[0] -= unit;
                break;
            case 'R':
                x[0] += unit;
                break;

        }

    }

    public void CheckApple() {
        if (applex == x[0] && appley == y[0]) {
            appleEaten++;
            bodyparts++;
            newApple();
        }

    }

    public void Checkcollects() {
        if (x[0] < 0 || y[0] < 0 || x[0] > screenWidth || y[0] > screenHeight) {
            running = false;
        }
    }

    public void draw(Graphics G) {
        if(running){
//        for (int i = 0; i < gameUnits / unit; i++) {
//            G.drawLine(i * unit, 0, i * unit, screenHigith);
//            G.drawLine(0, i * unit, screenWigith, i * unit);
//             }
             G.setColor(Color.red);
            G.fillOval(applex, appley, unit, unit);
            
             for (int i = 0; i < bodyparts; i++) {
             if (i == 0) {
                G.setColor(Color.white);
                G.fillRect(x[i], y[i], unit, unit);
                } 
             else 
             {
                G.setColor(Color.DARK_GRAY);
                G.fillRect(x[i], y[i], unit, unit);    
                
              }
            }
            }
            else 
                
            {
                gameover(G);
            }
        
        
}   
public void gameover(Graphics G)
{
    G.setColor(Color.red);
    G.setFont(new Font ("Ink free",Font.BOLD,75));
    FontMetrics met =getFontMetrics(G.getFont());
    G.drawString("Game Over" ,(screenWidth-met.stringWidth("Game Over"))/2, screenHeight/2);
}
        
        
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            CheckApple();
            Checkcollects();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (direction != 'D') {
                    direction = 'U';
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U') {
                    direction = 'D';
                }
                break;
            case KeyEvent.VK_LEFT:
                if (direction != 'R') {
                    direction = 'L';
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L') {
                    direction = 'R';
                }
                break;
        
           } 
       }
    }
}


    
