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
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio        */
/* -----------------------------------------------------------------------  */

import java.io.*;

public class Main {

    // Standard binary search between l and r
    static int binarySearch(int[] arr, int l, int r, int x) {
        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] < x)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    // Exponential search algorithm
    static int exponentialSearch(int[] arr, int x) {
        int n = arr.length;

        if (arr[0] == x)
            return 0;

        int i = 1;
        while (i < n && arr[i] <= x)
            i = i * 2;

        return binarySearch(arr, i / 2, Math.min(i, n - 1), x);
    }

    public static void main(String[] args) throws IOException {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18};
        int x = 14;

        int result = exponentialSearch(arr, x);
        System.out.println("Element found at index: " + result);
    }
}
