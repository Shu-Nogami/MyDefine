import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameView extends JFrame {

	private TextEditerView textEditerView;

	private SettingView settingView;

	private JFrame myDefinitionFrame;

	private JPanel framePanel;

	private CardLayout viewPanelsCardLayout;

	private final String FRAME_TITLE = "MyDefinition";

	private final Integer FRAME_X_SIZE = 600;

	private final Integer FRAME_Y_SIZE = 400;


	public FrameView(StringConversionDataModel aStringConversionDataModel) {
		this.initializeFrame();
		this.textEditerView = new TextEditerView(aStringConversionDataModel, this.myDefinitionFrame);
		this.settingView = new SettingView(aStringConversionDataModel);
		this.setUpCardLayout();
		this.showWindow();
	}

	private void initializeFrame(){
		myDefinitionFrame = new JFrame();
		myDefinitionFrame.setTitle(this.FRAME_TITLE);
		myDefinitionFrame.setSize(this.FRAME_X_SIZE, this.FRAME_Y_SIZE);
		myDefinitionFrame.setLocationRelativeTo(null);
		myDefinitionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setUpCardLayout(){
		this.framePanel = new JPanel();
		this.viewPanelsCardLayout = new CardLayout();
		this.framePanel.setLayout(this.viewPanelsCardLayout);

		this.framePanel.add(this.textEditerView.getTextEditerPanel());
		this.framePanel.add(this.settingView.getSettingPanel());

		this.myDefinitionFrame.getContentPane().add(this.framePanel, BorderLayout.CENTER);
		this.showTextEditerPanel();
	}

	public void showTextEditerPanel(){
		this.viewPanelsCardLayout.first(this.framePanel);
	}
	
	public void showSettingPanel(){
		this.viewPanelsCardLayout.last(this.framePanel);
	}

	public void updateConversionAreaString(Map<String, String> aTextConversionAreaMap, boolean isResetSelectedRadioButton){
		String aTextBeforeConversionAreaString = new String();
		String aTextAfterConversionAreaString = new String();

		for (Map.Entry<String, String> aConversionAreaMap : aTextConversionAreaMap.entrySet()) {
			aTextBeforeConversionAreaString = aConversionAreaMap.getKey();
			aTextAfterConversionAreaString = aConversionAreaMap.getValue();
		}

		if(isResetSelectedRadioButton){
		    this.settingView.reviewSetting(aTextBeforeConversionAreaString, aTextAfterConversionAreaString);
		}
		else{
			this.settingView.setTextConversionAreaString(aTextBeforeConversionAreaString, aTextAfterConversionAreaString);
		}
	}

	private void showWindow(){
		myDefinitionFrame.setVisible(true);
	}

	public void writeTextEditerFileString(File aOpeningTextEdterFile) throws IOException{
		this.textEditerView.writeFileTextEditer(aOpeningTextEdterFile);
	}

	public void writeTextEditerString(String aConvertedString){
		this.textEditerView.writeStringTextEditer(aConvertedString);
	}

	public String getTextAreaString(){
		return this.textEditerView.getTextAreaString();
	}

	public void resetSettingSelectedButtonNumber(){
		this.settingView.resetSelectedButtonList();
	}

	public void openTextEditerSaveAsFileDialog() throws IOException{
		this.textEditerView.saveAsFileDialog();
	}
}
