package actions;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import app.MyApp;

public class HelpAction extends JFrame{

	public HelpAction(){
	
	JFrame glavni = new JFrame("Pomoc");
	JPanel text = new JPanel(new BorderLayout());
	JLabel jl = new JLabel();
	JTextArea jta = new JTextArea();
	jta.setText( MyApp.getInstance().getResourceBundle().getString("helpAction"));
	jta.setWrapStyleWord(true);
	jta.setEditable(false);
	JPanel panel = new JPanel();
	JButton ok = new JButton("Ok");
ok.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		glavni.setVisible(false);
	}
});
	panel.add(ok);
	
	text.add(jta,BorderLayout.NORTH);
	text.add(panel,BorderLayout.SOUTH);
	
	text.setSize(500, 50);
glavni.setSize(940, 190);
	glavni.add(text);
	
	glavni.setVisible(true);
	glavni.setLocationRelativeTo(null);
}
	
}
