package klmnkki.task1;

public class SinFunction
{
    public static double mySin(double x, int accuracy) {
        double sum = 0;

        for (int n = 1; n <= accuracy; n++) {
            sum += (Math.pow(-1, n - 1) * Math.pow(x, 2 * n - 1)) / factorial(2 * n - 1);
        }

        return sum;
    }

    private static double factorial(int x)
    {
        if (x == 0 || x == 1) return 1;
        return x * factorial(x - 1);
    }


    public static void main(String[] args)
    {
        System.out.println("my sin: " + mySin(0.01,1));
        System.out.println("math sin: " + Math.sin(0.01));
    }
}
