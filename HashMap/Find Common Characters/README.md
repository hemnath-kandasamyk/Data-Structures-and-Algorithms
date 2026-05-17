# LeetCode 1002 — Find Common Characters

## 📌 Problem Statement

Given an array of strings `words`, return a list of all characters that appear in **every string** in the array, including duplicates.

You may return the answer in any order.

---

## 🧠 Approach

This solution uses the **Frequency Array Technique**.

### Steps

1. Store the frequency of characters from the first word.
2. Traverse the remaining words:
   - Count character frequencies for the current word.
   - Update the global frequency array using the minimum count.
3. Build the final result using the remaining frequencies.

The minimum frequency ensures that only common characters across all words are included.

---

# ⏱️ Complexity Analysis

| Operation | Complexity |
|---|---|
| Building frequency array for first word | O(M) |
| Traversing remaining words | O(N × M) |
| Updating minimum frequencies | O(26 × N) |
| Building final result | O(26) |
| Overall Time Complexity | O(N × M) |
| Space Complexity | O(26) |
