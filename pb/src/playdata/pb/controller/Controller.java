package playdata.pb.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playdata.pb.view.BookGenreView;
import playdata.pb.view.BookSelectView;
import playdata.pb.view.JoinView;
import playdata.pb.view.LoginView;
import playdata.pb.view.PassUpdateView;

public class Controller implements ActionListener {
	LoginView v_login;
	JoinView v_join;
	PassUpdateView v_passup;
	BookGenreView v_bookgenre;
	BookSelectView v_bookselect;
	
	public Controller() {
		v_login = new LoginView();
		v_join = new JoinView();
		v_passup = new PassUpdateView();
		v_bookgenre = new BookGenreView();
		v_bookselect =new BookSelectView();
		
		eventup();
	}
	
	public void eventup() {
		v_login.bt_join.addActionListener(this);
		v_join.bt_submit.addActionListener(this);
		v_bookgenre.bt_select.addActionListener(this);
		v_bookselect.bt_logout.addActionListener(this);
		v_bookselect.bt_genre.addActionListener(this);
		v_login.bt_login.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Controller();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == v_login.bt_join) {
			v_login.setVisible(false);
			v_join.setVisible(true);
		}
		else if(ob == v_join.bt_submit) {
			v_join.setVisible(false);
			v_login.setVisible(true);
		}
		else if(ob == v_bookgenre.bt_select) {
			v_bookgenre.setVisible(false);
			v_bookselect.setVisible(true);
		}
		else if(ob == v_bookselect.bt_logout) {
			v_bookselect.setVisible(false);
			v_login.setVisible(true);
		}
		else if(ob == v_bookselect.bt_genre) {
			v_bookselect.setVisible(false);
			v_bookgenre.setVisible(true);
		}
		else if(ob == v_login.bt_login) {
			v_login.setVisible(false);
			v_bookselect.setVisible(true);
		}
			
	}
}
