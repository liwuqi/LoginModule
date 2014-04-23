package tankWar;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyDialog extends JDialog{
	public MyDialog(Tank tk){
		super(tk,"Welcome",true);
		Container cont=getContentPane();
		cont.add(new JLabel("username and password are all correct,Welcome to our place!"));
		setBounds(100,100,400,300);
		
	}
}

public class Tank extends JFrame{
	public Tank(){
		setLayout(new GridLayout(7,1,10,10));
		Container container=getContentPane();
		JPanel pane0=new JPanel(new GridLayout(1,2,5,5));
		JPanel pane1=new JPanel(new GridLayout(1,2,10,10));
		JPanel pane2=new JPanel(new GridLayout(1,2,10,10));
		JLabel lab0=new JLabel("username: ",SwingConstants.RIGHT);
		final JTextField text1=new JTextField("Please input your name!",11);
		JLabel lab1=new JLabel("passwd: ",SwingConstants.RIGHT);
		lab0.setBorder(null);
		lab1.setBorder(null);
		final JPasswordField passwd=new JPasswordField("please input your passwd!",21);
		passwd.setEchoChar('*');
		JButton but0=new JButton("submit");
		JButton but1=new JButton("reset");
		
		pane0.setSize(10, 10);
		pane0.setBounds(0, 21, 10, 10);
		
		text1.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e){
				
			}
			public void focusGained(FocusEvent e){
				text1.setText("");
			}
			
		});
		passwd.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e){
				
			}
			public void focusGained(FocusEvent e){
				passwd.setText("");
			}
			
		});
		but0.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				String a=new String(passwd.getPassword());
				String b=new String("mrsoft");
				if(text1.getText().equals("mr") && a.equals(b)){
					new MyDialog(Tank.this).setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Your username or passwd is not right!Please input again!");
					text1.requestFocus();
				}
			}
		});
		but1.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				text1.setText("");
				passwd.setText("");
				text1.requestFocus();
			}
		});
		
		pane0.add(lab0);
		pane0.add(text1);
		pane1.add(lab1);
		pane1.add(passwd);
		pane2.add(but0);
		pane2.add(but1);
		container.add(pane0);
		container.add(pane1);
		container.add(pane2);
		setSize(200,200);
		setTitle("Login");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
	

	public static void main(String[] args) {
		new Tank();
	}
}
