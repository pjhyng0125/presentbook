package playdata.pb.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminView extends JFrame {
	DefaultTableModel dtm, dtm2;
	public JTable table, table2;
	JLabel la_id, la_book;
	public JScrollPane sp, sp2;
	public JButton bt_back, bt_addquiz, bt_selectmember, bt_addbook, bt_selectbook, bt_selectallmember, bt_selectallbook;
	Object rowData[][]= new String[0][5];
	Object columnnames[] = {"���̵�", "��й�ȣ", "�̸�", "�̸���", "�帣"};
	
	Object rowData2[][]= new String[0][6];
	Object columnnames2[] = {"������", "���ڸ�", "�ٰŸ�", "�帣", "����", "��"};
	public AdminView() {
		setTitle("AdminView");
		setLayout(null);
		
		la_id = new JLabel("ȸ�� ����");
		la_book = new JLabel("���� ����");		
		bt_back = new JButton("�α׾ƿ�");
		bt_addquiz = new JButton("���� ����");
		bt_selectmember = new JButton("ȸ�� ��ȸ");
		bt_addbook = new JButton("���� �߰�");
		bt_selectbook = new JButton("���� ��ȸ");
		bt_selectallmember = new JButton("ȸ�� ��ü ��ȸ");
		bt_selectallbook = new JButton("���� ��ü ��ȸ");
		
//member table
		dtm = new DefaultTableModel(rowData,columnnames);
		table = new JTable(dtm);
		sp = new JScrollPane(table);
//book table
		dtm2 = new DefaultTableModel(rowData2,columnnames2);
		table2 = new JTable(dtm2);
		sp2 = new JScrollPane(table2);

		table.setFillsViewportHeight(true);
		table2.setFillsViewportHeight(true);		
//setBounds	
		la_id.setBounds(50, 20, 100, 30);
		la_book.setBounds(550, 20, 100, 30);
		sp.setBounds(20, 50, 380, 300);
		sp2.setBounds(550, 50, 380, 300);
		bt_back.setBounds(20, 400, 100, 30);
		bt_addquiz.setBounds(620, 400, 100, 30);
		bt_addbook.setBounds(760, 400, 100, 30);		
		bt_selectbook.setBounds(690, 10, 100, 30);		
		bt_selectallbook.setBounds(810, 10, 120, 30);		
		bt_selectmember.setBounds(160, 10, 100, 30);
		bt_selectallmember.setBounds(280, 10, 120, 30);
//add
		add(la_id);
		add(la_book);
		add(sp);
		add(sp2);
		add(bt_back);
		add(bt_addquiz);
		add(bt_addbook);
		add(bt_selectbook);
		add(bt_selectmember);
		add(bt_selectallbook);
		add(bt_selectallmember);
		
		setVisible(false);
		setSize(1000, 530);
	}
	public void displayTable(ArrayList<Object> list) {
		   dtm.setRowCount(0);//��µ� �������� ��ġ 0 ---> ù��°��
		     
		   for(int i=0; i< list.size(); i++) {
		   Object p = list.get(i);
//		   Object rowData[]= {p.getNo(),p.getName(),p.getAge(),p.getJob()};
		   dtm.addRow(rowData);
		   }//for
		}//displayTable
}

