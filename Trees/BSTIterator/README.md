# 🌳 Binary Search Tree Iterator (LeetCode 173)

## 🧩 Problem Statement

Implement an iterator over a Binary Search Tree (BST). The iterator should support:

* `next()` → returns the next smallest number
* `hasNext()` → returns `true` if there exists a next number

---

## 💡 Approach: Inorder Traversal + List

### 🔍 Key Idea

In a Binary Search Tree, **inorder traversal** produces values in **sorted (ascending) order**.

So we:

1. Perform an inorder traversal of the BST
2. Store all node values in a list
3. Use an index pointer to iterate through the list

---

## 🧠 Algorithm Steps

1. Traverse the tree using inorder traversal:

   ```
   left → root → right
   ```
2. Store values in a list
3. Initialize index `idx = 0`
4. For each call:

   * `next()` → return `list[idx++]`
   * `hasNext()` → check if `idx < list.size()`

---

## ⏱️ Complexity Analysis

| Operation   | Complexity |
| ----------- | ---------- |
| Constructor | O(n)       |
| next()      | O(1)       |
| hasNext()   | O(1)       |
| Space       | O(n)       |

> `n` = number of nodes in the BST

---

## 🔎 Example

**Input BST:**

```id="o6m4qk"
      7
     / \
    3   15
       /  \
      9   20
```

**Iterator Output:**

```id="g6av3s"
3 → 7 → 9 → 15 → 20
```

---

## 🚀 Key Takeaways

* Inorder traversal of BST gives sorted values
* Preprocessing simplifies iterator implementation
* Trade-off: higher space for simpler logic

---

## ⚠️ Note

This solution uses **O(n) extra space**.
An optimized solution can achieve **O(h) space** using a stack (lazy traversal).

---

## 📌 Tags

`Binary Search Tree` `Stack` `Inorder Traversal` `Design`

---

## ✨ Author

Maintained by Hemnath
Building DSA mastery step by step 💪
