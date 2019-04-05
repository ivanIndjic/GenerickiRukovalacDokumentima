package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import app.MyApp;
import model.Dokument;
import model.Workspace;

public class LastUsedDocumentsDialog {
	public LastUsedDocumentsDialog(){
	Dokument mostUsed = new Dokument(MyApp.getInstance().getResourceBundle().getString("lastUsedView"));
	JFrame glavniFrejm = new JFrame(MyApp.getInstance().getResourceBundle().getString("lastUsedViewDocs"));
	JPanel panel = new JPanel(new BorderLayout());
	
	DefaultListModel<String>docModel = new DefaultListModel<>();
	JList<String> listaDokumenta = new JList<>(docModel);
    if(MyApp.getInstance().getPoslednjeKorisceni().size()>0){
    	
    	
    	
	
    				docModel.addElement(MyApp.getInstance().getPoslednjeKorisceni().get(MyApp.getInstance().getPoslednjeKorisceni().size()-1).getName());
    	    
    }
    
    JButton ok = new JButton("Ok");
	ok.setSize(30, 30);
	
	panel.add(ok,BorderLayout.SOUTH);
	ok.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			glavniFrejm.setVisible(false);
		}
	});




panel.add(listaDokumenta,BorderLayout.WEST);
panel.setBackground(new Color(255, 255, 255));

//	panel.setPreferredSize(new Dimension(500,500));
//	panel.setSize(500,500);
glavniFrejm.setPreferredSize(new Dimension(270, 190));
glavniFrejm.setSize(270, 190);
glavniFrejm.add(panel);
glavniFrejm.setVisible(true);
glavniFrejm.setLocationRelativeTo(null);
	
		
		
}
}