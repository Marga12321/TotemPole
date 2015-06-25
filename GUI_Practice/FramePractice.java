import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import javax.swing.*;       // access to JFrame and JComponents
import javax.swing.event.*;     // access to JSlider events
public class FramePractice extends JFrame
{
    JLabel label;
    JTextField input;
    JButton button;
    JCheckBox check;
    JComboBox combo;
        String[] comboNames = {"W","E","E","F","L","E"};
    JSlider slider;
    public FramePractice()
    {
        super("Widdle Widdle Widdle");
        
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        
        label = new JLabel("Wiffle Label");
        input = new JTextField(20);
        button = new JButton("Waddle Button");
        check = new JCheckBox("Check the wabble checkbox");
        combo = new JComboBox<String>(comboNames);
        slider = new JSlider();
        
        container.add(label);
        container.add(input);
        container.add(button);
        container.add(check);
        container.add(combo);
        container.add(slider);
        
        input.addActionListener(new TextFieldHandler());
        button.addActionListener(new ButtonHandler());
        check.addItemListener(new CheckBoxHandler());
        combo.addItemListener(new ComboBoxHandler());
        slider.addChangeListener(new SliderHandler());
        
        addWindowListener(new java.awt.event.WindowAdapter()
            {
                public void windowClosing(WindowEvent evt)
                {
                    System.exit(0);
                }
            }
        );
        
        setSize(275,275);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        FramePractice fp = new FramePractice();
    }
    
    //___________________________________________________________________________________//
    
    private class TextFieldHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == input)
            {
                System.out.print("Ya typed ");
                System.out.println(event.getActionCommand());
            }
        }
    }
    
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == button)
            {
                System.out.println("YA PRESSED THE WADDLE BUTTON WEEDLE WEEDLE WEEDLE");
            }
        }
    }
    
    private class CheckBoxHandler implements ItemListener
    {
        public void itemStateChanged (ItemEvent event)
        {
            if(event.getSource() == check)
            {
                if (event.getStateChange() == ItemEvent.SELECTED)
                    System.out.println("Ya checked tha Wabble CheckBox");
                else
                    System.out.println("CHECK THA WABBLE CHECKBOX YA FOOL");
            }
        }
    }
    
    private class ComboBoxHandler implements ItemListener
    {
        public void itemStateChanged (ItemEvent event)
        {
            if(event.getSource() == combo)
            {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    String itemSelected = comboNames[combo.getSelectedIndex()];
                    System.out.println("YA PICKED THE " + itemSelected + " IN WEEFLE");
                }
            }
        }
    }
    
    private class SliderHandler implements ChangeListener {
        public void stateChanged (ChangeEvent event) {
            if (event.getSource() == slider) {
                int x = slider.getValue();
                System.out.println("YOU HAVE " + x + " TIMES THE WEEDLE");
            }

        }
    }
}
