<img width="475" height="409" alt="image" src="https://github.com/user-attachments/assets/d4e1f4d7-d879-48cc-9b6e-2e8934075f98" />


# Tango Game Solver

## Overview

Tango Game Solver is a puzzle-solving application built using the **Backtracking Algorithm**.  
The solver efficiently explores all possible moves and finds a valid solution by recursively trying different configurations and backtracking whenever a constraint is violated.

This project demonstrates the practical use of:

- Recursion
- Backtracking
- Constraint Checking
- State Space Search
- Algorithm Optimization

---

## Features

- Solves Tango puzzles automatically
- Uses efficient backtracking strategy
- Validates moves dynamically
- Handles multiple puzzle sizes
- Interactive and optimized solving process
- Clean and modular implementation

---

## Algorithm Used

### Backtracking

The solver works by:

1. Selecting an empty position
2. Trying all possible valid moves
3. Checking constraints
4. Recursively continuing the search
5. Backtracking if a move leads to an invalid state

This process continues until the puzzle is solved.

---

## How Backtracking Works

```text
Choose → Explore → Validate → Backtrack
```

If a choice fails:

- Undo the move
- Try another possibility

This guarantees that all valid combinations are explored systematically.

---

## Technologies Used

- Java / Python / C++ (based on implementation)
- Backtracking Algorithm
- Recursion
- Data Structures

---

## Time Complexity

Backtracking may explore multiple states recursively.

### Worst Case Complexity

```text
O(branching_factor ^ depth)
```

Actual performance depends on:

- Puzzle size
- Constraints
- Pruning efficiency

---

## Space Complexity

```text
O(depth)
```

due to recursive call stack.

---

## Applications of Backtracking

- Sudoku Solver
- N-Queens Problem
- Maze Solving
- Crossword Puzzles
- Word Search
- Game AI

---

## Future Improvements

- GUI support
- Faster pruning techniques
- Heuristic optimization
- AI-based move prediction
- Multiplayer puzzle generation

---

## Learning Outcomes

This project helps in understanding:

- Recursive problem solving
- State space traversal
- Constraint satisfaction problems
- Depth First Search (DFS)
- Optimization techniques

---

## Conclusion

The Tango Game Solver demonstrates how backtracking can efficiently solve complex puzzles by exploring possibilities intelligently and reverting invalid decisions dynamically.
