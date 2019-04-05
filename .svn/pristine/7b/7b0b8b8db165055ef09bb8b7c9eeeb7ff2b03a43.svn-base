package commandMenager;

import model.Page;
import model.Slot;

public class MyRemoveSlotCommand extends MyAbstractCommand {
	

	private Slot slot;
	private Page parent;
	
	public MyRemoveSlotCommand(Slot s) {
		slot = s;
		parent = slot.getParent();
	}
	
	
	@Override
	public void undo_command() {
		parent.AddSlot(slot);
	}
	
	@Override
	public void do_command() {
		parent.RemoveSlot(slot);
	}

}
