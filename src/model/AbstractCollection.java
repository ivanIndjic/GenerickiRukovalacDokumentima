package model;


import java.io.Serializable;
import java.util.Observable;

import javax.swing.ImageIcon;

public abstract class AbstractCollection extends Observable implements Serializable  {

	protected String name;
	protected ImageIcon ikonica;

	public String getName() {
		return name;
	}
	
	/*public void update() {
		setChanged();
		hasChanged();
		notifyObservers();
	}*/
	

	public void setName(String name) {
		this.name = name;
		setChanged();
		hasChanged();
		notifyObservers();
	}

	public ImageIcon getIkonica() {
		return ikonica;
	}

	public void setIkonica(ImageIcon ikonica) {
		this.ikonica = ikonica;
	}

	public void add() {
		
	}
	
	public void remove() {
		
	}
	
	
	

}
