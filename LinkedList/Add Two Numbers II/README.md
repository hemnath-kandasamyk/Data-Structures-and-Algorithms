# 445. Add Two Numbers II

## Problem Link
https://leetcode.com/problems/add-two-numbers-ii/

## Difficulty
Medium

## Topics
- Linked List
- Stack
- Math

---

## Approach

Since the digits are stored in forward order, direct addition becomes difficult.

To solve this problem:

- Push all digits of both linked lists into stacks.
- Pop digits from stacks to simulate addition from right to left.
- Maintain carry during addition.
- Build the answer list.
- Reverse the final list before returning.

---

# Complexity Comparison

| Approach | Time Complexity | Space Complexity | Modifies Input | Extra Data Structure |
|---|---|---|---|---|
| Reverse Linked List Approach | O(n + m) | O(1) | Yes | No |
| Stack Based Approach | O(n + m) | O(n + m) | No | Stack |

---
