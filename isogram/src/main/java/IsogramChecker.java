class IsogramChecker {


    boolean isIsogram(String phrase) {
        char[] letters = phrase.toLowerCase().replace(" ", "").replace("-", "").toCharArray();
        for(int i=0; i<letters.length; i++){
            char temp = letters[i];
            for(int j=0; j<letters.length; j++){
                if (i==j){
                    continue;
                }
                if (temp == letters[j]){
                        return false;
                }
            }
        }
        return true;
    }

}
