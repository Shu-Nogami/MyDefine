import javax.swing.JFrame;

public class SettingView extends JFrame {

	private SettingController settingController;

	public SettingView(StringConversionDataModel aStringConversionDataModel) {
		this.settingController = new SettingController(this, aStringConversionDataModel);
		this.initializeSettingView();
	}

	private void initializeSettingView(){
		
	}

}
