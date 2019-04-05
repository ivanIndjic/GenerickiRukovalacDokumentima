package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import app.MyApp;
import commandMenager.MyAddPageCommand;
import model.Dokument;
import model.Page;
import model.Slot;
	
public class PageWindow {
	public int duzd;
	public int brslotd;
	public int pozicija;
	public boolean horizontalno;
	public int brStr;
	public PageWindow(){
	JFrame proj = new JFrame(MyApp.getInstance().getResourceBundle().getString("page"));
	JPanel naziv=new JPanel(new BorderLayout());

	JLabel addname = new JLabel(MyApp.getInstance().getResourceBundle().getString("namePage"));
	JTextField setname = new JTextField();
	setname.setPreferredSize(new Dimension(280,25));
	naziv.add(addname,BorderLayout.WEST);
	naziv.add(setname,BorderLayout.EAST);
	
	JPanel data = new JPanel( new BorderLayout());
	JButton OKbut = new JButton(MyApp.getInstance().getResourceBundle().getString("add"));
    
	OKbut.setSize(30, 30);
	JPanel dugme = new JPanel();
	dugme.add(OKbut);
	
	
	JPanel velicina1=new JPanel(new BorderLayout());
	JLabel vel1=new JLabel(MyApp.getInstance().getResourceBundle().getString("lengthPage"));
	JTextField duz = new JTextField();
	duz.setPreferredSize(new Dimension(280, 25));
	velicina1.add(vel1,BorderLayout.WEST);
	velicina1.add(duz,BorderLayout.EAST);
	JPanel velicina=new JPanel(new BorderLayout());
	velicina.add(velicina1,BorderLayout.CENTER);
	
	JPanel brSlotova=new JPanel(new BorderLayout());
	JLabel brSlotl=new JLabel(MyApp.getInstance().getResourceBundle().getString("slotsPage"));
	JTextField brslott = new JTextField();
	brslott.setPreferredSize(new Dimension(280, 25));
	brSlotova.add(brSlotl,BorderLayout.WEST);
	brSlotova.add(brslott,BorderLayout.EAST);
	
	JPanel poz=new JPanel(new BorderLayout());
	JLabel pozl=new JLabel(MyApp.getInstance().getResourceBundle().getString("positionPage"));
	JTextField poza = new JTextField();
	poza.setPreferredSize(new Dimension(280,25));

	poz.add(pozl,BorderLayout.WEST);
	poz.add(poza,BorderLayout.EAST);
	JPanel merge=new JPanel(new BorderLayout());
	merge.add(velicina,BorderLayout.NORTH);
	merge.add(poz,BorderLayout.CENTER);
	merge.add(brSlotova,BorderLayout.SOUTH);
	
	JLabel put = new JLabel(MyApp.getInstance().getResourceBundle().getString("nacin"));
	JRadioButton hor=new JRadioButton(MyApp.getInstance().getResourceBundle().getString("horizontalno"));
	JRadioButton ver=new JRadioButton(MyApp.getInstance().getResourceBundle().getString("vertikalno"));
	JPanel batni=new JPanel(new BorderLayout());
	batni.add(put,BorderLayout.WEST);
	batni.add(hor,BorderLayout.CENTER);
	batni.add(ver,BorderLayout.EAST);
	ButtonGroup bg=new ButtonGroup();
	bg.add(hor);
	bg.add(ver);

	JPanel medjuu=new JPanel();
	medjuu.add(merge,BorderLayout.NORTH);
	medjuu.add(batni,BorderLayout.SOUTH);
	

	data.add(naziv,BorderLayout.NORTH);
	data.add(medjuu,BorderLayout.CENTER);
	data.add(dugme,BorderLayout.SOUTH);

	proj.add(data);
	proj.setSize(500, 300);
    proj.setLocationRelativeTo(null);
	proj.setVisible(true);
	OKbut.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				duzd=Integer.parseInt(duz.getText());
				brslotd=Integer.parseInt(brslott.getText());
				pozicija=Integer.parseInt(poza.getText());
				
				if(duzd==0 || pozicija==0 || brslotd==0){		
					JOptionPane.showMessageDialog(null, MyApp.getInstance().getResourceBundle().getString("cantZero"),MyApp.getInstance().getResourceBundle().getString("info"), JOptionPane.INFORMATION_MESSAGE);	
				}else{

					String ime = setname.getText();
					if(ime.equals("")){
						JOptionPane.showMessageDialog(proj, MyApp.getInstance().getResourceBundle().getString("mustName"));
		   		
					}
					else{
						
						if(ver.isSelected()){
							horizontalno=false;
						}else{
							horizontalno=true; //po defaultu je hor
						}
						Page p = new Page(ime,duzd,brslotd,pozicija,horizontalno);
						p.addObserver(MyApp.getInstance().getModelTree());
						p.setParent(MyApp.getInstance().getDokument());//vraca aktivni projekat
						
						Dokument d=p.getParent();
						brStr=d.getStranice().size();
						
						if(pozicija>brStr+1){
							JOptionPane.showMessageDialog(null, MyApp.getInstance().getResourceBundle().getString("numPinD")+brStr+MyApp.getInstance().getResourceBundle().getString("biggest")+(brStr+1),MyApp.getInstance().getResourceBundle().getString("info"), JOptionPane.INFORMATION_MESSAGE);	
							
						}else{
						
							MyApp.getInstance().getDokument().AddStranicuOnSpecificPlace(p,pozicija); 
							d.getKomandMenadzer().dodajKomandu(new MyAddPageCommand(p, pozicija));/////////////////////////////
							//MyApp.getInstance().getDokument().AddStranicu(p); 

					
						try {		
							proj.setVisible(false);
							
							JFrame slots = new JFrame(MyApp.getInstance().getResourceBundle().getString("collectionSlots"));
							slots.setVisible(true);
							/////////////////////////////////////////////////////// kopirano je iz MoreSlotsWindow jer to vraca scrollPane i onda nzm kako da izgasim frame na ok dugme
							JPanel ppp=new JPanel();
							BoxLayout box= new BoxLayout(ppp, BoxLayout.Y_AXIS);
							ppp.setLayout(box);
							JScrollPane scrollPane = new JScrollPane(ppp,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
							scrollPane.setBorder(BorderFactory.createLineBorder(Color.gray));
							slots.setSize(500, 300);
							slots.setLocationRelativeTo(null);
							slots.setVisible(true);
							
							
							JTextField[] jtf=new JTextField[brslotd];
							for(int i=0;i<brslotd;i++){
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
									if(o instanceof Page){
										for(int j=0;j<brslotd;j++){

											Slot slot=new Slot(jtf[j].getText());
											slot.addObserver(MyApp.getInstance().getModelTree());
											slot.setParent(MyApp.getInstance().getPage());
											MyApp.getInstance().getPage().AddSlot(slot);	   
											
										}
									}
									else{
									for(int j=0;j<brslotd;j++){

										Slot slot=new Slot(jtf[j].getText());
										slot.addObserver(MyApp.getInstance().getModelTree());
										slot.setParent(p);
										p.AddSlot(slot);   
										
									}	
									}
									slots.setVisible(false);
								}
							});

							//////////////////////////////////////////////////////							

						} catch (Exception e1) {
						// TODO: handle exception
						}finally{}
						
						}
				}
			}
			} catch (Exception e1) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, MyApp.getInstance().getResourceBundle().getString("moraBr"),MyApp.getInstance().getResourceBundle().getString("info"), JOptionPane.INFORMATION_MESSAGE);	
			}
			
			
		}
	});

}

}