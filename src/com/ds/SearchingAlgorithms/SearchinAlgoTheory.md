# 🔍 Mastering Searching Algorithms in Java

Welcome to my repository on **Searching Algorithms** – a key topic in Data Structures and Algorithms (DSA) that every developer should master.

This project includes clean and beginner-friendly **Java implementations** of essential searching techniques, complete with explanations, use cases, and time complexities.

> ✅ Whether you're preparing for coding interviews, building real-world applications, or teaching others—this collection is designed to give you a strong foundation in algorithmic thinking.

---

## 📚 Covered Algorithms

### 1. 🔎 Linear Search

**Definition:**  
Linear (Sequential) Search goes through each element one by one until it finds the target or reaches the end.

**Purpose:**  
Used when the data is unsorted or the list is small.

**Use Case:**  
Finding a value in a small, unsorted list such as a user search in a dropdown menu.

**Java Code:**  
[View Linear Search Implementation](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/LinearSearch.java)

**Time Complexity:** O(n)

---

### 2. ⚡ Binary Search

**Definition:**  
Efficient search for **sorted arrays** by repeatedly dividing the search interval in half.

**Purpose:**  
Minimize comparisons by cutting down the search space.

**Use Case:**  
Used in sorted arrays like dictionary lookup, database index, pagination, etc.

**Java Code:**  
[View Binary Search Implementation](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/BinarySearch.java)

**Time Complexity:** O(log n)  
**Note:** Requires **sorted input**.

---

### 3. ⏩ Jump Search

**Definition:**  
An improvement over linear search that jumps in blocks of fixed size (√n) and then performs linear search within the block.

**Purpose:**  
Balances the speed of binary search and simplicity of linear search for **sorted arrays**.

**Use Case:**  
Optimized searches where random access is efficient (e.g., arrays in memory).

**Java Code:**  
[View Jump Search Implementation](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/JumpSearch.java)

**Time Complexity:** O(√n)

---




## 🛠 Features

- ✅ Clean and readable Java code
- ✅ Multiple examples and edge cases handled
- ✅ Designed for learning and teaching
- ✅ Beginner-friendly explanations
- ✅ Modular structure to easily add more algorithms

---

## 📂 Folder Structure

Searching-Algorithms/
│
├── LinearSearch.java
│
├── BinarySearch.java
│
├── JumpSearch.java
|
├── FibonacciSearch.java
|
├── Exponential Search.java
│
├── Ternary Search.java
|
├── InterpolationSearch.java
|
├── Graph/
│ ├── BFS.java
│ └── DFS.java
---

## 💬 Contribute & Connect

If you'd like to contribute more search algorithms or explore optimized variants (like Ternary Search, Exponential Search, etc.), feel free to open a PR.

🧠 **Let’s grow together as developers!**  
🔗 [Connect on LinkedIn](https://www.linkedin.com/in/jamal-veve/)  
🌟 Don’t forget to **Star** this repo if you find it useful!

---

## 📌 Bonus Reading Resources

- [GeeksforGeeks – Searching Algorithms](https://www.geeksforgeeks.org/dsa/searching-algorithms/)
- [Java Graph Implementation Guide](https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/)

---

## ⚡ Advanced Searching Algorithm


- ⚡ **Exponential Search**
- 🌀 **Fibonacci Search**
- ⚖️ **Ternary Search**
- 📊 **Interpolation Search**

> ℹ️ **Note:** All four algorithms assume a **sorted array** as input. For descending order, invert the comparisons accordingly.


---

## 1) ⚡ Exponential Search

**Definition:**  
Finds a range for the key by **doubling the index (1, 2, 4, 8, …)**, then applies **Binary Search** within that range.

**Purpose:**  
Great when the element is **near the beginning** or when working with **unbounded / unknown-size** sorted arrays.

**Use Case:**  
Searching in large logs/streams where you cannot know the full size up front.

**Java Code:**
[View Exponential Search Implementation](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/ExponentialSearch.java)


**Time Complexity:** `O(log n)` (after locating range); Space: `O(1)`


---

## 2) 🌀 Fibonacci Search

**Definition:**  
Uses **Fibonacci numbers** to split the array into sections, reducing division cost (relying mostly on addition/subtraction).

**Purpose:**  
Useful on systems where **division/modulo is expensive** compared to addition/subtraction.

**Use Case:**  
Embedded systems or constrained environments with limited arithmetic support.

**Java Code:**
[View Fibonacci Search Implementation](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/FibonacciSearch.java)

**Time Complexity:** `O(log n)`; Space: `O(1)`


---

## 3) ⚖️ Ternary Search

**Definition:**  
Splits the search space into **three parts** using two mid points and discards two-thirds each iteration.

**Purpose:**  
Primarily used to find **optimum (min/max)** of a **unimodal function**. It can also search in sorted arrays, though **Binary Search** is typically preferred for equality search.

**Use Case:**  
Optimization over a discrete domain or searching a peak in a unimodal array.

**Java Code**

[View Ternary Search Implementation](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/TernarySearch.java)

**Time Complexity:** `O(log₃ n)` (≈ `1.26 * log₂ n`); Space: `O(1)`


---

## 4) 📊 Interpolation Search

**Definition:**  
Estimates the probable position of the target using **linear interpolation** based on value distribution, then narrows the range.

**Purpose:**  
Extremely fast on **uniformly distributed** keys (e.g., evenly spread numeric IDs).

**Use Case:**  
Lookup in large **uniform** numeric datasets: membership IDs, phone numbers, sorted logs.

**Java Code:**
[View Interpolation Search Implementation](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/InterpolationSearch.java)



**Time Complexity:** Average `O(log log n)`; Worst `O(n)` (when distribution is highly skewed); Space: `O(1)`


---

## 🛠 Features
- Clean, readable **Java** implementations
- Edge cases handled (empty arrays, bounds, division-by-zero in interpolation)
- Explanations + complexities + use cases
- Easy to copy into your project or classroom notes


---

## 💬 Contribute & Extend
- Add **unit tests** for each algorithm
- Provide **descending-order** variants
- Benchmark against **Binary/Jump Search** on synthetic data (uniform vs skewed)

---

## 📈 What’s Next?
- Graph searching: **BFS, DFS**


- stay Tuned!