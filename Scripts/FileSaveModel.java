import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.IntStream;

public class FileSaveModel extends FileBase {

	private File conversionDataFile;

	public FileSaveModel() {

	}

	public void saveFile(File aSaveFile, String aTextEditerAreaString) throws IOException{
		FileWriter saveFileWriter = new FileWriter(aSaveFile);
		
		saveFileWriter.write(aTextEditerAreaString);

		saveFileWriter.close();
	}

	public File createConversionDataFile(String aConversionDataFilePath) throws IOException{
		this.conversionDataFile = new File(aConversionDataFilePath);
		this.conversionDataFile.createNewFile();

		this.initializeWriteConversionDataFile();

		return this.conversionDataFile;
	}

	private void initializeWriteConversionDataFile(){
		IntStream.rangeClosed(1, ConversionDataFileConstant.CONVERSION_STRING_NUMBER).forEach(i -> {
			try {
				this.writeConversionDataFile("", "");
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		});
		try {
			this.writeEndConversionDataFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	private void writeConversionDataFile(String aConversionBeforeDataString, String aConversionAfterDataString) throws IOException{
		FileWriter conversionDataFileWriter = new FileWriter(this.conversionDataFile, true);

		conversionDataFileWriter.write(ConversionDataFileConstant.BEFORE_CONVERSION_STRING);
		conversionDataFileWriter.write(ConversionDataFileConstant.LINE_SEPARATOR);

		conversionDataFileWriter.write(aConversionBeforeDataString);
		conversionDataFileWriter.write(ConversionDataFileConstant.LINE_SEPARATOR);

		conversionDataFileWriter.write(ConversionDataFileConstant.AFTER_CONVERSION_STRING);
		conversionDataFileWriter.write(ConversionDataFileConstant.LINE_SEPARATOR);

		conversionDataFileWriter.write(aConversionAfterDataString);
		conversionDataFileWriter.write(ConversionDataFileConstant.LINE_SEPARATOR);

		conversionDataFileWriter.close();
	}

	private void writeEndConversionDataFile() throws IOException{
		FileWriter conversionDataFileWriter = new FileWriter(this.conversionDataFile, true);
		
		conversionDataFileWriter.write(ConversionDataFileConstant.END_CONVERSION_STRING);

		conversionDataFileWriter.close();
	}

}
