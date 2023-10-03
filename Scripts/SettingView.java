import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Container;
import java.awt.BorderLayout;

public class SettingView extends JFrame {

	private SettingController settingController;

	private Container frameContentPane;

	private JPanel settingJPanel;

	private JTextArea textBeforeConversionArea;

	private JTextArea textAfterConversionArea;

    private JButton saveAsButton;
	
	private JButton saveButton;

	private final Integer TEXT_CONVERSION_AREA_COLUMNS = 30;

	private final Integer TEXT_CONVERSION_AREA_ROWS = 2;

	public SettingView(StringConversionDataModel aStringConversionDataModel, Container aframeContainer) {
		this.settingController = new SettingController(this, aStringConversionDataModel);
		this.frameContentPane = aframeContainer;
		this.initializeSettingView();
	}

	private void initializeSettingView(){
		this.settingJPanel = new JPanel();
		this.setUpTemplateArea();
		this.setUpButton();
	}

	private void setUpTemplateArea(){
		this.textBeforeConversionArea = new JTextArea();
		this.textAfterConversionArea = new JTextArea();
	}

	private void setUpButton(){

	}

}
