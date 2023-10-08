import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaveModel extends FileBase {

	public FileSaveModel() {

	}

	public void saveAsFile(File aSaveAsFile, String aTextEditerAreaString) throws IOException{
		FileWriter saveAsFileWriter = new FileWriter(aSaveAsFile);
		
		saveAsFileWriter.write(aTextEditerAreaString);

		saveAsFileWriter.close();
	}

}
