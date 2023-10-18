import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class StringConvertModel extends Object {

    private boolean isEqualsString = true;

    private List<String> conversionBeforeStringList;

    private List<String> conversionAfterStringList;

    private List<String> conversionOriginalStringList;

    private final String HALF_WIDTH_SPACE = " ";

    private final String COLON = ":";

    private final String SKIP_WILD_CORD = "$@$";

    public String stringConvert(String aConversionBeforeString, String aConversionAfterString, String aConversionOriginalString){
        StringBuilder convertedStringBuilder = new StringBuilder();
        List<String> notConveredStringList = new ArrayList<>();

        conversionBeforeStringList = new LinkedList<>(Arrays.asList(aConversionBeforeString.split(HALF_WIDTH_SPACE)));
        conversionAfterStringList = new LinkedList<>(Arrays.asList(aConversionAfterString.split(HALF_WIDTH_SPACE)));
        conversionOriginalStringList = new LinkedList<>(Arrays.asList(aConversionOriginalString.split(HALF_WIDTH_SPACE)));

        conversionBeforeStringList = this.divisionColon(conversionBeforeStringList);
        conversionAfterStringList = this.divisionColon(conversionAfterStringList);
        conversionOriginalStringList = this.divisionColon(conversionOriginalStringList);

        IntStream.range(0, conversionOriginalStringList.size() - 1).forEach(i -> {
            if(this.conversionBeforeStringList.get(i).equals(this.SKIP_WILD_CORD)){
                notConveredStringList.add(conversionOriginalStringList.get(i));
            }
            else{
                this.checkEqualsString(Integer.valueOf(i));
            }
        });

        if(isEqualsString){
            IntStream.range(0, conversionAfterStringList.size()).forEach(i -> {
                if(this.conversionAfterStringList.get(i).equals(this.SKIP_WILD_CORD)){
                    convertedStringBuilder.append(notConveredStringList.get(0));
                    notConveredStringList.remove(0);
                }
                else{
                    convertedStringBuilder.append(conversionAfterStringList.get(i));
                }
                if((conversionAfterStringList.size() - 1) != i){
                    if(!conversionAfterStringList.get(i + 1).equals(this.COLON)){
                        convertedStringBuilder.append(this.HALF_WIDTH_SPACE);
                    }
                }
            });
            convertedStringBuilder.append(ConversionDataFileConstant.LINE_SEPARATOR);
            return convertedStringBuilder.toString();
        }
        return null;
    }

    private List<String> divisionColon(List<String> aConversionStringList){
        String lastStringGroup;
        String lastString;

        lastStringGroup = aConversionStringList.get(aConversionStringList.size() - 1);
        lastString = lastStringGroup.substring(lastStringGroup.length() - 1);

        if(lastString.equals(COLON)){
            aConversionStringList.remove(aConversionStringList.size() - 1);
            aConversionStringList.add(lastStringGroup.substring(0, lastStringGroup.length() - 1));
            aConversionStringList.add(COLON);
        }
        return aConversionStringList;
    }

    private void checkEqualsString(Integer listNumber){
        if(this.conversionBeforeStringList.get(listNumber).equals(this.conversionOriginalStringList.get(listNumber))) this.isEqualsString = true;
        else this.isEqualsString = false;
    }
}
