package stablo;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import actions.ActionManager;
import app.MyApp;
import model.Dokument;
import model.Page;
import model.Project;
import model.Slot;
import model.Workspace;
import view.DokumentView;
import view.PageView;
import view.ProjectView;
import view.SlotView;

public class MySelectionListener implements TreeSelectionListener {

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		JTree tree = (JTree) e.getSource();
		Object selectedNode = tree.getLastSelectedPathComponent();

		//enable mogucih akcija
		if (selectedNode instanceof Workspace) {

			ActionManager.getInstance().getProjectAction().setEnabled(true);
			ActionManager.getInstance().getDocumentAction().setEnabled(false);
			ActionManager.getInstance().getPageAction().setEnabled(false);
			ActionManager.getInstance().getSaveAction().setEnabled(true);
			ActionManager.getInstance().getRemoveAction().setEnabled(true);
			ActionManager.getInstance().getMoreSlotsAction().setEnabled(false);
			ActionManager.getInstance().getElementAction().setEnabled(false);
			ActionManager.getInstance().getUndoAction().setEnabled(false);
			ActionManager.getInstance().getRedoAction().setEnabled(false);
			MyApp.getInstance().addToCentralPanelTab(new JTabbedPane());

		} else if (selectedNode instanceof Project) {
	
			ProjectView pw=new ProjectView((Project) selectedNode);
			ActionManager.getInstance().getProjectAction().setEnabled(false);
			ActionManager.getInstance().getDocumentAction().setEnabled(true);
			ActionManager.getInstance().getPageAction().setEnabled(false);
			ActionManager.getInstance().getSaveAction().setEnabled(true);
			ActionManager.getInstance().getChangeAction().setEnabled(true);
			ActionManager.getInstance().getRemoveAction().setEnabled(true);
			ActionManager.getInstance().getMoreSlotsAction().setEnabled(false);
			ActionManager.getInstance().getElementAction().setEnabled(false);
			ActionManager.getInstance().getUndoAction().setEnabled(false);
			ActionManager.getInstance().getRedoAction().setEnabled(false);
		}

		else if (selectedNode instanceof Dokument) {
			MyApp.getInstance().AddDok((Dokument)selectedNode);
			DokumentView dw=new DokumentView();
			Dokument d = (Dokument)selectedNode;			
			try {
				int tempBrojac;
				Project p =d.getParent();
				for(int i=0;i<p.getDokumente().size();i++){
					if(p.getDokumente().get(i).getName().equals(d.getName())){
						tempBrojac=p.getDokumente().get(i).getBrojac();
						p.getDokumente().get(i).setBrojac(tempBrojac+1);
					}
					
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}finally{
				
			}
			
			dw.initDokumentView((Dokument) selectedNode);
			ActionManager.getInstance().getProjectAction().setEnabled(false);
			ActionManager.getInstance().getDocumentAction().setEnabled(false);
			ActionManager.getInstance().getPageAction().setEnabled(true);
			ActionManager.getInstance().getSaveAction().setEnabled(true);
			ActionManager.getInstance().getChangeAction().setEnabled(true);
			ActionManager.getInstance().getRemoveAction().setEnabled(true);
			ActionManager.getInstance().getMoreSlotsAction().setEnabled(false);
			ActionManager.getInstance().getElementAction().setEnabled(false);
			ActionManager.getInstance().getUndoAction().setEnabled(true);
			ActionManager.getInstance().getRedoAction().setEnabled(true);
		} else if (selectedNode instanceof Page) {
			PageView pw=new PageView();
			pw.initPageView((Page) selectedNode);
			ActionManager.getInstance().getProjectAction().setEnabled(false);
			ActionManager.getInstance().getDocumentAction().setEnabled(false);
			ActionManager.getInstance().getPageAction().setEnabled(false);
			ActionManager.getInstance().getSaveAction().setEnabled(true);
			ActionManager.getInstance().getChangeAction().setEnabled(true);
			ActionManager.getInstance().getRemoveAction().setEnabled(true);
			ActionManager.getInstance().getMoreSlotsAction().setEnabled(true);
			ActionManager.getInstance().getElementAction().setEnabled(false);
			
			ActionManager.getInstance().getUndoAction().setEnabled(false);//za sada
			ActionManager.getInstance().getRedoAction().setEnabled(false);// za sada
		}else if (selectedNode instanceof Slot) {
			
			SlotView sw=new SlotView();
			sw.SlotIzgledsaNazStr((Slot) selectedNode,"a");
			ActionManager.getInstance().getProjectAction().setEnabled(false);
			ActionManager.getInstance().getDocumentAction().setEnabled(false);
			ActionManager.getInstance().getPageAction().setEnabled(false);
			ActionManager.getInstance().getSaveAction().setEnabled(true);
			ActionManager.getInstance().getRemoveAction().setEnabled(true);
			ActionManager.getInstance().getChangeAction().setEnabled(true);
			ActionManager.getInstance().getMoreSlotsAction().setEnabled(false);
			ActionManager.getInstance().getElementAction().setEnabled(true);
			
			ActionManager.getInstance().getUndoAction().setEnabled(false);//za sada
			ActionManager.getInstance().getRedoAction().setEnabled(false);//za sada
			
		
	}

}
}
