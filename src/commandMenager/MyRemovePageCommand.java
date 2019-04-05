package commandMenager;

import model.Dokument;
import model.Page;

public class MyRemovePageCommand extends MyAbstractCommand {
	
	private Page stranica;
	private Dokument parent;
	private int index;
	
	
	public MyRemovePageCommand(Page s, int i) {
		stranica = s;
		parent = stranica.getParent();
		index = i;
	}
	
	@Override
	public void undo_command() {
		parent.AddStranicuOnSpecificPlace(stranica, index);
	}
	
	@Override
	public void do_command() {
		parent.RemoveStranicu(stranica);
	}

}
