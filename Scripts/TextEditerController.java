import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TextEditerController extends Object implements ActionListener{

	private StringConversionDataModel stringConversionDataModel;

	private TextEditerView textEditerView;


	public TextEditerController(StringConversionDataModel aStringConversionDataModel, TextEditerView aTextEditerView) {
		this.stringConversionDataModel = aStringConversionDataModel;
		this.textEditerView = aTextEditerView;
	}

	public void actionPerformed(ActionEvent e){
		String actionCommand = e.getActionCommand();

		switch(actionCommand){
			case FrameComponentName.SETTING_BUTTON -> {
				this.stringConversionDataModel.frameChangeTextEditerToSetting();
			}
			case FrameComponentName.FILE_OPEN -> {
				try {
					this.stringConversionDataModel.openTextDiterFile(this.textEditerView.openFileDialog());
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			case FrameComponentName.FILE_SAVE_AS -> {

			}
		}
	}
}
