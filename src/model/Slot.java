package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.tree.TreeNode;

public class Slot extends AbstractCollection implements TreeNode {

	private ArrayList<Element> elementi;
	private Page parent;
	
	public Page getParent() {
		return parent;
	}

	public void setParent(Page parent) {
		this.parent = parent;
	}
	
	public ArrayList<Element> getElementi() {
		return elementi;
	}
	

	public void AddElement(Element e){
		elementi.add(e);
		setChanged();
		hasChanged();
		notifyObservers();
		
	}
	
	public void RemoveElement(Element e){
		elementi.remove(e);
		setChanged();
		hasChanged();
		notifyObservers();	
	}

	public Slot(String ime) {
		super();
		elementi = new ArrayList<Element>();
		this.name = ime;
		this.setIkonica(new ImageIcon(new ImageIcon("resources/slot.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));

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
		return elementi.size();
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

}
