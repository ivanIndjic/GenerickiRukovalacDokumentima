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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app.MyApp;
import model.Dokument;
import model.Workspace;

public class MostUsedDialog extends JFrame{

	public MostUsedDialog(){
		Dokument mostUsed = new Dokument(MyApp.getInstance().getResourceBundle().getString("mostUsedView"));
		JFrame glavniFrejm = new JFrame(MyApp.getInstance().getResourceBundle().getString("mostUsedViewDocs"));
		JPanel panel = new JPanel(new BorderLayout());
		DefaultListModel<String>docModel = new DefaultListModel<>();
		JList<String> listaDokumenta = new JList<>(docModel);
Dokument temp = null;
		DefaultListModel<Integer> dataModel = new DefaultListModel<>();
		   JList<Integer> intJList = new JList<>(dataModel);
		Workspace ws = MyApp.getInstance().getAktivniWorkspace();
	ArrayList<Dokument> dokTemp = new ArrayList<>();
		try{
			mostUsed = ws.getProjekte().get(0).getDokumente().get(0);
			for(int i=0;i<ws.getProjekte().size();i++){
			for(int j=0;j<ws.getProjekte().get(i).getDokumente().size();j++){
				dokTemp.add(ws.getProjekte().get(i).getDokumente().get(j));
			}
		}
		
				for(int j=0;j<dokTemp.size()-1;j++){
					if(dokTemp.get(j).getBrojac()<dokTemp.get(j+1).getBrojac()){
						temp=dokTemp.get(j);
						dokTemp.set(j, dokTemp.get(j+1));
						dokTemp.set(j+1, temp);
						
					}
				}
			
		if(dokTemp.size()>=5){
			docModel.addElement(dokTemp.get(0).getName());
			docModel.addElement(dokTemp.get(1).getName());
			docModel.addElement(dokTemp.get(2).getName());
			docModel.addElement(dokTemp.get(3).getName());
			docModel.addElement(dokTemp.get(4).getName());
			
			
		}
		else {
			for(int i=0;i<dokTemp.size();i++){
				docModel.addElement(dokTemp.get(i).getName());
				
			}
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
		panel.add(intJList,BorderLayout.EAST);
	//	panel.setPreferredSize(new Dimension(500,500));
	//	panel.setSize(500,500);
		glavniFrejm.setPreferredSize(new Dimension(300, 400));
		glavniFrejm.setSize(470, 400);
		glavniFrejm.add(panel);
		glavniFrejm.setVisible(true);
		glavniFrejm.setLocationRelativeTo(null);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(panel, MyApp.getInstance().getResourceBundle().getString("noDocs"));
		}
	
	}
}
