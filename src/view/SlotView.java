package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import app.MyApp;
import model.Element;
import model.Slot;

public class SlotView {
	public ArrayList<JPanel> paneli=new ArrayList<JPanel>();
	//public ArrayList<String> imena=new ArrayList<String>();	
	public JPanel SlotView2(Slot slot){
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.gray));
	
		for(Element el : slot.getElementi()){
			JTextArea jt = new JTextArea();
			jt.setEditable(false);
		
			jt.setText(el.getSadrzaj());
			jt.setPreferredSize(new Dimension(100, 100));
			jt.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					Border border = BorderFactory.createLineBorder(Color.BLACK);
					jt.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(30, 30, 30, 30))); 
					jt.setEditable(true);	
					el.setSadrzaj(jt.getText());
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub

					Border border = BorderFactory.createLineBorder(Color.YELLOW);
					jt.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(30, 30, 30, 30))); 
					jt.setEditable(true);
					jt.setLineWrap(true);
				}
			});

		
			p.add(jt);
			p.setVisible(true);
			paneli.add(p);
			//imena.add(e.getName());
			
		}
		 
		MyApp.getInstance().addToCentralPanel(p);
		return p;
	}
	
	public JPanel SlotIzgled(Slot slot){
		//JPanel p=new JPanel(new BorderLayout());
		JPanel p=new JPanel(new BorderLayout());
		p.setBackground(Color.GRAY);
		JLabel naziv=new JLabel(slot.getName());
		p.add(naziv,BorderLayout.SOUTH);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		p.setVisible(true);
		p.setSize(new Dimension(500,500));
		p.setPreferredSize(new Dimension(500,500));
		////////////////////////////////////////////////////////////////////
		for(Element el : slot.getElementi()){
			JTextArea jt = new JTextArea();
			jt.setEditable(true);
		
			jt.setText(el.getSadrzaj());
			jt.setPreferredSize(new Dimension(200, 200));
			jt.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					Border border = BorderFactory.createLineBorder(Color.BLACK);
					jt.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(30, 30, 30, 30))); 
			jt.setEditable(true);		
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub

					Border border = BorderFactory.createLineBorder(Color.YELLOW);
					jt.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(30, 30, 30, 30))); 
			jt.setEditable(true);
			jt.setLineWrap(true);

			jt.setText(jt.getText());
				}
			});

		
			p.add(jt,BorderLayout.CENTER);
			paneli.add(p);
			//imena.add(e.getName());
			
		}
		 

		////////////////////////////////////////////////////////////////////
		return p;
	}
	
	
	
	public JPanel SlotIzgledsaNazStr(Slot slot,String nazStr){
		JPanel p=new JPanel(new BorderLayout());
		
		p.setBackground(Color.WHITE);
		JLabel naziv=new JLabel("Str: "+nazStr+", Slot: "+slot.getName());
		p.add(naziv,BorderLayout.SOUTH);
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		p.setVisible(true);
		p.setSize(new Dimension(500,500));
		p.setPreferredSize(new Dimension(500,500));
		
		for(Element el : slot.getElementi()){
			JTextArea jt = new JTextArea();
			jt.setEditable(true);
		
			jt.setText(el.getSadrzaj());
			jt.setPreferredSize(new Dimension(200,200));
			jt.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					Border border = BorderFactory.createLineBorder(Color.BLACK);
					jt.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(30, 30, 30, 30))); 
			jt.setEditable(true);		
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub

					Border border = BorderFactory.createLineBorder(Color.YELLOW);
					jt.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(30, 30, 30, 30))); 
			jt.setEditable(true);
			jt.setLineWrap(true);

			jt.setText(jt.getText());
				}
			});

		
			p.add(jt,BorderLayout.CENTER);
			paneli.add(p);
		//	imena.add(e.getName());
			
		}
		 
		MyApp.getInstance().addToCentralPanel(p);
		
		return p;
	}
}

