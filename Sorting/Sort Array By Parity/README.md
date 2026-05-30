# LC-905 - Sort Array By Parity

## Problem Link

https://leetcode.com/problems/sort-array-by-parity/

## Problem Statement

Given an integer array `nums`, move all the even integers to the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

---

## Approach 1: Extra Array

### Idea

Create a new result array.

* Place even numbers from the beginning.
* Place odd numbers from the end.
* Return the resulting array.

---

## Approach 2: Two Pointers (Optimal)

### Idea

Use two pointers:

* `start` moves from left.
* `end` moves from right.

Skip correctly placed elements.

Swap when:

* Left contains odd.
* Right contains even.

---

## Comparison

| Feature                 | Extra Array | Two Pointers |
| ----------------------- | ----------- | ------------ |
| Time Complexity         | O(n)        | O(n)         |
| Space Complexity        | O(n)        | O(1)         |
| Modifies Original Array | No          | Yes          |
| Interview Preference    | Good        | Best         |
| Difficulty              | Easy        | Medium       |

---

## Key Takeaway

The extra-array approach is simple and intuitive, making it a good first solution.

The two-pointer approach is the optimal interview solution because it achieves the same O(n) runtime while reducing space complexity to O(1).
