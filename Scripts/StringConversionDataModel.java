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

	private File conversionDataFile;

	private List<Map<String, String>> stringConversionDataList;

	public StringConversionDataModel() {
		this.stringConversionDataList = new ArrayList<>();
		this.fileSaveModel = new FileSaveModel();
		this.conversionDataFileRoadModel = new ConversionDataFileRoadModel();
		try {
			this.searchConversionDataFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		this.frameView = new FrameView(this);
	}

	public void frameChangeTextEditerToSetting(){
		this.frameView.updateConversionAreaString(this.stringConversionDataList.get(0), true);
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
		File conversionDataFile = new File(ConversionDataFileConstant.CONVERSION_DATA_FILE_PATH);
		if(conversionDataFile.exists()){
			this.stringConversionDataList = this.conversionDataFileRoadModel.getConversionData(conversionDataFile, this.stringConversionDataList);
		}
		else{
			this.createConversionDataFile();
		}
	}

	private void createConversionDataFile() throws IOException{
		this.conversionDataFile = this.fileSaveModel.createConversionDataFile(ConversionDataFileConstant.CONVERSION_DATA_FILE_PATH);
	}

	public void setConversionAreaString(Integer selectRadioNumber){
		this.frameView.updateConversionAreaString(this.stringConversionDataList.get(selectRadioNumber), false);
	}
}
