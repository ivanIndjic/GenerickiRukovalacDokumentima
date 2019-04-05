package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.MyApp;
import model.Dokument;
import model.Project;
import model.Workspace;

public class OpenAction extends AbstractAction {
	public OpenAction(){
		Icon icon = new ImageIcon(new ImageIcon("resources/Open-icon.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_O);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("open"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("open"));
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o=MyApp.getInstance().getTree().getLastSelectedPathComponent();
		
		if(o instanceof Workspace){
			Workspace ws=(Workspace)o;
			JFileChooser fc2=new JFileChooser();
			fc2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		    fc2.setAcceptAllFileFilterUsed(false);
		    FileFilter filter=new FileNameExtensionFilter("proj","proj");
		    fc2.setFileFilter(filter);
		    
		    int b=fc2.showOpenDialog(MyApp.getInstance());
			File f2=fc2.getSelectedFile();
			
			File file2;
			if(f2!=null){
				file2 = new File(f2.toString());
				String naziv=f2.getName();
				int kraj=naziv.lastIndexOf('.');
				String naz=naziv.substring(0,kraj);
				Project p=new Project(naz);
				
				ws.addObserver(MyApp.getInstance().getModelTree());
		
				MyApp.getInstance().getWorkspace().dodajProjekat(p);
				p.setParent(ws);
				p.addObserver(MyApp.getInstance().getModelTree());
				
				File[] listOfFiles=f2.listFiles();
				try {
					for(int i=0;i<listOfFiles.length; i++){
						String ime=listOfFiles[i].getName();
						Dokument d=Serialization.openDokument(new File(f2.toString()+"\\"+ime));
						d.addObserver(MyApp.getInstance().getModelTree());
						d.setParent(p);//vraca aktivni projekat
						p.AddDocument(d); 
					}
					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		}else if(o instanceof Project){
			try{
				JFileChooser fc2=new JFileChooser();
				    fc2.setAcceptAllFileFilterUsed(false);
				    FileFilter filter=new FileNameExtensionFilter("dok","dok");
				    fc2.setFileFilter(filter);
					
					int b=fc2.showOpenDialog(MyApp.getInstance());
					File f2=fc2.getSelectedFile();
					
					File file2;
					if(f2!=null){
						file2 = new File(f2.toString());
				
			Dokument d=Serialization.openDokument(f2);
				
			d.addObserver(MyApp.getInstance().getModelTree());
			d.setParent(MyApp.getInstance().getProject());//vraca aktivni projekat
			MyApp.getInstance().getProject().AddDocument(d);   
			
						}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null,MyApp.getInstance().getResourceBundle().getString("warningFile"),MyApp.getInstance().getResourceBundle().getString("warning"), JOptionPane.WARNING_MESSAGE);
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, MyApp.getInstance().getResourceBundle().getString("warningDocument"),MyApp.getInstance().getResourceBundle().getString("warning"), JOptionPane.WARNING_MESSAGE);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}