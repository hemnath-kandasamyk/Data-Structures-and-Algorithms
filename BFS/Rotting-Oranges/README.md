# 🍊Rotting Oranges

## Problem Statement

You are given an `m x n` grid where:

- `0` represents an empty cell
- `1` represents a fresh orange
- `2` represents a rotten orange

Every minute, any fresh orange that is adjacent (up, down, left, right) to a rotten orange becomes rotten.

Return the minimum number of minutes required so that no fresh orange remains.  
If it is impossible, return `-1`.

---

## Approach

We use **Multi-Source BFS (Breadth First Search)**.

### Steps

1. Traverse the grid
   - Add all rotten oranges to the queue
   - Count fresh oranges

2. Perform BFS level by level
   - Each BFS level represents **1 minute**
   - Rot adjacent fresh oranges

3. Decrease fresh orange count whenever an orange becomes rotten

4. Return:
   - `minutes` if all oranges become rotten
   - `-1` if fresh oranges still remain

---

## Algorithm

1. Initialize queue with all rotten oranges
2. Count fresh oranges
3. Run BFS until queue becomes empty
4. Spread rot in 4 directions
5. Count minutes level-by-level
6. Return result

---

## Time Complexity

| Operation | Complexity |
|---|---|
| Grid Traversal | O(n × m) |
| BFS Traversal | O(n × m) |

### Overall Complexity

```text
O(n × m)
```

---

## Space Complexity

| Space Used | Complexity |
|---|---|
| Queue | O(n × m) |

---

## Topics

- Graph
- BFS
- Queue
- Matrix
- Multi-Source BFS
