import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameView extends JFrame {

	private TextEditerView textEditerView;

	private SettingView settingView;

	private JFrame myDefineFrame;

	private JPanel framePanel;

	private CardLayout viewPanelsCardLayout;

	private final String FRAME_TITLE = "MyDefine";

	private final Integer FRAME_X_SIZE = 600;

	private final Integer FRAME_Y_SIZE = 400;


	public FrameView(StringConversionDataModel aStringConversionDataModel) {
		this.initializeFrame();
		this.textEditerView = new TextEditerView(aStringConversionDataModel, this.myDefineFrame);
		this.settingView = new SettingView(aStringConversionDataModel);
		this.setUpCardLayout();
		this.showWindow();
	}

	private void initializeFrame(){
		myDefineFrame = new JFrame();
		myDefineFrame.setTitle(this.FRAME_TITLE);
		myDefineFrame.setSize(this.FRAME_X_SIZE, this.FRAME_Y_SIZE);
		myDefineFrame.setLocationRelativeTo(null);
		myDefineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setUpCardLayout(){
		this.framePanel = new JPanel();
		this.viewPanelsCardLayout = new CardLayout();
		this.framePanel.setLayout(this.viewPanelsCardLayout);

		this.framePanel.add(this.textEditerView.getTextEditerPanel());
		this.framePanel.add(this.settingView.getSettingPanel());

		this.myDefineFrame.getContentPane().add(this.framePanel, BorderLayout.CENTER);
		this.showTextEditerPanel();
	}

	public void showTextEditerPanel(){
		this.viewPanelsCardLayout.first(this.framePanel);
	}
	
	public void showSettingPanel(){
		this.viewPanelsCardLayout.last(this.framePanel);
	}

	private void showWindow(){
		myDefineFrame.setVisible(true);
	}

	public void writeTextEditerString(File aOpeningTextEdterFile) throws IOException{
		this.textEditerView.writeTextEditer(aOpeningTextEdterFile);
	}
}
