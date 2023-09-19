import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;

public class SettingView extends JFrame {

	private SettingController settingController;

	private Container settingContentPane;

	public SettingView(StringConversionDataModel aStringConversionDataModel, Container aSettingContainer) {
		this.settingController = new SettingController(this, aStringConversionDataModel);
		this.settingContentPane = aSettingContainer;
		this.initializeSettingView();
	}

	private void initializeSettingView(){
		
	}

}
