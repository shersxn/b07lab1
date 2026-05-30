import java.io.*;
import java.util.Scanner;

public class Polynomial {

    double[] coefficients;
    int[] exponents;

    public Polynomial() {
        coefficients = new double[1];
        coefficients[0] = 0;
        exponents = new int[1];
        exponents[0] = 0;
    }

    public Polynomial(File f) throws IOException {
        Scanner scanner = new Scanner(f);
        int count = 0;
        while (scanner.hasNextDouble()) {
            scanner.nextDouble();
            scanner.nextInt();
            count++;
        }
        scanner.close();
 
        coefficients = new double[count];
        exponents = new int[count];
 
        scanner = new Scanner(f);
        for (int i = 0; i < count; i++) {
            coefficients[i] = scanner.nextDouble();
            exponents[i] = scanner.nextInt();
        }
        scanner.close();
    }

    public Polynomial(double[] arr, int[] exp) {
        coefficients = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            coefficients[i] = arr[i];
        }
        exponents = new int[exp.length];
        for (int i = 0; i < exp.length; i++) {
            exponents[i] = exp[i];
        }
    }

    public Polynomial add(Polynomial p) {
        for (int i = 0; i < p.coefficients.length; i++) {
            coefficients[i] += p.coefficients[i];
        }
        return this;
    }

    public Polynomial multiply(Polynomial p) {
        for (int i = 0; i < p.coefficients.length; i++) {
            coefficients[i] = coefficients[i] * p.coefficients[i];
        }
        for (int j = 0; j < p.exponents.length; j++) {
            exponents[j] = exponents[j] * p.exponents[j];
        }
        return this;
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            result = result + coefficients[i] * Math.pow(x, exponents[i]);
        }
        return result;
    }

    public boolean hasRoot(double x) {
        if (evaluate(x) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < coefficients.length; i++) {
            writer.write(coefficients[i] + " " + exponents[i]);
            if (i < coefficients.length - 1) {
                writer.newLine();
            }
        }
        writer.close();
    }
}