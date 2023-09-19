import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.BorderLayout;

public class SettingView extends JFrame {

	private SettingController settingController;

	private Container frameContentPane;

	private JPanel settingJPanel;

	public SettingView(StringConversionDataModel aStringConversionDataModel, Container aframeContainer) {
		this.settingController = new SettingController(this, aStringConversionDataModel);
		this.frameContentPane = aframeContainer;
		this.initializeSettingView();
	}

	private void initializeSettingView(){
		settingJPanel = new JPanel();
	}

}
