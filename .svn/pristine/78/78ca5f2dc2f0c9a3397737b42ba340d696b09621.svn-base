package model;

import java.awt.Image;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.tree.TreeNode;

public class Element extends AbstractCollection implements TreeNode {

	private String sadrzaj;
	private Slot parent;
	
	public Slot getParent() {
		return parent;
	}

	public void setParent(Slot parent) {
		this.parent = parent;
	}

	public void AddSadrzaj(String Jtext){
		setSadrzaj(Jtext);
		setChanged();
		hasChanged();
		notifyObservers();
		
	}
	
	public void RemoveSadrzaj(String Jtext){
		setSadrzaj(Jtext);
		setChanged();
		hasChanged();
		notifyObservers();	
	}

       public Element(String sadrzaj) {
		// TODO Auto-generated constructor stub
		super();
		this.setSadrzaj(sadrzaj);
		this.setIkonica(new ImageIcon(new ImageIcon("resources/txt.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));

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
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

}
