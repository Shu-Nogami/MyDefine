import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;

public class TextEditerView extends JFrame {

	private TextEditerController textEditerController;

	private Container textEditerContentPane;

	public TextEditerView(StringConversionDataModel aStringConversionDataModel, Container aTexteditContainer) {
		this.textEditerController = new TextEditerController(aStringConversionDataModel, this);
		this.textEditerContentPane = aTexteditContainer;
	}

}
