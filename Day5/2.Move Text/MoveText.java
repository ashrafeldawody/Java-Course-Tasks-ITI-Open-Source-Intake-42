import java.awt.*;
import java.applet.*;
import java.awt.event.*;  

public class MoveText extends Applet implements KeyListener {
    int x = 100,y=100;
    public void init(){
        addKeyListener(this);
    }
    public void paint(Graphics g){
        g.setFont(new Font("Tahoma",Font.BOLD,20));
        g.drawString("Press Arrows To Move", x, y);
    }


    public void keyTyped(KeyEvent e) {
        return;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (x - 10 > 0) x -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                if (x + 10 < getWidth() - 220) x += 10;
                break;
            case KeyEvent.VK_DOWN:
                if (y + 10 < getHeight()) y += 10;
                break;
            case KeyEvent.VK_UP:
                if (y - 10 > 20 ) y -= 10;
                break;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        return;
    }
}