import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileExportModel extends FileBase {

	private StringConvertModel stringConvertModel;

	public FileExportModel() {
		this.stringConvertModel = new StringConvertModel();
	}

	public void exportFile(File aExportFile, List<Map<String, String>> aStringConversionDataList, String aConvrsionOriginalString) throws IOException{
		String[] conversionOriginalStrings = aConvrsionOriginalString.split(ConversionDataFileConstant.LINE_SEPARATOR);
		StringBuilder convertedStringBuilder = new StringBuilder();
		BufferedWriter exportFilWriter = new BufferedWriter(new FileWriter(aExportFile));
		String convertedString = null;

		for (String conversionOriginalString : conversionOriginalStrings) {
			for (Map<String,String> aStringConversionDataMap : aStringConversionDataList) {
				for (Map.Entry<String, String> aConversionDataMap : aStringConversionDataMap.entrySet()) {
					if(convertedString == null){
				    	convertedString = stringConvertModel.stringConvert(aConversionDataMap.getValue(), aConversionDataMap.getKey(), conversionOriginalString);
					}
				}
			}
			if(convertedString != null){
				convertedStringBuilder.append(convertedString);
				convertedString = null;
			}
			else{
				convertedStringBuilder.append(conversionOriginalString);
				convertedStringBuilder.append(ConversionDataFileConstant.LINE_SEPARATOR);
			}
		}
		exportFilWriter.write(convertedStringBuilder.toString());
		exportFilWriter.close();
	}
}
