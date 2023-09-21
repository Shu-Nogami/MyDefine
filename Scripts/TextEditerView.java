import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.BorderLayout;

public class TextEditerView extends JFrame {

	private TextEditerController textEditerController;

	private JFrame myDefinFrame;

	private JPanel textEditerJPanel;

	public TextEditerView(StringConversionDataModel aStringConversionDataModel, JFrame aMyDefineFrame) {
		this.textEditerController = new TextEditerController(aStringConversionDataModel, this);
		this.myDefinFrame = aMyDefineFrame;
		this.initializeTextEditer();
	}

	private void initializeTextEditer(){
		this.setUpMenu();
		textEditerJPanel = new JPanel();
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
