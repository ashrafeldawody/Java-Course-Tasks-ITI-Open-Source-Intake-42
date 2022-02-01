import java.applet.Applet;
import java.awt.*;
public class ImageApplet extends Applet{
	Image image;
	public void init()
	{
		image = getImage(getDocumentBase(),"img.jpg");  
	}

	public void paint(Graphics g){
		//g.drawImage(image, 0, 0,this);
		g.drawImage(image, 0, 0,getWidth(), getHeight(),this);
	}
}