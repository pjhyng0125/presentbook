package playdata.pb.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BookPayView extends JFrame {
	JPanel p_book, p_pay;
	JLabel la_image, la_book, la_writer, la_price;
	JTextArea ta_content;
	
	JLabel la_id, la_grade, la_point, la_lend, la_showpoint;
	JTextField tf_point;
	JButton bt_pay, bt_back;
	
	public BookPayView() {
		setTitle("BookPayView");
		p_book = new JPanel();
		p_book.setBackground(Color.CYAN);
		p_pay = new JPanel();
		p_pay.setBackground(Color.BLUE);
		p_book.setLayout(null);
//p_pay
		p_pay.setLayout(null);
		la_id = new JLabel("ȸ�� id");
		la_grade = new JLabel("ȸ�� ���");
		la_point = new JLabel("ȸ�� ����Ʈ");
		la_lend = new JLabel("�뿩�ݾ�: 2000��");
		la_showpoint = new JLabel("��� ����Ʈ: ");
		tf_point = new JTextField(10);
		bt_pay = new JButton("����");
		bt_back = new JButton("��������â");
		
		la_id.setBounds(50, 50, 100, 30);
		la_grade.setBounds(50, 120, 100, 30);
		la_point.setBounds(50, 190, 100, 30);
		p_pay.add(la_id);
		p_pay.add(la_grade);
		p_pay.add(la_point);
		la_lend.setBounds(300, 50, 100, 30);
		la_showpoint.setBounds(300, 120, 100, 30);
		tf_point.setBounds(400, 120, 100, 30);
		bt_pay.setBounds(300, 200, 100, 30);
		bt_back.setBounds(480, 200, 100, 30);
		p_pay.add(la_lend);
		p_pay.add(la_showpoint);
		p_pay.add(tf_point);
		p_pay.add(bt_back);
		p_pay.add(bt_pay);
		
//p_book
		la_image = new JLabel("���� �̹���");
		la_book = new JLabel("������");
		ta_content = new JTextArea();
		la_price = new JLabel("���� ����");
		la_writer = new JLabel("�۰���");
		la_image.setBounds(50, 30, 200, 200);
		la_book.setBounds(300, 50, 100, 30);
		la_writer.setBounds(300, 100, 100, 30);
		la_price.setBounds(300, 150, 100, 30);
		ta_content.setBounds(500, 30, 200, 200);
		p_book.add(la_image);
		p_book.add(la_book);
		p_book.add(la_price);
		p_book.add(la_writer);
		p_book.add(ta_content);
		
		p_book.setPreferredSize(new Dimension(0, 270));
		add(p_book, BorderLayout.PAGE_START);
		add(p_pay, BorderLayout.CENTER);
		
		setSize(800,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new BookPayView();
	}
}
