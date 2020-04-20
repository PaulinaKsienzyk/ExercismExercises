import java.text.NumberFormat;
import java.text.ParsePosition;

class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        if(!isNumeric(inputNumber)) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }

        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        int stringLength = this.inputNumber.length();
        if(numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        if(stringLength < numberOfDigits) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }


        long largestProduct = 0;
        StringBuilder sB = new StringBuilder(this.inputNumber);

        for(int i=0; i+(numberOfDigits-1) < stringLength; i++) {
            String substring = sB.substring(i, i+numberOfDigits);
            char[] chars = substring.toCharArray();
            long product = 1;

            for(char c: chars) {
                product *= Character.getNumericValue(c);
            }
            System.out.println(product);

            if(product >= largestProduct) {
                largestProduct = product;
            }
        }

        return largestProduct;
    }


    private static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

}
