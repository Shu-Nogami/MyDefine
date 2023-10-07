import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextEditerView extends JFrame{

	private TextEditerController textEditerController;

	private JFrame myDefinFrame;

	private JPanel textEditerJPanel;

	private JTextArea textEditerArea;

	private JScrollPane textEditerScrollPane;

	private final Integer TEXTEDITER_AREACOLUMNS = 45;

	private final Integer TEXTEDITER_AREAROWS = 20;
	

	public TextEditerView(StringConversionDataModel aStringConversionDataModel, JFrame aMyDefineFrame) {
		this.textEditerController = new TextEditerController(aStringConversionDataModel, this);
		this.myDefinFrame = aMyDefineFrame;
		this.initializeTextEditer();
	}

	private void initializeTextEditer(){
		this.textEditerJPanel = new JPanel();

		this.setUpMenu();
		this.setUpTextArea();
	}

	public JPanel getTextEditerPanel(){
		return this.textEditerJPanel;
	}

	private void setUpTextArea(){
		this.textEditerScrollPane = new JScrollPane();
		this.textEditerArea = new JTextArea();

		this.textEditerArea.setColumns(TEXTEDITER_AREACOLUMNS);
		this.textEditerArea.setRows(TEXTEDITER_AREAROWS);
		this.textEditerArea.setLineWrap(true);
		
		this.textEditerScrollPane.setViewportView(this.textEditerArea);
		this.textEditerScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		this.textEditerJPanel.add(this.textEditerScrollPane);
	}

	private void setUpMenu(){
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu(FrameComponentName.FILE_MENU);
		JMenuItem fileSetting = new JMenuItem(FrameComponentName.SETTING_BUTTON);

		menuBar.add(fileMenu);
		menuBar.add(fileSetting);

		JMenuItem fileOpen = new JMenuItem(FrameComponentName.FILE_OPEN);
		JMenuItem fileSave = new JMenuItem(FrameComponentName.FILE_SAVE);
		JMenuItem fileSaveAs = new JMenuItem(FrameComponentName.FILE_SAVE_AS);

		fileMenu.add(fileOpen);
		fileMenu.add(fileSave);
		fileMenu.add(fileSaveAs);

		fileSetting.addActionListener(this.textEditerController);
		fileOpen.addActionListener(this.textEditerController);
		fileSave.addActionListener(this.textEditerController);
		fileSaveAs.addActionListener(this.textEditerController);

		this.myDefinFrame.setJMenuBar(menuBar);
	}
}
