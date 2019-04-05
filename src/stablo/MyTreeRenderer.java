package stablo;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Dokument;
import model.Page;
import model.Project;
import model.Slot;
import model.Workspace;

public class MyTreeRenderer extends DefaultTreeCellRenderer {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyTreeRenderer() {
		
	}
	
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,int row, boolean hasFocus) {
		
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		// Podesavanje teksta i ikonice cvora koji se iscrtava
		if (value instanceof Workspace) {
			Workspace workspace = (Workspace) value;
			setText(workspace.getName());
			setIcon(workspace.getIkonica());
		} else if (value instanceof Project) {
			Project project = (Project) value;
			setText(project.getName());
			setIcon(project.getIkonica());
		} else if (value instanceof Dokument) {
			Dokument document = (Dokument) value;
			setText(document.getName());
			setIcon(document.getIkonica());
		} else if (value instanceof Page) {
			Page page = (Page) value;
			setText(page.getName());
			setIcon(page.getIkonica());
		}else if (value instanceof Slot) {
			Slot slot = (Slot) value;
			setText(slot.getName());
			setIcon(slot.getIkonica());
		}
		
		
		return this;
	}
	
	

}
