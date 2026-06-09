# LC-135 - Candy

## Problem

There are `n` children standing in a line. Each child is assigned a rating value given in the integer array `ratings`.

You are giving candies to these children subject to the following requirements:

1. Each child must have at least one candy.
2. Children with a higher rating than their immediate neighbors must receive more candies than those neighbors.

Return the minimum number of candies needed to distribute.

### Example 1

```text
Input: ratings = [1,0,2]

Output: 5

Explanation:
Candies = [2,1,2]
```

### Example 2

```text
Input: ratings = [1,2,2]

Output: 4

Explanation:
Candies = [1,2,1]
```

---

## Intuition

The candy distribution must satisfy constraints from both directions:

* If a child has a higher rating than the left neighbor, they must get more candies.
* If a child has a higher rating than the right neighbor, they must get more candies.

A single traversal cannot guarantee both conditions simultaneously.

Therefore:

1. Traverse from left to right and satisfy the left-neighbor condition.
2. Traverse from right to left and satisfy the right-neighbor condition.
3. For each child, take the maximum candies required by either traversal.

---

## Approach

### Left Pass

Create an array `left[]`.

* Initialize `left[0] = 1`.
* If `ratings[i] > ratings[i-1]`,
  then:

```java
left[i] = left[i - 1] + 1;
```

Otherwise:

```java
left[i] = 1;
```

---

### Right Pass

Create an array `right[]`.

* Initialize `right[n - 1] = 1`.
* If `ratings[i] > ratings[i + 1]`,
  then:

```java
right[i] = right[i + 1] + 1;
```

Otherwise:

```java
right[i] = 1;
```

---

### Final Answer

For every child:

```java
Math.max(left[i], right[i])
```

This guarantees both left and right constraints are satisfied while minimizing the total number of candies.

---



## Complexity Analysis

| Operation       | Time Complexity | Space Complexity |
| --------------- | --------------- | ---------------- |
| Left Pass       | O(n)            | O(n)             |
| Right Pass      | O(n)            | O(n)             |
| Final Traversal | O(n)            | O(1)             |
| Total           | **O(n)**        | **O(n)**         |

---

## Key Takeaways

* Greedy problem with constraints from both directions.
* Two-pass traversal ensures both neighbor conditions are satisfied.
* `Math.max(left[i], right[i])` is the crucial observation.
* Common interview question for understanding greedy reasoning.

### Topics

* Greedy
* Arrays

### Difficulty

* Hard
