#  Rotate Non-Negative Elements

## Leetcode-3819 :https://leetcode.com/problems/rotate-non-negative-elements/description/

## 🧩 Problem Statement
Given an integer array `nums` and an integer `k`, rotate only the **non-negative elements** of the array by `k` steps while keeping negative elements in their original positions.

---

## 💡 Approach

1. Extract all non-negative elements into a list
2. Rotate the list using the **reversal algorithm**
3. Place rotated elements back into original positions

---

## 🔄 Rotation Logic

- Normalize `k` using modulo
- Convert to right rotation
- Apply 3-step reversal:
  - Reverse first part
  - Reverse second part
  - Reverse whole list

---

## ⏱ Complexity

- Time: **O(n)**
- Space: **O(n)**

---

## 🧠 Key Concepts

- Array manipulation
- Two-pointer reversal
- Greedy placement

---

## 📌 Example

**Input:**
