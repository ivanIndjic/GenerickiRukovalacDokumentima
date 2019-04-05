

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

import app.MyApp;
import model.Dokument;
import model.Page;
import model.Project;
import model.Workspace;

public class SaveAction extends AbstractAction {

	public SaveAction() {
		Icon icon = new ImageIcon(new ImageIcon("resources/save.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_S);
		putValue(SMALL_ICON, icon);
		putValue(NAME, MyApp.getInstance().getResourceBundle().getString("save"));
		putValue(SHORT_DESCRIPTION, MyApp.getInstance().getResourceBundle().getString("save"));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o= MyApp.getInstance().getTree().getLastSelectedPathComponent();
		
		if(o instanceof Workspace){
			Workspace ws=(Workspace) o;
			JFileChooser fc=new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fc.setAcceptAllFileFilterUsed(false);
				
			int a=fc.showSaveDialog(MyApp.getInstance());
			File f=fc.getSelectedFile();
			File workFile=new File(f.toString()+"\\"+ws.getName()+".ws");
			new File(f.toString()+"\\"+ws.getName()+".ws").mkdirs();

			
			for(Project proj: ws.getProjekte()){
				File projFile=new File(workFile+"\\"+proj.getName()+".proj");
				new File(workFile+"\\"+proj.getName()+".proj").mkdirs();
				for(Dokument dok: proj.getDokumente()){
					try {
						File ff=new File(projFile+"\\"+dok.getName()+".dok");
						Serialization.saveDokument(dok,ff);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			JOptionPane.showMessageDialog(null, MyApp.getInstance().getResourceBundle().getString("success"),MyApp.getInstance().getResourceBundle().getString("info"), JOptionPane.INFORMATION_MESSAGE);
			
			
		}else if(o instanceof Project){
		   try {
			   Project proj=(Project) o;
				
				JFileChooser fc=new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				 fc.setAcceptAllFileFilterUsed(false);
					
					int a=fc.showSaveDialog(MyApp.getInstance());
					File f=fc.getSelectedFile();
					
					File novFile=new File(f.toString()+"\\"+proj.getName()+".proj");
					File path=new File(f.toString()+"\\"+proj.getName()+".proj");
					new File(f.toString()+"\\"+proj.getName()+".proj").mkdirs();
				
					for(Dokument dok : proj.getDokumente()){
						try {
							File ff=new File(path+"\\"+dok.getName()+".dok");
							Serialization.saveDokument(dok,ff);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
						JOptionPane.showMessageDialog(null, MyApp.getInstance().getResourceBundle().getString("success"),MyApp.getInstance().getResourceBundle().getString("info"), JOptionPane.INFORMATION_MESSAGE);
				
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, MyApp.getInstance().getResourceBundle().getString("docEx"),MyApp.getInstance().getResourceBundle().getString("warning"), JOptionPane.WARNING_MESSAGE);
		
		}
		}else if(o instanceof  Dokument){
			try {
				Dokument d=(Dokument)o;
				
				JFileChooser fc=new JFileChooser();

				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				 fc.setAcceptAllFileFilterUsed(false);
				
				 //fc.remove();
					int a=fc.showSaveDialog(MyApp.getInstance());
					File f=fc.getSelectedFile();
					
					File file;
					if(f!=null){
						file = new File(f.toString()+"\\"+d.getName()+".dok");
						Serialization.saveDokument(d, file);
						
					JOptionPane.showMessageDialog(null, "UspeÅ¡no!","Info", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Dokument nije saÄ�uvan! Podrazumevano ime dokumenta je ime iz aplikacije","Upozorenje!", JOptionPane.WARNING_MESSAGE);
			}
		}else if(o instanceof Page){
			
		}
		
	}


}