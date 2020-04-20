import java.util.ArrayList;
import java.util.List;

class LuhnValidator {

    boolean isValid(String candidate) {
        char[] charsArr = candidate.replace(" ", "").toCharArray();
        if(charsArr.length <= 1) {
            return false;
        }

        List<Integer> integerList = new ArrayList<>();
        int sum = 0;

        //check whether is digit
        for (char c : charsArr) {
            if (Character.isDigit(c)) {
                integerList.add(Character.getNumericValue(c));
            } else {
                return false;
            }
        }


        int count = 1;
        for(int i= integerList.size()-1; i>=0; i--) {
            if(count % 2 == 0) {     // doubling for each second digit, starting from right
                int temp = integerList.get(i) * 2;
                if(temp > 9) {
                    temp = temp - 9;
                }
                sum += temp;
            } else {
                sum += integerList.get(i);
            }

            count++;
        }

        return (sum % 10) == 0;

    }

}
