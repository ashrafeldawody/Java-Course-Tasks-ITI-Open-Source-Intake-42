import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class BallDrag extends Applet implements MouseMotionListener, MouseListener {

	boolean clicked = false, dragStarted = false;
	
	int x = 0, y=0,radius=50;
	
	public void init() {
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x,y,radius,radius);
	
	}
	
	public void mouseDragged(MouseEvent e) {
		if(dragStarted){
			x = e.getX() - (radius / 2);
			y = e.getY() - (radius / 2);
			repaint();
		}
		System.out.println("mouseDragged");
	}
	
	public void mouseMoved(MouseEvent e) {

		System.out.println("mouseMoved");
	}
	
	public void mouseClicked(MouseEvent e) {

		System.out.println("mouseClicked");
		
	}
	
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}
	
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}
	
	public void mousePressed(MouseEvent e) {
		//if(e.getX() > x && e.getX() < (x + radius) && e.getY() > y && e.getY() < y+radius){
			//dragStarted = true;
		//}
		x = e.getX() - (radius / 2);
		y = e.getY() - (radius / 2);
		dragStarted = true;
		repaint();
		System.out.println("mousePressed");
	}
	
	public void mouseReleased(MouseEvent e) {
		dragStarted = false;
		System.out.println("mouseReleased");
	}
	
	}
	