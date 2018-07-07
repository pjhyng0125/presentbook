package playdata.pb.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playdata.pb.view.JoinView;
import playdata.pb.view.LoginView;
import playdata.pb.view.PassUpdateView;

public class Controller implements ActionListener {
	LoginView v_login;
	JoinView v_join;
	PassUpdateView v_passup;
	
	public Controller() {
		v_login = new LoginView();
		v_join = new JoinView();
		v_passup = new PassUpdateView();
		
		eventup();
	}
	
	public void eventup() {
		v_login.bt_join.addActionListener(this);
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
	}
}
