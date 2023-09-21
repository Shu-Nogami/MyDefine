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

	}
}
