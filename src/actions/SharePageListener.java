package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import app.MyApp;
import model.Dokument;
import model.Page;
import model.Project;
import model.Slot;
import stablo.MyTreeModel;

public class SharePageListener implements ActionListener {

	private String dokument;
	private Page stranica;
	private JFrame frame;
	
	public SharePageListener(String s, Page d, JFrame j) {
		// TODO Auto-generated constructor stub
		this.dokument=s;
		this.stranica=d;
		this.frame=j;
		
	}
	
	public SharePageListener(Page d, JFrame j) {
		// TODO Auto-generated constructor stub
		
		this.stranica=d;
		this.frame=j;
		
	}
	
	public void setProjekat(String s)
	{
		dokument=s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(this.dokument);
		//JOptionPane.showMessageDialog(frame, "Selektovan je: " + this.projekat);

		boolean n=false;
		String ime=stranica.getName();
		ime+="Copy";
		Page d=new Page(ime, stranica.getDuz(), stranica.getBrSlotova(), stranica.getPozicija(), stranica.isHorizontalno(), true);
		//JOptionPane.showMessageDialog(frame, "Selektovan je: " + ime);
		
		if(stranica.getDeljenUnutar().isEmpty())
		{
			n=false;
		}else
		{
			for(String s: stranica.getDeljenUnutar())
			{
				if(s.equals(dokument))
				{
					n=true;
				}
			}
		}
		if(n){
			JOptionPane.showMessageDialog(frame, MyApp.getInstance().getResourceBundle().getString("pageShared"));
			
		}
		else{
			stranica.getDeljenUnutar().add(dokument);
			
			for(Slot s: stranica.getSlotovi())
			{
				d.getSlotovi().add(s);
			}
			
			for(Project s: MyApp.getInstance().getAktivniWorkspace().getProjekte())
			{
				for(Dokument dd : s.getDokumente()) {
					
					if(dd.getName().equals(dokument))
					{
						dd.AddStranicu(d);
						d.setParent(dd);
					}
				}
			}
		
			MyTreeModel m = (MyTreeModel) MyApp.getInstance().getTree().getModel();
			m.update(stranica.getParent().getParent(), this);
			frame.setVisible(false);   
			
		}
		
	}

}
