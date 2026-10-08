# 🧩 301. Remove Invalid Parentheses

**LeetCode:** [301. Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/)

## 📌 Problem

Given a string `s` containing parentheses and lowercase English letters, remove the **minimum number of invalid parentheses** so that the resulting string is valid.

Return **all possible valid results**.

---

## 💡 Approach — Backtracking

For every parenthesis, there are two possible choices:

1. **Remove** the parenthesis.
2. **Keep** the parenthesis.

So we explore both choices using **DFS + Backtracking**.

We maintain a `depth` variable:

* `'('` → `depth + 1`
* `')'` → `depth - 1`
* Letter → `depth` unchanged

If:

```java
depth < 0
```

the current sequence is already invalid, so we immediately stop exploring that branch.

At the end:

```java
depth == 0
```

means the generated sequence has balanced parentheses and is valid.

---

## 🔄 Backtracking Tree

For every parenthesis:

```text
             Current Parenthesis
                    /       \
                   /         \
              REMOVE         KEEP
                |              |
              DFS          Update depth
                               |
                              DFS
```

Example:

```text
s = "()"
```

Possible subsequences:

```text
()
(
)
""
```

Only:

```text
()
""
```

are valid.

---

## 🧠 Why Maximum Length?

The problem asks for the **minimum number of removals**.

If the original string has length `n`, then:

```text
Minimum removals
        ↓
Maximum length valid string
```

Therefore, while generating valid strings, we track:

```java
maxlength
```

After DFS, we return only the strings whose length equals `maxlength`.

---


## 🔍 Important Backtracking Concept

This line:

```java
dfs(nums, index + 1, depth);
```

without appending the current parenthesis means:

> **Remove the current parenthesis.**

While:

```java
curr.append(nums[index]);
dfs(...);
curr.deleteCharAt(curr.length() - 1);
```

means:

> **Keep the current parenthesis, explore the branch, then undo the choice.**

---

## ⏱️ Complexity

Let `n` be the length of the input string.

Each parenthesis has two choices:

```text
KEEP
REMOVE
```

Therefore, the maximum number of possibilities is:

```text
2ⁿ
```

Creating/storing a string can take `O(n)`.

### Time

```text
O(n × 2ⁿ)
```

### Space

The `HashSet` can store exponentially many strings, each up to length `n`.

```text
O(n × 2ⁿ)
```

Recursion stack:

```text
O(n)
```

---

## 🚀 Optimization

This solution is a **brute-force backtracking solution with pruning**.

A further optimized solution can first calculate exactly how many:

```text
'('
')'
```

need to be removed.

Then the DFS only explores necessary removals instead of exploring every possible removal.

### Progression

```text
Brute Force
    ↓
KEEP / REMOVE
    ↓
Balance Pruning
    ↓
Calculate Required Removals
    ↓
Optimized Backtracking
```

---

## 🎯 Key Takeaway

The main idea is:

> **Generate → Validate → Keep the longest valid sequences.**

And the most important backtracking pattern is:

```text
Choose
  ↓
Explore
  ↓
Undo
```

For this problem:

```text
Remove / Keep
     ↓
    DFS
     ↓
Backtrack
```

🔥 **Concepts Used:**
`Backtracking` · `DFS` · `Recursion` · `HashSet` · `StringBuilder` · `Pruning`
