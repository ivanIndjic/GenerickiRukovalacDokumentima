package commandMenager;

import java.io.Serializable;
import java.util.ArrayList;

import actions.ActionManager;

public class MyCommandMenager implements Serializable{
	
	private ArrayList<MyAbstractCommand> izvrseneKomande;
	private ArrayList<MyAbstractCommand> redoLista;
	
	public MyCommandMenager() {
		izvrseneKomande = new ArrayList<MyAbstractCommand>();
		redoLista = new ArrayList<MyAbstractCommand>();
	}
	
	public void dodajKomandu(MyAbstractCommand komanda) { 
		izvrseneKomande.add(komanda);
	}
	
	public ArrayList<MyAbstractCommand> getIzvrseneKomande() {
		return izvrseneKomande;
	}
	
	public ArrayList<MyAbstractCommand> getRedoLista() {
		return redoLista;
	}
	
	
	
	public void undo() {
		
		MyAbstractCommand poslednjaKomanda = izvrseneKomande.get(izvrseneKomande.size()-1);
		izvrseneKomande.remove(poslednjaKomanda);
		poslednjaKomanda.undo_command();
		redoLista.add(poslednjaKomanda);
		
		if(izvrseneKomande.size() == 0) {
			ActionManager.getInstance().getUndoAction().setEnabled(false);
		}
		ActionManager.getInstance().getRedoAction().setEnabled(true);
		
	}
	
	public void redo() {
		MyAbstractCommand poslednjaKomanda = redoLista.get(redoLista.size()-1);
		redoLista.remove(poslednjaKomanda);
		poslednjaKomanda.do_command();
		izvrseneKomande.add(poslednjaKomanda);
		
		if(redoLista.size() == 0) {
			ActionManager.getInstance().getRedoAction().setEnabled(false);
		}
		ActionManager.getInstance().getUndoAction().setEnabled(true);
		
	}
	

}
