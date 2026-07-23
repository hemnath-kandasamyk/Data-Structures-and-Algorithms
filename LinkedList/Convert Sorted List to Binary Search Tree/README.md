# 109. Convert Sorted List to Binary Search Tree

## Problem

Given the head of a singly linked list where elements are sorted in ascending order, convert it into a height-balanced Binary Search Tree (BST).

---

## Approach

### Algorithm
**Divide and Conquer using Slow and Fast Pointer**

### Steps

1. Handle the base cases:
   - If the list is empty, return `null`.
   - If the list has only one node, create a leaf node.

2. Use the slow and fast pointer technique to find the middle node.
   - `slow` moves one step.
   - `fast` moves two steps.

3. The middle node becomes the root of the BST.

4. Disconnect the left half of the linked list.

5. Recursively build:
   - Left subtree using the left half.
   - Right subtree using the right half.

---

## Complexity Analysis

### Time Complexity

O(n log n)

Reason:
- Each recursive call scans the linked list to find the middle node.
- There are `log n` levels of recursion.

### Space Complexity

O(log n)

Due to the recursive call stack.

--- 

## Key Concepts

- Divide and Conquer
- Slow and Fast Pointer
- Linked List
- Binary Search Tree
- Recursion

---

## Interview Notes

- Middle node becomes the root.
- Split the linked list into two halves.
- Recursively construct left and right subtrees.
- Produces a height-balanced BST.
- An optimized solution exists with **O(n)** time using inorder simulation.

---

## Learning Outcome

- Learned how to combine linked lists with binary trees.
- Practiced Divide and Conquer.
- Understood how slow and fast pointers can split a linked list efficiently.
