package playdata.pb.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playdata.pb.view.BookGenreView;
import playdata.pb.view.BookSelectView;
import playdata.pb.view.CashView;
import playdata.pb.view.HistoryView;
import playdata.pb.view.JoinView;
import playdata.pb.view.LoginView;
import playdata.pb.view.MyPageView;
import playdata.pb.view.PassUpdateView;

public class Controller implements ActionListener {
	LoginView v_login;
	JoinView v_join;
	PassUpdateView v_passup;
	BookGenreView v_bookgenre;
	BookSelectView v_bookselect;
	MyPageView v_mypage;
	HistoryView v_history;
	CashView v_cash;
	int selected_book;
	
	public Controller() {
		v_login = new LoginView();
		v_join = new JoinView();
		v_passup = new PassUpdateView();
		v_bookgenre = new BookGenreView();
		v_bookselect =new BookSelectView();
		v_mypage = new MyPageView();
		v_history = new HistoryView();
		v_cash = new CashView();
		
		eventup();
	}
	
	public void eventup() {
		v_login.bt_join.addActionListener(this);
		v_join.bt_submit.addActionListener(this);
		v_bookgenre.bt_select.addActionListener(this);
		v_bookselect.bt_logout.addActionListener(this);
		v_bookselect.bt_genre.addActionListener(this);
		v_login.bt_login.addActionListener(this);
		v_join.bt_reset.addActionListener(this);
		v_bookselect.bt_mypage.addActionListener(this);
		v_mypage.bt_back.addActionListener(this);
		v_mypage.bt_logout.addActionListener(this);
		v_mypage.bt_update.addActionListener(this);
		v_passup.bt_reset.addActionListener(this);
		v_passup.bt_submit.addActionListener(this);
		v_mypage.bt_history.addActionListener(this);
		v_history.bt_back.addActionListener(this);
		v_mypage.bt_cash.addActionListener(this);
		v_cash.bt_back.addActionListener(this);
		
		for(int i=0; i<v_bookselect.v_bc.length; i++) {
			v_bookselect.v_bc[i].tbt_image.addMouseListener(new MouseAdapter() {
	         @Override
	            public void mouseReleased(MouseEvent e) {      
	            boolean flag = false;   //toggle button이 선택되었는지 여부를 확인하는 변수
	            for(int i=0; i<v_bookselect.v_bc.length; i++) {
	            	v_bookselect.v_bc[i].ta_content.setVisible(false);	
	            }
	         /*--------------------toggle button 체크 확인------------------*/
	            for(int i=0; i<v_bookselect.v_bc.length; i++) {
	               if(v_bookselect.v_bc[i].tbt_image.isSelected()) {
	                  flag = true;
	                  selected_book = i;
	                  v_bookselect.v_bc[i].ta_content.setVisible(true);	
	               }
	            }
	            
	      /*--------------------toggle button 체크 여부에 따라 setEnabled() 호출 ------------------*/
	            if(!flag) {   
	               for(int j=0; j<v_bookselect.v_bc.length; j++) {
	            	   v_bookselect.v_bc[j].tbt_image.setEnabled(true);
	               }
	            }
	            else {
	               for(int j=0; j<v_bookselect.v_bc.length; j++)
	                  if(selected_book != j) {
	                	v_bookselect.v_bc[j].tbt_image.setEnabled(false);
	                  }
	            }
	            System.out.println("selected_book : "+selected_book);
	            }//mouseReleased   
	         });//v_schedule.v_sd[i].addMouseListener
	      }//for
	}
	
	public void setClickBookText(int i, boolean flag) {
		v_bookselect.v_bc[i].la_name.setVisible(flag);
		v_bookselect.v_bc[i].la_writer.setVisible(flag);
		v_bookselect.v_bc[i].la_price.setVisible(flag);
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
		else if(ob == v_join.bt_reset) {
			v_join.setVisible(false);
			v_login.setVisible(true);
		}
		else if(ob == v_bookselect.bt_mypage) {
			v_bookselect.setVisible(false);
			v_mypage.setVisible(true);
		}
		else if(ob == v_mypage.bt_back) {
			v_mypage.setVisible(false);
			v_bookselect.setVisible(true);
		}
		else if(ob == v_mypage.bt_logout) {
			v_mypage.setVisible(false);
			v_login.setVisible(true);
		}
		else if(ob == v_mypage.bt_update) {
			v_mypage.setVisible(false);
			v_passup.setVisible(true);
		}
		else if(ob == v_passup.bt_reset) {
			v_passup.setVisible(false);
			v_mypage.setVisible(true);
		}
		else if(ob == v_passup.bt_submit) {
			v_passup.setVisible(false);
			v_mypage.setVisible(true);
		}
		else if(ob == v_mypage.bt_history) {
			v_mypage.setVisible(false);
			v_history.setVisible(true);
		}
		else if(ob == v_history.bt_back) {
			v_history.setVisible(false);
			v_mypage.setVisible(true);
		}
		else if(ob == v_mypage.bt_cash) {
			v_mypage.setVisible(false);
			v_cash.setVisible(true);
		}
		else if(ob == v_cash.bt_back) {
			v_cash.setVisible(false);
			v_mypage.setVisible(true);
		}
			
	}
}
