import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditerController extends Object implements ActionListener{

	private StringConversionDataModel stringConversionDataModel;

	private TextEditerView textEditerView;

	public TextEditerController(StringConversionDataModel aStringConversionDataModel, TextEditerView aTextEditerView) {
		this.stringConversionDataModel = aStringConversionDataModel;
		this.textEditerView = aTextEditerView;
	}

	public void actionPerformed(ActionEvent e){

	}
}
