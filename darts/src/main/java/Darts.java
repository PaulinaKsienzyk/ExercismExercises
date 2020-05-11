class Darts {
    private double x;
    private double y;

    Darts(double x, double y) {
        this.x = Math.abs(x);
        this.y = Math.abs(y);
    }

    int score() {
        if(x > getMaxX(10.0) || y > getMaxY(10.0)) {
            return 0;
        }
        if(x > getMaxX(5.0) || y > getMaxY(5.0)) {
            return 1;
        }
        if(x > getMaxX(1.0) || y > getMaxY(1.0)) {
            return 5;
        }
        return 10;

    }

    private double getMaxX(double r) {
        double max =  Math.sqrt((r*r) - (y*y));
        if(max >=0) {
            return max;
        }
        return 0;
    }

    private double getMaxY(double r) {
        double max = Math.sqrt((r*r)  - (x*x));
        if(max >=0) {
            return max;
        }
        return 0;
    }


}


