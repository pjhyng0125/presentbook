package playdata.pb.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HistoryView extends JFrame {
	DefaultTableModel dtm;
	public JTable table;
	public JButton bt_back, bt_quiz, bt_read;
	Object rowData[][]= new String[0][3];
	Object columnnames[] = {"������", "���ڸ�", "�ϵ�����"};
	public HistoryView() {
		setTitle("HistoryView");
		setLayout(null);
		
		bt_back = new JButton("����������â����");
		bt_quiz = new JButton("����");
		bt_read = new JButton("���� �б�");
		dtm = new DefaultTableModel(rowData,columnnames);
		table = new JTable(dtm);

		JScrollPane sp = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
		sp.setBounds(50, 50, 300, 300);
		bt_back.setBounds(20, 400, 150, 30);
		bt_quiz.setBounds(200, 400, 80, 30);
		bt_read.setBounds(300, 400, 100, 30);
		add(sp);
		add(bt_back);
		add(bt_quiz);
		add(bt_read);
		
		setSize(600, 600);
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
