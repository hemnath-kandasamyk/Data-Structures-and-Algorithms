# LeetCode 209 - Minimum Size Subarray Sum

## Problem Statement

Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a subarray whose sum is greater than or equal to `target`.

If there is no such subarray, return `0`.

---

## Example

### Input

```text
target = 7
nums = [2,3,1,2,4,3]
```

### Output

```text
2
```

### Explanation

The subarray:

```text
[4,3]
```

has sum:

```text
7
```

and length:

```text
2
```

which is the minimum possible.

---

## Approach

This problem can be solved efficiently using the **Sliding Window** technique.

### Key Observation

Since all numbers are positive:

* Expanding the window increases the sum.
* Shrinking the window decreases the sum.

This property allows us to maintain a valid window and find the minimum length.

---

## Algorithm

1. Initialize:

   * `left = 0`
   * `sum = 0`
   * `window = n + 1`

2. Expand the window using `right`.

3. Add current element to the running sum.

4. While the sum is greater than or equal to the target:

   * Update the minimum window length.
   * Remove elements from the left.
   * Shrink the window.

5. Return:

   * `0` if no valid subarray exists.
   * Otherwise return the minimum length found.

---

## Complexity Analysis

| Complexity | Value |
| ---------- | ----- |
| Time       | O(N)  |
| Space      | O(1)  |

---

## Topics

* Sliding Window
* Two Pointers
* Array

## Difficulty

Medium

## Key Learning

When all array elements are positive:

* Expand window → sum increases
* Shrink window → sum decreases

This makes Sliding Window applicable and efficient.
