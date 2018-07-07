package playdata.pb.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class QuizView extends JFrame{
	JPanel panel;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	private JTextField textField;
	public JButton btnNewButton;
	public JButton button;
	public QuizView() {
		setTitle("퀴즈");
		btnNewButton = new JButton("확인");
		button = new JButton("취소");
		lblNewLabel = new JLabel("퀴즈");
		lblNewLabel_1 = new JLabel("책제목");
		lblNewLabel_2 = new JLabel("질문내용");
		textField = new JTextField();
		lblNewLabel_3 = new JLabel("정답");
		 panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.ORANGE, Color.YELLOW, null, null));
		
		panel.setLayout(null);
		getContentPane().setLayout(null);
		textField.setColumns(10);
		panel.setBounds(14, 12, 714, 64);
		lblNewLabel.setBounds(298, 12, 105, 40);
		lblNewLabel_1.setBounds(14, 102, 238, 51);
		lblNewLabel_2.setBounds(61, 178, 618, 92);
		textField.setBounds(216, 316, 463, 36);
		lblNewLabel_3.setBounds(75, 321, 98, 27);
		btnNewButton.setBounds(185, 393, 160, 64);
		button.setBounds(377, 393, 160, 64);

		panel.add(lblNewLabel);
		getContentPane().add(panel);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(lblNewLabel_3);
		getContentPane().add(textField);
		getContentPane().add(btnNewButton);
		getContentPane().add(button);
	}
}
