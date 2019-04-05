package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import app.MyApp;
import model.Dokument;
import model.Page;
import model.Project;
import stablo.MyTreeModel;

public class ShareActionListener implements ActionListener {
	
	private String projekat;
	private Dokument dokument;
	private JFrame frame;
	
	public ShareActionListener(String s, Dokument d, JFrame j) {
		// TODO Auto-generated constructor stub
		this.projekat=s;
		this.dokument=d;
		this.frame=j;
		
	}
	
	public ShareActionListener(Dokument d, JFrame j) {
		// TODO Auto-generated constructor stub
		
		this.dokument=d;
		this.frame=j;
		
	}
	
	public void setProjekat(String s)
	{
		projekat=s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(this.projekat);
		//JOptionPane.showMessageDialog(frame, "Selektovan je: " + this.projekat);

		boolean n=false;
		String ime=dokument.getName();
		ime+="Copy";
		Dokument d=new Dokument(ime, true);
		//JOptionPane.showMessageDialog(frame, "Selektovan je: " + ime);
		
		if(dokument.getDeljenUnutar().isEmpty())
		{
			n=false;
		}else
		{
			for(String s: dokument.getDeljenUnutar())
			{
				if(s.equals(projekat))
				{
					n=true;
				}
			}
		}
		if(n){
			JOptionPane.showMessageDialog(frame, MyApp.getInstance().getResourceBundle().getString("docShared"));
			
		}
		else{
			dokument.getDeljenUnutar().add(projekat);
			
			for(Page s:dokument.getStranice())
			{
				d.getStranice().add(s);
			}
			
			for(Project s: MyApp.getInstance().getAktivniWorkspace().getProjekte())
			{
				if(s.getName().equals(projekat))
				{
					s.AddDocument(d);
				}
			}
		
			MyTreeModel m = (MyTreeModel) MyApp.getInstance().getTree().getModel();
			m.update(dokument.getParent().getParent(), this);
			frame.setVisible(false);   
			
		}
		
	}

}
