# Spiral Matrix II

## Problem Statement

Given a positive integer `n`, generate an `n x n` matrix filled with elements from `1` to `n²` in spiral order.

---

## Approach

We use four boundaries:

- `top`
- `bottom`
- `left`
- `right`

The matrix is filled layer by layer in spiral order:

1. Left → Right
2. Top → Bottom
3. Right → Left
4. Bottom → Top

After each traversal, boundaries are updated.

---

## Algorithm

1. Initialize boundaries.
2. Fill top row.
3. Fill right column.
4. Fill bottom row.
5. Fill left column.
6. Repeat until boundaries cross.

---

## Time Complexity

| Operation | Complexity |
|---|---|
| Matrix Traversal | O(n²) |

---

## Space Complexity

| Space Used | Complexity |
|---|---|
| Extra Space | O(1) |

---
