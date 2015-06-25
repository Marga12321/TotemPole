import java.awt.*;          
import java.awt.event.*;    
import javax.swing.*;       
import javax.swing.event.*;
public class PicturePicker
{
    private int numOfPics;
    private String[] pictures = {/*"a1", "a2", "a3", "a4", "aa1", "aa2", "aa3", "aa4",*/ "ab1", "ab2", "ab3", "ab4", "ac1", "ac2", "ac3", "ac4", "ad1", "ad2", "ad3", "ad4", "ae1", "ae2", "ae3", "ae4",
         "af1", "af2", "af3", "af4", "ag1", "ag2", "ag3", "ag4", "ah1", "ah2", "ah3", "ah4", "ai1", "ai2", "ai3", "ai4", "aj1", "aj2", "aj3", "aj4", "ak1", "ak2", "ak3", "ak4", "al1", "al2", "al3", "al4",
         "am1", "am2", "am3", "am4"};
    private int index;
    
    public PicturePicker()
    {
        numOfPics = pictures.length;
        index = numOfPics - 1;
    }
   
    public String get(int index)
    {
        return pictures[index] + ".gif";
    }
    
    public String next()
    {
        String toReturn;
        if(index >= 0){
            toReturn = pictures[index] + ".gif";
            index--;
        }else{
            index = numOfPics - 1;
            toReturn = pictures[index] + ".gif";
            index--;
        }
        return toReturn;
    }
    
    public int length()
    {
        return numOfPics;
    }
}