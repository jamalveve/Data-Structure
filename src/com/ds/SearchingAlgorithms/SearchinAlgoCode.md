# 📊 Problem 1: Find Numbers with Even Number of Digits

## 📝 Description
Given an array `nums` of integers, return **how many of them contain an even number of digits**.

---
## ✨ Example 1

**Input:**
nums = [12, 345, 2, 6, 7896]

**Output:**
2
**Explanation:**
- 12 → 2 digits → ✅ even  
- 345 → 3 digits → ❌ odd  
- 2 → 1 digit → ❌ odd  
- 6 → 1 digit → ❌ odd  
- 7896 → 4 digits → ✅ even  

✅ Only 12 and 7896 contain an even number of digits.

---

## ✨ Example 2 

**Input:**
nums = [555, 901, 482, 1771]

**Output:**

2
**Explanation:**
- 12 → 2 digits → ✅ even  
- 345 → 3 digits → ❌ odd  
- 2 → 1 digit → ❌ odd  
- 6 → 1 digit → ❌ odd  
- 7896 → 4 digits → ✅ even  

✅ Only 12 and 7896 contain an even number of digits.


## 💻 Java Implementation
[🔗 Java code](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/LeetcodeExcercise/FindEVenNumofDigits.java)

---

# 🔢 Problem2: Kth Missing Positive Number

## 📝 Description
Given an array `arr` of **positive integers** sorted in strictly increasing order, and an integer `k`,  
return the **kth positive integer** that is missing from this array.

---

## ✨ Example 1
**Input:**
arr = [2, 3, 4, 7, 11], k = 5


**Output:**
9

**Explanation:**
Missing positive integers are:
The 5th missing positive integer is `9`.

---

## ✨ Example 2
**Input:**
arr = [1, 2, 3, 4], k = 2


**Explanation:**
Missing positive integers are:
[5, 6, 7, ...]


The 2nd missing positive integer is `6`.

---

## 📌 Constraints
- `1 <= arr.length <= 1000`
- `1 <= arr[i] <= 1000`
- `1 <= k <= 1000`
- `arr[i] < arr[j]` for `1 <= i < j <= arr.length`

---


## 💻 Java Implementation

[🔗 Java code](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/LeetcodeExcercise/FindKthMissingElement.java)

# ➕ Problem3: Running Sum of 1D Array

## 📝 Description
Given an array `nums`, we define a **running sum** of an array as:
runningSum[i] = sum(nums[0] + nums[1] + ... + nums[i])


Return the **running sum** of `nums`.

---

## ✨ Example 1
**Input:**
nums = [1, 2, 3, 4]



**Output:**
[1, 3, 6, 10]


**Explanation:**
[1, 1+2, 1+2+3, 1+2+3+4]
[1, 3, 6, 10]

---

## ✨ Example 2
**Input:**
nums = [1, 1, 1, 1, 1]



**Output:**
[1, 2, 3, 4, 5]



**Explanation:**
[1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1]
[1, 2, 3, 4, 5]


## 📌 Constraints
- `1 <= nums.length <= 1000`
- `-10^6 <= nums[i] <= 10^6`

---

## 💻 Java Implementation
[🔗 Java code](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/LeetcodeExcercise/RunningNumsofArray.java)



# ➕ Problem4 :Binary Search – LeetCode #704

## 📝 Problem Description
Given an array of integers `nums` **sorted in ascending order**, and an integer `target`, write a function to search `target` in `nums`.  

If the target exists, return its **index**. Otherwise, return `-1`.

You must write an algorithm with **O(log n)** runtime complexity.

---

## 📌 Example 1
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4.


## 📌 Example 2
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums, so return -1.

---

## 🎯 Constraints
- `1 <= nums.length <= 10^4`
- `-10^4 < nums[i], target < 10^4`
- All integers in `nums` are unique.
- `nums` is sorted in ascending order.

---

## 💡 Key Idea
This problem is a **classic Binary Search** application because:
- The array is sorted
- We need **O(log n)** time complexity
- At each step, we eliminate half of the search space

---

## 💻  Java Solution
[🔗 Java code](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/LeetcodeExcercise/FindTargetInArrays.java)


# ➕ Problem5:Find First and Last Position of Element in Sorted Array – LeetCode #34

## 📝 Problem Description
Given an array of integers `nums` **sorted in non-decreasing order**, find the **starting** and **ending** position of a given target value.

If the target is not found in the array, return `[-1, -1]`.

You must write an algorithm with **O(log n)** runtime complexity.

---

## 📌 Example 1
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]



## 📌 Example 2
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]


## 📌 Example 3
Input: nums = [], target = 0
Output: [-1,-1]

---

## 🎯 Constraints
- `0 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- `nums` is a non-decreasing array.
- `-10^9 <= target <= 10^9`

---

## 💡 Key Idea
Since the array is **sorted** and we need **O(log n)** complexity, we can:
- Use **Binary Search** twice:
  1. Once to find the **first occurrence** of the target.
  2. Once to find the **last occurrence** of the target.

## 💻  Java Solution
[🔗 Java code](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/LeetcodeExcercise/FirtsandLastPositionofElement.java)


# 🔍Problem6: Single Element in a Sorted Array – LeetCode #540

## 📝 Problem Description
You are given a **sorted array** consisting of only integers where **every element appears exactly twice**, **except** for one element which appears exactly once.

Return the **single element** that appears only once.

Your solution **must** run in:
- **O(log n)** time
- **O(1)** space

---

## 📌 Example 1
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2


## 📌 Example 2
Input: nums = [3,3,7,7,10,11,11]
Output: 10

---

## 🎯 Constraints
- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^5`
- Array is sorted in **non-decreasing** order.

---

## 💡 Key Idea
Since the array is sorted and has a single unique element, we can use **Binary Search**:
- Pairs before the single element start at **even indices**.
- After the single element, pairs start at **odd indices**.
- Use index parity to decide which half to search.

---

## 💻  Java Solution
[🔗 Java code](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/LeetcodeExcercise/SingleElementinSortedArray.java)

# 🏃‍♂️ Problem7: Jump Game – LeetCode #55

## 📝 Problem Description
You are given an **integer array** `nums`.
- You are initially positioned at the **array's first index**.
- Each element in the array represents your **maximum jump length** at that position.

Return **true** if you can reach the last index, or **false** otherwise.

---

## 📌 Example 1
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.


## 📌 Example 2
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


---

## 🎯 Constraints
- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 10^5`

---

## 💡 Key Idea
We can **greedily** track the **farthest reachable index**:
- Iterate over the array and keep updating the **max reachable index**.
- If at any point the current index is greater than the max reachable index → return **false**.
- If the max reachable index is at least the last index → return **true**.

## 💻  Java Solution
 

[🔗 Java code](https://github.com/jamalveve/Data-Structure/blob/main/src/com/ds/SearchingAlgorithms/LeetcodeExcercise/JumpGame.java)


 