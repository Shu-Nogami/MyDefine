import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TextEditerController extends Object implements ActionListener{

	private StringConversionDataModel stringConversionDataModel;

	private TextEditerView textEditerView;


	public TextEditerController(StringConversionDataModel aStringConversionDataModel, TextEditerView aTextEditerView) {
		this.stringConversionDataModel = aStringConversionDataModel;
		this.textEditerView = aTextEditerView;
	}

	public void openingFile(File aOpeningTextEdterFile) throws IOException {
		this.stringConversionDataModel.openTextEditerFile(aOpeningTextEdterFile);
	}

	public void saveAsFile(File aSaveAsTextEditerFile) throws IOException {
		this.stringConversionDataModel.saveAsFile(aSaveAsTextEditerFile, this.textEditerView.getTextAreaString());
	}

	public void actionPerformed(ActionEvent e){
		String actionCommand = e.getActionCommand();

		switch(actionCommand){
			case FrameComponentName.SETTING_BUTTON -> {
				this.stringConversionDataModel.frameChangeTextEditerToSetting();
			}
			case FrameComponentName.FILE_OPEN -> {
				try {
					this.textEditerView.openFileDialog();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			case FrameComponentName.FILE_SAVE -> {
				try {
					this.stringConversionDataModel.saveFile(this.textEditerView.getTextAreaString());
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			case FrameComponentName.FILE_SAVE_AS -> {
				try {
					this.textEditerView.saveAsFileDialog();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
