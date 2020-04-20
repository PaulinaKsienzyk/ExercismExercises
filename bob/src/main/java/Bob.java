
public class Bob {


    public String hey(String saySomething) {
        String something = saySomething.replace(" ", "").replace("\t", "")
                .replace("\n", "").replace("\r", "");
        if(something.equals("")) {
            return "Fine. Be that way!";
        }
        if(isStringUppercase(something)) {
            if(something.contains("?")) {
                return "Calm down, I know what I'm doing!";
            }
            return "Whoa, chill out!";
        }
        char[] chars = something.toCharArray();
        if(chars[chars.length - 1] == '?') {
            return "Sure.";
        }
        return "Whatever.";



    }

    private boolean isStringUppercase(String string) {
        char[] chars = string.toCharArray();
        String letters = "";
        for(int i=0; i<string.length(); i++) {
            if (Character.isLetter(chars[i])) {
                letters += chars[i];
                if(!Character.isUpperCase(chars[i])) {
                    return false;
                }
            }
        }
        if(letters.equals("")) {
            return false;
        }
        return true;
    }

}
