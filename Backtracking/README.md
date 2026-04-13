# 🔁 Backtracking

## 📌 What is Backtracking?

Backtracking is an algorithmic technique used to solve problems recursively by trying all possible solutions and removing those that do not satisfy the constraints.

It builds solutions step by step and **backtracks (undoes choices)** when a path does not lead to a valid solution.

---

## 💡 Key Idea

> Try → Explore → Undo (Backtrack)

At each step:
1. Choose an option
2. Explore further
3. If it fails, undo the choice and try another

---

## 🧠 When to Use Backtracking?

Use backtracking when:
- You need to generate **all combinations or permutations**
- The problem involves **choices at each step**
- You must **explore multiple possibilities**

---

## 🔧 General Template

```java
void backtrack(parameters) {
    if (base_condition) {
        add_solution();
        return;
    }

    for (choice : choices) {
        make_choice();
        backtrack(next_state);
        undo_choice(); // backtrack
    }
}
