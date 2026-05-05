# 🔁 Rotate List (LeetCode 61)

## 🧩 Problem Statement

Given the head of a singly linked list, rotate the list to the right by `k` places.

---

## 💡 Approach: Circular Linked List

### 🔍 Key Idea

Instead of shifting nodes one by one, we:

1. Compute the length of the list
2. Connect the last node to the head (make it circular)
3. Find the new tail at position `(length - k % length)`
4. Break the circle to get the rotated list

---

## 🧠 Algorithm Steps

1. Handle edge cases:

   * If list is empty, has one node, or `k = 0`
2. Traverse the list to find:

   * Length (`n`)
   * Last node (tail)
3. Compute:

   ```
   k = k % n
   ```
4. Make the list circular:

   ```
   tail.next = head
   ```
5. Find new tail:

   * Move `(n - k - 1)` steps from head
6. Set:

   * `newHead = newTail.next`
   * Break the link → `newTail.next = null`

---

## ⏱️ Complexity Analysis

| Type  | Complexity |
| ----- | ---------- |
| Time  | O(n)       |
| Space | O(1)       |

---


## 🔎 Example

**Input:**

```
1 → 2 → 3 → 4 → 5, k = 2
```

**Output:**

```
4 → 5 → 1 → 2 → 3
```

---

## 🚀 Key Takeaways

* Converting to a circular list simplifies rotation
* Always reduce `k` using modulo
* Linked list problems often rely on pointer manipulation

---

## 📌 Tags

`Linked List` `Two Pointers` `Simulation`

---

## ✨ Author

Maintained by Hemnath
More solutions coming soon 💪
