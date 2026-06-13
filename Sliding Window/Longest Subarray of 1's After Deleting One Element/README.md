# 1493. Longest Subarray of 1's After Deleting One Element

## Problem Link

https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

## Difficulty

Medium

## Topics

* Array
* Sliding Window
* Two Pointers

---

# Problem Statement

Given a binary array `nums`, return the size of the longest non-empty subarray containing only `1`s after deleting exactly one element.

---

# Example

### Input

```text
nums = [1,1,0,1]
```

### Output

```text
3
```

### Explanation

Delete the `0`:

```text
[1,1,1]
```

Longest subarray length = `3`.

---

# Approach: Sliding Window with Zero Index Tracking

## Key Observation

Since we must delete exactly one element, our window can contain:

* Any number of `1`s
* At most one `0`

If a second `0` appears:

* Shrink the window
* Remove the previous `0`
* Keep only the latest `0`

Instead of maintaining a zero count, we store the position of the current zero inside the window.

```java
int zeroidx = -1;
```

This allows us to efficiently maintain a valid window with at most one zero.

---

# Algorithm

1. Expand the window using `right`.
2. If the current element is `0` and another zero already exists in the window:

   * Move `left`
   * Remove the previous zero from the window
3. Store the new zero position.
4. Calculate the answer.

Since one element must be deleted:

```text
answer = windowLength - 1
```

which becomes:

```java
right - left
```

instead of:

```java
right - left + 1
```

---

# Dry Run

Input:

```text
[1,1,0,1,1,0,1]
```

### First Zero

```text
Window = [1,1,0,1,1]
zeroidx = 2
```

Valid because only one zero exists.

---

### Second Zero Appears

```text
Window = [1,1,0,1,1,0]
```

Now two zeros exist.

Move `left` until the first zero leaves the window.

```text
left -> 2
```

Remove old zero.

```text
zeroidx = -1
```

Store new zero.

```text
zeroidx = 5
```

Window becomes valid again.

---

# Complexity Analysis

| Complexity | Value |
| ---------- | ----- |
| Time       | O(N)  |
| Space      | O(1)  |

---

# Why Time Complexity is O(N)

Although a `while` loop exists inside the `for` loop:

```java
for(...)
{
    while(...)
}
```

the left pointer never moves backward.

Each element is:

* Visited once by `right`
* Removed at most once by `left`

Therefore:

```text
Total Operations ≤ 2N
```

which simplifies to:

```text
O(N)
```

---

# Key Learning

Many sliding window solutions use a counter:

```java
zeroCount
```

This solution takes a different approach:

```java
zeroidx
```

Instead of counting zeros, we directly track the position of the zero currently inside the window.

This demonstrates an important Sliding Window principle:

> Store only the minimum information required to keep the window valid.

---

# Takeaway

When solving Sliding Window problems, ask:

1. What condition makes the window invalid?
2. What is the minimum information required to detect that condition?
3. Can I maintain that information in O(1) space?

This problem is a great example of using index tracking instead of counters to maintain window validity efficiently.
