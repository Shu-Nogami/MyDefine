import java.io.File;
import java.io.IOException;

public class StringConversionDataModel extends Object {

	private FrameView frameView;

	private FileSaveModel fileSaveModel;

	private File openingTextEditerFile;

	public StringConversionDataModel() {
		this.frameView = new FrameView(this);
		this.fileSaveModel = new FileSaveModel();
	}

	public void frameChangeTextEditerToSetting(){
		this.frameView.showSettingPanel();
	}

	public void frameChangeSettingToTextEditer(){
		this.frameView.showTextEditerPanel();
	}

	public void openTextEditerFile(File aOpeningTextEdterFile) throws IOException{
		this.openingTextEditerFile = aOpeningTextEdterFile;
		this.frameView.writeTextEditerString(aOpeningTextEdterFile);
	}

}
