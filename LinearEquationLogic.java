import java.util.Scanner;
public class LinearEquationLogic {
    private Scanner scan;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private LinearEquation equation;
    private String more = "y";
    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }
    public void start() {
        System.out.println("Welcome to the linear equation calculator! ");
        while (more.equals("y")) {
            getCoordinates();
            if (x1 != x2) {
                getXValue();
            }
            repeat();
        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }
    public void getCoordinates() {
        if (more.equals("y")) {
            System.out.print("Enter coordinate 1: ");
            String c1 = scan.nextLine();
            System.out.print("Enter coordinate 2: ");
            String c2 = scan.nextLine();
            int c1Index = c1.indexOf(",");
            int c2Index = c2.indexOf(",");
            x1 = Integer.parseInt(c1.substring(1, c1Index));
            y1 = Integer.parseInt(c1.substring(c1Index + 2, c1.length() - 1));
            x2 = Integer.parseInt(c2.substring(1, c2Index));
            y2 = Integer.parseInt(c2.substring(c2Index + 2, c2.length() - 1));
            equation = new LinearEquation(x1, y1, x2, y2);
            if (x1 != x2) {
                System.out.println("Equation: " + equation.equation());
                System.out.println("Slope: " + equation.slope());
                System.out.println("y-intercept: " + equation.yInt());
                System.out.println("Distance: " + equation.distance());
                System.out.println();
                System.out.println("----- Line info -----");
                System.out.println(equation.lineInfo());
                System.out.println();
            } else {
                System.out.println("These points are on a vertical line: x = " + x1);
            }

        }
    }
    public void getXValue() {
        System.out.print("Enter an x value: ");
        double x = scan.nextDouble();
        scan.nextLine();
        System.out.println("The point on the line is " + equation.coordinateForX(x));
    }
    public void repeat() {
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        more = scan.nextLine();
    }
}


