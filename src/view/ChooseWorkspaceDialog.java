package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import actions.ChooseActionListener;
import app.MyApp;
import model.Workspace;

public class ChooseWorkspaceDialog extends JDialog {
	
	private JPanel panelGlavni;
	private JPanel panelLevi;
	private JPanel panelDesni;
	private JButton okButton;
	private JFrame parentFrame;
	public Workspace selektovani;
	
	
	public ChooseWorkspaceDialog(JFrame parentFrame, boolean modal) {
		super(parentFrame,MyApp.getInstance().getResourceBundle().getString("pickWorkspace"),modal);
		this.parentFrame = parentFrame;
		
		setSize(400, 150);
		setLocationRelativeTo(parentFrame);
		
		panelGlavni = new JPanel(new BorderLayout());
		panelGlavni.setSize(300,110);
		
		panelLevi = new JPanel();
		panelLevi.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label = new JLabel(MyApp.getInstance().getResourceBundle().getString("pickWorkspace"));
		panelLevi.add(label,BorderLayout.NORTH);
		
		JButton browseButton = new JButton(MyApp.getInstance().getResourceBundle().getString("browse"));
		browseButton.addActionListener(new ChooseActionListener(this, selektovani));

		panelLevi.add(browseButton,BorderLayout.SOUTH);
		
		
		panelDesni = new JPanel();
		panelDesni.setLayout(new BoxLayout(panelDesni, BoxLayout.Y_AXIS));
		panelDesni.setBackground(Color.white);
		panelDesni.setPreferredSize(new Dimension(panelGlavni.getWidth()-panelLevi.getWidth(),panelGlavni.getHeight()));
		
		JLabel labela = new JLabel(MyApp.getInstance().getResourceBundle().getString("newWorkspace"));
	    panelDesni.add(labela,BorderLayout.NORTH);
	    
	    JTextArea novi = new JTextArea("Uneti ovde...");
	    panelDesni.add(novi, BorderLayout.CENTER);
	    
	    okButton = new JButton(MyApp.getInstance().getResourceBundle().getString("create"));
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				selektovani = new Workspace(novi.getText());
				MyApp.getInstance().getListaWorkspaceova().add(selektovani);
				MyApp.getInstance().setAktivniWorkspace(selektovani);
				setVisible(false);		
				
				
				
			}
		});
		panelDesni.add(okButton);
		
	   
		
		
		//ako izadje, da skroz izadje iz programa
		addWindowListener(new WindowAdapter() {  
	        @Override
	        public void windowClosing(WindowEvent e) {  
	        	parentFrame.dispose();
	            System.exit(0);  
	        }  
	    });
		

		panelGlavni.add(panelLevi,BorderLayout.WEST);
		panelGlavni.add(panelDesni,BorderLayout.CENTER);
		
		this.add(panelGlavni);
		
		
	}
}