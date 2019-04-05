package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.tree.TreeNode;

public class Page extends AbstractCollection implements TreeNode {
	
	private ArrayList<Slot> slotovi;
	private Dokument parent;
	private int duz;
	private int brSlotova;
	private int pozicija;
	private ArrayList<String> deljenUnutar;
	private boolean kopija;
	private boolean horizontalno;
	public Dokument getParent() {
		return parent;
	}

	public void setParent(Dokument parent) {
		this.parent = parent;
	}
	
	public ArrayList<Slot> getSlotovi() {
		return slotovi;
	}
	
	public boolean isKopija()
	{
		return kopija;
	}
	
	public ArrayList<String> getDeljenUnutar() {
		return deljenUnutar;
	}

	public Page(String ime,int duz,int brSlotova,int pozicija,boolean horizontalno) {
		super();
		slotovi = new ArrayList<Slot>();
		deljenUnutar = new ArrayList<String>();
		this.kopija=false;
		this.name = ime;
		this.duz=duz;
		this.brSlotova=brSlotova;
		this.pozicija=pozicija;
		this.horizontalno=horizontalno;
		this.setIkonica(new ImageIcon(new ImageIcon("resources/page.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));

	}
	
	public Page(String ime,int duz,int brSlotova,int pozicija,boolean horizontalno, boolean k) {
		super();
		slotovi = new ArrayList<Slot>();
		deljenUnutar = new ArrayList<String>();
		this.kopija=k;
		this.name = ime;
		this.duz=duz;
		this.brSlotova=brSlotova;
		this.pozicija=pozicija;
		this.horizontalno=horizontalno;
		this.setIkonica(new ImageIcon(new ImageIcon("resources/page.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));

	}


	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return null;
	}

	@Override
	public int getChildCount() {
		return slotovi.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void RemoveSlot(Slot s){
		slotovi.remove(s);
		setChanged();
		hasChanged();
		notifyObservers();	
	}
	
	
	public void AddSlot(Slot s){
		slotovi.add(s);
		setChanged();
		hasChanged();
		notifyObservers();
		
	}
	
	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		super.notifyObservers();
	}

	public int getDuz() {
		return duz;
	}

	public void setDuz(int duz) {
		this.duz = duz;
	}
	
	public int getBrSlotova() {
		return brSlotova;
	}

	public void setBrSlotova(int brSlotova) {
		this.brSlotova = brSlotova;
	}

	public int getPozicija() {
		return pozicija;
	}

	public void setPozicija(int pozicija) {
		this.pozicija = pozicija;
	}

	public boolean isHorizontalno() {
		return horizontalno;
	}

	public void setHorizontalno(boolean horizontalno) {
		this.horizontalno = horizontalno;
	}

	//mozda is leaph alse

}
