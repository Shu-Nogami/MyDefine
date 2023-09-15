public class SettingView extends JFrame {

	private SettingController settingController;

	public SettingView(StringConversionDataModel aStringConversionDataModel) {
		this.settingController = new SettingController(this, aStringConversionDataModel);
	}

}
