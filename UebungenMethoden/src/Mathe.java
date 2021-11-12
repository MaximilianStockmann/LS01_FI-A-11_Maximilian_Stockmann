public class Mathe {
    public static double quadrat(double x) {
        return x * x;
    }

    public static double hypotenuse(double kathete1, double kathete2) {
        return Math.sqrt(quadrat(kathete1) + quadrat(kathete2));
    }
}
