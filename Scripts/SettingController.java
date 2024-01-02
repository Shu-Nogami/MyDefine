import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SettingController extends Object implements ActionListener{

	private SettingView settingView;

	private StringConversionDataModel stringConversionDataModel;

	public SettingController(SettingView aSettingView, StringConversionDataModel aStringConversionDataModel){
		this.settingView = aSettingView;
		this.stringConversionDataModel = aStringConversionDataModel;
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		switch(actionCommand){
			case FrameComponentName.EXIT_SETTING_BUTTON -> {
				this.stringConversionDataModel.updateSettingStringConversionDataList(this.settingView.getSelectedButtonNumber(true), this.settingView.getConversionAreaStringMap());
				try {
					this.stringConversionDataModel.updateConversionDataFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				this.stringConversionDataModel.frameChangeSettingToTextEditer();
			}
			case FrameComponentName.SAVE_SETTING_BUTTON -> {
				this.stringConversionDataModel.updateSettingStringConversionDataList(this.settingView.getSelectedButtonNumber(true), this.settingView.getConversionAreaStringMap());
				try {
					this.stringConversionDataModel.updateConversionDataFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}

			}
			default -> {
				this.searchConversionName(actionCommand);
			}
		}
	}

	private void searchConversionName(String actionCommandString){
		for (FrameComponentName.ConversionNames conversionName : FrameComponentName.ConversionNames.values()) {
			if(conversionName.name().equals(actionCommandString)){
				this.settingView.setSelectedButtonNumber(conversionName.getInteger());
				this.stringConversionDataModel.updateSettingStringConversionDataList(this.settingView.getSelectedButtonNumber(false), this.settingView.getConversionAreaStringMap());
				this.stringConversionDataModel.setConversionAreaString(conversionName.getInteger());
			}
		}
	}
}
