# 🌳 Trie (Prefix Tree)

> A complete guide to Trie for Coding Interviews, DSA, and Competitive Programming.

---

# 📚 Table of Contents

- What is Trie?
- Why Trie?
- Structure of Trie
- Operations
- Time Complexity
- Space Complexity
- Advantages
- Disadvantages
- Implementation
- Common Interview Questions
- Tricks & Patterns
- Practice Problems
- Revision Notes

---

# 📖 What is Trie?

A **Trie (Prefix Tree)** is a tree-based data structure used to efficiently store and search strings.

Each node represents a character.

Example:

Words:

apple
app
ape

Trie:

```

(root)
|
a
|
p
|
p -----
|       \
l        (end) -> app
|
e (end) -> apple

\
e (end) -> ape

```

Instead of storing complete words, Trie stores characters one by one.

---

# Why Trie?

Trie is useful when we need to perform:

- Search words quickly
- Prefix searching
- Dictionary implementation
- Auto-complete
- Spell Checker
- Word Search
- Contacts List
- IP Routing

---

# Real World Applications

✅ Google Search Suggestions

✅ Mobile Keyboard Suggestions

✅ Dictionary

✅ Auto Complete

✅ Search Engine

✅ Word Games

✅ DNS Lookup

---

# Trie Node Structure

Java

```java
class TrieNode{

    TrieNode[] children = new TrieNode[26];

    boolean isWord;

}
```

children[0] → 'a'

children[1] → 'b'

...

children[25] → 'z'

---

# Root Node

```

root

```

The root node does **not** store any character.

It is only the starting point.

---

# Example

Insert:

```

cat
car
care

```

Trie

```

(root)
|
c
|
a
|
t (end)

\
r (end)
\
e (end)

```

---

# Operation 1 — Insert

Algorithm

For every character

- Find index
- Create node if not exists
- Move to child

Finally

```

isWord = true

```

Code

```java
public void insert(String word){

    TrieNode current = root;

    for(char ch : word.toCharArray()){

        int index = ch-'a';

        if(current.children[index]==null){
            current.children[index]=new TrieNode();
        }

        current=current.children[index];
    }

    current.isWord=true;
}
```

Time

```

O(L)

```

L = length of word

---

# Operation 2 — Search

Algorithm

For every character

If child doesn't exist

Return false

Else

Move forward

Finally

Return

```

current.isWord

```

Code

```java
public boolean search(String word){

    TrieNode current=root;

    for(char ch:word.toCharArray()){

        int index=ch-'a';

        if(current.children[index]==null){
            return false;
        }

        current=current.children[index];
    }

    return current.isWord;
}
```

Time

```

O(L)

```

---

# Operation 3 — StartsWith

Algorithm

Exactly same as Search

Only difference

Return true after traversal

Code

```java
public boolean startsWith(String prefix){

    TrieNode current=root;

    for(char ch:prefix.toCharArray()){

        int index=ch-'a';

        if(current.children[index]==null){
            return false;
        }

        current=current.children[index];
    }

    return true;
}
```

Time

```

O(L)

```

---

# Operation 4 — Wildcard Search

Example

```

b.d

```

Matches

```

bad
bed
bid

```

Idea

When

```

'.'

```

appears

Try every child recursively.

Pseudo

```

if(character=='.'){

for every child

DFS(child)

}

```

---

# Time Complexity

| Operation | Complexity |
|------------|------------|
| Insert | O(L) |
| Search | O(L) |
| StartsWith | O(L) |
| Delete | O(L) |
| Wildcard Search | O(26^d × L) |

d = number of dots

---

# Space Complexity

Each node

```

26 pointers

+

1 boolean

```

Worst case

```

O(N × L)

```

N = number of words

---

# Advantages

✅ Fast Search

✅ Fast Prefix Search

✅ Auto Complete

✅ Easy DFS

✅ Good for Dictionary

---

# Disadvantages

❌ High Memory

❌ Wasted Empty Children

❌ Not suitable for small datasets

---

# Trie vs HashMap

| Trie | HashMap |
|------|---------|
| Prefix Search | ✅ |
| Search | ✅ |
| Auto Complete | ✅ |
| Memory | High |
| Exact Search | Good |

---

# Trie vs BST

| Trie | BST |
|------|-----|
| Search | O(L) |
| Prefix Search | Excellent |
| Ordered | No |
| Memory | High |

---

# Interview Tricks

## Trick 1

```

'a'

↓

0

```

```

'z'

↓

25

```

Always

```java
index=ch-'a';
```

---

## Trick 2

Search

```

word

```

Return

```

current.isWord

```

StartsWith

Return

```

true

```

---

## Trick 3

Root stores nothing.

---

## Trick 4

Every node represents one character.

---

## Trick 5

Children size

```

26

```

only for lowercase letters.

---

# Common Patterns

Pattern 1

Trie + DFS

Examples

- Word Search II
- Word Dictionary

---

Pattern 2

Trie + Backtracking

Examples

- Word Search II

---

Pattern 3

Trie + Bit Manipulation

Examples

- Maximum XOR

---

Pattern 4

Trie + Prefix

Examples

- Replace Words

---

Pattern 5

Trie + Counting

Examples

- Map Sum Pairs

---

# Common Interview Questions

Easy

✅ Implement Trie

Medium

✅ Design Add and Search Words

✅ Replace Words

✅ Longest Word in Dictionary

✅ Map Sum Pairs

Hard

✅ Word Search II

✅ Maximum XOR

---

# LeetCode Problems

### Easy

208 — Implement Trie

---

### Medium

211 — Design Add and Search Words

648 — Replace Words

677 — Map Sum Pairs

720 — Longest Word in Dictionary

---

### Hard

212 — Word Search II

421 — Maximum XOR of Two Numbers

---

# Mistakes Beginners Make

❌ Forget

```

current=current.children[index]

```

---

❌ Forget

```

current.isWord=true

```

---

❌ Return

```

true

```

instead of

```

current.isWord

```

---

❌ Confuse Search and StartsWith

---

❌ Forget recursion in '.'

---

# Revision Notes

✔ Trie stores characters

✔ Root is empty

✔ Every node has children

✔ Search → return isWord

✔ StartsWith → return true

✔ Insert → create nodes

✔ '.' → DFS

✔ Prefix Search → O(L)

✔ Search → O(L)

✔ Auto Complete → Trie

✔ Dictionary → Trie

✔ Spell Checker → Trie

✔ Search Suggestions → Trie

✔ Maximum XOR → Bit Trie

---

# Interview Cheat Sheet

```

Trie

↓

Character Tree

↓

Root

↓

26 Children

↓

Insert

↓

Search

↓

StartsWith

↓

DFS

↓

Wildcard

↓

Prefix

↓

Auto Complete

↓

Word Search

↓

Maximum XOR

```

---

# Final Tip

Whenever a problem contains words like:

- Prefix
- Dictionary
- Auto Complete
- Search Suggestions
- StartsWith
- Word Search
- Contacts
- Lexicographical Words

👉 Think **Trie** first.

Happy Coding! 🚀
