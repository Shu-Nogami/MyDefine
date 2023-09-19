import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;

public class TextEditerView extends JFrame {

	private TextEditerController textEditerController;

	public TextEditerView(StringConversionDataModel aStringConversionDataModel) {
		this.textEditerController = new TextEditerController(aStringConversionDataModel, this);
	}

}
