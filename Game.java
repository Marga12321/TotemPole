import apcslib.*;
import chn.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.URL;
public class Game extends JFrame implements ActionListener
{
    
    private Block block;
    private Block block2;
    private Block block3;
    private Block block4;
    
    private PicturePicker picker = new PicturePicker();
    private String next = picker.next();
    
    private boolean end = false;
    
    private Timer timer;
    
    private final int Y5 = 700;
    private final int Y4 = Y5 - 100;
    private final int Y3 = Y4 - 100;
    private final int Y2 = Y3 - 100;
    private final int Y1 = Y2 - 100;
    
    private JLabel scoreLabel;
    private int score = 0;
    private JLabel plus3;
    
    Image background;
    
    public Game()
    {
        block4 = new Block(125, 250, Y4, next);
        next = picker.next();
        block3 = new Block(125, 250, Y3, next);
        next = picker.next();
        block2 = new Block(125, 250, Y2, next);
        next = picker.next();
        block = new Block(0, 250, Y1, next);
        next = picker.next();
        
        addKeyListener(new KeyHandler());
        
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(WindowEvent evt) 
            {
                System.exit(0);
            }
        }
        );
        
        ClassLoader loader = this.getClass().getClassLoader();
        ImageIcon backgroundIcon = new ImageIcon(loader.getResource("background.jpg"));
        Image temp = backgroundIcon.getImage();
        background = temp.getScaledInstance(500, 700, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(background);
        setContentPane(new JLabel(backgroundIcon));
        setLayout(new FlowLayout());
        
        setSize(500,700);
        setVisible(true);       
        
        timer = new javax.swing.Timer(10, this);
        timer.start();
    }
    
    public void paint(Graphics g)
    {
        Image offImage = createImage(500, 700);
        // Creates an off-screen drawable image to be used for
        // double buffering; XSIZE, YSIZE are each of type ‘int’
        Graphics buffer = offImage.getGraphics();
        // Creates a graphics context for drawing to an 
        // off-screen image
        paintOffScreen(buffer);     // your own method
        g.drawImage(offImage, 0, 0, null);  
        // draws the image with upper left corner at 0,0
      
    }

    public void paintOffScreen(Graphics g)
    {
        g.clearRect(0, 0, 500, 700);
        
        g.drawImage(background,0,0,this);
        g.drawImage(block.getImage(), block.getX(), block.getY(), this);
        g.drawImage(block2.getImage(), block2.getX(), block2.getY(), this);
        g.drawImage(block3.getImage(), block3.getX(), block3.getY(), this);
        g.drawImage(block4.getImage(), block4.getX(), block4.getY(), this);

        g.setColor(new Color(153, 0, 0));
        Font f = new Font("SansSerif", Font.PLAIN, 35);
        g.setFont(f);
        g.drawString("Score is: " + score ,175,65);
    }

    
    private boolean go = true;
    private boolean scroll;
    public void actionPerformed(ActionEvent evt)
    {
        if(!end)
        {
            if(go)
            {
                block.move();
            }else{
                scroll = block.scroll();
                block2.scroll();
                block3.scroll();
                block4.scroll();
                if(!scroll)
                {
                    block.resize(block2.getX(),block2.getX2());
                    if(block.getWidth() <= 0){
                        end = true;
                        end();
                        setVisible(false);
                    }
                    if(block.getWidth() == block2.getWidth())
                        score += 3;
                    else
                        score++;
                    if(!end)
                        newBlock();
                    go = true;
                }
            }
            repaint();
        }
    }
    
    public void newBlock()
    {
        block4 = block3;
        block3 = block2;
        block2 = block;
        
        block = new Block(0,block2.getWidth(),Y1, next);
        next = picker.next();
    }
    
    public void end()
    {
        EndScreen end = new EndScreen(score);
    }
    
    public static void main(String[] args) {
        Game application = new Game();
    }

    private class KeyHandler implements KeyListener
    {
        public void keyPressed(KeyEvent event)
        {
            if(event.getKeyCode() == KeyEvent.VK_SPACE)
            {
                //System.out.println("Spacebar pressed");
                go = false;
                //timer.cancel();
            }
        }

        public void keyReleased (KeyEvent event )
        {
            /*if(event.getKeyCode() == KeyEvent.VK_SPACE)
            {
                timer.start();
            }*/
        }

        public void keyTyped (KeyEvent event )
        {
            
        }
    }
}

