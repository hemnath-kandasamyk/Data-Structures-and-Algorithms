# Remove Element

##LeetCode 27 :https://leetcode.com/problems/remove-element/

## 🧩 Problem
Given an integer array nums and an integer val, remove all occurrences of val in-place and return the number of remaining elements.

## 💡 Approach
- Use a pointer `k` to track the position for valid elements.
- Traverse the array:
  - If current element is not equal to val,
    place it at index `k`.
  - Increment `k`.

## ✅ Key Idea
This approach overwrites unwanted elements while maintaining O(1) extra space.

## ⏱ Complexity
- Time: O(n)
- Space: O(1)


