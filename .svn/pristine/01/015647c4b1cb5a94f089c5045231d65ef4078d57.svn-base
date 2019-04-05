package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import actions.ActionManager;
import actions.ExitOnX;
import actions.HelpAction;
import actions.PrikaziDugmeIzMaina;
import model.Dokument;
import model.Page;
import model.Project;
import model.Slot;
import model.Workspace;
import segments.MyMenuBar;
import segments.MyToolBar;
import stablo.MySelectionListener;
import stablo.MyTreeModel;
import stablo.MyTreeRenderer;
import view.ChooseWorkspaceDialog;

public class MyApp extends JFrame {
	public static int flag=0;	
	private static MyApp instance = null;
	public static ArrayList<Workspace> listaWorkspaceOva=new ArrayList<Workspace>();
	private Workspace aktivniWorkspace;	
	private ArrayList<Dokument> slobodniDokumenti;
	private ArrayList<Dokument> nedavnoKorisceni;
	private ArrayList<Dokument> poslednjeKorisceni;
	private ArrayList<Dokument> najcesceKorisceni;
	private ResourceBundle resourceBundle;
	private JTree tree;
	private MyTreeModel treeModel;
	private MyMenuBar meni;
	private MyToolBar toolbar;
	private JPanel centralPanel;

	
	private MyApp() {
		poslednjeKorisceni = new ArrayList<>();
		listaWorkspaceOva = new ArrayList<Workspace>();
		aktivniWorkspace=new Workspace("Root");
		listaWorkspaceOva.add(aktivniWorkspace);
		listaWorkspaceOva.add(new Workspace("Probni zbog choose dialoga"));
		
		slobodniDokumenti = new ArrayList<Dokument>();
		nedavnoKorisceni = new ArrayList<Dokument>();
		najcesceKorisceni = new ArrayList<Dokument>();
	} 
	
	
	public static MyApp getInstance() {

		if (instance == null) {
			instance = new MyApp();
			instance.initialise();
		}
		return instance;
	}
	
	public Workspace getAktivniWorkspace() {
		return aktivniWorkspace;
	}
	
	
	public void setAktivniWorkspace(Workspace w) {
		aktivniWorkspace = w;
	}
	
	public ArrayList<Workspace> getListaWorkspaceova() {
	     return listaWorkspaceOva;
	}
	
	public ArrayList<Dokument>getPoslednjeKorisceni(){
		return poslednjeKorisceni;
	}
	
	public void AddDok(Dokument d){
		poslednjeKorisceni.add(d);
	}
	
	public void dodajNoviWorkspace(Workspace w) {
		listaWorkspaceOva.add(w);
	}
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public ArrayList<Dokument> getSlobodniDokumenti() {
	    return slobodniDokumenti;
	}
	
	public ArrayList<Dokument> getNedavnoKorisceni() {
	    return slobodniDokumenti;
	}
	public ArrayList<Dokument> getNajcesceKorisecni(){
		return najcesceKorisceni;
	}
	
	public void addToCentralPanel(JPanel p) {
		
		centralPanel.removeAll();
		centralPanel.add(p);
		centralPanel.revalidate();
		centralPanel.repaint();
	}
	
	public void addToCentralPanelSkrol(ArrayList<JScrollPane> pp,ArrayList<String> imena){
		centralPanel.removeAll();
		JTabbedPane tab=new JTabbedPane();
			
		for(int i=0;i<pp.size();i++){
			tab.add(imena.get(i), pp.get(i));
		}
	
		
		centralPanel.add(tab);
		centralPanel.revalidate();
		centralPanel.repaint();
	}
	
	public void addToCentralPanelTab(JTabbedPane p) {
		
		centralPanel.removeAll();
		centralPanel.add(p);
		centralPanel.revalidate();
		centralPanel.repaint();
	}
	
	public JPanel getCentralPanel() {
		return centralPanel;
	}
	
	public Workspace getWorkspace(){
		return aktivniWorkspace;
	}
	
	public Project getProject(){
		Project p=(Project) MyApp.getInstance().getTree().getLastSelectedPathComponent();
		return p;
	}
	
	public Page getPage(){
		Page page = (Page)MyApp.getInstance().getTree().getLastSelectedPathComponent();
		return page;
		
	}
	
	public Dokument getDokument(){
		Dokument d=(Dokument) MyApp.getInstance().getTree().getLastSelectedPathComponent();
		return d;
	}
	
	public Slot getSlot(){
		Slot s = (Slot) MyApp.getInstance().getTree().getLastSelectedPathComponent();
		return s;
	}
	
	
	public MyTreeModel getModelTree(){
		return treeModel;
	}
	
	public JTree getTree()
	{
		return tree;
	}	
	
	private void initialise() {
		resourceBundle =ResourceBundle.getBundle("Languages.MessageResources", Locale.getDefault());
		ActionManager.getInstance().getProjectAction().setEnabled(false);//da se ne bi mucili ako hendlovanja izuzetaka
		ActionManager.getInstance().getDocumentAction().setEnabled(false);
		ActionManager.getInstance().getPageAction().setEnabled(false);
		ActionManager.getInstance().getSaveAction().setEnabled(false);
		ActionManager.getInstance().getRemoveAction().setEnabled(false);
		ActionManager.getInstance().getMoreSlotsAction().setEnabled(false);
		ActionManager.getInstance().getElementAction().setEnabled(false);
		ActionManager.getInstance().getChangeAction().setEnabled(false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screenHeight / 2);
		setTitle("GeRuDok");
		setResizable(true);
		setIconImage(toolkit.getImage("resources/gerudok.png"));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		ChooseWorkspaceDialog cwd = new ChooseWorkspaceDialog(this, true);
		cwd.setVisible(true);
		
		//aktivniWorkspace = cwd.selektovani;

		
		meni = new MyMenuBar();
		this.setJMenuBar(meni);
		toolbar = new MyToolBar();
		
		JPanel toolbarPanel = new JPanel(new BorderLayout());
		toolbarPanel.add(toolbar,BorderLayout.WEST);
		this.add(toolbarPanel,BorderLayout.NORTH);
		
		inititialiseTree();
		
		JPanel southPanel = new JPanel();
		JButton prikazi=new JButton(MyApp.getInstance().getResourceBundle().getString("show"));
	    prikazi.addActionListener(new PrikaziDugmeIzMaina());
	  //  southPanel.add(prikazi);			
		this.add(southPanel,BorderLayout.SOUTH);
		
		
		centralPanel = new JPanel(new BorderLayout());
		this.add(getCentralPanel(),BorderLayout.CENTER);
		
		addWindowListener(new ExitOnX());
				
	}
	
	public void inititialiseTree() {

		tree = new JTree();
		PopupMenu m = new PopupMenu();
		MenuItem i = new MenuItem(MyApp.getInstance().getResourceBundle().getString("help"));
	    i.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 HelpAction hp = new HelpAction();
		}
	});
		
		m.add(i);
		tree.add(m);
		tree.addMouseListener(new MouseAdapter() {
			  public void mousePressed(MouseEvent e) {
	                if (e.isPopupTrigger()) {
	                    System.out.println("My Popup");
	                }
	            }
			  
			  public void mouseClicked(MouseEvent e) {

				    if (SwingUtilities.isRightMouseButton(e)) {

				        int row = tree.getClosestRowForLocation(e.getX(), e.getY());
				        tree.setSelectionRow(row);
				      
				        m.show(e.getComponent(), e.getX(), e.getY());
				       
				    }
				}
		});
		
		
		
		
		
		
		treeModel = new MyTreeModel(aktivniWorkspace,tree);
		tree.setModel(treeModel);
		aktivniWorkspace.addObserver(treeModel);
		tree.setCellRenderer(new MyTreeRenderer());
		
		tree.addTreeSelectionListener(new MySelectionListener());
		
		JScrollPane scrollPane = new JScrollPane(tree,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(200, 325));
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.gray));
		add(scrollPane, BorderLayout.WEST);
		
		
	}
	
	
	
}
