package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.MyApp;
import model.Dokument;

public class RecentlyUsedDialog extends JDialog {
	
	private JPanel panelGlavni;
	private JPanel panelLevi;
	private JPanel panelDesni;
	private JPanel panelDonji;
	private JButton okButton;
	private JButton cancelButton;
	private ArrayList<Dokument> recentlyUsed;
	
	public RecentlyUsedDialog(JFrame parentFrame, boolean modal) {
		super(parentFrame,MyApp.getInstance().getResourceBundle().getString("recentlyUsed"),modal);
		setSize(400, 300);
		setLocationRelativeTo(parentFrame);

		panelGlavni = new JPanel(new BorderLayout());
		panelGlavni.setSize(400,300);
		
		panelLevi = new JPanel();
		panelLevi.setLayout(new BoxLayout(panelLevi, BoxLayout.Y_AXIS));
		panelLevi.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label = new JLabel(MyApp.getInstance().getResourceBundle().getString("five"));
		panelLevi.add(label);
		
		panelDesni = new JPanel();
		panelDesni.setLayout(new BoxLayout(panelDesni, BoxLayout.Y_AXIS));
		panelDesni.setBackground(Color.white);
		panelDesni.setPreferredSize(new Dimension(panelGlavni.getWidth()-panelLevi.getWidth(),panelGlavni.getHeight()));
		
		recentlyUsed = MyApp.getInstance().getNedavnoKorisceni();
		int duzina = recentlyUsed.size();
		int brojac = 1;
		
		while(brojac<6 && (duzina-brojac)>=0) {
			String s = recentlyUsed.get(duzina-brojac).getName();
			JLabel l = new JLabel(s);
			//JButton b = new JButton(s);
			//b.setPreferredSize(new Dimension(120,10)); 
			panelDesni.add(l);
			brojac++;	
		}
		
		panelDonji = new JPanel(new FlowLayout());
		okButton = new JButton("OK");
		//okButton.addActionListener(nekimoj);
		panelDonji.add(okButton);
		cancelButton = new JButton("Cancel");
		//cancelButton.addActionListener(this.close otp);
		panelDonji.add(cancelButton);
		
		panelGlavni.add(panelDonji,BorderLayout.SOUTH);
		panelGlavni.add(panelLevi,BorderLayout.WEST);
		panelGlavni.add(panelDesni,BorderLayout.CENTER);
		
		this.add(panelGlavni);
		
		
	}
}