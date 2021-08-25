package cookbook.util;

import cookbook.domain.MeasureUnity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    /**
     * Method that receives a string that corresponds to the measure unit, and slips it between the integer and the string.
     *
     * @param measureUnit is the string that is necessary to split
     * @return a Measure Unity object
     */
    public static MeasureUnity splitMeasureUnity(String measureUnit) {
        Pattern pattern = Pattern.compile("(\\d+)(\\w+)");
        Matcher matcher = pattern.matcher(measureUnit);
        if (matcher.find()) {
            String amount = matcher.group(1);
            String measureUnity = matcher.group(2);
            return new MeasureUnity(Integer.parseInt(amount), measureUnity);
        }
        return null;
    }
}
