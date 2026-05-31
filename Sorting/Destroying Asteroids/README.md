# 2126. Destroying Asteroids

* **Difficulty:** Medium
* **Topics:** Array, Greedy, Sorting, Counting Sort
* **LeetCode:** https://leetcode.com/problems/destroying-asteroids/

---

## Problem Statement

You are given an integer `mass` representing the mass of a planet and an integer array `asteroids`, where `asteroids[i]` represents the mass of the `i-th` asteroid.

The planet can destroy an asteroid if its mass is **greater than or equal to** the asteroid's mass. After destroying it, the planet gains the asteroid's mass.

Return `true` if all asteroids can be destroyed; otherwise, return `false`.

---


## Approaches

### Approach 1: Greedy + Sorting

**Idea**

* Sort asteroids in ascending order.
* Destroy smaller asteroids first.
* Gain mass progressively.
* If at any point the planet cannot destroy an asteroid, return `false`.

**Why It Works**

Destroying smaller asteroids first maximizes the planet's growth before facing larger asteroids.

**Complexity**

| Metric | Complexity |
| ------ | ---------- |
| Time   | O(n log n) |
| Space  | O(1)       |

---

### Approach 2: Frequency Array

**Idea**

* Constraints guarantee:

```text
1 <= asteroids[i] <= 100000
```

* Count occurrences of each asteroid mass.
* Traverse masses from smallest to largest.
* Simulate sorted processing without performing an explicit sort.

**Why It Works**

The frequency array naturally processes asteroids in ascending order, preserving the same greedy strategy as the sorting solution.

**Complexity**

| Metric | Complexity    |
| ------ | ------------- |
| Time   | O(n + 100000) |
| Space  | O(100000)     |

---

## Comparison

| Feature                | Greedy + Sorting   | Frequency Array        |
| ---------------------- | ------------------ | ---------------------- |
| Technique              | Sorting + Greedy   | Counting Sort + Greedy |
| Time Complexity        | O(n log n)         | O(n + 100000)          |
| Space Complexity       | O(1)               | O(100000)              |
| Uses Input Constraints | No                 | Yes                    |
| Easy to Understand     | ✅                  | ⚠️ Moderate            |
| Easy to Maintain       | ✅                  | ⚠️ Moderate            |
| Interview Friendly     | ✅ Highly Preferred | ✅ Good Follow-Up       |
| Production Friendly    | ✅                  | Depends on Constraints |

---

## Trade-Off Analysis

### When to Use Sorting

* Input values are not bounded.
* Simpler implementation is preferred.
* Readability and maintainability are important.

### When to Use Frequency Array

* Value range is small and fixed.
* Sorting becomes a bottleneck.
* Constraints can be exploited for better performance.

---

## Key Learnings

1. Greedy strategies often rely on processing elements in a specific order.
2. Sorting is a common way to establish that order.
3. Constraints can sometimes eliminate the need for sorting.
4. Always watch for integer overflow when accumulating values.
5. Choosing between time and space optimizations is an important interview discussion.

---

## Interview Follow-Up Questions

### Q1. Why does sorting work?

Destroying smaller asteroids first allows the planet to grow as quickly as possible, maximizing the chance of destroying larger asteroids later.

### Q2. Why is `long` necessary?

The accumulated mass can exceed the maximum value of an `int`, causing overflow.

### Q3. Can we do better than O(n log n)?

Yes. Since asteroid masses are bounded by `100000`, a frequency-array approach achieves `O(n + 100000)`.

### Q4. Which solution would you choose?

For most interviews and production code, the **Greedy + Sorting** solution is preferred because it is simpler, cleaner, and independent of value constraints.
