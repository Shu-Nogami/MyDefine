public class FrameView extends JFrame {

	private TextEditerView textEditerView;

	private SettingView settingView;

	public FrameView(StringConversionDataModel aStringConversionDataModel) {
		this.textEditerView = new TextEditerView(aStringConversionDataModel);
		this.settingView = new SettingView(aStringConversionDataModel);
	}

}
