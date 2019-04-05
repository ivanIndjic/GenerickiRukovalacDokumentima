package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import app.MyApp;
import model.Page;
import model.Slot;

public class PageView extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public void initPageView(Page p){
		
		
		this.setLayout(new BorderLayout()); //postavljen layout
		this.setSize(new Dimension(500,p.getDuz()));
		this.setPreferredSize(new Dimension(500,p.getDuz()));
		this.setBackground(Color.WHITE);
		this.setBounds(10, 10, 200, 400);
		if(p.isHorizontalno()){
			this.setLayout(new  BoxLayout(this, BoxLayout.X_AXIS));
			for(int i=0;i<p.getSlotovi().size();i++){
				if(i==0){
				SlotView sw=new SlotView();
				//Slot s=new Slot(p.getSlotovi().get(i).getName());
				this.add(sw.SlotIzgledsaNazStr(p.getSlotovi().get(i),p.getName()));
				}else{
					SlotView sw=new SlotView();
					//Slot s=new Slot(p.getSlotovi().get(i).getName());
					this.add(sw.SlotIzgled(p.getSlotovi().get(i)));
					
				}
				
			}

		}else{
			this.setLayout(new  BoxLayout(this, BoxLayout.Y_AXIS));
			for(int i=0;i<p.getSlotovi().size();i++){
				if(i==0){
				SlotView sw=new SlotView();
				//Slot s=new Slot(p.getSlotovi().get(i).getName());
				this.add(sw.SlotIzgledsaNazStr(p.getSlotovi().get(i),p.getName()));
				}else{
					SlotView sw=new SlotView();
					//Slot s=new Slot(p.getSlotovi().get(i).getName());
					this.add(sw.SlotIzgled(p.getSlotovi().get(i)));
					
				}
		}
			}
	
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	
		MyApp.getInstance().addToCentralPanel(this);
		
	}
	public JPanel Strizgled(Page str) {
		
		JPanel stranica=new JPanel();
		stranica.setSize(new Dimension(500,str.getDuz()));
		stranica.setPreferredSize(new Dimension(500,str.getDuz()));
		stranica.setBackground(Color.WHITE);
		stranica.setBorder(BorderFactory.createLineBorder(Color.black));
		stranica.setBounds(10, 10, 200, 400);
	
		if(str.isHorizontalno()){
			stranica.setLayout(new  BoxLayout(stranica, BoxLayout.X_AXIS));
			for(int i=0;i<str.getSlotovi().size();i++){
				if(i==0){
				SlotView sw=new SlotView();
				Slot s=new Slot(str.getSlotovi().get(i).getName());
				stranica.add(sw.SlotIzgledsaNazStr(s,str.getName()));
				}else{
					SlotView sw=new SlotView();
					Slot s=new Slot(str.getSlotovi().get(i).getName());
					stranica.add(sw.SlotIzgled(s));
					
				}
				
			}

		}else{
			stranica.setLayout(new  BoxLayout(stranica, BoxLayout.Y_AXIS));
			for(int i=0;i<str.getSlotovi().size();i++){
				if(i==0){
				SlotView sw=new SlotView();
				Slot s=new Slot(str.getSlotovi().get(i).getName());
				stranica.add(sw.SlotIzgledsaNazStr(s,str.getName()));
				}else{
					SlotView sw=new SlotView();
					Slot s=new Slot(str.getSlotovi().get(i).getName());
					stranica.add(sw.SlotIzgled(s));
					
				}
				
			}
		}
		return stranica;


	}
	
}
