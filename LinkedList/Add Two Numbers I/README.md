#  Add Two Numbers

## Problem Statement

You are given two non-empty linked lists representing two non-negative integers.

The digits are stored in reverse order, and each node contains a single digit.

Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero except the number `0` itself.

---

## Example

### Input

```text
l1 = [2,4,3]
l2 = [5,6,4]
```

### Output

```text
[7,0,8]
```

### Explanation

```text
342 + 465 = 807
```

---

## Approach

### Idea

- Traverse both linked lists simultaneously.
- Add corresponding digits along with carry.
- Create a new node for `(sum % 10)`.
- Update carry using `(sum / 10)`.
- Continue until:
  - both lists become null
  - and carry becomes 0.

---

## Algorithm

1. Create a dummy node for the result list.
2. Maintain a pointer for traversal.
3. Traverse both linked lists:
   - add values from both nodes
   - include carry
4. Create a new node with digit `(sum % 10)`.
5. Update carry as `(sum / 10)`.
6. Move pointers forward.
7. Return `dummy.next`.

---

## Time Complexity

```text
O(max(n, m))
```

Where:
- `n` = length of first linked list
- `m` = length of second linked list

---

## Space Complexity

```text
O(max(n, m))
```

Extra space is used for the result linked list.

---

## Concepts Used

- Linked List
- Iteration
- Carry Handling
- Dummy Node Technique

---

## Key Learning

- Using a dummy node simplifies linked list construction.
- Carry propagation is similar to elementary addition.
- Efficient traversal avoids unnecessary conversions.

---
