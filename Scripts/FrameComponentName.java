public class FrameComponentName {

	public static final String FILE_OPEN = "Open";

	public static final String SETTING_BUTTON = "Setting";

	public static final String USER_SETTING_BUTTON = "User Setting";

	public static final String FILE_SAVE = "Save";

	public static final String FILE_SAVE_AS = "Save as";

	public static final String IMPORT_BUTTON = "Import";

	public static final String EXPORT_BUTTON = "Export";

	public static final String ADD_TEMPLATE_BUTTON = "Add template";

	public static final String EXIT_SETTING_BUTTON = "Save and exit";

	public static final String SAVE_SETTING_BUTTON = "Save";

	public static final String TEXTEDITER = "";

	public static final String ORIGINAL_TEXT = "";

	public static final String CONVERSION_TEXT = "";

	public static final String FILE_MENU = "File";

	public static final String EDIT_MENU = "";

	public enum ConversionNames{
		conversionFirstMap(0),
		conversionSecondMap(1),
		conversionThirdMap(2),
		conversionFourthMap(3),
		conversionFifthMap(4),
		conversionSixthMap(5),
		conversionSeventhMap(6),
		conversionEighthMap(7),
		conversionNinthMap(8),
		conversionTenthMap(9);

		private Integer id;

		private ConversionNames(Integer id){
			this.id = id;
		}

		public Integer getInteger(){
			return this.id;
		}

		public static String getConversionNames(final Integer id){
			ConversionNames[] conversionNames = ConversionNames.values();
			for (ConversionNames conversionName : conversionNames) {
				if(conversionName.getInteger() == id){
					return conversionName.name();
				}
			}
			return null;
		}
	}
}
