package playdata.pb.view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class BookGenreView extends JFrame {
	public JLabel la_msg;
	public JRadioButton rb_1, rb_2, rb_3;
	public ButtonGroup bg;
	public JButton bt_select;
	public BookGenreView() {
		setTitle("BookGenreView");
		setLayout(null);
//new
		la_msg = new JLabel("�帣�� �����ϼ���");
		rb_1 = new JRadioButton("�Ҽ�");
		rb_2 = new JRadioButton("����");
		rb_3 = new JRadioButton("������");
		bg = new ButtonGroup();
		bt_select = new JButton("�帣 ����");
		bg.add(rb_1);
		bg.add(rb_2);
		bg.add(rb_3);
//setBounds
		la_msg.setBounds(60, 30, 120, 30);
		rb_1.setBounds(20, 100 , 80, 30);
		rb_2.setBounds(120, 100 , 80, 30);
		rb_3.setBounds(200, 100 , 80, 30);
		bt_select.setBounds(60, 200, 90, 30);
// frame
		add(la_msg);
		add(rb_1);
		add(rb_2);
		add(rb_3);
		add(bt_select);
		
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new BookGenreView();
	}
}
