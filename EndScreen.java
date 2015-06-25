import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.event.KeyAdapter;
import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import java.*;
import java.awt.image.*;
import javax.swing.border.*;
import java.io.*;
import java.net.URL;
import javax.imageio.*;
import java.awt.Dimension.*;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.*;

import java.net.URL;        // added for JAR file access
public class EndScreen extends JFrame
{
    //Master JFrame
    public static JFrame frame1;

    //Spacing Labels
    JLabel spacingLabel1, spacingLabel2, spacingLabel3;

    //Title Panel
    JPanel titlePanel;
    JLabel titleLabel;

    //Buttons on master frame
    JButton restart;
    JButton main;

    Dimension buttonDimension = new Dimension(200, 125);
    Dimension spacingLabelDimension = new Dimension(50, 50);
    Dimension titleDimension = new Dimension(180, 100);

    //Button Color - Blue
    Color buttonColor = new Color(255,0,0);

    private ImageIcon background;

    public EndScreen(int score)
    {
        frame1 = new JFrame();
        //frame1.setSize(new Dimension(500, 700));

        //Title Label
        titleLabel = new JLabel("You Lost. Score: " + score);
        titleLabel.setFont(new Font("Algerian", 1, 40));
        titleLabel.setForeground(Color.RED);
        titleLabel.setVisible(true);

        //Spacing Labels
        spacingLabel1 = new JLabel();
        spacingLabel1.setPreferredSize(new Dimension(300, 50));
        spacingLabel2 = new JLabel();
        spacingLabel2.setPreferredSize(new Dimension(300, 100));
        spacingLabel3 = new JLabel();
        spacingLabel3.setPreferredSize(new Dimension(500, 100));

        //New Game Button
        restart = new JButton("Play Again");
        restart.setPreferredSize(buttonDimension);
        restart.setBackground(buttonColor);
        restart.addActionListener(new ButtonHandler());
        restart.setVisible(true);

        //Instructions Button
        main = new JButton("Main Menu");
        main.setPreferredSize(buttonDimension);
        main.setBackground(buttonColor);
        main.addActionListener(new ButtonHandler());
        main.setVisible(true);

        //Aesthetics for the Title Frame
        //frame1.setTitle("Loser");
        //frame1.setLayout( FlowLayout());
        frame1.setVisible(true);

        //Sets Background of frame to the field picture
        ClassLoader loader = this.getClass().getClassLoader();
        ImageIcon backgroundIcon = new ImageIcon(loader.getResource("background.jpg"));
        Image temp = backgroundIcon.getImage();
        Image background = temp.getScaledInstance(500, 700, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(background);
        frame1.setContentPane(new JLabel(backgroundIcon));
        frame1.setLayout(new FlowLayout());

        //Add various JComponents to JFrame
        frame1.add(spacingLabel3);
        frame1.add(titleLabel);
        frame1.add(spacingLabel2);
        frame1.add(restart);
        frame1.add(spacingLabel1);
        frame1.add(main);
   
        frame1.pack();
    }

    private class  ButtonHandler implements ActionListener
    {
            public void actionPerformed (ActionEvent event) {
                // replace with appropriate reaction to button press

                // sample code to show that button pressed
                if (event.getSource() == restart) {
                    Game play = new Game();
                    frame1.setVisible(false);
                }
                if (event.getSource() == main) {
                    MainMenu mainmenu = new MainMenu();
                    frame1.setVisible(false);
                }
            }
        }
    } 