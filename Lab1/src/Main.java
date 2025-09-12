import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static int getInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Expression exp1 = new Expression(getInt("a1: "), getInt("b1: "), getInt("c1: "));
        System.out.println("The first expression: " + exp1.getExpressionString() + "\n");

        Expression exp2 = new Expression(getInt("a2: "), getInt("b2: "), getInt("c2: "));
        System.out.println("The second expression: " + exp2.getExpressionString() + "\n");

        System.out.println(exp1.getExpressionString() + "  D: " + exp1.getDiscriminant());
        double[] firstExpRoots = exp1.getRoots();
        System.out.println("First Exp Roots: " + (firstExpRoots == null ? "No roots" : Arrays.toString(firstExpRoots)));

        System.out.println(exp2.getExpressionString() + "  D: " + exp2.getDiscriminant());
        double[] secondExpRoots = exp2.getRoots();
        System.out.println("Second Exp Roots: " + (secondExpRoots == null ? "No roots" : Arrays.toString(secondExpRoots)));

        if(firstExpRoots == null) {
            System.out.println("\nThe second equation has the larger maximum root. Because the first does not have any roots");
            return;
        } else if(secondExpRoots == null) {
            System.out.println("\nThe first equation has the larger maximum root. Because the second does nt have any roots");
            return;
        }

        double max1 = Math.max(firstExpRoots[0], firstExpRoots[1]);
        double max2 = Math.max(secondExpRoots[0], secondExpRoots[1]);

        if (max1 > max2) {
            System.out.println("\nThe first equation has the larger maximum root");
        } else if (max1 < max2) {
            System.out.println("\nThe second equation has the larger maximum root");
        } else {
            System.out.println("\nThe maximum roots are equal");
        }

        scanner.close();
    }
}