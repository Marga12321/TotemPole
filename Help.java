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
public class Help extends JFrame
{
    //Master JFrame
    public static JFrame frame1;

    //Spacing Labels
    JLabel spacingLabel1, spacingLabel2, spacingLabel3;

    //Title Panel
    JPanel titlePanel;
    JLabel titleLabel, titleLabel2, titleLabel3;

    //Buttons on master frame
    JButton play;

    Dimension buttonDimension = new Dimension(200, 125);
    Dimension spacingLabelDimension = new Dimension(50, 50);
    Dimension titleDimension = new Dimension(180, 100);

    //Button Color - Blue
    Color buttonColor = new Color(255,0,0);

    private ImageIcon background;

    public Help()
    {
        frame1 = new JFrame();
        //frame1.setSize(new Dimension(500, 700));

        //Title Label
        titleLabel = new JLabel("Press the SPACE button");
        titleLabel2 = new JLabel("in order to stop the blocks");
        titleLabel3 = new JLabel("and build your totem pole!");
        titleLabel.setFont(new Font("Algerian", 1, 30));
        titleLabel2.setFont(new Font("Algerian", 1, 30));
        titleLabel3.setFont(new Font("Algerian", 1, 30));
        titleLabel.setForeground(Color.RED);
        titleLabel2.setForeground(Color.RED);
        titleLabel3.setForeground(Color.RED);
        titleLabel.setVisible(true);
        titleLabel2.setVisible(true);
        titleLabel3.setVisible(true);

        
        //Aesthetics for the Title Frame
        //frame1.setTitle"");
        //frame1.setLayout( FlowLayout());
        frame1.setVisible(true);
        
        //Spacing Labels
        spacingLabel1 = new JLabel();
        spacingLabel1.setPreferredSize(new Dimension(300, 5));
        spacingLabel2 = new JLabel();
        spacingLabel2.setPreferredSize(new Dimension(300, 100));
        spacingLabel3 = new JLabel();
        spacingLabel3.setPreferredSize(new Dimension(500, 100));

        //New Game Button
        play = new JButton("Play");
        play.setPreferredSize(buttonDimension);
        play.setBackground(buttonColor);
        play.addActionListener(new ButtonHandler());
        play.setVisible(true);

        //Sets Background of frame to the field picture
        ClassLoader loader = this.getClass().getClassLoader();
        ImageIcon backgroundIcon = new ImageIcon(loader.getResource("background.jpg"));
        Image temp = backgroundIcon.getImage();
        Image background = temp.getScaledInstance(500, 700, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(background);
        frame1.setContentPane(new JLabel(backgroundIcon));
        frame1.setLayout(new FlowLayout());

        //Add various JComponents to JFrame
      
        
        frame1.add(spacingLabel2);
        frame1.add(titleLabel);
        frame1.add(titleLabel2);
        frame1.add(titleLabel3);
        frame1.add(spacingLabel1);
        frame1.add(spacingLabel3);
        frame1.add(play);
        frame1.add(spacingLabel1);

        frame1.pack();
    }

    private class  ButtonHandler implements ActionListener
    {
        public void actionPerformed (ActionEvent event) {
            // replace with appropriate reaction to button press

            // sample code to show that button pressed
            if (event.getSource() == play) {
                Game play = new Game();
                frame1.setVisible(false);
            }
        }
    }
} 
