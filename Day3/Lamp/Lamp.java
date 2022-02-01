import java.applet.Applet;
import java.awt.*;

public class Lamp extends Applet{
	Color fillColor =new Color(251, 244, 142);
	public void paint(Graphics g){

		g.drawRect(111,624,424,30);
		g.drawLine(311,465,270,624);
		g.drawLine(339,465,380,624);
		//bottom arc
		g.drawArc(45, 365, 571,100, 180, 180);

		//side lines
		g.drawLine(45, 415,116,150);
		g.drawLine(617,415,550,150);

		

		//upper ellipse
		g.setColor(fillColor);
		g.fillOval(115, 100, 435,100);
		g.setColor(Color.BLACK);
		g.drawOval(115, 100, 435,100);

		//inner ellipses
		g.setColor(fillColor);
		g.fillOval(250, 220, 150,200);
		g.setColor(Color.BLACK);
		g.drawOval(250, 220, 150,200);
		
		g.setColor(fillColor);
		g.fillOval(100, 250, 75,100);
		g.setColor(Color.BLACK);
		g.drawOval(100, 250, 75,100);

		g.setColor(fillColor);
		g.fillOval(490, 250, 75,100);
		g.setColor(Color.BLACK);
		g.drawOval(490, 250, 75,100);

	}
}