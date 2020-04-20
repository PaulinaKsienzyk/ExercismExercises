class ReverseString {

    String reverse(String inputString) {
        String reverseWord = "";
        char[] letters = inputString.toCharArray();
        for(int i=letters.length-1; i>=0; i--) {
            reverseWord += letters[i];
        }
        return reverseWord;
    }


    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverse("list"));
    }
  
}