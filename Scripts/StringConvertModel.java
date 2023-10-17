import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StringConvertModel {

    private boolean isEqualsString = true;

    private List<String> conversionBeforeStringList;

    private List<String> conversionAfterStringList;

    private List<String> conversionOriginalStringList;

    private final String HALF_WIDTH_SPACE = " ";

    private final String COLON = ":";

    private final String SKIP_WILD_CORD = "$@$";

    public String stringConvert(String aConversionBeforeString, String aConversionAfterString, String aConversionOriginalString){
        StringBuilder convertedStringBuilder = new StringBuilder();

        conversionBeforeStringList = Arrays.asList(aConversionBeforeString.split(HALF_WIDTH_SPACE));
        conversionAfterStringList = Arrays.asList(aConversionAfterString.split(HALF_WIDTH_SPACE));
        conversionOriginalStringList = Arrays.asList(aConversionOriginalString.split(HALF_WIDTH_SPACE));

        conversionBeforeStringList = this.divisionColon(conversionBeforeStringList);
        conversionAfterStringList = this.divisionColon(conversionAfterStringList);
        conversionOriginalStringList = this.divisionColon(conversionOriginalStringList);

        IntStream.range(0, conversionOriginalStringList.size()).forEach(i -> {
            if(this.conversionBeforeStringList.get(i).equals(this.SKIP_WILD_CORD)){
                convertedStringBuilder.append(conversionOriginalStringList.get(i));
            }
            else{
                this.checkEqualsString(Integer.valueOf(i));
                if(isEqualsString) convertedStringBuilder.append(conversionAfterStringList.get(i));
            }
        });

        if(!isEqualsString) return null;
        return convertedStringBuilder.toString();
    }

    private List<String> divisionColon(List<String> aConversionString){
        String lastStringGroup;
        String lastString;

        lastStringGroup = aConversionString.get(aConversionString.size() - 1);
        lastString = lastStringGroup.substring(lastStringGroup.length() - 1);

        if(lastString.equals(COLON)){
            aConversionString.remove(aConversionString.size() - 1);
            aConversionString.add(lastStringGroup.substring(0, lastStringGroup.length() - 1));
            aConversionString.add(COLON);
        }
        return aConversionString;
    }

    private void checkEqualsString(Integer listNumber){
        if(this.conversionBeforeStringList.get(listNumber).equals(this.conversionOriginalStringList.get(listNumber))) this.isEqualsString = true;
        else this.isEqualsString = false;
    }
}
