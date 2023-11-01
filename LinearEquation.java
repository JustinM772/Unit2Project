public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        String equation = equation();
    }
    public double distance() {
        double distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        return roundedToHundredth(distance);
    }
    public double slope() {
        double slope = roundedToHundredth((double) (y2 - y1) / (x2 - x1));
        return slope;
    }
    public double yInt() {
        double slope = slope();
        return roundedToHundredth(y1 - slope * x1);
    }
    public String equation() {
        int differenceOfY = (int) y2 - y1;
        int differenceOfX = (int) x2 - x1;
        double equationYInt = yInt();
        String equation = "";
        equation += "y = ";
        if (differenceOfX == 0) {
            return "";
        } else if (slope() == 1) {
            equation += "x ";
        } else if (slope() == 0) {
            equation += "";
        } else if (slope() == -1) {
            equation += "-x ";
        } else if (differenceOfY % differenceOfX == 0) {
            equation += differenceOfY / differenceOfX + "x ";
        } else if (differenceOfY < 0 && differenceOfX < 0) {
            equation += (0 - differenceOfY) + "/" + (0 - differenceOfX) + "x ";
        } else if (differenceOfX < 0) {
            equation += "-" + differenceOfY + "/" + (0 - differenceOfX) + "x ";
        } else {
            equation += differenceOfY + "/" + differenceOfX + "x ";
        }
        if (yInt() == 0) {
            if (slope() == 0) {
                equation += "0";
            } else {
                equation += "";
            }
        } else if (yInt() < 0) {
            equation += "- " + roundedToHundredth(0 - yInt());
        } else {
            if (slope() == 0) {
                equation += yInt();
            } else {
                equation += "+ " + yInt();
            }
        }
        return equation;
    }
    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
    public String coordinateForX(double x) {
        double yCo = roundedToHundredth(slope() * x + yInt());
        return "(" + x + ", " + yCo + ")";
    }
    public String lineInfo() {
        String info = "";
        info += "The two points are: (" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 + ")" + "\n";
        info += "The equation of the line between these points is: " + equation() + "\n";
        info += "The slope of this line is: " + slope() + "\n";
        info += "The y-intercept of this line is: " + yInt() + "\n";
        info += "The distance between these points is: " + distance();
        return info;
    }
}





