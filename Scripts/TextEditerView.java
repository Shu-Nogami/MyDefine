import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;

public class TextEditerView extends JFrame {

	private TextEditerController textEditerController;

	private Container frameContentPane;

	public TextEditerView(StringConversionDataModel aStringConversionDataModel, Container aframeContainer) {
		this.textEditerController = new TextEditerController(aStringConversionDataModel, this);
		this.frameContentPane = aframeContainer;
	}

}
