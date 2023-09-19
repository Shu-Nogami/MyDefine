import javax.swing.JFrame;

public class FrameView extends JFrame {

	private TextEditerView textEditerView;

	private SettingView settingView;

	private final String FRAME_TITLE = "MyDefine";

	private final Integer FRAME_X_SIZE = 600;

	private final Integer FRAME_Y_SIZE = 400;


	public FrameView(StringConversionDataModel aStringConversionDataModel) {
		this.initializeFrame();
		this.textEditerView = new TextEditerView(aStringConversionDataModel);
		this.settingView = new SettingView(aStringConversionDataModel);
	}

	private void initializeFrame(){
		JFrame frame = new JFrame();
		frame.setTitle(this.FRAME_TITLE);
		frame.setSize(this.FRAME_X_SIZE, this.FRAME_Y_SIZE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
