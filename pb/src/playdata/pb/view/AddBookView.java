package playdata.pb.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddBookView extends JFrame 
{
	 public JTextField tf_id,tf_name,tf_email;
	 public JPasswordField tf_pass,tf_pass2;
	 public JButton bt_submit,bt_reset,bt_checkid;
	 JLabel la_id,la_pass1,la_pass2,la_n,la_email, la_genre;
	 public JComboBox<String> cb_genre;
	  public AddBookView(){   
	  setTitle("AddBookView");
	  
	  tf_id = new JTextField();
	  tf_pass = new JPasswordField();
	  tf_pass2 = new JPasswordField();
	  tf_name= new JTextField();
	  tf_email = new JTextField();
	  
	  bt_submit = new JButton("���");
	  bt_reset = new JButton("���");
	  bt_checkid = new JButton("�ߺ�Ȯ��");
	  
	  la_id = new JLabel("I  D:");
	  la_pass1 = new JLabel("��  ��:");
	  la_pass2 = new JLabel("���Ȯ��:");
	  la_n = new JLabel("��  ��:");
	  la_email = new JLabel("�̸���:"); 
	  la_genre = new JLabel("��  ��:");
	  
//setBounds 
	  tf_id.setBounds(80,30,100,25);
	  tf_pass.setBounds(80,70,100,25);
	  tf_pass2.setBounds(80,110,100,25);
	  tf_name.setBounds(80,150,100,25);
	  tf_email.setBounds(80,190,180,25);
	  cb_genre.setBounds(80,230,100,25);
	  
	  bt_submit.setBounds(50,290,90,25);
	  bt_reset.setBounds(150,290,90,25);
	  bt_checkid.setBounds(190,30,90,25);
	  
	  la_id.setBounds(10,30,100,25);
	  la_pass1.setBounds(10,70,100,25);
	  la_pass2.setBounds(10,110,100,25);
	  la_n.setBounds(10,150,100,25);
	  la_email.setBounds(10, 190, 100, 25);
	  la_genre.setBounds(10, 230, 100, 25);
//add
	  setLayout(null);
	  add(tf_id);
	  add(tf_pass);
	  add(tf_pass2);
	  add(tf_name);
	  add(tf_email);
	  add(cb_genre);
	  
	  add(bt_submit);
	  add(bt_reset);
	  add(bt_checkid);
	  
	  add(la_id); 
	  add(la_pass1); 
	  add(la_pass2); 
	  add(la_n);
	  add(la_email);
	  add(la_genre);
	  
	  setBounds(350,200,300,400); 
	  setVisible(false);
	 }//������  
	  public void showMsg(String msg) {
	  JOptionPane.showMessageDialog(this, msg);
	 }
	  
	  public void setEmpty() {
	   tf_id.setText("");
	   tf_email.setText("");
	   tf_name.setText("");
	   tf_pass.setText("");
	   tf_pass2.setText("");
	  }
}//JoinForm
