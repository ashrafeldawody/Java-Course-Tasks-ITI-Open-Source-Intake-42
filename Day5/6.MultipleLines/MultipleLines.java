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
public class MultipleLines extends Applet implements MouseMotionListener, MouseListener {
	int arrSize = 10;
	Line linesList[] = new Line[arrSize];
	int lineCount = 0;
	Line line;
	public void init() {
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g2.setColor(Color.green);
		for (int i = 0;i<lineCount;i++) {
			if(linesList[i].readyToPaint())
				g2.drawLine(linesList[i].p1.x,linesList[i].p1.y,linesList[i].p2.x,linesList[i].p2.y);
		}
	}
	public void mousePressed(MouseEvent e) {
		if(lineCount >= arrSize) return;
		line = new Line();
		line.setFirstPoint(e.getX(), e.getY());
	}
	public void mouseDragged(MouseEvent e) {
		if(lineCount >= arrSize) return;
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
	

	
	public void mouseReleased(MouseEvent e) {
		if(lineCount >= arrSize) return;
		linesList[lineCount] = line;
		lineCount++;
		repaint();
	}

}
	