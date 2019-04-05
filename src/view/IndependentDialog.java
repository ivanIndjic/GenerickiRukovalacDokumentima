package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.MyApp;
import model.Dokument;
import model.Project;

public class IndependentDialog extends JDialog {
	
	private JPanel panelGlavni;
	private JPanel panelLevi;
	private JPanel panelDesni;
	private JComboBox<String> comboBox;
	private JComboBox<String> availableProjects;
	
	public IndependentDialog(JFrame parentFrame, String title, boolean modal) {
		super(parentFrame,title,modal);
		setSize(450, 350);
		setLocationRelativeTo(parentFrame);
		
		panelGlavni = new JPanel(new BorderLayout());
		panelGlavni.setSize(400,300);
		
		
		panelLevi = new JPanel();
		panelLevi.setLayout(new BoxLayout(panelLevi, BoxLayout.Y_AXIS));
		panelLevi.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label = new JLabel(MyApp.getInstance().getResourceBundle().getString("freeNowDocs"));
		panelLevi.add(label);
		
		
        
		for(int i = 0 ; i < MyApp.getInstance().getSlobodniDokumenti().size() ; i++ ) {
			
			String s = MyApp.getInstance().getSlobodniDokumenti().get(i).getName();
        	JLabel l = new JLabel(s);
			panelLevi.add(l);
		}
		
		
		panelDesni = new JPanel();
		panelDesni.setLayout(new BoxLayout(panelDesni, BoxLayout.Y_AXIS));
		panelDesni.setBackground(Color.white);
		panelDesni.setPreferredSize(new Dimension(panelGlavni.getWidth()-panelLevi.getWidth(),panelGlavni.getHeight()));
		panelDesni.add(new JLabel(MyApp.getInstance().getResourceBundle().getString("uvezivanjeProjekti")));
		panelDesni.add(new JLabel(MyApp.getInstance().getResourceBundle().getString("picDocs")));
		
		JLabel labela = new JLabel(MyApp.getInstance().getResourceBundle().getString("pickedDocs"));
		
	    comboBox = new JComboBox<String>();
	    
	    
	    comboBox.addItem(MyApp.getInstance().getResourceBundle().getString("nijedan"));
		for(int i = 0 ; i < MyApp.getInstance().getSlobodniDokumenti().size() ; i++ ) {			
        	comboBox.addItem(MyApp.getInstance().getSlobodniDokumenti().get(i).getName());
		}
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
			    if (e.getStateChange() == ItemEvent.SELECTED && !comboBox.getSelectedItem().equals("Nijedan") && 
			    		!labela.getText().contains(comboBox.getSelectedItem().toString())) {
			    	
					String s = labela.getText();
					if(s.equals(MyApp.getInstance().getResourceBundle().getString("pickedDocs"))) {
						s+= comboBox.getSelectedItem();
					} else {
					    s+= "," + comboBox.getSelectedItem();
					}
					labela.setText(s);
			    
			    } 
			}
		});
		panelDesni.add(comboBox);
		
		panelDesni.add(labela);
		
		//u labelu na listener comba dodaj imena i preko nje u petlji uvezuj
		
		panelDesni.add(new JLabel(MyApp.getInstance().getResourceBundle().getString("picDocsLink")));
		
		availableProjects = new JComboBox<String>();
		for(int i = 0 ; i < MyApp.getInstance().getAktivniWorkspace().getProjekte().size() ; i++ ) {			
        	availableProjects.addItem(MyApp.getInstance().getAktivniWorkspace().getProjekte().get(i).getName());
		}
		panelDesni.add(availableProjects);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!labela.getText().equals(MyApp.getInstance().getResourceBundle().getString("pickedDocs")) && availableProjects.getSelectedIndex()!=-1) {
					String dokumenti[] = labela.getText().split(",");
					String[] parts = dokumenti[0].split(":");
					dokumenti[0] = parts[1].trim();
					
					String imeDestProjekta = availableProjects.getSelectedItem().toString();
					
					//preuzmi odradisni projekat
					Project p = null;
					for(int i = 0 ; i < MyApp.getInstance().getAktivniWorkspace().getProjekte().size() ; i++ ) {			
			        	if(MyApp.getInstance().getAktivniWorkspace().getProjekte().get(i).getName().equals(imeDestProjekta)) {
			        		p = MyApp.getInstance().getAktivniWorkspace().getProjekte().get(i);
			        		break;
			        	}
					}
					
				    //u projekat ubaci izabrane dokumente
					if(p!= null) {
						for(int j = 0 ; j < dokumenti.length ; j++) {
							for(int i = 0 ; i < MyApp.getInstance().getSlobodniDokumenti().size() ; i++ ) {			
								if(MyApp.getInstance().getSlobodniDokumenti().get(i).getName().equals(dokumenti[j])) {
									p.AddDocument(MyApp.getInstance().getSlobodniDokumenti().get(i));
									MyApp.getInstance().getSlobodniDokumenti().remove(i);
								}
							}
						}
					}
					
				} else {
					
				}
				
				setVisible(false);
			}
		});
		
		panelDesni.add(okButton);
		
		panelGlavni.add(panelLevi,BorderLayout.WEST);
		panelGlavni.add(panelDesni,BorderLayout.CENTER);
		
		this.add(panelGlavni);
		
	}

}
