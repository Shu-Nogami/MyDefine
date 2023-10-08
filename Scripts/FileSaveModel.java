import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaveModel extends FileBase {

	public FileSaveModel() {

	}

	public void saveFile(File aSaveFile, String aTextEditerAreaString) throws IOException{
		FileWriter saveFileWriter = new FileWriter(aSaveFile);
		
		saveFileWriter.write(aTextEditerAreaString);

		saveFileWriter.close();
	}

}
