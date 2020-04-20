import java.util.ArrayList;
import java.util.List;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        List<Integer> digits = new ArrayList<>();

        // add only digits
        char[] chars = stringToVerify.toCharArray();
        for(char character : chars) {
            if(Character.isDigit(character)) {
                digits.add(Character.getNumericValue(character));
            }
        }

        // check if X is last
        if(stringToVerify.endsWith("X")) {
            digits.add(10);
            System.out.println("There is X");
        }

        // return the pattern; digits list must have 10 numbers
        int sum = 0;
        if(digits.size() == 10) {
            for(int i=1; i<=digits.size(); i++) {
                sum += (11-i) * digits.get(i-1);
            }

            return sum % 11 == 0;
        }

        return false;


    }

}
