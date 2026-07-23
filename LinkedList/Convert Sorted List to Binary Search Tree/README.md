<div align="center">

# 🌳 109. Convert Sorted List to Binary Search Tree

<img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=openjdk">
<img src="https://img.shields.io/badge/Difficulty-Medium-yellow?style=for-the-badge">
<img src="https://img.shields.io/badge/Topic-Divide%20%26%20Conquer-blue?style=for-the-badge">
<img src="https://img.shields.io/badge/Status-Solved-success?style=for-the-badge">

### 🚀 LeetCode Problem Solution

</div>

---

# 📖 Problem Statement

Given the head of a singly linked list where elements are sorted in ascending order, convert it into a **Height Balanced Binary Search Tree (BST).**

A height-balanced BST is defined as:

> The depth of the two subtrees of every node never differs by more than one.

---

# 💡 Approach

## 🔹 Algorithm Used

> **Divide and Conquer + Slow & Fast Pointer**

The idea is simple:

- Find the middle node of the linked list.
- Make it the root of the BST.
- Split the linked list into two halves.
- Recursively construct the left and right subtrees.

This guarantees that the generated BST remains height-balanced.

---

# 🛠️ Algorithm

```
Find Middle Node
        │
        ▼
Create Root
        │
        ▼
Split Linked List
        │
 ┌──────┴──────┐
 ▼             ▼
Left List   Right List
 ▼             ▼
Recursive    Recursive
 Build BST    Build BST
```

---

# 🧠 Dry Run

### Input

```
1 → 2 → 3 → 4 → 5
```

### Step 1

```
slow = 3
```

Middle element becomes root.

```
        3
```

---

### Step 2

Split

```
Left

1 → 2

Right

4 → 5
```

---

### Step 3

Recursively build

```
        3
       / \
      2   5
     /   /
    1   4
```

---

# 📊 Complexity Analysis

| Operation | Complexity |
|------------|-----------:|
| Finding Middle Node | O(n) |
| Splitting Linked List | O(1) |
| Recursive Calls | O(log n) Levels |
| **Overall Time Complexity** | **O(n log n)** |
| **Auxiliary Space** | **O(log n)** |

---

# 📚 Why Time Complexity is O(n log n)?

Each recursive call traverses the linked list to find the middle node.

```
Level 1 : Traverse n nodes

Level 2 : Traverse n nodes

Level 3 : Traverse n nodes

...

Total Levels = log n
```

Therefore,

```
O(n × log n)
```

---

# 🌲 Recursive Tree

```
             3
           /   \
         1→2   4→5
         / \   / \
        1  2  4  5
```

---

# ✅ Java Solution

```java
class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        if(head == null){
            return null;
        }

        if(head.next == null){
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);

        slow = slow.next;
        prev.next = null;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow);

        return root;
    }
}
```

---

# 🎯 Key Concepts

- ✅ Divide and Conquer
- ✅ Slow & Fast Pointer
- ✅ Linked List
- ✅ Binary Search Tree
- ✅ Height Balanced Tree
- ✅ Recursion

---

# ⚠️ Edge Cases Considered

| Case | Handled |
|------|:-------:|
| Empty List | ✅ |
| Single Node | ✅ |
| Two Nodes | ✅ |
| Odd Length List | ✅ |
| Even Length List | ✅ |

---

# 🔍 Interview Discussion

### Why choose the middle element?

Choosing the middle element minimizes the height difference between the left and right subtrees, producing a height-balanced BST.

---

### Why use `prev.next = null`?

It disconnects the left half of the linked list from the middle node, preventing the left recursive call from processing the root node again.

---

### Can this be optimized?

Yes.

An optimized solution exists that builds the BST using an **inorder simulation**, reducing the overall time complexity to **O(n)** while keeping the recursion stack at **O(log n)**.

---

# 📈 Complexity Summary

| Metric | Value |
|---------|------:|
| Time Complexity | ⭐ **O(n log n)** |
| Space Complexity | ⭐ **O(log n)** |
| Technique | Divide and Conquer |
| Data Structure | Linked List + BST |
| Difficulty | Medium |

---

# 🏆 Learning Outcomes

- Learned to convert a sorted linked list into a balanced BST.
- Practiced the Slow & Fast Pointer technique.
- Understood Divide and Conquer recursion.
- Improved recursive problem-solving skills.
- Learned the trade-offs between an O(n log n) approach and the optimal O(n) solution.

---

<div align="center">

### ⭐ If you found this solution helpful, consider giving this repository a star!

**Happy Coding! 🚀**

</div>
