# Exponential Search is a searching algorithm used to find the 
# position of a target element in a sorted array.
# It works by exponentially increasing the search bound and then applying binary search within that bound.

# Explanation

# Step 1: Start from index 1 and keep doubling the index (1, 2, 4, 8,...) 
# until the element at that index is greater than or equal to the target or until we go out of bounds.

# Step 2: Once we find a range [prev, curr] where the target may exist, 
# we apply Binary Search within this range.

# Step 3: If found, return the index; else return -1.

# This method is efficient for unbounded or very large sorted arrays 
# because it quickly narrows down the possible range for the element.

def binary_search(arr, l, r, x):
    while l <= r:
        mid = (l + r) // 2
        if arr[mid] == x:
            return mid
        elif arr[mid] < x:
            l = mid + 1
        else:
            r = mid - 1
    return -1

def exponential_search(arr, x):
    n = len(arr)
    if arr[0] == x:
        return 0
    
    i = 1
    while i < n and arr[i] <= x:
        i *= 2

    return binary_search(arr, i // 2, min(i, n - 1), x)

arr = [2, 4, 6, 8, 10, 12, 14, 16, 18];
x = 14;
result = exponential_search(arr, x)
print("Element found at index:", result)

