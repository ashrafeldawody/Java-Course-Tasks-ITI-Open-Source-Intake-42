import java.applet.*;
import java.awt.*;
import java.awt.event.*; 
public class MovingBall extends Applet implements Runnable {
  	int currentX = 200, currentY = 200;
  	int offsetX = 4, offsetY = 6;
	Boolean isPaused = true;
  	Thread t;
  	Button play;
  	Button pause;

  public void init(){
	  play = new Button("play");
	  pause = new Button("pause");
	  play.addActionListener(new PlayButtonListener());
	  pause.addActionListener(new PauseButtonListener());
	  add(play);
	  add(pause);
  }
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
		if(!isPaused)
			startMoving();
      	try {
        	Thread.sleep(10);
      	} catch (Exception e) {
        	System.out.println(e);
      	};
   		}
  	}
	private void startMoving(){
		if ((currentX + offsetX < 0) || (currentX + 50 + offsetX > getWidth())) 
			offsetX = -offsetX;
      	if ((currentY + offsetY < 0) || (currentY + 50 + offsetY > getHeight())) 
		  	offsetY = -offsetY;

	  	currentX += offsetX;
      	currentY += offsetY;
		repaint();
	} 
	class PlayButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
			isPaused = false;
            repaint() ;
        }
    }
    class PauseButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            isPaused = true;
            repaint() ;
        }
    }
}