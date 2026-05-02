# 🍊 Rotting Oranges (LeetCode 994)

## 🧩 Problem Statement
You are given a grid where:
- `0` = empty cell  
- `1` = fresh orange  
- `2` = rotten orange  

Every minute, any fresh orange adjacent (up, down, left, right) to a rotten orange becomes rotten.

Return the minimum time required to rot all oranges. If impossible, return `-1`.

---

## 💡 Approach

This problem is solved using **Multi-Source BFS**:

1. Add all initially rotten oranges to a queue
2. Count total fresh oranges
3. Perform BFS level by level (each level = 1 minute)
4. Spread rot to adjacent fresh oranges
5. Track time using level traversal

---

## 🔄 Key Idea

- Each BFS level represents **one minute**
- Multiple sources (rotten oranges) spread simultaneously

---

## ⏱ Complexity

- Time Complexity: **O(n × m)**
- Space Complexity: **O(n × m)** (queue in worst case)

---

## 📌 Example

**Input:**
