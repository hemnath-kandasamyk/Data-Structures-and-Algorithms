# Leetcode 04-Median of Two Sorted Arrays

## 🧩 Problem
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

## 💡 Approach
- Merge both arrays into a single sorted array
- Find the median based on length:
  - If even → average of two middle elements
  - If odd → middle element

## ⏱ Complexity
- Time: O(n + m)
- Space: O(n + m)

