import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.BorderLayout;

public class TextEditerView extends JFrame {

	private TextEditerController textEditerController;

	private Container frameContentPane;

	private JPanel textEditerJPanel;

	public TextEditerView(StringConversionDataModel aStringConversionDataModel, Container aframeContainer) {
		this.textEditerController = new TextEditerController(aStringConversionDataModel, this);
		this.frameContentPane = aframeContainer;
		this.InitializeTextEditer();
	}

	private void InitializeTextEditer(){
		textEditerJPanel = new JPanel();
	}

}
