# 949. Largest Time for Given Digits

## 🧩 Problem Statement

Given an array `arr` of 4 digits, return the largest 24-hour time that can be made.

The returned time must be in the format `"HH:MM"`.
If no valid time can be made, return an empty string.

---

## 💡 Approach: Backtracking + Pruning

We generate all possible permutations using backtracking and apply constraints early:

### ⛔ Constraints:

* First digit (H₁) ≤ 2
* If H₁ = 2 → Second digit (H₂) ≤ 3
* Third digit (M₁) ≤ 5

### ⚡ Optimization:

* Traverse digits from **9 → 0** to get the largest time first
* Stop recursion early when a valid time is found

---

## 🧠 Algorithm

1. Use a frequency array to track digits
2. Build time digit by digit
3. Apply constraints at each position
4. Return first valid result

---

## ⏱️ Complexity

* Time Complexity: **O(1)** (since only 4 digits → max 24 permutations)
* Space Complexity: **O(1)**

---


## 🚀 Key Takeaways

* Use **pruning** to reduce search space
* Always try **largest values first** when maximizing
* Backtracking becomes powerful with constraints

---
