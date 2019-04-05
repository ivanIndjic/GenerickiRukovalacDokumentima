package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.tree.TreeNode;

public class Project extends AbstractCollection implements TreeNode {
	
	private ArrayList<Dokument> dokumenti;
	private Workspace parent;
	
	public Project(String ime) {
		super();
		dokumenti = new ArrayList<Dokument>();
		this.name = ime;
		this.setIkonica(new ImageIcon(new ImageIcon("resources/project.png").getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));

	}
	
	public ArrayList<Dokument> getDokumente() {
		return dokumenti;
	}


	public Workspace getParent() {
		return parent;
	}


	public void AddDocument(Dokument d){
		dokumenti.add(d);
		setChanged();
		hasChanged();
		notifyObservers();
		
	}
	
	public void RemoveDocument(Dokument d){
		dokumenti.remove(d);
		setChanged();
		hasChanged();
		notifyObservers();
	}
	
	public void setParent(Workspace parent) {
		this.parent = parent;
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
		return (TreeNode) dokumenti.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return dokumenti.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}
	
	
	//mozda nece zbog parent istog naziva

}
