package playdata.pb.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BookView extends JFrame{
	JLabel lblNewLabel ;
	JButton btnNewButton ;
	JButton btnNewButton_1 ;
	JButton button;
	JPanel panel ;
	public BookView() {
		getContentPane().setLayout(null);
		
		lblNewLabel	= new JLabel("å ����");
		btnNewButton = new JButton("����������");
		JPanel panel = new JPanel();
		btnNewButton_1 = new JButton("����");
		JButton button = new JButton("����");
		
		panel.setBounds(133, 54, 1164, 615);
		btnNewButton.setBounds(14, 13, 105, 27);
		btnNewButton_1.setBounds(14, 331, 105, 68);
		lblNewLabel.setBounds(417, 12, 640, 28);
		button.setBounds(1301, 331, 105, 68);
		
		getContentPane().add(lblNewLabel);
		getContentPane().add(btnNewButton);
		getContentPane().add(panel);
		getContentPane().add(btnNewButton_1);
		getContentPane().add(button);
		
		setVisible(true);
	}
}
