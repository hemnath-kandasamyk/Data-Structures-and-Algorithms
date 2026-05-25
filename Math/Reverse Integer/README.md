# 7. Reverse Integer

## Problem Statement

Given a signed 32-bit integer `x`, return `x` with its digits reversed.

If reversing `x` causes the value to go outside the signed 32-bit integer range:

```text
[-2^31, 2^31 - 1]
```

then return `0`.

---

## Approach

### Digit Extraction

We repeatedly:

1. Extract the last digit using `% 10`
2. Append it to the reversed number
3. Remove the last digit using `/ 10`

We use a `long` variable to safely detect overflow.

---

## Example

### Input
```text
x = 123
```

### Steps
```text id="hbjlwm"
rev = 0

rev = 3
rev = 32
rev = 321
```

### Output
```text id="6l4fy3"
321
```

---

## Complexity Analysis

| Metric | Complexity |
|---|---|
| Time | O(log n) |
| Space | O(1) |

---

## Key Concepts

- Modulo Operator
- Integer Division
- Overflow Handling
- Math Manipulation
