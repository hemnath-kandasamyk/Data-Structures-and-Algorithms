#  Add Binary

## Problem Statement

Given two binary strings `a` and `b`, return their sum as a binary string.

---

## Example 1

### Input
```text
a = "11"
b = "1"
```

### Output
```text
"100"
```

---

## Example 2

### Input
```text
a = "1010"
b = "1011"
```

### Output
```text
"10101"
```

---

# Approach

We solve this problem using:

- Two pointers starting from the end of both strings
- A carry variable for binary addition
- StringBuilder to efficiently build the result

### Steps

1. Start from the last character of both strings
2. Add corresponding digits along with carry
3. Append `sum % 2` to result
4. Update carry using `sum / 2`
5. Reverse the final string

---

# Dry Run

## Input

```text
a = "11"
b = "1"
```

| Step | Sum | Result | Carry |
|---|---|---|---|
| 1 | 1 + 1 = 2 | 0 | 1 |
| 2 | 1 + carry = 2 | 00 | 1 |
| 3 | carry = 1 | 001 | 0 |

Final Answer:

```text
100
```

---

# Time & Space Complexity

| Complexity | Value |
|---|---|
| Time Complexity | O(max(n, m)) |
| Space Complexity | O(max(n, m)) |

Where:
- `n = a.length()`
- `m = b.length()`

---

# Edge Cases Covered

- Different length strings
- Final carry exists
- Both inputs are zero
- Large binary strings

---

# Topics

- String
- Simulation
- Bit Manipulation
- Two Pointers

---
