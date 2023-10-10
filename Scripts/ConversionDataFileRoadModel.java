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
					System.out.println(conversionBeforeDataBuilder);
					conversionDataMap.put(conversionBeforeDataBuilder.toString(), conversionAfterDataBuilder.toString());
					conversionBeforeDataBuilder = this.resetStringBuilder(conversionBeforeDataBuilder);
					conversionAfterDataBuilder = this.resetStringBuilder(conversionAfterDataBuilder);
				}
				isBeforeConversionData = true;
				readLine = conversionDataFileReader.readLine();
				continue;
			}
			if(readLine.equals(this.AFTER_CONVERSION_STRING)){
				isBeforeConversionData = false;
				readLine = conversionDataFileReader.readLine();
				continue;
			}
			if(isBeforeConversionData){
				this.setReadStringBuilder(readLine, conversionBeforeDataBuilder);
			}
			if(!isBeforeConversionData){
				this.setReadStringBuilder(readLine, conversionAfterDataBuilder);
			}
			readLine = conversionDataFileReader.readLine();
		}

		conversionDataFileReader.close();
		aStringConversionDataMap.add(conversionDataMap);

		return aStringConversionDataMap;
	}

	private StringBuilder setReadStringBuilder(String aReadLine, StringBuilder aConversionDataBuilder){
		aConversionDataBuilder.append(aReadLine);
		aConversionDataBuilder.append(this.LINE_SEPARATOR);
		return aConversionDataBuilder;
	}

	private StringBuilder resetStringBuilder(StringBuilder aConversionDataBuilder){
		aConversionDataBuilder.delete(0, aConversionDataBuilder.length());
		return aConversionDataBuilder;
	}
}
