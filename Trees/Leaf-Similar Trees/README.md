# 872. Leaf-Similar Trees

**LeetCode Problem:** [872. Leaf-Similar Trees](https://leetcode.com/problems/leaf-similar-trees/)

**Difficulty:** Easy  
**Topic:** Binary Tree, DFS, Stack, Tree Traversal  
**Language:** Java

---

## 1. Problem Definition

Consider two binary trees, `root1` and `root2`.

A leaf node is a node that has no left or right children.

The **leaf value sequence** of a tree is the sequence of values of all its leaf nodes, ordered from left to right.

We need to determine whether the two given binary trees are leaf-similar.

In other words, both trees must have exactly the same leaf values in the same order.

### Example 1

**Input:**

```text
root1 = [3,5,1,6,2,9,8,null,null,7,4]

root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
```

**Output:**

```text
true
```

**Explanation:**

Both trees produce the same leaf sequence:

```text
Tree 1: [6, 7, 4, 9, 8]

Tree 2: [6, 7, 4, 9, 8]
```

Therefore, both trees are leaf-similar.

### Example 2

**Input:**

```text
root1 = [1,2,3]

root2 = [1,3,2]
```

**Output:**

```text
false
```

**Explanation:**

```text
Tree 1: [2, 3]

Tree 2: [3, 2]
```

The leaf sequences are different.

---

## 2. Constraints

```text
1 <= Number of nodes in each tree <= 200

0 <= Node.val <= 200
```

**Important observations:**

- A leaf node has both `left == null` and `right == null`.
- Leaf nodes must be compared from left to right.
- The number of leaf nodes can differ between the two trees.
- Both the values and their order must match.

---

# 3. Approach 1: Recursive DFS + ArrayList

### Intuition

The simplest brute-force approach is to traverse both trees using Depth First Search (DFS).

We collect all leaf node values into two separate ArrayLists.

After collecting the sequences, compare both lists using Java's `equals()` method.

### Algorithm

1. Create two ArrayLists.
2. Perform DFS on the first tree.
3. Whenever a leaf node is encountered, add its value to the first list.
4. Repeat the same process for the second tree.
5. Compare both lists using `equals()`.
6. Return the comparison result.

### Java Implementation

```java
class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        trav(root1, list1);
        trav(root2, list2);

        return list1.equals(list2);
    }

    public void trav(TreeNode root, ArrayList<Integer> list) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        trav(root.left, list);
        trav(root.right, list);
    }
}
```

### Complexity Analysis

Let:
- N = Number of nodes in Tree 1.
- M = Number of nodes in Tree 2.
- L1 and L2 = Number of leaf nodes.
- H1 and H2 = Heights of the trees.

| Complexity | Value |
|---|---|
| Time | O(N + M) |
| Auxiliary Space | O(L1 + L2 + H1 + H2) |

**Advantages:**
- Simple and easy to understand.
- Recursive DFS naturally maintains left-to-right order.
- Easy to debug and implement.

**Disadvantages:**
- Stores all leaf values in memory.
- Uses two additional ArrayLists.

---

# 4. Approach 2: Iterative DFS + ArrayList

### Intuition

Instead of using recursive DFS, we can implement DFS using an explicit Stack.

The first tree's leaf sequence is stored in an ArrayList.

While traversing the second tree, we compare each leaf value with the corresponding value from the first list.

This avoids creating a second ArrayList.

### Algorithm

1. Create a Stack and an ArrayList.
2. Push the first tree's root into the Stack.
3. Perform iterative DFS.
4. Store every leaf value in the ArrayList.
5. Reuse the Stack for the second tree.
6. Traverse the second tree and compare each leaf with the corresponding ArrayList element.
7. Check whether all leaf values were matched.

### Important DFS Concept

Push the right child first and the left child second.

```java
if (curr.right != null) {
    stack.push(curr.right);
}

if (curr.left != null) {
    stack.push(curr.left);
}
```

Since Stack follows LIFO (Last In, First Out), the left child is processed first.

### Java Implementation

```java
class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        stack.push(root1);

        // First tree: collect leaf values
        while (!stack.isEmpty()) {

            TreeNode curr = stack.pop();

            if (curr.left == null && curr.right == null) {
                list.add(curr.val);
            }

            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        int index = 0;

        // Second tree: compare leaf values
        stack.push(root2);

        while (!stack.isEmpty()) {

            TreeNode curr = stack.pop();

            if (curr.left == null && curr.right == null) {

                if (index >= list.size() ||
                    list.get(index) != curr.val) {

                    return false;
                }

                index++;
            }

            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return index == list.size();
    }
}
```

### Complexity Analysis

| Complexity | Value |
|---|---|
| Time | O(N + M) |
| Auxiliary Space | O(L1 + max(H1, H2)) |

**Advantages:**
- No recursive function calls.
- Uses only one ArrayList.
- Can stop early when a mismatch is found.

**Disadvantages:**
- Still stores the first tree's entire leaf sequence.
- Requires an additional index to compare the sequences.

---

# 5. Approach 3: Two Stacks + Iterative DFS (Optimized)

### Intuition

Instead of storing all leaf values in an ArrayList, we can generate and compare leaf values one at a time.

We maintain two independent stacks:

- `stack1` for the first tree.
- `stack2` for the second tree.

We create a helper method called `getLeaf()`.

Its responsibility is to find and return the next leaf node from the given stack.

Whenever we need the next leaf value, we call this method for both trees and compare the returned values.

This eliminates the need for storing leaf sequences.

### Algorithm

1. Create two stacks.
2. Push the roots of both trees into their respective stacks.
3. Call `getLeaf()` on both stacks to generate the next leaf.
4. Compare the returned leaf values.
5. If the values differ, return `false`.
6. If either traversal finishes, check whether both have finished.
7. If both sequences finish together, return `true`.

### Helper Method Logic

```java
public Integer getLeaf(Stack<TreeNode> stack) {

    while (!stack.isEmpty()) {

        TreeNode curr = stack.pop();

        if (curr.left == null && curr.right == null) {
            return curr.val;
        }

        if (curr.right != null) {
            stack.push(curr.right);
        }

        if (curr.left != null) {
            stack.push(curr.left);
        }
    }

    return null;
}
```

**Why return `null` instead of `-1`?**

Because `-1` could be a valid node value in other versions of this problem or similar problems.

Using `null` distinguishes between:

- A valid leaf value.
- The end of the traversal.

### Java Implementation

```java
class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root1);
        stack2.push(root2);

        while (true) {

            Integer leaf1 = getLeaf(stack1);
            Integer leaf2 = getLeaf(stack2);

            // Check whether both traversals are completed
            if (leaf1 == null || leaf2 == null) {

                return leaf1 == null && leaf2 == null;
            }

            // Compare corresponding leaf values
            if (!leaf1.equals(leaf2)) {
                return false;
            }
        }
    }

    public Integer getLeaf(Stack<TreeNode> stack) {

        while (!stack.isEmpty()) {

            TreeNode curr = stack.pop();

            // Found a leaf node
            if (curr.left == null && curr.right == null) {
                return curr.val;
            }

            // Push right child first
            if (curr.right != null) {
                stack.push(curr.right);
            }

            // Push left child second
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return null;
    }
}
```

### Complexity Analysis

| Complexity | Value |
|---|---|
| Time | O(N + M) |
| Auxiliary Space | O(H1 + H2) |

**Advantages:**
- No ArrayList required.
- No recursion required.
- Generates one leaf at a time.
- Stops immediately when a mismatch is found.
- Uses only the DFS stacks for traversal.

**Disadvantages:**
- Slightly more complex implementation.
- Requires careful handling of the end of each traversal.

---

# 6. Comparison of All Three Approaches

| Feature | Approach 1 | Approach 2 | Approach 3 |
|---|---|---|---|
| Technique | Recursive DFS | Iterative DFS | Two-stack DFS |
| ArrayList | Two | One | None |
| Stack | Recursion | Explicit | Two explicit stacks |
| Early termination | No | Yes | Yes |
| Time | O(N + M) | O(N + M) | O(N + M) |
| Auxiliary Space | O(L1+L2+H1+H2) | O(L1+max(H1,H2)) | O(H1+H2) |

---

# 7. Best Solution

**Approach 3 – Two Stacks + Iterative DFS**

This is the best space-efficient approach among the three implementations.

### Why?

1. It does not store all leaf values.
2. It generates leaf nodes only when needed.
3. It compares corresponding leaf values immediately.
4. It terminates early if a mismatch is found.
5. Its auxiliary space depends on the tree heights rather than the total number of leaf nodes.

### Final Complexity

```text
Time Complexity: O(N + M)

Auxiliary Space: O(H1 + H2)
```

Where:
- N and M represent the number of nodes in the two trees.
- H1 and H2 represent the heights of the two trees.

---

# 8. Important Concepts Learned

Through this problem, we can understand several important DSA concepts:

- Binary Tree Traversal
- Recursive DFS
- Iterative DFS
- Stack and LIFO operations
- Left-to-right traversal
- Leaf node identification
- ArrayList comparison
- Streaming data comparison
- Space optimization
- Early termination

### Key Takeaway

The main optimization in this problem is moving from:

**Storing the complete leaf sequence → Generating and comparing leaves one at a time.**

This is an example of how we can optimize auxiliary space without changing the overall time complexity.

---

**Problem:** LeetCode 872 – Leaf-Similar Trees

**Solved using:** 3 different approaches in Java.

**Learning focus:** DFS, Stack, Binary Trees, and Space Optimization.
