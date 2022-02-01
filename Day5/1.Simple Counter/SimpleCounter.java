import java.awt.*;
import java.applet.*;
import java.awt.event.*;


public class SimpleCounter extends Applet {
    int x = 0;
    Button increase;
    Button decrease;

    public void init(){
        increase = new Button("Increment");
        decrease = new Button("Decrement");
        increase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                x++ ;
                repaint() ;
            }
        });
        decrease.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(x > 0) x--;
                repaint() ;
            }
        });
        add(increase);
        add(decrease);
    }

    public void paint(Graphics g){
        g.setFont(new Font("Tahoma",Font.BOLD,25));
        g.drawString("Click Count:" + x, 200, 100);
    }
}