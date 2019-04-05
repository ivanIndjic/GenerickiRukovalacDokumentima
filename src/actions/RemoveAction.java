package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MyApp;
import commandMenager.MyRemovePageCommand;
import commandMenager.MyRemoveSlotCommand;
import model.Dokument;
import model.Page;
import model.Project;
import model.Slot;
import model.Workspace;

public class RemoveAction extends AbstractAction {


	public RemoveAction() {
		
		Icon icon = new ImageIcon(new ImageIcon("resources/remove.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_R);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("remove"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("remove"));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Object o=MyApp.getInstance().getTree().getLastSelectedPathComponent();
		if(o instanceof Workspace){
			Workspace w = (Workspace) o;
			//w.addObserver(MyApp.getInstance().getModelTree());
			
		}
		if(o instanceof Project){
			Project p = (Project) o;
			//p.addObserver(MyApp.getInstance().getModelTree());
			
			for(int i = 0 ; i < p.getDokumente().size() ; i++)                             //brisanje projekta, a kasnije i workspace-a
			     MyApp.getInstance().getSlobodniDokumenti().add(p.getDokumente().get(i));  //ubacuje dokumente koje je imao u slobodne
			     
			MyApp.getInstance().getWorkspace().izbrisiProjekat(p);
		}else if(o instanceof Dokument){
			Dokument p = (Dokument) o;
			for(int i=0;i<MyApp.getInstance().getPoslednjeKorisceni().size();i++){
				if(MyApp.getInstance().getPoslednjeKorisceni().get(i).getName().equals(p.getName()))
					MyApp.getInstance().getPoslednjeKorisceni().remove(i);
			}
			//p.addObserver(MyApp.getInstance().getModelTree());
			Project proj=p.getParent();
			proj.RemoveDocument(p);
		}else if(o instanceof Page){
			Page p = (Page) o;
			//p.addObserver(MyApp.getInstance().getModelTree());
			Dokument d=p.getParent();
			if(!((Page) o).isKopija()){
			       d.getKomandMenadzer().dodajKomandu(new MyRemovePageCommand(p,p.getPozicija()));
			}
			d.RemoveStranicu(p); 
		
			
		}else if(o instanceof Slot){
			Slot s=(Slot)o;
			//s.addObserver(MyApp.getInstance().getModelTree());
			Page p=s.getParent();
			p.getParent().getKomandMenadzer().dodajKomandu(new MyRemoveSlotCommand(s));
			p.RemoveSlot(s);
		}

		
	}

}
