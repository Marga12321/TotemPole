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

import java.net.URL;
public class Block
{
    private Image block;
    private String imageName;
    
    private int x,x2,width,y;
    private boolean right; 
    
    private int scrollIndex;

    public Block(int xIn, int widthIn, int yIn, String imageNameIn)
    {
        imageName = imageNameIn;
        
        x = xIn;
        width = widthIn;
        x2 = xIn + widthIn;
        y = yIn;
        
        scrollIndex = 0;
        
        ClassLoader cldr = this.getClass().getClassLoader();
        
        ImageIcon blockIcon = new ImageIcon(cldr.getResource(imageName));
        Image uneditedBlock = blockIcon.getImage();
        block = uneditedBlock.getScaledInstance(width, 100, Image.SCALE_DEFAULT);
        int load = blockIcon.getImageLoadStatus();
        //System.out.println("Block load: " + load);
    }

    public void move()
    {
        if(right == false && (x > -100)){
            x -= 5;
            x2 -= 5;
        }else if(right == true && (x2 < 600)){
            x += 5;
            x2 += 5;
        }else if(right == false && (x <= -100)){
            right = true;
        }else if(right == true && (x2 >= 600)){
            right = false;
        }
    }
    public boolean scroll()
    {
        if(scrollIndex < 20)
        {
            y += 5;
            scrollIndex++;
            return true;
        }
        scrollIndex = 0;
        return false;
    }
    public void resize(int otherX, int otherX2)
    {
        if(x < otherX)
        {
            width = x2 - otherX;
            x = otherX;
        }else if(otherX < x){
            width = otherX2 - x;
            x2 = otherX2;
        }else if(x == otherX){
            width = width;
        }else
            width = 0;
        if(width != 0)
            block = block.getScaledInstance(width, 100, Image.SCALE_DEFAULT);
    }
    
    public int getX()
    {return x;}
    public int getWidth()
    {return width;}
    public int getX2()
    {return x2;}
    public int getY()
    {return y;}
    public void setY(int newY)
    {y = newY;}
    public Image getImage()
    {return block;}
}
