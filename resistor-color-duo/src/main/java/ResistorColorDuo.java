import java.util.LinkedHashMap;
import java.util.Map;

class ResistorColorDuo {

    private final ResistorColor resistorColor = new ResistorColor();

    int value(String[] colors) {
        StringBuilder value = new StringBuilder();

        for (int i=0; i<colors.length; i++) {
            if(i==2) {
                break;
            }
            value.append(resistorColor.colorCode(colors[i]));
        }



        return Integer.parseInt(value.toString());
    }



    static final class ResistorColor {

        Map<String,Integer> colorsMap;

        public ResistorColor() {
            this.colorsMap = new LinkedHashMap<>();
            this.colorsMap.put("black", 0);
            this.colorsMap.put("brown", 1);
            this.colorsMap.put("red", 2);
            this.colorsMap.put("orange", 3);
            this.colorsMap.put("yellow", 4);
            this.colorsMap.put("green", 5);
            this.colorsMap.put("blue", 6);
            this.colorsMap.put("violet", 7);
            this.colorsMap.put("grey", 8);
            this.colorsMap.put("white", 9);
        }

        int colorCode(String color) {
            return this.colorsMap.get(color.toLowerCase());
        }

    }

}
