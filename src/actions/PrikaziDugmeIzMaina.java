package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.MyApp;
import model.Dokument;
import model.Page;
import model.Project;
import view.DokumentView;
import view.PageView;
import view.ProjectView;

public class PrikaziDugmeIzMaina implements ActionListener {


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=MyApp.getInstance().getTree().getLastSelectedPathComponent();
		
		if(o instanceof Dokument){
			DokumentView dw=new DokumentView();
			dw.initDokumentView((Dokument) o);
		}else if(o instanceof Project){
			ProjectView pw=new ProjectView((Project) o);
		}else if(o instanceof Page){
			PageView pw=new PageView();
			pw.initPageView((Page) o);
		}
		
	}

}
