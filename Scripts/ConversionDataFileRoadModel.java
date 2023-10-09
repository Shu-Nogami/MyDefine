import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversionDataFileRoadModel extends FileBase {

	public ConversionDataFileRoadModel() {

	}

	public List getConversionData(File aConversionDataFile, List aStringConversionDataMap) throws FileNotFoundException{
		Map<String, String> conversionDataMap = new HashMap<>();
		BufferedReader conversionDataFileReader = new BufferedReader(new FileReader(aConversionDataFile));
		StringBuilder conversionBeforeDataBuilder = new StringBuilder();
		StringBuilder conversionAfterDataBuilder = new StringBuilder();

		return aStringConversionDataMap;
	}
}
