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

    private JButton saveAndExitButton;
	
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
		this.showSettingPanel();
	}
	
	private void showSettingPanel(){
		this.frameContentPane.add(this.settingJPanel, BorderLayout.CENTER);
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
		JRadioButton firstTemplateSelectButton = new JRadioButton();
		JRadioButton secondTemplateSelectButton = new JRadioButton();
		JRadioButton thirdTemplateSelectButton = new JRadioButton();
		JRadioButton fourthTemplateSelectButton = new JRadioButton();
		JRadioButton fifthTemplateSelectButton = new JRadioButton();
		JRadioButton sixthTemplateSelectButton = new JRadioButton();
		JRadioButton seventhTemplateSelectButton = new JRadioButton();
		JRadioButton eighthTemplateSelectButton = new JRadioButton();
		JRadioButton ninthTemplateSelectButton = new JRadioButton();
		JRadioButton tenthTemplateSelectButton = new JRadioButton();

		this.templateSelectButton = new ButtonGroup();

		this.templateSelectButton.add(firstTemplateSelectButton);
		this.templateSelectButton.add(secondTemplateSelectButton);
		this.templateSelectButton.add(thirdTemplateSelectButton);
		this.templateSelectButton.add(fourthTemplateSelectButton);
		this.templateSelectButton.add(fifthTemplateSelectButton);
		this.templateSelectButton.add(sixthTemplateSelectButton);
		this.templateSelectButton.add(seventhTemplateSelectButton);
		this.templateSelectButton.add(eighthTemplateSelectButton);
		this.templateSelectButton.add(ninthTemplateSelectButton);
		this.templateSelectButton.add(tenthTemplateSelectButton);

		this.settingJPanel.add(firstTemplateSelectButton);
		this.settingJPanel.add(secondTemplateSelectButton);
		this.settingJPanel.add(thirdTemplateSelectButton);
		this.settingJPanel.add(fourthTemplateSelectButton);
		this.settingJPanel.add(fifthTemplateSelectButton);
		this.settingJPanel.add(sixthTemplateSelectButton);
		this.settingJPanel.add(seventhTemplateSelectButton);
		this.settingJPanel.add(eighthTemplateSelectButton);
		this.settingJPanel.add(ninthTemplateSelectButton);
		this.settingJPanel.add(tenthTemplateSelectButton);
	}

	private void setUpButton(){
		this.saveButton = new JButton();
		this.saveAndExitButton = new JButton();

		this.saveButton.setText(FrameComponentName.SAVE_SETTING_BUTTON);
		this.saveAndExitButton.setText(FrameComponentName.EXIT_SETTING_BUTTON);

		this.settingJPanel.add(this.saveButton);
		this.settingJPanel.add(this.saveAndExitButton);
	}

}
