import java.applet.Applet;
import java.awt.Graphics;
public class HelloApplet extends Applet{
	String name;
	String age;
	String gender;
	public void init()
	{
		name = getParameter("Name");
		age = getParameter("Age");
		gender = getParameter("Gender");
	}

	public void paint(Graphics g){
		g.drawString("Name: " + name, 50, 100);
		g.drawString("Age: " + age, 50, 130);
		g.drawString("Gender: " + gender, 50, 160);
	}
}