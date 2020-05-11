public class BeerSong {

    public String sing(int bottles, int verses) {
        StringBuilder sB = new StringBuilder();

        for(int i=verses; i>0; i--) {
            if(bottles == 0) {
                sB.append("No more bottles of beer on the wall, no more bottles of beer.\n" +
                        "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n");
                break;
            } else if (bottles == 1) {
                sB.append("1 bottle of beer on the wall, 1 bottle of beer.\n" +
                        "Take it down and pass it around, ");
            } else {
                sB.append(bottles).append(" bottles of beer on the wall, ").append(bottles).append(" bottles of beer.\n").
                        append("Take one down and pass it around, ");
            }


            if((bottles-1) == 0) {
                sB.append("no more");
            } else {
                sB.append(bottles - 1);
            }
            sB.append(((bottles-1)==1) ? " bottle" : " bottles").append(" of beer on the wall.\n\n");

            bottles--;
        }

        return sB.toString();
    }

    public String singSong() {
        return sing(99, 100);
    }



}
