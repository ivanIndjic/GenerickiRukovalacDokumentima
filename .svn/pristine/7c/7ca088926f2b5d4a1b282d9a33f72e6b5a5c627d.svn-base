package actions;

public class ActionManager {
	
	private static ActionManager instance = null;
	private NewProjectAction newProj;
	private NewDocumentAction newDoc;
	private NewPageAction newPage;
	private NewElementAction newElem;
	private SaveAction save;
	private OpenAction open;
	private RemoveAction remove;
	private IndependentDocumentsAction independent;
	private MostUsedDocuments mostused;
	private LastUsedDocument lastUsed;
	private ChangeAction change;
	//private NewSlotAction newSlot;
	private NewMoreSlotsAction nmsa;
	private CloseWorkspaceAction close;
	private ShareAction share;
	private UndoAction undo;
	private RedoAction redo;
	

	public UndoAction getUndoAction(){
		
		return undo;
	}

	public RedoAction getRedoAction(){
		
		return redo;
	}
	
	public LastUsedDocument getLast(){
		return lastUsed;
	}
	public ShareAction getShareAction(){
		
		return share;
	}
	
	public MostUsedDocuments getMostUsed(){
		return mostused;
	}
	
	public CloseWorkspaceAction getCloseAction() {
		return close;
	}
	public NewElementAction getElementAction(){
		return newElem;
		
	}
	public void setCloseAction(CloseWorkspaceAction close) {
		this.close = close;
	}
	public OpenAction getRemoveActio(){
		
		return open;
	}
	public NewMoreSlotsAction getMoreSlotsAction(){
		return nmsa;
		
	}
	
	public IndependentDocumentsAction getIndependentAction() {
		return independent;
	}
	
	
	public NewProjectAction getProjectAction() {
		return newProj;
	}
	
	public NewDocumentAction getDocumentAction() {
		return newDoc;
	}
	
	public NewPageAction getPageAction() {
		return newPage;
	}

	//public NewSlotAction getSlotAction() {
		//return newSlot;
	//}

	
       public SaveAction getSaveAction() {
		return save;
	}

       public RemoveAction getRemoveAction() {
		return remove;
	}
       
       public ChangeAction getChangeAction() {
   		return change;
   	}

	private ActionManager() {
		super();
		
		newProj= new NewProjectAction();
		newDoc= new NewDocumentAction();
		newPage= new NewPageAction();
		save= new SaveAction();
		remove= new RemoveAction();
		independent = new IndependentDocumentsAction();
		change=new ChangeAction();
		nmsa = new NewMoreSlotsAction();
		close = new CloseWorkspaceAction();
		newElem =new NewElementAction();
		share=new ShareAction();
		undo = new UndoAction();
		redo = new RedoAction();
		mostused = new MostUsedDocuments();
        lastUsed = new LastUsedDocument();
	
	}
	
	public static ActionManager getInstance() {
		if (instance == null)
			instance = new ActionManager();

		return instance;
	}
	
	
	

}

