import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringConversionDataModel extends Object {

	private FrameView frameView;

	private FileSaveModel fileSaveModel;

	private ConversionDataFileRoadModel conversionDataFileRoadModel;

	private File openingTextEditerFile;

	private List<Map<String, String>> stringConversionDataList;

	private final String CONVERSION_DATA_FILE_PATH = "../conversionData.txt";

	public StringConversionDataModel() {
		this.stringConversionDataList = new ArrayList<>();
		this.conversionDataFileRoadModel = new ConversionDataFileRoadModel();
		try {
			this.searchConversionDataFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		this.frameView = new FrameView(this);
		this.fileSaveModel = new FileSaveModel();
	}

	public void frameChangeTextEditerToSetting(){
		this.frameView.showSettingPanel();
	}

	public void frameChangeSettingToTextEditer(){
		this.frameView.showTextEditerPanel();
	}

	public void openTextEditerFile(File aOpeningTextEdterFile) throws IOException {
		this.openingTextEditerFile = aOpeningTextEdterFile;
		this.frameView.writeTextEditerString(aOpeningTextEdterFile);
	}

	public void saveFile(String aTextEditerAreaString) throws IOException {
		this.fileSaveModel.saveFile(this.openingTextEditerFile, aTextEditerAreaString);
	}

	public void saveAsFile(File aSaveAsFile, String aTextEditerAreaString) throws IOException {
		this.fileSaveModel.saveFile(aSaveAsFile, aTextEditerAreaString);
	}

	private void searchConversionDataFile() throws IOException{
		File conversionDataFile = new File(CONVERSION_DATA_FILE_PATH);
		if(conversionDataFile.exists()){
			this.stringConversionDataList = this.conversionDataFileRoadModel.getConversionData(conversionDataFile, this.stringConversionDataList);
		}
		else{
			this.createConversionDataFile();
		}
	}

	private void createConversionDataFile() throws IOException{
		File conversionDataFile = new File(CONVERSION_DATA_FILE_PATH);
		conversionDataFile.createNewFile();
	}
}
