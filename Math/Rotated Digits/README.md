# 788. Rotated Digits

## Problem
Given an integer `n`, return the number of good numbers in the range `[1, n]`.

A number is considered good if:
- Every digit remains valid after rotation
- The rotated number becomes different from the original number

### Rotation Rules
- `0, 1, 8` → remain same
- `2 ↔ 5`
- `6 ↔ 9`
- `3, 4, 7` → invalid

---

## Approach
- Traverse numbers from `1` to `n`
- Check each digit of the number
- If the number contains `3`, `4`, or `7`, it becomes invalid
- If the number contains at least one of `2`, `5`, `6`, or `9`, it changes after rotation
- Count numbers that are valid and changed

---

## Explanation
There are 3 types of digits:

- Same digits → `0, 1, 8`
- Changing digits → `2, 5, 6, 9`
- Invalid digits → `3, 4, 7`

A number is GOOD only if:
1. All digits are valid
2. At least one digit changes after rotation

Example:
- `56` → `29` ✅ Good
- `11` → `11` ❌ Not Good
- `53` → Invalid ❌

---

## Complexity Analysis

| Complexity | Value |
|---|---|
| Time Complexity | O(n log n) |
| Space Complexity | O(1) |

---

## Tags
`Math` `Simulation` `Digit Manipulation` `Brute Force`
