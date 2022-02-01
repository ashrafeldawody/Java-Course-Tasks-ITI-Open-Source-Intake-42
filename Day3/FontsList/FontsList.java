import java.applet.Applet;
import java.awt.*;
public class FontsList extends Applet{
	String[] fonts;
	public void init()
	{
		//fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();


		fonts = Toolkit.getDefaultToolkit().getFontList();
	}

	public void paint(Graphics g){
		
		for (int i = 0; i< fonts.length;i++) {
			g.setFont (new Font (fonts[i], Font.PLAIN, 20));
			g.drawString(fonts[i], 10, 40*i);

		}
	}
}