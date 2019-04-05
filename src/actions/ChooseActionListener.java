package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import app.MyApp;
import model.Dokument;
import model.Project;
import model.Workspace;
import view.ChooseWorkspaceDialog;

public class ChooseActionListener implements ActionListener {

	private ChooseWorkspaceDialog cwd;
	private Workspace selektovani;
	
	public ChooseActionListener(ChooseWorkspaceDialog c, Workspace w) {
		cwd = c;
		selektovani = w;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFileChooser chooser =new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		chooser.addChoosableFileFilter(new FileFilter() {
			 
		    public String getDescription() {
		        return "GeRuDok workspace (*.ws)";
		    }
		 
		    public boolean accept(File f) {
		        if (f.isDirectory()) {
		            return true;
		    		
		        } else {
		            return false;//mozda alse
		        }
		    }
		});
		chooser.setAcceptAllFileFilterUsed(false);
		
		
		if (chooser.showOpenDialog(cwd) == JFileChooser.APPROVE_OPTION) {
            File f2 = chooser.getSelectedFile();
            if(!f2.getName().toLowerCase().endsWith(".ws")) {
            	JOptionPane.showMessageDialog(null,MyApp.getInstance().getResourceBundle().getString("notWorkspace"));
            } else {
                // deserijalizacija Workspace w = f.deserialize
              //  selektovani = new Workspace("temp");//ovo dok nema serijalizacije
              //  System.out.println("selektovan workspace je " + selektovani.getName());
    			File file2;
    			if(f2!=null){
    				file2 = new File(f2.toString());
    				String naziv=f2.getName();
    				int kraj=naziv.lastIndexOf('.');
    				String naz=naziv.substring(0,kraj);
        			selektovani=new Workspace(naz);
    				System.out.println(naz);
                    cwd.selektovani = selektovani;
                    MyApp.getInstance().setAktivniWorkspace(selektovani);
					//selektovani.addObserver(MyApp.getInstance().getModelTree());

                    File[] listOfFiles=f2.listFiles();
                    
                    try {
                    	for(int i=0;i<listOfFiles.length; i++){
    						String ime=listOfFiles[i].getName();
                    		int kraj2=ime.lastIndexOf('.');
            				String naz2=ime.substring(0,kraj2);
            				Project p=new Project(naz2);

            				//MyApp.getInstance().getWorkspace().dodajProjekat(p);
    						//p.addObserver(MyApp.getInstance().getModelTree());

    						p.setParent(selektovani);
    						selektovani.dodajProjekat(p);

    						File[] listOfFiles2=listOfFiles[i].listFiles();
    						try {
    							for(int j=0;j<listOfFiles2.length;j++){
                					String ime2=listOfFiles2[j].getName();

            						Dokument d=Serialization.openDokument(new File(f2.toString()+"\\"+ime+"\\"+ime2));

            						//d.addObserver(MyApp.getInstance().getModelTree());

            						d.setParent(p);//vraca aktivni projekat
            						p.AddDocument(d); 

                					
                				}
							} catch (Exception e2) {
								// TODO: handle exception
							}
            			
    					}
    					
					} catch (Exception e2) {
						// TODO: handle exception
					}
    			
            	
      			}

    		
                cwd.setVisible(false);
                
            }
        } else {
        	JOptionPane.showMessageDialog(null,MyApp.getInstance().getResourceBundle().getString("selectWorkspace"));
			
        }
		
		
	}

}
