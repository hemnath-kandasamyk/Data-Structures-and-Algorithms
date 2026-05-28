# 977. Squares of a Sorted Array

## Problem Link

https://leetcode.com/problems/squares-of-a-sorted-array/

---

# Problem Description

Given an integer array `nums` sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

---

# Example

## Input

```text
nums = [-4,-1,0,3,10]
```

## Output

```text
[0,1,9,16,100]
```

---

# Observations

* The array is already sorted.
* Negative numbers become positive after squaring.
* Largest square always comes from:

  * leftmost negative value
  * OR rightmost positive value

This leads to the optimal Two Pointer approach.

---

# Approaches

---

## Approach 1 — Counting Sort Style

### Idea

1. Convert all negative values into positive values.
2. Store frequencies using a frequency array.
3. Rebuild the array using squared values.

### Code Logic

* Take absolute values.
* Track maximum value.
* Use frequency array.
* Fill result array in sorted order.

### Pros

* Creative approach
* Avoids comparison sorting

### Cons

* Uses extra memory
* Inefficient for large value ranges

---

## Approach 2 — Sorting Approach

### Idea

1. Convert negative values into positive.
2. Sort the array.
3. Square all elements.

### Pros

* Very simple
* Easy to understand

### Cons

* Sorting increases time complexity

---

## Approach 3 — Optimal Two Pointer

### Idea

* Largest square exists at either end of the sorted array.
* Compare left square and right square.
* Place larger square at the back of result array.

### Steps

1. Initialize:

   * `left = 0`
   * `right = n - 1`
   * `idx = n - 1`

2. Compare:

   * `nums[left]^2`
   * `nums[right]^2`

3. Place larger value into result array.

4. Move pointers accordingly.

### Why This Works

The original array is already sorted.

After squaring:

* smaller negatives can become large positives

So only the extremes matter.

---

# Time & Space Complexity

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Counting Sort | O(n + maxValue) | O(maxValue)      |
| Sorting       | O(n log n)      | O(1)             |
| Two Pointers  | O(n)            | O(n)             |

---


# Learning Outcomes

* Array Manipulation
* Two Pointer Technique
* Sorting Concepts
* Identifying Hidden Properties in Arrays
* Complexity Optimization

---

# Topics

* Array
* Two Pointers
* Sorting

---

# Difficulty

Easy
