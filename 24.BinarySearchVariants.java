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
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio      */
/* -----------------------------------------------------------------------  */

import java.io.*;
import java.util.*;

public class BinarySearchVariants {

    // lower_bound: first index where arr[i] >= target
    static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                // if mid value < target, discard left part
                low = mid + 1;
            } else {
                // if arr[mid] >= target, possible answer, move left
                high = mid;
            }
        }
        return low;
    }

    // upper_bound: first index where arr[i] > target
    static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) {
                // if mid value <= target, go right
                low = mid + 1;
            } else {
                // if arr[mid] > target, possible answer, move left
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 4, 4, 4, 6, 7, 9};
        int target = 4;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        int lb = lowerBound(arr, target);
        int ub = upperBound(arr, target);

        System.out.println("Lower Bound index: " + lb);
        System.out.println("Upper Bound index: " + ub);
    }
}
