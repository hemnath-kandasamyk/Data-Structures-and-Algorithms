<div align="center">

# 🔢 421. Maximum XOR of Two Numbers in an Array

### Bit Manipulation • Binary Trie • Greedy Strategy

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow?style=for-the-badge)
![Topic](https://img.shields.io/badge/Topic-Bit%20Manipulation-blueviolet?style=for-the-badge)
![Structure](https://img.shields.io/badge/Structure-Binary%20Trie-orange?style=for-the-badge)
![Time](https://img.shields.io/badge/Time-O(n)-brightgreen?style=for-the-badge)
![Space](https://img.shields.io/badge/Space-O(n)-informational?style=for-the-badge)

*Turning an O(n²) brute force into O(32·n) using a bit-trie*

</div>

---

## 📌 Problem Statement

Given an integer array `nums`, return the **maximum value** of:

```
nums[i] XOR nums[j]
```

**Constraints:** `0 <= i < nums.length`, `0 <= j < nums.length`, `i != j`

<table>
<tr><th>Input</th><th>Output</th><th>Explanation</th></tr>
<tr>
<td>

```
nums = [3,10,5,25,2,8]
```

</td>
<td align="center">

```
28
```

</td>
<td>

`5 XOR 25 = 28`

</td>
</tr>
</table>

---

## 🚦 Brute Force vs. Optimized

```mermaid
flowchart LR
    A["🐢 Brute Force<br/>Compare every pair"] -->|"O(n²)"| B["❌ Too slow<br/>for large n"]
    C["⚡ Binary Trie<br/>Greedy opposite-bit walk"] -->|"O(32·n) ≈ O(n)"| D["✅ Efficient<br/>bitwise search"]

    style A fill:#ffe0e0,stroke:#d33,color:#000
    style B fill:#ffcccc,stroke:#d33,color:#000
    style C fill:#e0f7e9,stroke:#2a9d5c,color:#000
    style D fill:#c8f2d9,stroke:#2a9d5c,color:#000
```

| Approach | Time Complexity | Space Complexity | Verdict |
|---|:---:|:---:|---|
| 🐢 Brute Force (Nested Loops) | `O(n²)` | `O(1)` | Simple, but slow at scale |
| ⚡ **Binary Trie + Greedy** | **`O(32·n) ≈ O(n)`** | **`O(32·n) ≈ O(n)`** | ✅ Optimal — interview standard |

---

## 💡 Core Idea

XOR is maximized when the two bits **differ**:

| Bit A | Bit B | XOR |
|:---:|:---:|:---:|
| 0 | 0 | 0 |
| 0 | 1 | **1** |
| 1 | 0 | **1** |
| 1 | 1 | 0 |

> 🎯 **Greedy insight:** for every number, walk a binary trie of all numbers from the **Most Significant Bit (bit 31)** down to bit 0, and at each step greedily jump to the **opposite bit** if it exists — this guarantees the largest possible XOR.

---

## 🌳 The Binary Trie

Every number is inserted as a path of 32 bits (MSB → LSB). Each node has at most two children: `0` and `1`.

```mermaid
graph TD
    R((root)) -->|0| A(( ))
    R -->|1| B(( ))
    A -->|0| C(( ))
    A -->|1| D(( ))
    B -->|0| E(( ))
    B -->|1| F(( ))
    C --> G["... 32 levels deep ..."]
    D --> H["... 32 levels deep ..."]
    E --> I["... 32 levels deep ..."]
    F --> J["... 32 levels deep ..."]

    style R fill:#6c5ce7,color:#fff,stroke:#4834d4
    style A fill:#74b9ff,color:#000
    style B fill:#74b9ff,color:#000
```

**Example — inserting `5` (binary `00101`):**

```
Root → 0 → 0 → 1 → 0 → 1
```

---

## 🚀 Algorithm Walkthrough

```mermaid
flowchart TD
    S1["1️⃣ Insert every number<br/>into the Binary Trie"] --> S2["2️⃣ For each number,<br/>walk the trie from MSB → LSB"]
    S2 --> S3{"Opposite bit<br/>child exists?"}
    S3 -->|Yes| S4["Move to opposite child<br/>Set that bit in result: xor |= (1 << i)"]
    S3 -->|No| S5["Move to same-bit child<br/>(forced path)"]
    S4 --> S6["3️⃣ Track the max XOR<br/>across all numbers"]
    S5 --> S6
    S6 --> S7["✅ Return maxXor"]

    style S1 fill:#dfe6e9,color:#000
    style S2 fill:#dfe6e9,color:#000
    style S3 fill:#ffeaa7,color:#000
    style S4 fill:#c8f2d9,color:#000
    style S5 fill:#ffe0e0,color:#000
    style S6 fill:#a29bfe,color:#fff
    style S7 fill:#00b894,color:#fff
```

---

## 📖 Dry Run

**Input:** `nums = [5, 25]`

| Number | Binary (5-bit) |
|---|---|
| 5 | `00101` |
| 25 | `11001` |

**Goal:** find the max XOR achievable with `5`.

<details>
<summary>🔍 <b>Click to expand full bit-by-bit trie walk</b></summary>

| Step | Bit Position | Bit of `5` | Opposite Bit Available? | Action | Running XOR (binary) |
|:---:|:---:|:---:|:---:|---|:---:|
| 1 | 4 | `0` | ✅ `1` exists (from 25) | Take opposite → set bit | `10000` |
| 2 | 3 | `0` | ✅ `1` exists | Take opposite → set bit | `11000` |
| 3 | 2 | `1` | ✅ `0` exists | Take opposite → set bit | `11100` |
| 4 | 1 | `0` | ❌ only same bit `0` | Forced same path | `11100` |
| 5 | 0 | `1` | ❌ only same bit `1` | Forced same path | `11100` |

**Final XOR (binary):** `11100` → **Decimal: `28`** ✅

</details>

---

## 🧩 Java Implementation (Primary)

```java
class Solution {

    public int findMaximumXOR(int[] nums) {

        Trie trie = new Trie();

        for (int num : nums) {
            trie.insert(num);
        }

        int maxXor = 0;

        for (int num : nums) {
            maxXor = Math.max(maxXor, trie.getMaxXor(num));
        }

        return maxXor;
    }
}

class Trie {

    class TrieNode {
        TrieNode zero;
        TrieNode one;
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(int num) {

        TrieNode curr = root;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >> i) & 1;

            if (bit == 0) {
                if (curr.zero == null) curr.zero = new TrieNode();
                curr = curr.zero;
            } else {
                if (curr.one == null) curr.one = new TrieNode();
                curr = curr.one;
            }
        }
    }

    public int getMaxXor(int num) {

        TrieNode curr = root;
        int xor = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >> i) & 1;

            if (bit == 0) {
                if (curr.one != null) {
                    xor |= (1 << i);
                    curr = curr.one;
                } else {
                    curr = curr.zero;
                }
            } else {
                if (curr.zero != null) {
                    xor |= (1 << i);
                    curr = curr.zero;
                } else {
                    curr = curr.one;
                }
            }
        }

        return xor;
    }
}
```

<details>
<summary>🐍 <b>Click to expand equivalent Python solution</b></summary>

```python
class TrieNode:
    def __init__(self):
        self.zero = None
        self.one = None


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, num: int) -> None:
        curr = self.root
        for i in range(31, -1, -1):
            bit = (num >> i) & 1
            if bit == 0:
                if curr.zero is None:
                    curr.zero = TrieNode()
                curr = curr.zero
            else:
                if curr.one is None:
                    curr.one = TrieNode()
                curr = curr.one

    def get_max_xor(self, num: int) -> int:
        curr = self.root
        xor = 0
        for i in range(31, -1, -1):
            bit = (num >> i) & 1
            if bit == 0:
                if curr.one is not None:
                    xor |= (1 << i)
                    curr = curr.one
                else:
                    curr = curr.zero
            else:
                if curr.zero is not None:
                    xor |= (1 << i)
                    curr = curr.zero
                else:
                    curr = curr.one
        return xor


class Solution:
    def findMaximumXOR(self, nums: list[int]) -> int:
        trie = Trie()
        for num in nums:
            trie.insert(num)

        max_xor = 0
        for num in nums:
            max_xor = max(max_xor, trie.get_max_xor(num))

        return max_xor
```

</details>

---

## ⏱ Complexity Analysis

```mermaid
pie showData
    title Time Spent Per Phase (relative)
    "Insertion (O(32·n))" : 50
    "Search / Query (O(32·n))" : 50
```

| Phase | Work per Number | Total for n Numbers |
|---|:---:|:---:|
| 🌱 Insertion | `O(32)` | `O(32 × n)` |
| 🔍 Search | `O(32)` | `O(32 × n)` |
| **Total Time** | — | **`O(32 × n) ≈ O(n)`** |
| **Total Space** | — | **`O(32 × n) ≈ O(n)`** |

---

## 🎯 Key Observations

- ✅ XOR is maximized when bits **differ** — that's the whole greedy engine.
- ✅ Always process from the **Most Significant Bit** downward.
- ✅ Greedily choose the **opposite bit** whenever the trie has that path.
- ✅ Each query resolves in a fixed **O(32)** — independent of `n`.

---

## 📚 Concepts Used

<div align="center">

| 🧮 Bit Manipulation | 🌳 Binary Trie | 🎯 Greedy Strategy | ⚡ XOR Properties | 🌲 Tree Traversal | ⏱ Complexity Optimization |
|:---:|:---:|:---:|:---:|:---:|:---:|

</div>

---

## 🎤 Interview Takeaways

```mermaid
flowchart LR
    A["Start with<br/>brute force O(n²)"] --> B["Explain why<br/>it's inefficient"]
    B --> C["Observe XOR<br/>depends on bits"]
    C --> D["Introduce<br/>Binary Trie"]
    D --> E["Greedy opposite-bit<br/>traversal"]
    E --> F["Build result<br/>MSB → LSB"]

    style A fill:#dfe6e9,color:#000
    style B fill:#dfe6e9,color:#000
    style C fill:#ffeaa7,color:#000
    style D fill:#a29bfe,color:#fff
    style E fill:#74b9ff,color:#000
    style F fill:#00b894,color:#fff
```

> 💬 This pattern — **Binary Trie for bitwise maximization** — shows up repeatedly in product-based company interviews and signals strong command of bit manipulation, tries, and greedy design.

---

<div align="center">

⭐ **If this helped, drop a star on the repo!** ⭐

</div>
