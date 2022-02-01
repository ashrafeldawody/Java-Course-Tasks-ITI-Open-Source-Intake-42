import java.applet.*;
import java.awt.*;


public class AnimationBall extends Applet implements Runnable {

  Thread t;
  	public void start() {
		Ball.createBall(200,200,6,8);
    	t = new Thread(this);
    	t.start();
  	}

  public void paint(Graphics g) {
    for (int i = 0;i< Ball.NumberOfBalls; i++) {
		if(Ball.balls[i] == null) break;
		g.setColor(Color.red);
		g.fillOval(Ball.balls[i].currentX, Ball.balls[i].currentY, 50, 50);
	}
  }

  public void run() {
    while (true) {
		
      	try {
        	Thread.sleep(50);
      	} catch (Exception e) {
        	System.out.println(e);
      	};
      		repaint();
   		}
  	}
	
}