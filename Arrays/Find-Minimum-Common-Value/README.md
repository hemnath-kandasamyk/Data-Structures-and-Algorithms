# 2540. Minimum Common Value

## Description

Given two integer arrays `nums1` and `nums2` sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer, return `-1`.

---

## Example

### Input
```text
nums1 = [1,2,3]
nums2 = [2,4]
```

### Output
```text
2
```

---

# Approach 1 — Two Pointer

## Idea

Since both arrays are already sorted:

- Use two pointers `i` and `j`
- Compare elements from both arrays
- Move the smaller element pointer forward
- If both elements become equal, return that value

---

# Approach 2 — HashSet

## Idea

- Store all elements from first array into a `HashSet`
- Traverse second array
- If element exists in set, return it

---

# Complexity Comparison

| Approach | Time Complexity | Space Complexity | Best Use Case |
|---|---|---|---|
| Two Pointer | O(n + m) | O(1) | Sorted Arrays |
| HashSet | O(n + m) | O(n) | Unsorted Arrays |

---

# Conclusion

- The **Two Pointer** approach is the optimal solution because the arrays are already sorted.
- The **HashSet** approach is simpler for unsorted arrays but uses extra memory.
- Understanding array properties helps in choosing the best algorithm.
