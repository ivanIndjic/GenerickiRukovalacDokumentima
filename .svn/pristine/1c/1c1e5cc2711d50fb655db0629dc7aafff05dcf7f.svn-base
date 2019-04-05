package commandMenager;

import model.AbstractCollection;
import model.Dokument;

public class MyUpdateCommand extends MyAbstractCommand {
	
	private AbstractCollection dokument;
	private String prethodnoIme;
	
	public MyUpdateCommand(AbstractCollection d) {
		dokument = d;
		prethodnoIme = dokument.getName();
	}
	
	//mora da se napravi pre menjanja imena
	
	@Override
	public void undo_command() {
		String s = dokument.getName();
		dokument.setName(prethodnoIme);
		prethodnoIme = s;
	}
	
	@Override
	public void do_command() {
		String s = dokument.getName();
		dokument.setName(prethodnoIme);
		prethodnoIme = s;
	}

}
