import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

	private ButtonGroup templateSelectButton;

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
		this.setUpTemplateSelectButton();
		this.setUpButton();
	}

	private void setUpTemplateArea(){
		this.textBeforeConversionArea = new JTextArea();
		this.textAfterConversionArea = new JTextArea();

		this.textBeforeConversionArea.setColumns(this.TEXT_CONVERSION_AREA_COLUMNS);
		this.textBeforeConversionArea.setRows(this.TEXT_CONVERSION_AREA_ROWS);
		this.textAfterConversionArea.setColumns(this.TEXT_CONVERSION_AREA_COLUMNS);
		this.textAfterConversionArea.setRows(this.TEXT_CONVERSION_AREA_ROWS);

		this.settingJPanel.add(this.textBeforeConversionArea);
		this.settingJPanel.add(this.textAfterConversionArea);
	}

	private void setUpTemplateSelectButton(){
		JRadioButton firstTemplateSelecButton = new JRadioButton();
		this.templateSelectButton = new ButtonGroup();
	}

	private void setUpButton(){
		this.saveButton = new JButton();
		this.saveAsButton = new JButton();
	}

}
