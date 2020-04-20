
public class PhoneNumber {
    private final String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        String number = phoneNumber.replaceAll("[ ()-.]", "");

        if (number.matches(".*[a-z].*")) throw new IllegalArgumentException("letters not permitted");
        if (number.matches(".*\\D.*")) throw new IllegalArgumentException("punctuations not permitted");
        if (number.length() < 10) throw new IllegalArgumentException("incorrect number of digits");
        if (number.length() == 11) {
            if (number.startsWith("1")) {
                number = number.substring(1);
            } else {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
        }
        if (number.length() > 11) throw new IllegalArgumentException("more than 11 digits");
        if (number.startsWith("0")) throw new IllegalArgumentException("area code cannot start with zero");
        if (number.startsWith("1")) throw new IllegalArgumentException("area code cannot start with one");
        if (number.charAt(3) == '0') throw new IllegalArgumentException("exchange code cannot start with zero");
        if (number.charAt(3) == '1') throw new IllegalArgumentException("exchange code cannot start with one");

        this.phoneNumber = number;
    }

    public String getNumber() {
        return phoneNumber;
    }
    
}