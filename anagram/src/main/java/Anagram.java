

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

    private String word;
    private List<String> anagrams = new ArrayList<>();

    public Anagram(String word) {
        this.word = word.toLowerCase().replace(" ", "");
    }

    protected List<String> match(List<String> asList) {
        char[] temp1 = this.word.toCharArray();
        Arrays.sort(temp1);
        String word1 = Arrays.toString(temp1);
        for (int i = 0; i < asList.size(); i++) {
            if(!this.word.equals(asList.get(i).toLowerCase())
                    && this.word.compareTo(asList.get(i)) != 0) {
                char[] temp2 = asList.get(i).toLowerCase().toCharArray();
                Arrays.sort(temp2);
                String word2 = Arrays.toString(temp2);
                if (word1.equals(word2)) {
                    anagrams.add(asList.get(i));
                }
            }
        }
        return anagrams;
    }







}