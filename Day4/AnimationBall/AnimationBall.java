import java.applet.*;
import java.awt.*;

public class AnimationBall extends Applet implements Runnable {
  int currentX = 200, currentY = 200;
  int offsetX = 4, offsetY = 6;

  Thread t;

  public void start() {
    t = new Thread(this);
    t.start();
  }

  public void paint(Graphics g) {
    g.setColor(Color.red);
    g.fillOval(currentX, currentY, 50, 50);
  }

  public void run() {
    while (true) {
		startMoving();
      	try {
        	Thread.sleep(20);
      	} catch (Exception e) {
        	System.out.println(e);
      	};
      		repaint();
   		}
  	}
	private void startMoving(){
		if ((currentX + offsetX < 0) || (currentX + 50 + offsetX > getWidth())) 
			offsetX = -offsetX;
      		if ((currentY + offsetY < 0) || (currentY + 50 + offsetY > getHeight())) 
		  	offsetY = -offsetY;

	  	currentX += offsetX;
      		currentY += offsetY;
	} 
	
}