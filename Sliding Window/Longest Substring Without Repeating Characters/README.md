# LeetCode 3 - Longest Substring Without Repeating Characters

## Problem Statement

Given a string `s`, find the length of the longest substring without repeating characters.

### Example 1

Input:

```text
s = "abcabcbb"
```

Output:

```text
3
```

Explanation:

The answer is `"abc"`, with length `3`.

### Example 2

Input:

```text
s = "bbbbb"
```

Output:

```text
1
```

Explanation:

The answer is `"b"`.

---

## Approach

This problem can be solved using the **Sliding Window** technique.

### Key Idea

Maintain a window `[left, right]` that always contains unique characters.

When a duplicate character is encountered:

1. Shrink the window from the left.
2. Remove characters until the duplicate disappears.
3. Expand the window again.
4. Track the maximum window size.

---

## Algorithm

1. Create a boolean frequency array to track characters present in the current window.
2. Use two pointers:

   * `left`
   * `right`
3. Expand `right`.
4. If a duplicate appears:

   * Move `left`
   * Remove characters from the frequency array.
5. Update the maximum substring length.

---

## Dry Run

Input:

```text
abcabcbb
```

Window Progress:

```text
a      -> length = 1
ab     -> length = 2
abc    -> length = 3
bca    -> length = 3
cab    -> length = 3
abc    -> length = 3
```

Maximum Length:

```text
3
```

---


## Complexity Analysis

### Time Complexity

```text
O(N)
```

Each character enters and leaves the sliding window at most once.

### Space Complexity

```text
O(1)
```

Fixed-size frequency array of length 128.

---

## Topics

* Sliding Window
* Two Pointers
* String

## Difficulty

Medium

## Learnings

* Maintaining a valid sliding window.
* Handling duplicates efficiently.
* Using a frequency array for O(1) character lookup.
