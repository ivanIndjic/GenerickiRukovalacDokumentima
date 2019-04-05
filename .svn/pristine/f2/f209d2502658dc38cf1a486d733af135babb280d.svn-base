package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import app.MyApp;
import commandMenager.MyAddSlotCommand;
import model.Dokument;
import model.Page;
import model.Slot;

public class MoreSlotsWindoww  {
  public MoreSlotsWindoww(){
	 Object o=MyApp.getInstance().getTree().getLastSelectedPathComponent();
	 Page p=(Page) o;
	JFrame slot = new JFrame(MyApp.getInstance().getResourceBundle().getString("collectionSlots"));
	JLabel addname = new JLabel(MyApp.getInstance().getResourceBundle().getString("numSlots"));
	JTextArea setname = new JTextArea();
	JPanel p1=new JPanel(new FlowLayout());
	p1.add(addname);
	p1.add(setname);
	setname.setPreferredSize(new Dimension(300,23));
	addname.setSize(100,30);

	JButton OKbut = new JButton("Ok");
	JPanel dugme=new JPanel(new FlowLayout());
	dugme.add(OKbut);
	OKbut.setSize(30, 30);
	
	slot.add(p1,BorderLayout.NORTH);
	slot.add(dugme, BorderLayout.SOUTH);
	slot.setSize(500, 300);
    slot.setLocationRelativeTo(null);
	slot.setVisible(true);
	
	OKbut.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	
	if(setname.getText().isEmpty()){
		JOptionPane.showMessageDialog(null, MyApp.getInstance().getResourceBundle().getString("mustNum"),MyApp.getInstance().getResourceBundle().getString("info"), JOptionPane.INFORMATION_MESSAGE);	
		
	}else{
		try {
			
			
			int broj=Integer.parseInt(setname.getText());
			slot.setVisible(false);
			JFrame slots = new JFrame(MyApp.getInstance().getResourceBundle().getString("collectionSlots"));
			slots.setVisible(true);
		//////////////////////////////////////////////////////////////////////////////
			JPanel ppp=new JPanel();
			BoxLayout box= new BoxLayout(ppp, BoxLayout.Y_AXIS);
			ppp.setLayout(box);
			JScrollPane scrollPane = new JScrollPane(ppp,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBorder(BorderFactory.createLineBorder(Color.gray));
			slots.setSize(500, 300);
			slots.setLocationRelativeTo(null);
			slots.setVisible(true);
			
			
			JTextField[] jtf=new JTextField[broj];
			for(int i=0;i<broj;i++){
				JPanel pp=new JPanel(new FlowLayout());
				pp.add(new JLabel("Slot"+" "+(i+1)));
				jtf[i]=new JTextField();
				jtf[i].setSize(90,15);
				jtf[i].setPreferredSize(new Dimension(120, 30));
				pp.add(jtf[i]);
				ppp.add(pp);
				slots.add(scrollPane);

			}
			
			JButton ok=new JButton("OK");
			ppp.add(ok);
			ok.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Object o=MyApp.getInstance().getTree().getLastSelectedPathComponent();
				
					MyAddSlotCommand komanda = new MyAddSlotCommand();//ovo 
					if(o instanceof Page){
						for(int j=0;j<broj;j++){

							Slot slot=new Slot(jtf[j].getText());
							slot.addObserver(MyApp.getInstance().getModelTree());
							slot.setParent(MyApp.getInstance().getPage());
							MyApp.getInstance().getPage().AddSlot(slot);
							komanda.addSlot(slot); //ovo 
							
						}
					    if(!((Page) o).isKopija()){//ovo
						   Dokument dok = (Dokument)((Page) o).getParent();
						   dok.getKomandMenadzer().dodajKomandu(komanda);
						}
						
					}
					else{
					for(int j=0;j<broj;j++){

						Slot slot=new Slot(jtf[j].getText());
						slot.addObserver(MyApp.getInstance().getModelTree());
						slot.setParent(p);
						p.AddSlot(slot);   
						
					}	
					}
					slots.setVisible(false);
				}
			});


			////////////////////////////////////////////////////////////////////////

		} catch (Exception e1) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, MyApp.getInstance().getResourceBundle().getString("mustNum"),MyApp.getInstance().getResourceBundle().getString("info"), JOptionPane.INFORMATION_MESSAGE);
		}finally{}
	}
		}
});
	
}
  }
