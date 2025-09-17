/* ----------------------------------------------------------------------------  */
/*   ( The Authentic JS/JAVA CodeBuff )
 ___ _                      _              _ 
 | _ ) |_  __ _ _ _ __ _ __| |_ __ ____ _ (_)
 | _ \ ' \/ _` | '_/ _` / _` \ V  V / _` || |
 |___/_||_\__,_|_| \__,_\__,_|\_/\_/\__,_|/ |
                                        |__/ 
 */
/* --------------------------------------------------------------------------   */
/*    Youtube: https://youtube.com/@code-with-Bharadwaj                        */
/*    Github : https://github.com/Manu577228                                  */
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio       */
/* -----------------------------------------------------------------------  */

public class Main {

    // A sample unimodal function: f(x) = -(x-2)^2 + 3
    static double f(double x) {         // Defines the function to maximize
        return -Math.pow(x - 2, 2) + 3; // This is a downward parabola with max at x = 2
    }

    static double ternarySearchMax(double l, double r, int iterations) {
        for (int i = 0; i < iterations; i++) {  // Repeat fixed number of times
            double m1 = l + (r - l) / 3.0;      // First internal point
            double m2 = r - (r - l) / 3.0;      // Second internal point
            if (f(m1) < f(m2)) {                // If f(m1) < f(m2)
                l = m1;                         // Discard left third, search in [m1, r]
            } else {
                r = m2;                         // Else discard right third, search in [l, m2]
            }
        }
        return (l + r) / 2.0;                   // Return middle of the last interval
    }

    public static void main(String[] args) {
        double left = 0.0, right = 4.0;                              // Search interval [0, 4]
        double estimate = ternarySearchMax(left, right, 100);        // Do 100 iterations
        System.out.println("Ternary search estimate for x (maximum): " + estimate);
        System.out.println("Function value at estimate f(x): " + f(estimate));
        System.out.println("Actual maximum is at x = 2.0, f(x) = 3.0");
    }
}
