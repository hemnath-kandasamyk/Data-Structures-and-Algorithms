# 1669. Merge In Between Linked Lists

## Problem Title
Merge In Between Linked Lists

---

## Description

You are given two linked lists `list1` and `list2` and two integers `a` and `b`.

Remove the nodes from index `a` to `b` in `list1` and insert the entire `list2` in their place.

Return the modified linked list.

---

## Constraints

- The number of nodes in `list1` is in the range `[3, 10^4]`
- `1 <= a <= b < list1.length - 1`
- The number of nodes in `list2` is in the range `[1, 10^4]`
- `1 <= Node.val <= 10^4`

---

## Approach

### Step-by-Step Idea

1. Traverse `list2` to find its tail node.
2. Traverse `list1` until reaching the node before index `a`.
3. Store the node after index `b`.
4. Connect:
   - node before `a` → head of `list2`
   - tail of `list2` → node after `b`
5. Return the modified `list1`.

---

## Algorithm

1. Find the tail of `list2`
2. Move to the node before index `a` in `list1`
3. Skip nodes from `a` to `b`
4. Attach `list2`
5. Connect the tail of `list2` with remaining nodes

---

## Complexity Analysis

| Operation | Complexity |
|---|---|
| Traversing `list1` | O(n) |
| Traversing `list2` | O(m) |
| Total Time Complexity | O(n + m) |
| Space Complexity | O(1) |

Where:
- `n` = length of `list1`
- `m` = length of `list2`

---

## Concepts Used

- Linked List Traversal
- Pointer Manipulation
- In-place Modification
- Singly Linked List Operations

---
