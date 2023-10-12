import java.util.ArrayList;
import java.util.List;

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

	private List<JRadioButton> templateSelectButtonList;

	private ButtonGroup templateSelectButtonGroup;

	private final Integer TEXT_CONVERSION_AREA_COLUMNS = 30;

	private final Integer TEXT_CONVERSION_AREA_ROWS = 4;

	private final Integer TEMPLATE_SELECT_BUTTON_MAX = 10;

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
		JRadioButton templateSelecButton;
		this.templateSelectButtonList = new ArrayList<>();
		this.templateSelectButtonGroup = new ButtonGroup();
		this.templateSelectButtonPanel = new JPanel();

        for(Integer i = 0;i < this.TEMPLATE_SELECT_BUTTON_MAX;i++){
			templateSelecButton = new JRadioButton();
			this.templateSelectButtonList.add(templateSelecButton);
			this.templateSelectButtonGroup.add(this.templateSelectButtonList.get(i));
			this.templateSelectButtonPanel.add(this.templateSelectButtonList.get(i));
		}

		this.templateSelectButtonList.get(0).setSelected(true);
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

	public void reviewSetting(String aTextBeforeConversionAreaString, String aTextAfterConversionAreaString){
		this.templateSelectButtonList.get(0).setSelected(true);
		this.setTextConversionAreaString(aTextBeforeConversionAreaString, aTextAfterConversionAreaString);
	}

	public void setTextConversionAreaString(String aTextBeforeConversionAreaString, String aTextAfterConversionAreaString){
		this.textBeforeConversionArea.setText(aTextBeforeConversionAreaString);
		this.textAfterConversionArea.setText(aTextAfterConversionAreaString);
	}
}
