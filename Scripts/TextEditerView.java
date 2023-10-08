import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
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

	private final String LINE_SEPARATOR = System.getProperty("line.separator");
	

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

	public void openFileDialog() throws IOException{
		JFileChooser openFileChooser = new JFileChooser();
		Integer selectedOpenFile = openFileChooser.showOpenDialog(openFileChooser);
		if(selectedOpenFile == JFileChooser.APPROVE_OPTION){
			this.textEditerController.openingFile(openFileChooser.getSelectedFile());
		}
	}

	public void writeTextEditer(File aOpeningTextEdterFile) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(aOpeningTextEdterFile));
		String readTextLine = bufferedReader.readLine();
		StringBuilder writingText = new StringBuilder();

		this.textEditerArea.setText("");

		while(readTextLine != null){
			this.resetStringBuilder(writingText);
			writingText.append(readTextLine);
			writingText.append(this.LINE_SEPARATOR);
			this.addTextToTextEditerArea(writingText.toString());

			readTextLine = bufferedReader.readLine();
		}

		bufferedReader.close();
	}

	private void addTextToTextEditerArea(String addString){
		this.textEditerArea.append(addString);
	}

	private StringBuilder resetStringBuilder(StringBuilder aStringBuilder){
		aStringBuilder.delete(0, aStringBuilder.length());
		return aStringBuilder;
	}
}
