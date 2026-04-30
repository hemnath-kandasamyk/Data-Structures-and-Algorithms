# 2267. Check if There Is a Valid Parentheses String Path

## 🧩 Problem
Given a grid of '(' and ')', determine if there exists a path from top-left to bottom-right such that the resulting string is a valid parentheses string.

## 🚀 Approach
- Use BFS with state (row, col, balance)
- Balance tracks open brackets
- Use 3D visited array to avoid recomputation
- Apply pruning:
  - balance < 0 → invalid
  - balance > remaining steps → invalid

## 🧠 Key Concepts
- BFS on state space
- Parentheses validation using balance
- 3D DP / visited

## ⏱️ Complexity
- Time: O(n * m * (n + m))
- Space: O(n * m * (n + m))

## 💻 Language-java
