# 561. Array Partition

## Problem Statement

Given an integer array `nums` of `2n` integers, group these integers into `n` pairs such that:

- The sum of `min(ai, bi)` for all pairs is maximized.

Return the maximized sum.

---

## Approach

### Greedy + Sorting

1. Sort the array.
2. Pair adjacent elements.
3. The smaller element in each pair will be at even indices.
4. Add all even-indexed elements.

---

## Example

### Input
```text
nums = [1,4,3,2]
