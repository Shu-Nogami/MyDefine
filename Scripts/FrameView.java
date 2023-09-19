import javax.swing.JFrame;

public class FrameView extends JFrame {

	private TextEditerView textEditerView;

	private SettingView settingView;

	private JFrame myDefineFrame;

	private final String FRAME_TITLE = "MyDefine";

	private final Integer FRAME_X_SIZE = 600;

	private final Integer FRAME_Y_SIZE = 400;


	public FrameView(StringConversionDataModel aStringConversionDataModel) {
		this.initializeFrame();
		this.textEditerView = new TextEditerView(aStringConversionDataModel, myDefineFrame.getContentPane());
		this.settingView = new SettingView(aStringConversionDataModel, myDefineFrame.getContentPane());
	}

	private void initializeFrame(){
		myDefineFrame = new JFrame();
		myDefineFrame.setTitle(this.FRAME_TITLE);
		myDefineFrame.setSize(this.FRAME_X_SIZE, this.FRAME_Y_SIZE);
		myDefineFrame.setLocationRelativeTo(null);
		myDefineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myDefineFrame.setVisible(true);
	}

}
