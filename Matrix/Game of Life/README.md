# LeetCode 289 — Game of Life

**Problem:** [289. Game of Life](https://leetcode.com/problems/game-of-life/)

## Problem Overview

Given a 2D board containing live cells (`1`) and dead cells (`0`), update the board according to the Game of Life rules.

The board must be updated in place.

## Solution 1: In-Place State Encoding

### Approach

Use temporary values to preserve the original state while computing the next generation.

| Value | Meaning       |
| ----- | ------------- |
| `0`   | Dead → Dead   |
| `1`   | Alive → Alive |
| `2`   | Alive → Dead  |
| `3`   | Dead → Alive  |

The first pass calculates the next state while preserving the original state for neighbor calculations. The second pass converts the temporary values into the final board.

### Complexity

* **Time:** O(m × n)
* **Auxiliary space:** O(1)

## Solution 2: Optimization Attempt


### Approach

Attempt to reduce the work of the second pass by finalizing selected cells during the main traversal and processing the remaining boundaries afterward.

### Learning Note

This version is an experimental attempt. Finalizing a cell too early can change the original state before another cell counts its neighbors.

### Complexity

* **Time:** O(m × n)
* **Auxiliary space:** O(1)

## Key Learning

This problem demonstrates the importance of preserving the previous generation when updating a matrix in place.
