import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class ClientGUI extends JFrame {
	Socket mySocket;
    BufferedReader dis;
    PrintStream ps;
	JTextArea textArea;
	JTextField textField;
public ClientGUI(){
	try {
		mySocket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5005);
		dis = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
		ps = new PrintStream(mySocket.getOutputStream());
		
	} catch (IOException e) {
		System.out.println("Failed to connect to server");
		System.exit(0);
	}

	this.setLayout(new FlowLayout());
	textArea= new JTextArea(20,50);
	textArea.setEnabled(false);
	textArea.setDisabledTextColor(Color.BLUE);
	JScrollPane scroll= new JScrollPane(textArea);
	JTextField textField= new JTextField(40);
	JButton okButton= new JButton("Send");
	okButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			ps.println(textField.getText());
			textField.setText("");
		}
	});
	add(scroll);
	add(textField);
	add(okButton);
	this.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent windowEvent) {
			ps.println("@closing");
		}
	});
	new ChatUpdater();

	
}
	public static void main(String args[]) {
		ClientGUI ui = new ClientGUI();
		ui.setSize(600, 400);
		ui.setResizable(false);
		ui.setVisible(true);
	}
	public class ChatUpdater extends Thread{
		public ChatUpdater(){
			start();
		}
		public void run()
		{
			while(true){
				String str;
				try {
					str = dis.readLine();
					textArea.append(str+"\n");
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}	
}