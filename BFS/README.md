# Breadth First Search (BFS)

## Introduction

Breadth First Search (BFS) is a traversal algorithm used to explore graphs and grids level by level.

It starts from a source node and first visits all nearby nodes before moving deeper into the structure.

BFS guarantees the shortest path in an unweighted graph.

---

# Core Idea

BFS works using:

- Queue (FIFO)
- Visited tracking
- Level-by-level traversal

The node inserted first is processed first.

---

# Working Principle

1. Start from a source node
2. Mark it as visited
3. Push it into the queue
4. Remove one node at a time
5. Visit all unvisited neighbors
6. Repeat until queue becomes empty

---

# Data Structure Used

## Queue

BFS uses a Queue because it follows:

```text
First In First Out (FIFO)
```

This helps process nodes level by level.

---

# BFS Traversal Style

```text
Level 0
↓
Level 1
↓
Level 2
↓
Level 3
```

It explores breadth first rather than depth.

---

# Properties of BFS

- Visits nodes level by level
- Finds shortest path in unweighted graphs
- Uses queue data structure
- Requires visited tracking
- Traverses nearest nodes first

---

# Applications of BFS

BFS is widely used in:

- Graph traversal
- Matrix traversal
- Network broadcasting
- Shortest path problems
- Flood fill algorithms
- Social network analysis
- Web crawling
- GPS navigation systems

---

# BFS in Graphs

In graphs, BFS explores all neighboring vertices before moving to the next depth level.

It is useful for:

- Connectivity checking
- Shortest path finding
- Cycle detection
- Bipartite graph checking

---

# BFS in Matrices

In grids/matrices, BFS moves in directions such as:

- Up
- Down
- Left
- Right

Sometimes diagonal traversal is also used.

---

# Multi-Source BFS

In Multi-source BFS:

- Multiple starting nodes are inserted into the queue initially.
- Expansion happens simultaneously from all sources.

Used in:
- Spread simulations
- Distance problems
- Infection problems

---

# BFS vs DFS

| BFS | DFS |
|---|---|
| Uses Queue | Uses Stack/Recursion |
| Level traversal | Depth traversal |
| Finds shortest path | Does not guarantee shortest path |
| More memory usage | Less memory usage |
| Better for nearest search | Better for deep traversal |

---

# Time Complexity

For graphs:

```text
O(V + E)
```

Where:
- V = Vertices
- E = Edges

For matrices:

```text
O(n × m)
```

---

# Space Complexity

```text
O(V)
```

or

```text
O(n × m)
```

depending on the structure.

---

# Advantages of BFS

- Simple to implement
- Finds shortest path
- Systematic traversal
- Works well for level problems
- Useful in real-world navigation systems

---

# Disadvantages of BFS

- High memory usage
- Slower for very deep graphs
- Queue can grow large

---

# Real World Examples

- Google Maps shortest route
- Instagram/Facebook friend suggestions
- WiFi/Bluetooth signal spreading
- Virus spread simulation
- Network packet routing

---

# Important Concepts Related to BFS

- Queue
- Visited Array
- Graph Traversal
- Level Order Traversal
- Shortest Path
- Multi-source Traversal

---

# Conclusion

Breadth First Search is one of the most important traversal algorithms in computer science.

It is highly useful for:
- shortest path problems,
- level traversal,
- graph exploration,
- and matrix-based simulations.

Understanding BFS is fundamental for mastering Graph and Grid problems in Data Structures and Algorithms.
