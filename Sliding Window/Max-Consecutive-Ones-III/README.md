# 1004. Max Consecutive Ones III

## Problem Link

https://leetcode.com/problems/max-consecutive-ones-iii/

## Difficulty

Medium

## Topics

* Array
* Sliding Window
* Queue
* Two Pointers

---

# Problem Statement

Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`s in the array if you can flip at most `k` zeros.

---

# Approach 1: Queue Based Sliding Window

## Intuition

Store the indices of all zeros inside the current window.

Whenever the number of zeros exceeds `k`:

1. Remove the oldest zero index from the queue.
2. Move the left pointer directly after that zero.

This avoids scanning through unnecessary elements.

### Code



### Complexity

| Complexity | Value |
| ---------- | ----- |
| Time       | O(N)  |
| Space      | O(K)  |

---

# Approach 2: Optimal Sliding Window

## Intuition

Instead of storing zero positions, maintain only the count of zeros.

Expand the window using `right`.

If the number of zeros exceeds `k`:

* Move `left`
* Decrease zero count whenever a zero leaves the window


### Complexity

| Complexity | Value |
| ---------- | ----- |
| Time       | O(N)  |
| Space      | O(1)  |

---

# Comparison

| Feature              | Queue Approach | Zero Count Approach |
| -------------------- | -------------- | ------------------- |
| Time Complexity      | O(N)           | O(N)                |
| Space Complexity     | O(K)           | O(1)                |
| Stores Zero Indices  | Yes            | No                  |
| Direct Left Jump     | Yes            | No                  |
| Additional Memory    | Required       | Not Required        |
| Interview Preference | Good           | Preferred           |
| Simplicity           | Medium         | Easy                |

---

# Key Learning

Both solutions run in O(N) time.

Although the second approach contains a nested `while` loop, each element is visited at most twice:

* Once by `right`
* Once by `left`

Therefore total operations are bounded by `2N`, which simplifies to `O(N)`.

The Queue approach is an excellent example of trading extra space for direct pointer jumps, while the Zero Count approach achieves the same time complexity with constant space.

---

# Takeaway

When solving Sliding Window problems, always ask:

1. What information makes the window invalid?
2. Can I maintain that information incrementally?
3. Can I trade extra space for simpler pointer movement?
4. Is there a way to reduce space to O(1)?

This problem is a classic example of evolving from a Queue-based Sliding Window to an Optimal Sliding Window solution.
