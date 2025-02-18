
package com.mycompany.snackgame;

import javax.accessibility.AccessibleContext;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class  Frame  extends JFrame {

    public Frame () {     
      super("Snak Game");//سوبر لازم يبقى اول واحد 
      this.add(new Panel());
      this.setVisible(true);
      this.pack();
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);//عشان اوضح ان هقفل عكس ما كنت هحط ارقام
      this.setLocationRelativeTo(null);
      String path="C:\\Users\\alaam\\Pictures\\images (11).jpeg";
      ImageIcon image=new ImageIcon(path);
      this.setIconImage(image.getImage());
      this.setResizable(false);
    }
         
  
    
    
    
    
    
    
    
}
