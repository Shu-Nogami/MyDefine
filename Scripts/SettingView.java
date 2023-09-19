import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;

public class SettingView extends JFrame {

	private SettingController settingController;

	private Container frameContentPane;

	public SettingView(StringConversionDataModel aStringConversionDataModel, Container aframeContainer) {
		this.settingController = new SettingController(this, aStringConversionDataModel);
		this.frameContentPane = aframeContainer;
		this.initializeSettingView();
	}

	private void initializeSettingView(){
		
	}

}
