package stablo;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import model.Dokument;
import model.Page;
import model.Project;
import model.Slot;
import model.Workspace;

public class MyTreeModel extends DefaultTreeModel implements Observer {
	
	private Workspace root;
	private JTree treeComponent;
	
	public MyTreeModel(Workspace r, JTree tree) {
		super(r);
		root = r;
		treeComponent = tree;
		treeComponent.setCellRenderer(new MyTreeRenderer()); //ovde povezan sa rendererom
	}

	@Override
	public void addTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getChild(Object parent, int i) {
		if (parent instanceof Workspace) {
			return ((Workspace) parent).getProjekte().get(i);
		} 
		else if (parent instanceof Project) {
			return ((Project) parent).getDokumente().get(i);
		}
		else if(parent instanceof Dokument){
			return ((Dokument) parent).getStranice().get(i);
			
		} 
		else if(parent instanceof Page){
			return ((Page) parent).getSlotovi().get(i);
		}
		else if(parent instanceof Slot){
			return ((Slot) parent).getElementi().get(i);
		}
		
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		if (parent instanceof Workspace) {
			return ((Workspace) parent).getChildCount();
		} 
		else if (parent instanceof Project) {
			return ((Project) parent).getChildCount();
		}
		else if(parent instanceof Dokument){
			return ((Dokument) parent).getChildCount();
			
		} 
		else if(parent instanceof Page){
			return ((Page) parent).getChildCount();
		}	
		else if(parent instanceof Slot){
			return ((Slot) parent).getChildCount();
		}
		
		return 0;
	}

	@Override
	public int getIndexOfChild(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public boolean isLeaf(Object node) {
		if (node instanceof Slot)
			return true;
		return false;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueForPathChanged(TreePath arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		SwingUtilities.updateComponentTreeUI(treeComponent);
	}

	

}
