import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				this.stringConversionDataModel.frameChangeSettingToTextEditer();
			}
			default -> {
				this.searchConversionName(actionCommand);
			}
		}
	}

	private void searchConversionName(String actionCommandString){
		System.out.println(actionCommandString);
		for (FrameComponentName.ConversionNames conversionName : FrameComponentName.ConversionNames.values()) {
			if(conversionName.name().equals(actionCommandString)){
				this.stringConversionDataModel.setConversionAreaString(conversionName.getInteger());
			}
		}
	}
}
