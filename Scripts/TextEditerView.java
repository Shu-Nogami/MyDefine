import java.io.BufferedReader;
import java.io.File;
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
		JMenu fileSetting = new JMenu(FrameComponentName.SETTING_BUTTON);

		menuBar.add(fileMenu);
		menuBar.add(fileSetting);

		JMenuItem fileOpen = new JMenuItem(FrameComponentName.FILE_OPEN);
		JMenuItem fileSave = new JMenuItem(FrameComponentName.FILE_SAVE);
		JMenuItem fileSaveAs = new JMenuItem(FrameComponentName.FILE_SAVE_AS);
		JMenuItem fileImport = new JMenuItem(FrameComponentName.IMPORT_BUTTON);
		JMenuItem fileExport = new JMenuItem(FrameComponentName.EXPORT_BUTTON);

		JMenuItem fileUserSetting = new JMenuItem(FrameComponentName.USER_SETTING_BUTTON);

		fileMenu.add(fileOpen);
		fileMenu.add(fileSave);
		fileMenu.add(fileSaveAs);
		fileMenu.add(fileImport);
		fileMenu.add(fileExport);

		fileSetting.add(fileUserSetting);

		fileImport.addActionListener(this.textEditerController);
		fileExport.addActionListener(this.textEditerController);
		fileOpen.addActionListener(this.textEditerController);
		fileSave.addActionListener(this.textEditerController);
		fileSaveAs.addActionListener(this.textEditerController);

		fileUserSetting.addActionListener(this.textEditerController);

		this.myDefinFrame.setJMenuBar(menuBar);
	}

	public void openFileDialog() throws IOException{
		JFileChooser openFileChooser = new JFileChooser();
		Integer selectedOpenFile = openFileChooser.showOpenDialog(openFileChooser);
		if(selectedOpenFile == JFileChooser.APPROVE_OPTION){
			this.textEditerController.openingFile(openFileChooser.getSelectedFile());
		}
	}
	
	public void saveAsFileDialog() throws IOException{
		JFileChooser saveAsFileChooser = new JFileChooser();
		Integer selectedSaveAsFile = saveAsFileChooser.showSaveDialog(saveAsFileChooser);
		if(selectedSaveAsFile == JFileChooser.APPROVE_OPTION){
			this.textEditerController.saveAsFile(saveAsFileChooser.getSelectedFile());
		}
	}

	public void importFileDialog() throws IOException{
		JFileChooser importFileChooser = new JFileChooser();
		Integer selectedOpenFile = importFileChooser.showOpenDialog(importFileChooser);
		if(selectedOpenFile == JFileChooser.APPROVE_OPTION){
			this.textEditerController.importFile(importFileChooser.getSelectedFile());
		}
	}

	public void exportFileDialog() throws IOException{
		JFileChooser exportFileChooser = new JFileChooser();
		Integer selectedOpenFile = exportFileChooser.showSaveDialog(exportFileChooser);
		if(selectedOpenFile == JFileChooser.APPROVE_OPTION){
			this.textEditerController.exportFile(exportFileChooser.getSelectedFile());
		}
	}

	public void writeFileTextEditer(File aOpeningTextEdterFile) throws IOException{
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

	public void writeStringTextEditer(String aConvertedString){
		this.textEditerArea.setText("");
		this.addTextToTextEditerArea(aConvertedString);
	}

	private void addTextToTextEditerArea(String addString){
		this.textEditerArea.append(addString);
	}

	private StringBuilder resetStringBuilder(StringBuilder aStringBuilder){
		aStringBuilder.delete(0, aStringBuilder.length());
		return aStringBuilder;
	}

	public String getTextAreaString(){
		return this.textEditerArea.getText();
	}
}
