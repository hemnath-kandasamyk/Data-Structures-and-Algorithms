# 784. Letter Case Permutation

## Problem Statement
Given a string `s`, generate **all possible strings** by transforming every letter individually to be lowercase or uppercase, while leaving digits unchanged. Return the resulting strings in any order.

**Example 1**
```
Input:  s = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
```

**Example 2**
```
Input:  s = "3z4"
Output: ["3z4", "3Z4"]
```

**Constraints**
- `1 <= s.length <= 12`
- `s` consists of lowercase/uppercase English letters and digits `0-9`.

---

## Approach 1 — String Building (Level-Order / BFS-style)

### Idea
- Start with a list containing the empty string.
- Process the input one character at a time:
  - **Digit** → append it to every string currently in the list (no branching).
  - **Letter** → for every string currently in the list, create **two** new versions — one with the lowercase form appended, one with the uppercase form appended.
- After processing all characters, the list holds every valid permutation.

### Code (Java)
```java
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        result.add("");

        for (char c : s.toCharArray()) {
            int size = result.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < size; i++) {
                    String prefix = result.get(i);
                    result.set(i, prefix + Character.toLowerCase(c));
                    result.add(prefix + Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < size; i++) {
                    result.set(i, result.get(i) + c);
                }
            }
        }
        return result;
    }
}
```

### Complexity
| | Complexity |
|---|---|
| Time | O(n · 2^k) — n = length of s, k = number of letters |
| Space | O(n · 2^k) — every generated string is stored |

### Trade-offs
- Simple to reason about, no recursion/call stack.
- Rebuilds strings repeatedly → more garbage collection pressure in Java (strings are immutable).

---

## Approach 2 — In-place Backtracking (DFS)

### Idea
- Convert the string to a `char[]` so characters can be mutated directly.
- Recurse index by index:
  - **Digit** → skip to the next index (only one branch).
  - **Letter** → branch twice:
    1. Recurse with the character **as-is**.
    2. **Toggle the case** in place, recurse, then **restore** the original character (the backtracking step).
- When the index reaches the end of the array, record a copy of the current state as one valid permutation.

### Code (Java)
```java
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result);
        return result;
    }

    private void backtrack(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        // Branch 1: keep the character unchanged
        backtrack(chars, index + 1, result);

        // Branch 2: toggle case only if it's a letter
        if (Character.isLetter(chars[index])) {
            chars[index] ^= 32;                    // toggle case via bit flip
            backtrack(chars, index + 1, result);
            chars[index] ^= 32;                    // restore (backtrack)
        }
    }
}
```

> **Why `^= 32` works:** ASCII uppercase and lowercase letters differ by exactly bit 5 (`0x20`). XOR-ing with `32` flips that bit, toggling case without branching logic for direction.

### Complexity
| | Complexity |
|---|---|
| Time | O(n · 2^k) — same branching factor as Approach 1 |
| Auxiliary Space | O(n) — recursion depth + one shared `char[]`, excluding output storage |

### Trade-offs
- More space-efficient during computation (mutates one array instead of building many strings).
- Requires careful restore-after-recurse discipline — a classic backtracking bug source if the toggle isn't undone.

---

## Approach Comparison

| Aspect | Approach 1 (String Building) | Approach 2 (Backtracking) |
|---|---|---|
| Data structure | `List<String>`, rebuilt each step | `char[]`, mutated in place |
| Style | Iterative, BFS-like | Recursive, DFS-like |
| Extra space during computation | O(n · 2^k) | O(n) |
| Ease of tracing | Easier to visualize level-by-level | Requires tracking call stack + undo step |
| Java-specific note | Leans on string immutability (new object per concat) | Exploits mutable arrays to avoid reallocation |

---

## Key Learnings
- **Recursive branching** — each letter doubles the search space; digits pass through untouched.
- **Backtracking discipline** — mutate, recurse, then always restore state before returning to the parent call.
- **Mutable vs. Immutable objects in Java** — `String` concatenation allocates new objects each time, while `char[]` allows in-place edits, which is why Approach 2 saves auxiliary space.
- **Space optimization** — trading a slightly harder-to-trace recursive structure for a smaller memory footprint during computation (output storage is unavoidable either way).
- **Bit manipulation trick** — `c ^= 32` is a compact, branch-free way to toggle ASCII letter case.
