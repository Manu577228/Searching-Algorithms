# Ternary search is an algorithm for finding the maximum or minimum of a 
# unimodal function (a function that increases then decreases, or vice-versa) by 
# repeatedly dividing the search interval into three parts. It repeatedly compares two interior points and 
# discards one third of the interval until the extremum is isolated.

# Explanation (how and when to use it)

# When to use: use ternary search when you have a 
# unimodal function on an interval (single peak or single valley). Common in optimization problems where the objective is unimodal (e.g., maximize profit over a continuous parameter).

# Core idea: pick two points m1 and m2 that split [l, r] into three equal parts:

# m1 = l + (r-l)/3, m2 = r - (r-l)/3.

# Evaluate f(m1) and f(m2).

# If f(m1) < f(m2), the maximum lies in [m1, r]. Otherwise it lies in [l, m2].

# Repeat until the interval is small enough.

# Stopping: for continuous functions use an epsilon or fixed number of iterations; 
# for discrete integer problems adjust to integer comparisons and end 
# when interval size ≤ 2 then brute-force.

# Complexity: O(log n) (logarithmic number of iterations; base 3). 
# Each iteration does two function evaluations.

# Caveats: the function must be unimodal on the search interval. 
# If it is not unimodal, ternary search can fail.

def f(x):
    return -(x - 2)**2 + 3

def ternary_search_max(l, r, func, iterations = 100):
    for i in range(iterations):
        m1 = l + (r - l) / 3.0
        m2 = r - (r - l) / 3.0
        if func(m1) < func(m2):
            l = m1
        else:
            r = m2
    return (l + r) / 2.0

left, right = 0.0, 4.0
estimate = ternary_search_max(left, right, f, iterations=100)
print("Ternary search estimate for x (maximum):", estimate)
print("Function value at estimate f(x):", f(estimate))
print("Actual maximum is at x = 2.0, f(x) = 3.0")

