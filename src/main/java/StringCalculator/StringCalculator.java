package StringCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(final String text) {

        if (text == null) {
            return 0;
        }

        if (text.isEmpty()) {
            return 0;
        }

        return sum(stringToArray(text));
    }

    private String[] stringToArray(String text) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }

        String[] tokens= text.split(",|:");
        return tokens;
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .map(this::parsePositiveNumber)
                .reduce(0, Integer::sum);
    }

    private int parsePositiveNumber(String text) {
        if (Integer.parseInt(text) >= 0) {
            return Integer.parseInt(text);
        } else {
            throw new RuntimeException();
        }
    }
}