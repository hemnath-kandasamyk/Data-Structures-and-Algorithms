# Two Sum (Key Pair) - GeeksforGeeks

## Problem

Determine whether there exists a pair of elements in an array whose sum is equal to a given target value.

**Platform:** GeeksforGeeks
**Problem:** Key Pair (Two Sum)

---

## Approach

This solution uses a **HashMap** to efficiently store previously visited elements.

For every element in the array:

1. Compute the required complement:

   ```
   complement = target - currentElement
   ```
2. Check whether the complement already exists in the HashMap.
3. If it exists, return `true`.
4. Otherwise, insert the current element into the HashMap.
5. If the loop finishes without finding a pair, return `false`.

This is a **single-pass** solution with optimal time complexity.

---

## Dry Run

**Input**

```
arr = [1, 4, 45, 6, 10, 8]
target = 16
```

| Current | Needed | HashMap    | Result       |
| ------- | ------ | ---------- | ------------ |
| 1       | 15     | {}         | Insert 1     |
| 4       | 12     | {1}        | Insert 4     |
| 45      | -29    | {1,4}      | Insert 45    |
| 6       | 10     | {1,4,45}   | Insert 6     |
| 10      | 6      | {1,4,45,6} | Pair Found ✅ |

Output:

```
true
```

---

## Complexity Analysis

| Complexity | Value |
| ---------- | ----- |
| Time       | O(n)  |
| Space      | O(n)  |

---

## Key Interview Takeaways

* Uses a single-pass HashMap approach.
* Avoids nested loops, improving time complexity from **O(n²)** to **O(n)**.
* Checks for the complement **before** inserting the current element to prevent using the same element twice.
* Handles duplicate values correctly.

---

## Concepts Used

* Arrays
* HashMap
* Single-pass traversal
* Time Complexity Optimization
* Complement Search Pattern

---

