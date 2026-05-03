package mvc.binary;

import mvc.common.ICalculatorModel;

public class BinaryCalculatorModel implements ICalculatorModel {

    private double result;

    /** inputMode : "BIN" ou "DEC" */
    public void calculate(String rawA, String rawB, String op, String inputMode) {
        long a, b;
        if ("BIN".equals(inputMode)) {
            if (!rawA.matches("[01]+")) throw new IllegalArgumentException("\"" + rawA + "\" n'est pas un nombre binaire valide");
            if (!rawB.matches("[01]+")) throw new IllegalArgumentException("\"" + rawB + "\" n'est pas un nombre binaire valide");
            a = Long.parseLong(rawA, 2);
            b = Long.parseLong(rawB, 2);
        } else {
            a = (long) Double.parseDouble(rawA);
            b = (long) Double.parseDouble(rawB);
        }

        switch (op) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "×": result = a * b; break;
            case "÷":
                if (b == 0) throw new ArithmeticException("Division par zéro impossible");
                result = (double) a / b;
                break;
            default: throw new IllegalArgumentException("Opération inconnue");
        }
    }

    @Override
    public double getResult() { return result; }

    @Override
    public void clear() { result = 0; }

    public String getResultBinary() {
        long r = (long) result;
        return (r < 0 ? "-" : "") + Long.toBinaryString(Math.abs(r));
    }

    public String getResultDecimal() {
        if (result == Math.floor(result)) return String.valueOf((long) result);
        return String.format("%.6g", result);
    }
}
