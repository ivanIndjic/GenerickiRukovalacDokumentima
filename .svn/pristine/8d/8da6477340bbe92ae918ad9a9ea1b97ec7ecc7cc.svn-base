package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import actions.ShareActionListener;
import actions.SharePageListener;
import app.MyApp;
import model.Dokument;
import model.Page;
import model.Project;

public class ShareDialog {
	
	private String x;
	private String b;
	
	public void setString(String s)
	{
		x=s;
	}

	public ShareDialog()
	{
		Object o=MyApp.getInstance().getTree().getLastSelectedPathComponent();
		String g=null;
		ShareActionListener action;
		SharePageListener pageAction;
		
		 if(o instanceof Dokument){
			 Dokument p = (Dokument) o;
			 if(!p.isKopija()){
			 JFrame proj=new JFrame(MyApp.getInstance().getResourceBundle().getString("share"));
			 
				
				//Dokument p = (Dokument) o;
				Dokument d;
				action=new ShareActionListener(p, proj);
				JLabel addname = new JLabel(MyApp.getInstance().getResourceBundle().getString("shareIn"));
				JButton OKbut = new JButton(MyApp.getInstance().getResourceBundle().getString("share"));

				
				ArrayList<String> strings = new ArrayList<>();
				
				strings.add("");
				for(Project s: MyApp.getInstance().getAktivniWorkspace().getProjekte())
				{
					if(!s.getName().equals(p.getParent().getName()))
					{
						strings.add(s.getName());
					
					}
				}
				
				JComboBox setname = new JComboBox();
			//	setname.setSelectedIndex(-1);
				
				for(String s: strings)
				{
					setname.addItem(s);
				}
				
				setname.setPreferredSize(new Dimension(300,23));
				setname.addItemListener(new ItemListener() {
				      public void itemStateChanged(ItemEvent itemEvent) {
				        int state = itemEvent.getStateChange();
			/*	        System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
				        System.out.println("Item: " + itemEvent.getItem());*/
				        if(state == ItemEvent.SELECTED)
				        {
				        //	ItemSelectable is = itemEvent.getItemSelectable();
				        //System.out.println(selectedString(is));
				        //x=selectedString(is);
				        String gg;
				        action.setProjekat(itemEvent.getItem().toString());
				        x=itemEvent.getItem().toString();
				        gg=x;
				        b=gg;
				       
				        System.out.println(x);
				       // d=new Dokument(x);
				        if(x.equals(""))
				        {
				        	OKbut.setEnabled(false);
				        }
				        else
				        {
				        	OKbut.setEnabled(true);
				        }
				        }
				       // setProjekat(selectedString(is));
				      }
				    });
				
				addname.setSize(100,30);
				JPanel data = new JPanel( new BorderLayout());
				OKbut.setSize(30, 30);
				JPanel dugme = new JPanel();
				JPanel ime = new JPanel();
				JPanel setIme = new JPanel();
				ime.add(setname);
				setIme.add(addname);
				dugme.add(OKbut);
				data.add(dugme,BorderLayout.SOUTH);
				data.add(ime,BorderLayout.EAST);
				data.add(setIme,BorderLayout.WEST);
				proj.add(data);
				proj.setSize(500, 300);
			    proj.setLocationRelativeTo(null);
				proj.setVisible(true);
				
				//String x = setname.getSelectedItem().toString();
			//	System.out.println(x);
				// setString(b);
				//OKbut.addActionListener(new ShareActionListener(this.x,p,proj));
				OKbut.addActionListener(action);
			 }
			 else
			 {
				 JOptionPane.showMessageDialog(null,MyApp.getInstance().getResourceBundle().getString("alreadyCopy"),MyApp.getInstance().getResourceBundle().getString("warning"), JOptionPane.WARNING_MESSAGE);
			 }

				
				/*d.addObserver(MyApp.getInstance().getModelTree());
				d.setParent(MyApp.getInstance().getProject());//vraca aktivni projekat
				MyApp.getInstance().getProject().AddDocument(d);   */
				
			}else if(o instanceof Page)
			{
				Page p = (Page) o;
				 if(!p.isKopija()){
				 JFrame proj=new JFrame(MyApp.getInstance().getResourceBundle().getString("share"));
				 
					
					//Dokument p = (Dokument) o;
					
					pageAction=new SharePageListener(p, proj);
					JLabel addname = new JLabel(MyApp.getInstance().getResourceBundle().getString("shareIn"));
					JButton OKbut = new JButton(MyApp.getInstance().getResourceBundle().getString("share"));

					
					ArrayList<String> strings = new ArrayList<>();
					
					strings.add("");
					for(Project s: MyApp.getInstance().getAktivniWorkspace().getProjekte())
					{
						for(Dokument dd : s.getDokumente()) {
							if(!dd.getName().equals(p.getParent().getName()))
							{
								strings.add(dd.getName());
							
							}
						}
					
					}
					
					JComboBox setname = new JComboBox();
				//	setname.setSelectedIndex(-1);
					
					for(String s: strings)
					{
						setname.addItem(s);
					}
					
					setname.setPreferredSize(new Dimension(300,23));
					setname.addItemListener(new ItemListener() {
					      public void itemStateChanged(ItemEvent itemEvent) {
					        int state = itemEvent.getStateChange();
				/*	        System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
					        System.out.println("Item: " + itemEvent.getItem());*/
					        if(state == ItemEvent.SELECTED)
					        {
					        //	ItemSelectable is = itemEvent.getItemSelectable();
					        //System.out.println(selectedString(is));
					        //x=selectedString(is);
					        String gg;
					        pageAction.setProjekat(itemEvent.getItem().toString());
					        x=itemEvent.getItem().toString();
					        gg=x;
					        b=gg;
					       
					        System.out.println(x);
					       // d=new Dokument(x);
					        if(x.equals(""))
					        {
					        	OKbut.setEnabled(false);
					        }
					        else
					        {
					        	OKbut.setEnabled(true);
					        }
					        }
					       // setProjekat(selectedString(is));
					      }
					    });
					
					addname.setSize(100,30);
					JPanel data = new JPanel( new BorderLayout());
					OKbut.setSize(30, 30);
					JPanel dugme = new JPanel();
					JPanel ime = new JPanel();
					JPanel setIme = new JPanel();
					ime.add(setname);
					setIme.add(addname);
					dugme.add(OKbut);
					data.add(dugme,BorderLayout.SOUTH);
					data.add(ime,BorderLayout.EAST);
					data.add(setIme,BorderLayout.WEST);
					proj.add(data);
					proj.setSize(500, 300);
				    proj.setLocationRelativeTo(null);
					proj.setVisible(true);
					
					//String x = setname.getSelectedItem().toString();
				//	System.out.println(x);
					// setString(b);
					//OKbut.addActionListener(new ShareActionListener(this.x,p,proj));
					OKbut.addActionListener(pageAction);
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null,MyApp.getInstance().getResourceBundle().getString("alreadyCopy"),MyApp.getInstance().getResourceBundle().getString("warning"), JOptionPane.WARNING_MESSAGE);
				 }
			}		 
		 		else {
								JOptionPane.showMessageDialog(null,MyApp.getInstance().getResourceBundle().getString("cantShare"),MyApp.getInstance().getResourceBundle().getString("warning"), JOptionPane.WARNING_MESSAGE);
							}
			
				
				/*JOptionPane.showMessageDialog(null,"Nije pronaÄ‘en fajl!","Upozorenje!", JOptionPane.WARNING_MESSAGE);
			
				
				JOptionPane.showMessageDialog(null, "Dokument nije saÄ�uvan!","Upozorenje!", JOptionPane.WARNING_MESSAGE);
			*/
				// TODO Auto-generated catch block
			}

	/*static private String selectedString(ItemSelectable is) {
	    Object selected[] = is.getSelectedObjects();
	    return (String) selected[0];
	  }*/
/*	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED)
		{
			setString(e.getItem().toString());
			System.out.println(e.getItem().toString());
		}
		// TODO Auto-generated method stub
	*/	
	}


	
	

