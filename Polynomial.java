public static void main (String[] args){
    double[] coefficients;

    public class Polynomial {

        public Polynomial() {
            coefficients = new double[0];
            coefficients [0] = 0;
        }
        public Polynomial(double[] arr) {
            coefficients = new double[arr.length];
            for (int i=0; i<arr.length; i++) {
                coefficients[i] = arr[i];
            }
        }
        public Polynomial add(Polynomial p) {
            for (int i=0; i<p.length(); i++) {
                this.coefficients[i] += p.coefficients[i];
                return this;
            }
        }

        public int evaluate(int x) {
            double result;
            for (int i=0; i<this.length(); i++) {
                result = result + this.coefficients[i] * pow(x, i-this.length());
            }
            return result;
        }

        public boolean hasRoot(double x) {
            if (evaluate(x) == 0) {
                return true;
            }
            else {
                return false;
            }

        }
}
}