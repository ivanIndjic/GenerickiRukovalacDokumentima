package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import app.MyApp;
import model.Dokument;
import model.Page;

public class DokumentView extends JPanel{
	
	public DokumentView() {
		
	}

	public void initDokumentView(Dokument dokument){
		
		JTabbedPane tab=new JTabbedPane();
		
		BoxLayout box= new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(box);
		this.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.gray));
		for (Page  p : dokument.getStranice()) {
			PageView pw=new PageView();
			pw.initPageView(p);
			this.add(pw);
			
		}
	
		tab.add(dokument.getName(), scrollPane);

		MyApp.getInstance().addToCentralPanelTab(tab);

	}

	public JPanel DokViewzaProj(Dokument dokument){
		
		BoxLayout box= new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(box);
		this.setBackground(Color.GRAY);
		
	    for (Page  p : dokument.getStranice()) {
			PageView pw=new PageView();
			
			this.add(pw.Strizgled(p));
		
		}

	    return this;
	}
	
}
