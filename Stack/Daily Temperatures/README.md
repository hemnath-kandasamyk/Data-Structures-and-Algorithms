# 739. Daily Temperatures

## Problem Link

https://leetcode.com/problems/daily-temperatures/

## Difficulty

Medium

## Topics

* Array
* Stack
* Monotonic Stack
* Next Greater Element

---

# Problem Statement

Given an array of daily temperatures `temperatures`, return an array `answer` such that:

```text
answer[i]
```

is the number of days you have to wait after the `i-th` day to get a warmer temperature.

If there is no future day with a warmer temperature:

```text
answer[i] = 0
```

---

# Example

### Input

```text
temperatures = [73,74,75,71,69,72,76,73]
```

### Output

```text
[1,1,4,2,1,1,0,0]
```

### Explanation

| Day | Temp | Next Warmer Day | Wait |
| --- | ---- | --------------- | ---- |
| 73  | 74   | 1 day           | 1    |
| 74  | 75   | 1 day           | 1    |
| 75  | 76   | 4 days          | 4    |
| 71  | 72   | 2 days          | 2    |
| 69  | 72   | 1 day           | 1    |
| 72  | 76   | 1 day           | 1    |
| 76  | None | 0               | 0    |
| 73  | None | 0               | 0    |

---

# Intuition

For each day we need:

```text
Nearest future day having a greater temperature
```

This is a classic:

```text
Next Greater Element
```

problem.

Instead of checking every future day, we use a Monotonic Stack.

---

# Monotonic Stack Idea

Process temperatures from:

```text
Right → Left
```

The stack stores indices of temperatures.

Before processing the current temperature:

```java
while(current >= stackTopTemperature)
```

remove all smaller or equal temperatures.

Those temperatures can never become the answer for the current day.

After removals:

```text
Stack Top
```

contains the nearest warmer day.

---

# Algorithm

1. Traverse from right to left.
2. Remove all temperatures smaller than or equal to the current temperature.
3. If stack becomes empty:

   * Answer = 0
4. Otherwise:

   * Answer = stack.peek() - currentIndex
5. Push the current index into the stack.

---

---

# Dry Run

Input:

```text
[73,74,75,71]
```

### i = 3

```text
71
```

Stack:

```text
[]
```

Result:

```text
0
```

Push:

```text
[3]
```

---

### i = 2

```text
75
```

Pop:

```text
71 <= 75
```

Stack becomes empty.

Result:

```text
0
```

Push:

```text
[2]
```

---

### i = 1

```text
74
```

Stack Top:

```text
75
```

Warmer day found.

Result:

```text
2 - 1 = 1
```

Push:

```text
[2,1]
```

---

### i = 0

```text
73
```

Stack Top:

```text
74
```

Result:

```text
1 - 0 = 1
```

Final:

```text
[1,1,0,0]
```

---

# Why This Is O(N)

Although a while loop exists:

```java
while(...)
```

each index:

* Pushed once
* Popped once

Therefore:

```text
Total Pushes = N
Total Pops = N
```

Maximum operations:

```text
2N
```

which simplifies to:

```text
O(N)
```

---

# Complexity Analysis

| Complexity | Value |
| ---------- | ----- |
| Time       | O(N)  |
| Space      | O(N)  |

---

# Pattern Recognition

This problem belongs to the Monotonic Stack family.

Common related problems:

* Next Greater Element I
* Next Greater Element II
* Daily Temperatures
* Stock Span Problem
* Largest Rectangle in Histogram
* Trapping Rain Water

---

# Key Learning

Whenever a problem asks:

> Find the next greater/smaller element on the left or right

think:

```text
Monotonic Stack
```

Daily Temperatures is one of the most important Monotonic Stack interview questions and serves as an excellent introduction to the Next Greater Element pattern.
