package arvore234;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Arvore234 
{
    public static void main(String[] args) 
    {
        long value;
        Tree234 t = new Tree234();
        
        t.insert(50);
        t.insert(40);
        t.insert(60);
        t.insert(30);
        t.insert(70);
        
        t.displayTree();
        //t.find(70);
       
        
    }
}
