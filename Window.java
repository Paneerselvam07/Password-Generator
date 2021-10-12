import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class Window extends JFrame implements ActionListener{
	JButton b1 = new JButton("Generate");
	JTextField text = new JTextField();
	public Window() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setTitle("Password Generator");
		b1.addActionListener(this);
		text.setPreferredSize(new Dimension(250,40));
		text.setFont(new Font("Calabri",Font.PLAIN,12));
		text.setBackground(Color.black);
		text.setForeground(new Color(0x00FF00));
		text.setText("Enter max length (Min 4)");
		this.add(b1);
		ImageIcon image = new ImageIcon("logo1.jpg");
		this.setIconImage(image.getImage());
		this.add(text);
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
	generate(text.getText());
	}
		
	
}

	public void generate(String length) {
		int l = Integer.parseInt(length);
		String ucase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lcase="abcdefghijklmnopqrstuvwxyz";
		String schars="!@#$";
		String numbers="0123456789";
		String allchars = ucase + lcase + schars + numbers;
		char[] password = new char[l];
		Random r = new Random();
		
		password[0] = ucase.charAt(r.nextInt(ucase.length()));
		password[1] = lcase.charAt(r.nextInt(lcase.length()));
		password[2] = schars.charAt(r.nextInt(schars.length()));
		password[3] = numbers.charAt(r.nextInt(numbers.length()));
		
		for(int i=4;i<l;i++) {
			password[i] = allchars.charAt(r.nextInt(allchars.length()));
		}
		String pass = new String(password);
		text.setText(pass);
		
	}
}