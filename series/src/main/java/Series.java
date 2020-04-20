import java.util.ArrayList;
import java.util.List;

public class Series {
    private final String number;

    public Series(String number) {
        this.number = number;
    }

    public List<String> slices(int digitQuantity) throws IllegalArgumentException {
        int nrLength = this.number.length();

        if (digitQuantity > nrLength) {
            throw new IllegalArgumentException("Slice size is too big.");
        }
        if (digitQuantity < 1) {
           throw new IllegalArgumentException("Slice size is too small.");
        }

        List<String> series = new ArrayList<>();
        for (int i = 0; (i + digitQuantity) <= nrLength; i++) {
            series.add(this.number.substring(i, i + (digitQuantity)));
        }

        return series;
    }
}
