# 290. Word Pattern

## Problem Statement

Given a pattern and a string `s`, determine if `s` follows the same pattern.

A valid pattern means:

- Each character maps to exactly one word.
- Each word maps to exactly one character.

This is called a **bijection mapping**.

---

# Approach

This solution uses two HashMaps:

## 1. Character → Word Mapping

```text
a -> dog
b -> cat
```

Stored using:

```java
HashMap<Character, String>
```

---

## 2. Word → Character Mapping

```text
dog -> a
cat -> b
```

Stored using:

```java
HashMap<String, Character>
```

This ensures both mappings remain unique.

---

# Algorithm

1. Split the string using spaces.
2. Check if pattern length matches number of words.
3. Traverse both pattern and words together.
4. Verify:
   - Existing character maps to same word.
   - Existing word maps to same character.
5. If any mismatch occurs, return `false`.
6. Otherwise return `true`.

---

# Key Observation

Using only one HashMap is not enough.

Example:

```text
pattern = "abba"
s = "dog dog dog dog"
```

Single mapping may incorrectly pass.

Two-way mapping guarantees proper bijection.

---

# Time Complexity

```text
O(n)
```

Where `n` is the number of characters/words.

---

# Space Complexity

```text
O(n)
```

Used for storing mappings in HashMaps.

---

# Concepts Used

- HashMap
- String Manipulation
- Bijective Mapping
- Pattern Matching


