package commandMenager;

import java.util.ArrayList;

import model.Page;
import model.Slot;

public class MyAddSlotCommand extends MyAbstractCommand {
	
	private ArrayList<Slot> slotovi;
	private ArrayList<Page> parenti;

	
	public MyAddSlotCommand() {
	    slotovi = new ArrayList<Slot>();
	    parenti = new ArrayList<Page>();
	}
	
	public void addSlot(Slot s) {
		slotovi.add(s);
		parenti.add(s.getParent());
	}
	
	
	@Override
	public void undo_command() {
		for(int i = 0 ; i < slotovi.size() ; i++) {
			Page parent = parenti.get(parenti.size()-i-1);
			Slot slot = slotovi.get(parenti.size()-i-1);
			parent.RemoveSlot(slot);
		}
	}
	
	@Override
	public void do_command() {
		
		for(int i = 0 ; i < slotovi.size() ; i++) {
			Page parent = parenti.get(i);
			Slot slot = slotovi.get(i);
			parent.AddSlot(slot);
			
		}
	}

}
