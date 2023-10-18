import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileImportModel extends FileBase {

	private StringConvertModel stringConvertModel;

	public FileImportModel() {
		stringConvertModel = new StringConvertModel();
	}

	public String importFile(File aImportFile, List<Map<String, String>> aStringConversionDataList) throws IOException{
		StringBuilder importedStringBuilder = new StringBuilder();
		BufferedReader importFileReader = new BufferedReader(new FileReader(aImportFile));
		String readLine = importFileReader.readLine();
		String convertedString = null;

		while(readLine != null){
			for (Map<String,String> aStringConversionDataMap : aStringConversionDataList) {
				for (Map.Entry<String, String> aConversionDataMap : aStringConversionDataMap.entrySet()) {
					if(convertedString == null){
				    	convertedString = stringConvertModel.stringConvert(aConversionDataMap.getKey(), aConversionDataMap.getValue(), readLine);
					}
				}
			}
			if(convertedString != null){
				importedStringBuilder.append(convertedString);
				convertedString = null;
			}
			else{
				importedStringBuilder.append(readLine);
				importedStringBuilder.append(ConversionDataFileConstant.LINE_SEPARATOR);
			}
			readLine = importFileReader.readLine();
		}

		importFileReader.close();
		return importedStringBuilder.toString();
	}

}
