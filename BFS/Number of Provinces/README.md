# Number of Provinces 

##Leetcode 547 -https://leetcode.com/problems/number-of-provinces/

## Problem Statement
There are `n` cities. Some cities are directly connected, while others are connected indirectly through intermediate cities.

A province is a group of directly or indirectly connected cities.

Given an adjacency matrix `isConnected`, return the total number of provinces.

---

## Approach

This solution uses **Breadth First Search (BFS)** to find connected components in the graph.

### Idea
- Each city is treated as a node.
- If two cities are connected, there is an edge between them.
- Every time we find an unvisited city, we start a BFS traversal.
- All cities visited during that traversal belong to the same province.
- Increment province count for every new BFS start.

---

## Algorithm
1. Create a `visited` array.
2. Traverse all cities.
3. If a city is unvisited:
   - Increment province count.
   - Start BFS from that city.
4. Mark all reachable cities as visited.
5. Return province count.

---

