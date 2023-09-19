import javax.swing.JFrame;

public class TextEditerView extends JFrame {

	private TextEditerController textEditerController;

	public TextEditerView(StringConversionDataModel aStringConversionDataModel) {
		this.textEditerController = new TextEditerController(aStringConversionDataModel, this);
	}

}
