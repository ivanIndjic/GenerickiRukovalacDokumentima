package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import app.MyApp;
import model.Dokument;
import model.Project;

public class ProjectView extends JPanel {
	public ArrayList<JScrollPane> paneli=new ArrayList<JScrollPane>();
	public ArrayList<String> imena=new ArrayList<String>();
	public ProjectView(Project projekat){

		for (Dokument dd : projekat.getDokumente()) {
			JPanel pan=new JPanel(new BorderLayout());
		
			
			DokumentView dokView=new DokumentView();
			//dokView.initDokumentView(dd);
		
			pan.add(dokView.DokViewzaProj(dd),BorderLayout.CENTER);
			imena.add(dd.getName());
			JScrollPane scrollPane = new JScrollPane(pan,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			paneli.add(scrollPane);
			 
		}

		MyApp.getInstance().addToCentralPanelSkrol(paneli,imena);
		
	}
}
