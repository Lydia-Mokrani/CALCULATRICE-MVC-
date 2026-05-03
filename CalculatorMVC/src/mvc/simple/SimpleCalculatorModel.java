package mvc.simple;

public class SimpleCalculatorModel {

    private double result;

    public void calculate(double a, double b, String op) {
        switch (op) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "×": result = a * b; break;
            case "÷":
                if (b == 0) throw new ArithmeticException("Division par zéro impossible");
                result = a / b;
                break;
            default: throw new IllegalArgumentException("Opération inconnue : " + op);
        }
    }

    public double getResult() { return result; }

    public String format(double v) {
        if (v == Math.floor(v) && !Double.isInfinite(v))
            return String.valueOf((long) v);
        return String.format("%.6g", v);
    }
}
