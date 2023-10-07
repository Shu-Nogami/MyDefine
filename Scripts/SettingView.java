import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class SettingView extends JFrame {

	private SettingController settingController;

	private JPanel settingJPanel;

	private JPanel textConversionAreaPanel;

	private JPanel templateSelectButtonPanel;

	private JPanel saveButtonPanel;

	private JTextArea textBeforeConversionArea;

	private JTextArea textAfterConversionArea;

    private JButton saveAndExitButton;
	
	private JButton saveButton;

	private ButtonGroup templateSelectButton;

	private final Integer TEXT_CONVERSION_AREA_COLUMNS = 30;

	private final Integer TEXT_CONVERSION_AREA_ROWS = 4;

	public SettingView(StringConversionDataModel aStringConversionDataModel) {
		this.settingController = new SettingController(this, aStringConversionDataModel);
		this.initializeSettingView();
	}

	private void initializeSettingView(){
		this.settingJPanel = new JPanel();
		this.setUpTemplateArea();
		this.setUpTemplateSelectButton();
		this.setUpButton();
	}

	public JPanel getSettingPanel(){
        return this.settingJPanel;
	}

	private void setUpTemplateArea(){
		this.textBeforeConversionArea = new JTextArea();
		this.textAfterConversionArea = new JTextArea();
		this.textConversionAreaPanel = new JPanel();

		this.textBeforeConversionArea.setColumns(this.TEXT_CONVERSION_AREA_COLUMNS);
		this.textBeforeConversionArea.setRows(this.TEXT_CONVERSION_AREA_ROWS);
		this.textAfterConversionArea.setColumns(this.TEXT_CONVERSION_AREA_COLUMNS);
		this.textAfterConversionArea.setRows(this.TEXT_CONVERSION_AREA_ROWS);

		this.textBeforeConversionArea.setLineWrap(true);
		this.textAfterConversionArea.setLineWrap(true);

		this.textConversionAreaPanel.add(this.textBeforeConversionArea);
		this.textConversionAreaPanel.add(this.textAfterConversionArea);

		this.settingJPanel.add(this.textConversionAreaPanel);

		this.settingJPanel.setLayout(new BoxLayout(this.settingJPanel, BoxLayout.Y_AXIS));
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
		this.templateSelectButtonPanel = new JPanel();

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

		firstTemplateSelectButton.setSelected(true);

		this.templateSelectButtonPanel.add(firstTemplateSelectButton);
		this.templateSelectButtonPanel.add(secondTemplateSelectButton);
		this.templateSelectButtonPanel.add(thirdTemplateSelectButton);
		this.templateSelectButtonPanel.add(fourthTemplateSelectButton);
		this.templateSelectButtonPanel.add(fifthTemplateSelectButton);
		this.templateSelectButtonPanel.add(sixthTemplateSelectButton);
		this.templateSelectButtonPanel.add(seventhTemplateSelectButton);
		this.templateSelectButtonPanel.add(eighthTemplateSelectButton);
		this.templateSelectButtonPanel.add(ninthTemplateSelectButton);
		this.templateSelectButtonPanel.add(tenthTemplateSelectButton);

		this.settingJPanel.add(this.templateSelectButtonPanel);
	}

	private void setUpButton(){
		this.saveButton = new JButton();
		this.saveAndExitButton = new JButton();
		this.saveButtonPanel = new JPanel();

		this.saveButton.setText(FrameComponentName.SAVE_SETTING_BUTTON);
		this.saveAndExitButton.setText(FrameComponentName.EXIT_SETTING_BUTTON);

		this.saveButtonPanel.add(this.saveButton);
		this.saveButtonPanel.add(this.saveAndExitButton);

		this.saveButton.addActionListener(this.settingController);
		this.saveAndExitButton.addActionListener(this.settingController);

		this.settingJPanel.add(this.saveButtonPanel);
	}
}
