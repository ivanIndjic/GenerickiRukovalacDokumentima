package commandMenager;

import model.Dokument;
import model.Page;

public class MyAddPageCommand extends MyAbstractCommand {
	
	private Page stranica;
	private Dokument parent; //zato sto kad se uradi remove, parentu vise nece moci da se pristupi za redo
	private int index;
	
	public MyAddPageCommand(Page s, int i) {
		stranica = s;
		parent = stranica.getParent();
		index = i;
	}
	
	@Override
	public void undo_command() {
		parent.RemoveStranicu(stranica);
	}
	
	@Override
	public void do_command() {
		parent.AddStranicuOnSpecificPlace(stranica, index);
	}

}
