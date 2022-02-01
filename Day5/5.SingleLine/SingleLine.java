import java.applet.*;
import java.awt.*;
import java.awt.event.*;

class Point{
	int x;
	int y;

	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
}
class Line{
	Point p1,p2;

	void setFirstPoint(int x,int y){
		this.p1 = new Point(x,y);
	}
	void setSecondPoint(int x,int y){
		this.p2 = new Point(x,y);
	}
	Boolean readyToPaint(){
		if(p1 != null && p2 != null){
			return true;
		}
		return false;
	}
}
public class SingleLine extends Applet implements MouseMotionListener, MouseListener {

	Line line;	
	public void init() {
		line = new Line();
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		g2.setColor(Color.green);
		if(line.readyToPaint())
			g2.drawLine(line.p1.x,line.p1.y,line.p2.x,line.p2.y);
	}
	
	public void mouseDragged(MouseEvent e) {
		line.setSecondPoint(e.getX(), e.getY());
		repaint();
	}
	
	public void mouseMoved(MouseEvent e) {

	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {

	}
	
	public void mouseExited(MouseEvent e) {

	}
	
	public void mousePressed(MouseEvent e) {
		line.setFirstPoint(e.getX(), e.getY());
	}
	
	public void mouseReleased(MouseEvent e) {

	}

}
	