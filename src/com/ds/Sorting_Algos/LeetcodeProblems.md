https://leetcode.com/problems/sort-an-array/
912. Sort an Array
Medium
Topics
premium lock icon
Companies
Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessarily unique.


Got it — you want to sort an array in **O(n log n)** without using any built-in sort functions.  
That means we need to **implement our own sorting algorithm** such as **Merge Sort** or **Heap Sort**.

***

## ✅ Option 1 – Merge Sort (Easy to implement, O(n) extra space)
```java
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return; // Base case: single element

        int mid = left + (right - left) / 2;

        // Sort left half
        mergeSort(arr, left, mid);
        // Sort right half
        mergeSort(arr, mid + 1, right);

        // Merge sorted halves
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i = 0; i--)
            heapify(arr, n, i);

        // Step 2: Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left  arr[largest])
            largest = left;
        if (right  arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
```

**⏳ Time Complexity:** O(n log n)  
**💾 Space Complexity:** O(1) (**in-place**)

***

### 🔹 Which to Choose?
- **Merge Sort** → stable sort, simpler to code, uses O(n) extra space.  
- **Heap Sort** → in-place O(1) space, but not stable.  

***
2. Sort Colors
Medium

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

https://leetcode.com/problems/sort-colors/




# 3. Merge k Sorted Lists
Hard
Topics
premium lock icon
Companies
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.


Alright — let’s go **line by line** and understand your `sortColors` code clearly.  
This is the **Dutch National Flag algorithm**, which sorts `0`s, `1`s, and `2`s *in place* in **O(n)** time and **O(1)** space.

***

## **Code Recap**
```java
class Solution {
    public void sortColors(int[] nums) {
        int left = -1;           // Last index of 0 region
        int right = nums.length; // First index of 2 region (exclusive)
        int current = 0;
        while (current < right) {
            if (nums[current] == 0) {
                swap(nums, ++left, current++);
            } else if (nums[current] == 2) {
                swap(nums, --right, current);
            } else {
                current++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

***

## **Step-by-step Explanation**

### **1. Variables**
```java
int left = -1;
int right = nums.length;
int current = 0;
```
We divide the array into **three regions**:

```
[0 ... left] → All 0's region
[left+1 ... current-1] → All 1's region
[current ... right-1] → Unprocessed
[right ... end] → All 2's region
```

- `left = -1` → Means initially there are **no 0’s** placed yet.  
- `right = nums.length` → Means initially there are **no 2’s** placed yet.  
- `current = 0` → The index we start processing from.

***

### **2. Loop**
```java
while (current < right) {
```
We process until **current crosses right** (because everything after `right-1` is already sorted as 2's).

***

### **3. When `nums[current] == 0`**
```java
swap(nums, ++left, current++);
```
- Increment `left` (because we found a new 0 position).
- Swap the `0` into the `left` region.
- Move `current` forward because the swapped element at `current` is already processed (since 0's region is built from the left side).

***

### **4. When `nums[current] == 2`**
```java
swap(nums, --right, current);
```
- Decrement `right` (because we found a new 2 position).
- Swap `2` into the `right` side region.
- **Do NOT increment `current`** here because the swapped element from the right might be `0` or `2` or `1`, and needs to be processed.

***

### **5. When `nums[current] == 1`**
```java
current++;
```
- Just move forward because 1's are automatically in the middle and don't require boundary changes.

***

### **6. Swap method**
```java
private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```
- Exchanges elements at indices `i` and `j`.

***

## **Example Walkthrough**
Input:
```
nums = [2, 0, 2, 1, 1, 0]
```

### Initial:
```
left = -1, right = 6, current = 0
Regions: [ | unprocessed(0..5) | ]
```

### Step 1: current = 0 → nums = 2
- Move 2 to right:
```
swap(nums, --right=5, current=0) → nums = [0, 0, 2, 1, 1, 2]
```
- Keep current = 0 because swapped value 0 needs to be processed.

***

### Step 2: current = 0 → nums = 0
- Move 0 to left:
```
swap(nums, ++left=0, current=0) → nums = [0, 0, 2, 1, 1, 2]
```
- current++ → current = 1

***

### Step 3: current = 1 → nums = 0
- Move 0 to left:
```
swap(nums, ++left=1, current=1) → nums = [0, 0, 2, 1, 1, 2]
```
- current++ → current = 2

***

### Step 4: current = 2 → nums = 2
- Move 2 to right:
```
swap(nums, --right=4, current=2) → nums = [0, 0, 1, 1, 2, 2]
```
- Keep current = 2

***

### Step 5: current = 2 → nums = 1
- current++ → current = 3

***

### Step 6: current = 3 → nums = 1
- current++ → current = 4

***

### Stop Condition
`current = 4` equals `right = 4` → Sorting finished.

***

✅ **Result:**  
```
[0, 0, 1, 1, 2, 2]
```

***

## **Complexity**
- **Time:** O(n) → Each element processed at most once.  
- **Space:** O(1) → Sorting is done in place.

***
