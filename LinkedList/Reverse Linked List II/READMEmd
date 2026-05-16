# 92. Reverse Linked List II

## Problem Statement
Given the head of a singly linked list and two integers `left` and `right`, reverse the nodes from position `left` to position `right`, and return the modified list.

---

## Approach
- Use a dummy node to handle edge cases.
- Traverse to the node before the `left` position.
- Reverse the nodes between `left` and `right`.
- Reconnect the reversed sublist with the remaining list.

---

## Algorithm
1. Create a dummy node pointing to `head`.
2. Move `prev` to the node before position `left`.
3. Reverse nodes from `left` to `right`.
4. Connect:
   - `prev.next` → reversed head
   - tail of reversed sublist → remaining list

---

## Dry Run

### Input
```text
1 → 2 → 3 → 4 → 5
left = 2
right = 4
```

### Output
```text
1 → 4 → 3 → 2 → 5
```

---

## Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time Complexity | O(N) |
| Space Complexity | O(1) |

---

## Key Concepts
- Linked List
- In-place Reversal
- Pointer Manipulation
- Dummy Node

---

## Interview Insights
- Dummy node helps handle edge cases easily.
- Original start node of reversal becomes tail after reversing.
- Reconnection step is important.

---
