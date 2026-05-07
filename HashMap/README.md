# HashMap in Java

## Introduction

HashMap is a data structure used to store data in **key-value pairs**.

Each key is unique and is mapped to a specific value.

HashMap belongs to the Java Collections Framework and provides fast insertion, deletion, and searching operations.

---

# Key Features

- Stores data using key-value mapping
- Keys are unique
- Values can be duplicated
- Unordered collection
- Provides average constant time complexity for operations

---

# Syntax

```java
HashMap<KeyType, ValueType> map = new HashMap<>();
```

Example:

```java
HashMap<Integer, String> map = new HashMap<>();
```

---

# Common Operations

## Insert

```java
map.put(key, value);
```

---

## Access Value

```java
map.get(key);
```

---

## Check Key Exists

```java
map.containsKey(key);
```

---

## Remove Element

```java
map.remove(key);
```

---

## Size of HashMap

```java
map.size();
```

---

## Iterate Through HashMap

```java
for(Integer key : map.keySet()){
    System.out.println(key + " " + map.get(key));
}
```

---

# Internal Working

HashMap internally uses:

- Hashing
- Buckets
- Hash Functions

The hash code of a key determines where the value is stored.

---

# Time Complexity

| Operation | Average Complexity |
|---|---|
| Insert | O(1) |
| Search | O(1) |
| Delete | O(1) |

Worst case:

```text
O(n)
```

---

# Space Complexity

```text
O(n)
```

---

# Advantages

- Fast lookup operations
- Efficient key-value storage
- Flexible data mapping
- Widely used in algorithms

---

# Disadvantages

- Does not maintain insertion order
- Extra memory usage
- Worst-case collisions possible

---

# Common Use Cases

HashMap is commonly used for:

- Frequency counting
- Caching
- Pattern matching
- Prefix sum problems
- Counting duplicates
- Fast searching
- Mapping relationships

---

# Important Methods

| Method | Description |
|---|---|
| put() | Insert key-value pair |
| get() | Retrieve value |
| remove() | Delete key |
| containsKey() | Check key existence |
| containsValue() | Check value existence |
| keySet() | Get all keys |
| values() | Get all values |

---

# HashMap vs HashSet

| HashMap | HashSet |
|---|---|
| Stores key-value pairs | Stores only values |
| Uses put() | Uses add() |
| Key must be unique | Elements must be unique |

---

# HashMap vs TreeMap

| HashMap | TreeMap |
|---|---|
| Unordered | Sorted order |
| Faster average operations | Slower operations |
| Uses hashing | Uses Red-Black Tree |

---

# Important Concepts

- Hashing
- Collision Handling
- Buckets
- Load Factor
- Rehashing

---

# When to Use HashMap?

Use HashMap when:

- Fast lookup is required
- Key-value mapping needed
- Order is not important
- Frequent insert/search operations occur

---

# Conclusion

HashMap is one of the most important and widely used data structures in Java.

It provides efficient storage and retrieval using hashing and is heavily used in:
- Data Structures and Algorithms
- Competitive Programming
- Backend Development
- System Design
- Real-world applications
