# Binary Search on a rotated array finds a target value in a sorted array 
# that has been rotated (shifted) at some pivot.
# It uses a modified binary search: at each step determine which half is sorted and 
# decide which half can possibly contain the target.

# Explanation

# A rotated sorted array looks like [4,5,6,7,0,1,2] — 
# originally sorted but rotated at pivot between 7 and 0. 
# Standard binary search fails because the whole array isn't strictly sorted. 
# The trick: at every step check whether the left or right half is sorted (compare nums[left] and nums[mid]). 
# If the left half is sorted and the target lies inside that sorted range, search left; 
# otherwise search right. Mirror the logic if the right half is sorted. 
# This keeps the search O(log n) for arrays without duplicates.

def search_rotated(nums, target):
    left = 0 
    right = len(nums) - 1

    while left <= right:
        mid = (left + right) // 2
        if nums[mid] == target:
            return mid
        
        if nums[left] <= nums[mid]:
            if nums[left] <= target < nums[mid]:
                right = mid - 1
            else:
                left = mid + 1

        else: 
            if nums[mid] < target <= nums[right]:
                left = mid + 1
            else:
                right = mid - 1

    return -1

arr = [4, 5, 6, 7, 0, 1, 2]
print("Array:", arr)
print("search 0 ->", search_rotated(arr, 0))
print("search 3 ->", search_rotated(arr, 3))

arr2 = [1, 2, 3, 4, 5]
print("Array2:", arr2)
print("Search 4 ->", search_rotated(arr2, 4))


