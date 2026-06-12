# LeetCode 1456 - Maximum Number of Vowels in a Substring of Given Length

## Problem

Given a string `s` and an integer `k`, return the maximum number of vowel letters in any substring of `s` with length `k`.

### Example

Input:

```text
s = "abciiidef"
k = 3
```

Output:

```text
3
```

Explanation:

The substring `"iii"` contains 3 vowels.

---

## Approach

This problem can be solved efficiently using the **Sliding Window** technique.

### Key Idea

1. Count vowels in the first window of size `k`.
2. Slide the window one character at a time.
3. Remove the contribution of the left character.
4. Add the contribution of the new right character.
5. Maintain the maximum vowel count encountered.

---

## Algorithm

1. Initialize vowel count for the first window.
2. Store it as the current maximum.
3. Move the window from left to right.
4. Update the vowel count by:

   * Removing the leftmost character.
   * Adding the new character.
5. Update the maximum count.

---

## Complexity Analysis

### Time Complexity

O(N)

Each character is processed at most once.

### Space Complexity

O(1)

Only a few variables are used.

---


## Topics

* Sliding Window
* String
* Two Pointers

## Difficulty

Medium
