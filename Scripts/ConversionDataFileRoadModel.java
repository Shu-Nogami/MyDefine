import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversionDataFileRoadModel extends FileBase {

	private final String LINE_SEPARATOR = System.getProperty("line.separator");

	private final String BEFORE_CONVERSION_STRING = "Before:";

	private final String AFTER_CONVERSION_STRING = "After:";

	public ConversionDataFileRoadModel() {

	}

	public List<Map<String, String>> getConversionData(File aConversionDataFile, List<Map<String, String>> aStringConversionDataMap) throws IOException{
		Map<String, String> conversionDataMap = new HashMap<>();
		BufferedReader conversionDataFileReader = new BufferedReader(new FileReader(aConversionDataFile));
		String readLine = conversionDataFileReader.readLine();
		StringBuilder conversionBeforeDataBuilder = new StringBuilder();
		StringBuilder conversionAfterDataBuilder = new StringBuilder();
		boolean isBeforeConversionData = true;

		while(readLine != null){
			if(readLine.equals(this.BEFORE_CONVERSION_STRING)){
				if(!isBeforeConversionData){
					conversionDataMap.put(conversionBeforeDataBuilder.toString(), conversionAfterDataBuilder.toString());
					aStringConversionDataMap.add(conversionDataMap);
					conversionDataMap = new HashMap<>();
					conversionBeforeDataBuilder = this.resetStringBuilder(conversionBeforeDataBuilder);
					conversionAfterDataBuilder = this.resetStringBuilder(conversionAfterDataBuilder);
				}
				isBeforeConversionData = true;
				readLine = conversionDataFileReader.readLine();
				this.setReadStringBuilder(readLine, conversionBeforeDataBuilder, false);
				readLine = conversionDataFileReader.readLine();
				continue;
			}
			if(readLine.equals(this.AFTER_CONVERSION_STRING)){
				isBeforeConversionData = false;
				readLine = conversionDataFileReader.readLine();
				this.setReadStringBuilder(readLine, conversionAfterDataBuilder, false);
				readLine = conversionDataFileReader.readLine();
				continue;
			}
			if(isBeforeConversionData){
				this.setReadStringBuilder(readLine, conversionBeforeDataBuilder, true);
			}
			if(!isBeforeConversionData){
				this.setReadStringBuilder(readLine, conversionAfterDataBuilder, true);
			}
			readLine = conversionDataFileReader.readLine();
		}

		conversionDataFileReader.close();

		return aStringConversionDataMap;
	}

	private StringBuilder setReadStringBuilder(String aReadLine, StringBuilder aConversionDataBuilder, boolean isAddLineSeparator){
		if(isAddLineSeparator){
		    aConversionDataBuilder.append(this.LINE_SEPARATOR);
		}
		aConversionDataBuilder.append(aReadLine);
		return aConversionDataBuilder;
	}

	private StringBuilder resetStringBuilder(StringBuilder aConversionDataBuilder){
		aConversionDataBuilder.delete(0, aConversionDataBuilder.length());
		return aConversionDataBuilder;
	}
}
