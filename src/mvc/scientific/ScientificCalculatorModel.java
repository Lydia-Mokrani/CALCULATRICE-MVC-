package mvc.scientific;

import mvc.common.ICalculatorModel;

public class ScientificCalculatorModel implements ICalculatorModel {

    private double result;

    /** Opérations binaires (+, -, ×, ÷, pow) */
    public void calculateBinary(double a, double b, String op) {
        switch (op) {
            case "+":   result = a + b; break;
            case "-":   result = a - b; break;
            case "×":   result = a * b; break;
            case "÷":
                if (b == 0) throw new ArithmeticException("Division par zéro impossible");
                result = a / b; break;
            case "pow": result = Math.pow(a, b); break;
            default: throw new IllegalArgumentException("Opération binaire inconnue : " + op);
        }
    }

    /** Opérations unaires */
    public void calculateUnary(double a, String op) {
        switch (op) {
            case "sin":  result = Math.sin(Math.toRadians(a)); break;
            case "cos":  result = Math.cos(Math.toRadians(a)); break;
            case "tan":
                if (Math.cos(Math.toRadians(a)) == 0)
                    throw new ArithmeticException("tan indéfini pour " + a + "°");
                result = Math.tan(Math.toRadians(a)); break;
            case "√":
                if (a < 0) throw new ArithmeticException("Racine carrée d'un nombre négatif");
                result = Math.sqrt(a); break;
            case "log":
                if (a <= 0) throw new ArithmeticException("log indéfini pour valeur ≤ 0");
                result = Math.log10(a); break;
            case "ln":
                if (a <= 0) throw new ArithmeticException("ln indéfini pour valeur ≤ 0");
                result = Math.log(a); break;
            case "abs":  result = Math.abs(a); break;
            case "1/x":
                if (a == 0) throw new ArithmeticException("Division par zéro (1/0)");
                result = 1.0 / a; break;
            case "x²":   result = a * a; break;
            case "exp":  result = Math.exp(a); break;
            default: throw new IllegalArgumentException("Opération unaire inconnue : " + op);
        }
    }

    @Override
    public double getResult() { return result; }

    @Override
    public void clear() { result = 0; }

    public String format(double v) {
        if (Double.isNaN(v))      return "NaN";
        if (Double.isInfinite(v)) return v > 0 ? "+∞" : "-∞";
        if (v == Math.floor(v) && Math.abs(v) < 1e12) return String.valueOf((long) v);
        return String.format("%.8g", v);
    }

    public static final String[] BINARY_OPS = {"+", "-", "×", "÷", "pow"};
    public static final String[] UNARY_OPS  = {"sin","cos","tan","√","log","ln","abs","1/x","x²","exp"};
}
