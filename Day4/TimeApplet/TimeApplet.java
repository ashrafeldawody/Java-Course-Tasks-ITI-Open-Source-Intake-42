import java.applet.Applet;
import java.awt.*;
import java.util.Date;

public class TimeApplet extends Applet implements Runnable{
	Thread th; Date d;
	public void init(){
		th= new Thread(this);
		th.start();
		d = new Date();
	}
	public void paint(Graphics g){
		g.setFont (new Font("verdana", Font.BOLD, 20));
		g.drawString(d.toString(), 50, 200);
	}
	public void run(){
		while(true){
			d = new Date();
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}