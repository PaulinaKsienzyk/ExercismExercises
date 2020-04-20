class RaindropConverter {

    String convert(int number) {
        String word = "";
        if(number%3==0){
            word += ("Pling");
        }
        if(number%5==0){
            word += ("Plang");
        }
        if(number%7==0){
            word += ("Plong");
        }
        if(number%3!=0&&number%5!=0&&number%7!=0){
            word = String.valueOf(number);
        }
        return word;
    }

    public static void main (String[] args){
        RaindropConverter raindropConverter = new RaindropConverter();
        System.out.println(raindropConverter.convert(15));

    }

}
