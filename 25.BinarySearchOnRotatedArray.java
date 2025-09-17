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

public class Main {

    // function to search in rotated sorted array
    static int searchRotated(int[] nums, int target) {
        int left = 0;                                 // left pointer of search space
        int right = nums.length - 1;                  // right pointer of search space

        while (left <= right) {                       // continue while valid range exists
            int mid = (left + right) / 2;             // middle index of current range

            if (nums[mid] == target) {                // if we found target at mid
                return mid;                           // return index
            }

            if (nums[left] <= nums[mid]) {            // check if left half [left..mid] is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;                  // target in left half -> move right
                } else {
                    left = mid + 1;                   // target not in left half -> move left
                }
            } else {                                  // right half [mid..right] is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;                   // target in right half -> move left
                } else {
                    right = mid - 1;                  // target not in right half -> move right
                }
            }
        }

        return -1;                                    // target not found
    }

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);

        int[] arr = {4, 5, 6, 7, 0, 1, 2};              // rotated sorted array example
        out.println("Array: [4, 5, 6, 7, 0, 1, 2]");
        out.println("search 0 -> " + searchRotated(arr, 0));  // expected index 4
        out.println("search 3 -> " + searchRotated(arr, 3));  // expected -1

        int[] arr2 = {1, 2, 3, 4, 5};                   // normal sorted array
        out.println("Array2: [1, 2, 3, 4, 5]");
        out.println("search 4 -> " + searchRotated(arr2, 4)); // expected index 3

        out.flush();
    }
}
