import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import java.awt.Container;
import java.awt.ScrollPane;
import java.awt.BorderLayout;

public class TextEditerView extends JFrame {

	private TextEditerController textEditerController;

	private JFrame myDefinFrame;

	private Container textEditerContainer;

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
		this.textEditerContainer = myDefinFrame.getContentPane();
		this.textEditerJPanel = new JPanel();

		this.setUpMenu();
		this.setUpTextArea();
		this.showTextEditerPanel();
	}

	private void showTextEditerPanel(){
		this.textEditerContainer.add(this.textEditerJPanel, BorderLayout.CENTER);
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
		JMenu fileSetting = new JMenu(FrameComponentName.SETTING_BUTTON);

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
