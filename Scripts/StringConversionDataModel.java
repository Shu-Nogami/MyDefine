import java.io.File;
import java.io.IOException;

public class StringConversionDataModel extends Object {

	private FrameView frameView;

	private File openingTextEditerFile;

	public StringConversionDataModel() {
		this.frameView = new FrameView(this);

	}

	public void frameChangeTextEditerToSetting(){
		this.frameView.showSettingPanel();
	}

	public void frameChangeSettingToTextEditer(){
		this.frameView.showTextEditerPanel();
	}

	public void opneTextDiterFile(File aOpeningTextEdterFile) throws IOException{
		this.openingTextEditerFile = aOpeningTextEdterFile;
		this.frameView.writeTextEditerString(aOpeningTextEdterFile);
	}
}
