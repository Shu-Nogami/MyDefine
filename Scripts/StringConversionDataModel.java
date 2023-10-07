public class StringConversionDataModel extends Object {

	private FrameView frameView;

	public StringConversionDataModel() {
		this.frameView = new FrameView(this);

	}

	public void frameChangeTextEditerToSetting(){
		this.frameView.showSettingPanel();
	}

	public void frameChangeSettingToTextEditer(){
		this.frameView.showTextEditerPanel();
	}

}
