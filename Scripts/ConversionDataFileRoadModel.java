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

	private final String END_CONVERSION_STRING = "End";

	public ConversionDataFileRoadModel() {

	}

	public List<Map<String, String>> getConversionData(File aConversionDataFile, List<Map<String, String>> aStringConversionDataList) throws IOException{
		BufferedReader conversionDataFileReader = new BufferedReader(new FileReader(aConversionDataFile));
		String readLine = conversionDataFileReader.readLine();
		StringBuilder conversionBeforeDataBuilder = new StringBuilder();
		StringBuilder conversionAfterDataBuilder = new StringBuilder();
		boolean isBeforeConversionData = true;

		while(readLine != null){
			if(readLine.equals(this.BEFORE_CONVERSION_STRING)){
				if(!isBeforeConversionData){
				    aStringConversionDataList = this.addListToConversionMap(conversionBeforeDataBuilder, conversionAfterDataBuilder, aStringConversionDataList);
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
			if(readLine.equals(this.END_CONVERSION_STRING)){
				aStringConversionDataList = this.addListToConversionMap(conversionBeforeDataBuilder, conversionAfterDataBuilder, aStringConversionDataList);
				break;
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

		return aStringConversionDataList;
	}

	private StringBuilder setReadStringBuilder(String aReadLine, StringBuilder aConversionDataBuilder, boolean isAddLineSeparator){
		if(isAddLineSeparator){
		    aConversionDataBuilder.append(this.LINE_SEPARATOR);
		}
		aConversionDataBuilder.append(aReadLine);
		return aConversionDataBuilder;
	}

	private List<Map<String, String>> addListToConversionMap(StringBuilder aConversionBeforeDataBuilder, StringBuilder aConversionAfterDataBuilder, List<Map<String, String>> aStringConversionDataList){
		Map<String, String> conversionDataMap = new HashMap<>();
		conversionDataMap.put(aConversionBeforeDataBuilder.toString(), aConversionAfterDataBuilder.toString());
		aStringConversionDataList.add(conversionDataMap);
		return aStringConversionDataList;
	}

	private StringBuilder resetStringBuilder(StringBuilder aConversionDataBuilder){
		aConversionDataBuilder.delete(0, aConversionDataBuilder.length());
		return aConversionDataBuilder;
	}
}
