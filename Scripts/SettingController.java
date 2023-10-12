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
			case FrameComponentName.CONVERSION_FIRST_MAP -> {
				
			}
			case FrameComponentName.CONVERSION_SECOND_MAP -> {

			}
			case FrameComponentName.CONVERSION_THIRD_MAP -> {

			}
			case FrameComponentName.CONVERSION_FOURTH_MAP -> {

			}
			case FrameComponentName.CONVERSION_FIFTH_MAP -> {

			}
			case FrameComponentName.CONVERSION_SIXTH_MAP -> {

			}
			case FrameComponentName.CONVERSION_SEVENTH_MAP -> {

			}
			case FrameComponentName.CONVERSION_EIGHTH_MAP -> {

			}
			case FrameComponentName.CONVERSION_NINTH_MAP -> {

			}
			case FrameComponentName.CONVERSION_TENTH_MAP -> {
				
			}
		}
	}
}
