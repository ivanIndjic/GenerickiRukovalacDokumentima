package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.tree.TreeNode;

public class Workspace extends AbstractCollection implements TreeNode {

	private ArrayList<Project> projekti;
	
	public Workspace(String ime) {
		super();
		projekti = new ArrayList<Project>();
		this.name = ime;
		this.setIkonica(new ImageIcon(new ImageIcon("resources/workspace.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
		
	}
	
	public void dodajProjekat(Project p) {
		projekti.add(p);
		setChanged();
		hasChanged();
		notifyObservers();
		
	}
	
	public void izbrisiProjekat(Project p){
		projekti.remove(p);
		setChanged();
		hasChanged();
		notifyObservers();
	}
	
	public ArrayList<Project> getProjekte() {
		return projekti;
	}
@Override
public void notifyObservers() {
	// TODO Auto-generated method stub
	super.notifyObservers();
}

	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public TreeNode getChildAt(int i) {
		return (TreeNode) projekti.get(i);
	}


	@Override
	public int getChildCount() {
		return projekti.size();
	}


	@Override
	public int getIndex(TreeNode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isLeaf() {
		return false;
	}
	
}
