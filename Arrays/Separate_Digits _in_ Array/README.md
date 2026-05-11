# Separate the Digits in an Array

## 🧩 Problem Statement
Given an array of positive integers `nums`, separate the digits of each integer in the same order they appear and return them as a single array.

---

## LeetCode :2553. Separate the Digits in an Array-https://leetcode.com/problems/separate-the-digits-in-an-array/

## 💡 Approach
This solution avoids using extra data structures like:
- Stack
- ArrayList
- String conversion

### Steps:
1. Count the total number of digits required.
2. Create a result array of exact size.
3. Traverse the original array in reverse order.
4. Fill the result array backwards using mathematical digit extraction.

---

## 🧠 Key Concepts
- Digit Extraction
- Reverse Traversal
- Space Optimization
- Array Manipulation

---


## Complexity Analysis

| Approach | Time | Space |
|----------|------|------|
| Stack Solution | O(d) | O(d) |
| Space Optimized | O(d) | O(1) auxiliary |
