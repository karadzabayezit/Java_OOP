public class Expression {
    public int a, b, c;

    public Expression(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getExpressionString() {
        return this.a + "x^2 + " + this.b + "x + " + this.c + " = 0";
    }

    public double getDiscriminant() {
        return Math.pow(this.b, 2) - 4 * this.a * this.c;
    }

    public double[] getRoots() {
        double[] roots = new double[2];
        double discriminant = getDiscriminant();

        if (discriminant < 0) return null;

        roots[0] = (-b + Math.sqrt(discriminant)) / (2 * this.a);
        roots[1] = (-b - Math.sqrt(discriminant)) / (2 * this.a);

        return roots;
    }
}