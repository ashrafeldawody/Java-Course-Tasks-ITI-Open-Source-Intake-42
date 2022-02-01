import java.applet.Applet;
import java.awt.*;

public class TextBanner extends Applet implements Runnable{
	Thread th; 
	int currentX = 0;
	public void init(){
		th= new Thread(this);
		th.start();
	}
	public void paint(Graphics g){
		g.setFont (new Font("verdana", Font.BOLD, 20));
		g.drawString("Hello JAVA", currentX, 200);
	}
	public void run(){
		while(true){
			moveLeft();
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void moveLeft(){
		if(currentX < getWidth()){
			currentX+=10;
		}else{
			currentX = -100;
		}
	}
}