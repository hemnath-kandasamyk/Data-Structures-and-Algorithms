# 904. Fruit Into Baskets

## Problem Link

https://leetcode.com/problems/fruit-into-baskets/

---

## Difficulty

Medium

---

## Topics

* Arrays
* Sliding Window
* HashMap
* Two Pointers

---

# Problem Description

You are visiting a farm that has a row of fruit trees represented by an integer array `fruits`.

Each tree produces a fruit type represented by `fruits[i]`.

You have exactly **two baskets**.

### Rules

* Each basket can hold only one type of fruit.
* You may start at any tree.
* You must pick exactly one fruit from every tree while moving to the right.
* Once you stop, you cannot return.

Return the maximum number of fruits you can collect.

---

## Example

### Input

```java
fruits = [1,2,1]
```

### Output

```java
3
```

### Explanation

We can collect all fruits:

```text
[1,2,1]
```

Only two fruit types exist.

---

# Key Observation

The problem can be rewritten as:

> Find the length of the longest contiguous subarray containing at most 2 distinct integers.

This is a classic Sliding Window problem.

---

# Approach 1: Sliding Window + HashMap

## Idea

Maintain a window:

```text
[left ... right]
```

Use a HashMap to store:

```java
fruitType -> frequency
```

Expand the window by moving `right`.

If the number of distinct fruits exceeds `2`:

```java
while(map.size() > 2)
```

shrink the window from the left.

Keep updating the maximum window length.

---

## Algorithm

1. Create a HashMap.
2. Expand the window using `right`.
3. Add current fruit to the map.
4. If more than 2 fruit types exist:

   * Remove fruits from the left.
   * Delete fruit type when frequency becomes 0.
5. Update the maximum length.

---

# Approach 2: Sliding Window + Frequency Array

## Idea

Since the constraint guarantees:

```java
0 <= fruits[i] < fruits.length
```

we can replace the HashMap with a frequency array.

This avoids hashing overhead.

---

# Comparison Table

| Feature                           | HashMap Solution  | Frequency Array Solution |
| --------------------------------- | ----------------- | ------------------------ |
| Data Structure                    | HashMap           | Array                    |
| Time Complexity                   | O(N)              | O(N)                     |
| Space Complexity                  | O(1)*             | O(N)                     |
| Works for Large Fruit Values      | ✅ Yes             | ❌ No                     |
| Faster Constant Factors           | ❌ Slightly Slower | ✅ Faster                 |
| Robust Against Constraint Changes | ✅ Yes             | ❌ No                     |
| Interview Preference              | ⭐⭐⭐⭐⭐             | ⭐⭐⭐⭐                     |

* At most 3 distinct fruit types are stored during execution.

---

# Dry Run

Input:

```java
[1,2,1,2,3]
```

Window Expansion:

```text
[1]
[1,2]
[1,2,1]
[1,2,1,2]
```

Current Answer:

```text
4
```

Add:

```text
3
```

Window becomes:

```text
[1,2,1,2,3]
```

Distinct Fruits:

```text
1,2,3
```

Invalid.

Shrink from left until only two fruit types remain.

Final Answer:

```text
4
```

---

# Complexity Analysis

## HashMap

| Operation | Complexity |
| --------- | ---------- |
| Insert    | O(1)       |
| Remove    | O(1)       |
| Lookup    | O(1)       |

Overall:

```text
Time  : O(N)
Space : O(1)
```

---

## Frequency Array

```text
Time  : O(N)
Space : O(N)
```

---

# Pattern Recognition

This problem belongs to:

```text
Longest Subarray With At Most K Distinct Elements
```

where:

```text
K = 2
```

Generic Sliding Window Pattern:

```java
Expand Right

while(invalid){
    Shrink Left
}

Update Answer
```

# Takeaway

Whenever you see:

```text
Longest
Contiguous
At Most K Distinct
```

think:

```text
Sliding Window + Frequency Tracking
```

For this problem:

```text
K = 2
```

which makes the solution straightforward using a HashMap or Frequency Array.
