package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.tree.TreeNode;

import commandMenager.MyCommandMenager;

public class Dokument extends AbstractCollection implements TreeNode {
	
	private ArrayList<Page> stranice;
	private Project parent;
	private boolean kopija;
	private ArrayList<String> deljenUnutar;
	private int brojac;
	
	private MyCommandMenager komandMenadzer;
	
	public MyCommandMenager getKomandMenadzer() {
		return komandMenadzer;
	}

	public void setKomandMenadzer(MyCommandMenager komandMenadzer) {
		this.komandMenadzer = komandMenadzer;
	}

	public Project getParent() {
		return parent;
	}
	
	public boolean isKopija() {
		return kopija;
	}

	public void setParent(Project parent) {
		this.parent = parent;
	}
	
	public ArrayList<Page> getStranice() {
		return stranice;
	}
	
	public ArrayList<String> getDeljenUnutar() {
		return deljenUnutar;
	}
    
	public void AddStranicu(Page p){
		stranice.add(p);
		setChanged();
		hasChanged();
		notifyObservers();
		
	}
	
	public void AddStranicuOnSpecificPlace(Page p,int pozicija){
		
		stranice.add((pozicija-1),p);
		setChanged();
		hasChanged();
		notifyObservers();

	}
	
	public Dokument(String ime) {
		super();
		stranice = new ArrayList<Page>();
		deljenUnutar = new ArrayList<String>();
		this.kopija=false;
		this.name = ime;
		this.setIkonica(new ImageIcon(new ImageIcon("resources/ikonica.jpg").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
		komandMenadzer = new MyCommandMenager();
	}
	
	
	
	public Dokument(String ime, boolean k) {
		super();
		stranice = new ArrayList<Page>();
		deljenUnutar = new ArrayList<String>();
		
		this.name = ime;
		this.kopija=k;
		this.setIkonica(new ImageIcon(new ImageIcon("resources/ikonica.jpg").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));

	}
	
	public void RemoveStranicu(Page p){
		stranice.remove(p);
		setChanged();
		hasChanged();
		notifyObservers();	
	}

	@Override
	public Enumeration children() {
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return (TreeNode) stranice.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return stranice.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		super.notifyObservers();
	}

	public int getBrojac() {
		return brojac;
	}

	public void setBrojac(int brojac) {
		this.brojac = brojac;
	}
	

}
