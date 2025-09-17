# Lower Bound: The index of the first element that is ≥ target in a sorted list.
# Upper Bound: The index of the first element that is > target in a sorted list.

# Explanation

# Binary Search can be tweaked to find not only whether an element exists, 
# but also to find the position where it could be inserted while maintaining order:

# Lower Bound helps find the leftmost suitable position.

# Upper Bound helps find the rightmost suitable position (just after last occurrence).

# This is extremely useful in problems like:

# Counting occurrences of an element.

# Finding insertion points.

# Range queries (e.g., count of numbers ≤ X or ≥ X).

# We will write two functions using binary search logic.

def lower_bound(arr, target):
    low, high = 0, len(arr)
    while low < high:
        mid = (low + high) // 2
        if arr[mid] < target:
            low = mid + 1
        else: 
            high = mid
    return low

def upper_bound(arr, target):
    low, high = 0, len(arr)
    while low < high:
        mid = (low + high) // 2
        if arr[mid] <= target:
            low = mid + 1
        else:
            high = mid
    return low

arr = [1, 2, 4, 4, 4, 6, 7, 9]
target = 4

print("Array:", arr)
print("Target:", target)

lb = lower_bound(arr, target)
ub = upper_bound(arr, target)

print("Lower Bound index:", lb)
print("Upper Bound index:", ub)

