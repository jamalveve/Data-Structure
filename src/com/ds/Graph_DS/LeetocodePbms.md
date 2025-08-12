# 📊 Problem 1: FIll the flood with new color


[🔗 Flood Fill Solution](https://leetcode.com/problems/flood-fill/)


Let's analyze the given grid step-by-step to find the number of islands. Recall:

- `'1'` means land
- `'0'` means water
- An island is a group of connected lands horizontally or vertically (no diagonal connections)

Your grid is:

```
1 1 1 0 0
1 0 0 1 1
1 1 0 0 0
0 0 0 0 1
```



### Step 1 — Start scanning from top-left:

- `(0,0)` is `1`: Found first island.
  - Explore connected land from `(0,0)`:
    - `(0,1)` = 1 → connected
    - `(0,2)` = 1 → connected
    - `(1,0)` = 1 → connected
    - `(2,0)` = 1 → connected
    - `(2,1)` = 1 → connected
- So, these positions form the first island:

```
1 1 1 0 0
1 0 0 1 1
1 1 0 0 0
0 0 0 0 1
```
(Cells marked `1`s connected: `(0,0),(0,1),(0,2),(1,0),(2,0),(2,1)`)



### Step 2 — Continue scanning:

- `(1,3)` is `1`: Not connected to the first island (separated by `0`s).
  - Explore connected land for second island:
    - `(1,4)` = 1 → connected
- So, second island cells are `(1,3)` and `(1,4)`.



### Step 3 — Continue scanning:

- `(3,4)` is `1`: No adjacent connected lands.
- So, this cell `(3,4)` alone is the third island.



### Step 4 — Summary of islands:

| Island Number | Cells                               |
|---------------|------------------------------------|
| 1             | `(0,0),(0,1),(0,2),(1,0),(2,0),(2,1)` |
| 2             | `(1,3),(1,4)`                      |
| 3             | `(3,4)`                           |

### **Final Output:** Number of islands = **3**

***


# 📊 Problem 2: Find Number of Island


[🔗 Flood Fill Solution](https://leetcode.com/problems/flood-fill/)

This is solving the **Number of Islands** problem using **Depth-First Search (DFS)**.  
Let’s go line-by-line.

***

## **1️⃣ Method: `numIslands`**

```java
public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;
```
- If the grid is **empty** (`null` or row count == 0), there are no islands, so return **0** immediately.


```java
    int islands = 0;
    int rows = grid.length;
    int cols = grid[0].length;
```
- `islands` → counter for how many islands we find.
- `rows` & `cols` store the grid dimensions.



```java
    for (int r = 0; r = grid.length || c >= grid[0].length) return;
```
- Stop if we go **outside** the grid.



```java
    // If water or already visited
    if (grid[r][c] == '0') return;
```
- If this cell is **water (`'0'`)** or we've already visited and marked it `'0'`, we **stop**.



```java
    // Mark current as visited (make it water)
    grid[r][c] = '0';
```
- Change this land cell to `'0'` so we **don’t visit** it again in the future.
- This effectively "removes" it from the island.



```java
    // Explore neighbors (up, down, left, right)
    dfs(grid, r + 1, c); // Down
    dfs(grid, r - 1, c); // Up
    dfs(grid, r, c + 1); // Right
    dfs(grid, r, c - 1); // Left
```
- Call DFS recursively in **all 4 directions**.
- This step **"flood fills"** the entire connected island.



## **3️⃣ How it works in a sample input**

### Example:
```
grid = [
  ['1','1','0','0'],
  ['1','0','0','1'],
  ['0','0','1','1']
]
```
**Step-by-step:**
1. Start scanning — first land found at `(0,0)` → islands = 1 → DFS called.
2. DFS from `(0,0)` marks `(0,0)` as `'0'` and explores:
   - `(1,0)` → mark `'0'`, explore its neighbors … stops when no more `'1'` is connected.
3. All cells in this connected group are turned into `'0'`.
4. Continue scanning — next unvisited `'1'` becomes a new island → islands++.
5. Repeat until all land cells are visited.



## **4️⃣ Complexity**
- **Time Complexity**: O(m × n) — each cell is visited at most once.
- **Space Complexity**: O(m × n) in worst case (recursive DFS stack for the largest island) — if the island covers the whole grid.



✅ **Summary:**  
- The outer loops find a starting land cell.  
- Each DFS marks that entire island visited so it's counted only once.  
- `islands` keeps track of how many separate land groups exist.

***

# 📊 Problem 3: find Island perimeter

[🔗 Island Perimeter Solution](https://leetcode.com/problems/island-perimeter/submissions/1731263397/)



## **Restating the Problem**
We have a grid:
- `1` = Land
- `0` = Water
- Land cells are connected only **up, down, left, right** (no diagonals).
- There is exactly **one island** and no lakes.
- We need to find the **perimeter** — the total number of edges of land that touch either water or the grid boundary.



## **Understanding the Idea**
Think of each land cell like a square:
- Alone, it has **4 sides** (perimeter = 4).
- But, if it is **adjacent to another land cell**, they **share** a side, so that shared side is **not part of the perimeter** anymore.

**So our step-by-step plan is:**
1. Loop through every cell in the grid.
2. If the cell is `1` (land):
    - Add 4 to the perimeter (because it has 4 sides to start with).
    - If there’s land **below it**, subtract 2 (since one vertical side is shared).
    - If there’s land **to the right**, subtract 2 (since one horizontal side is shared).
3. At the end, the total perimeter is the answer.



## **Step-by-Step with Example**
### Input:
```
grid = [
  [0, 1, 0, 0],
  [1, 1, 1, 0],
  [0, 1, 0, 0],
  [1, 1, 0, 0]
]
```


### Step 1 — Start scanning from `(0,0)`:
- `(0,0)` = 0 → Ignore.
- `(0,1)` = 1 → Add 4 → `perimeter = 4`
    - Below `(1,1)` = 1 → subtract 2 → `perimeter = 2`
    - Right `(0,2)` = 0 → no subtraction.



### Step 2 — `(0,2)` = 0 → skip, `(0,3)` = 0 → skip.



### Step 3 — Second row:
- `(1,0)` = 1 → +4 → `perimeter = 6`
    - Below `(2,0)` = 0 → no subtraction.
    - Right `(1,1)` = 1 → subtract 2 → `perimeter = 4`

- `(1,1)` = 1 → +4 → `perimeter = 8`
    - Below `(2,1)` = 1 → subtract 2 → `perimeter = 6`
    - Right `(1,2)` = 1 → subtract 2 → `perimeter = 4`

- `(1,2)` = 1 → +4 → `perimeter = 8`
    - Below `(2,2)` = 0 → no subtraction.
    - Right `(1,3)` = 0 → no subtraction.


### Step 4 — Third row:
- `(2,0)` = 0 → skip.
- `(2,1)` = 1 → +4 → `perimeter = 12`
    - Below `(3,1)` = 1 → subtract 2 → `perimeter = 10`
    - Right `(2,2)` = 0 → no subtraction.



### Step 5 — Fourth row:
- `(3,0)` = 1 → +4 → `perimeter = 14`
    - Below → outside grid → no subtraction.
    - Right `(3,1)` = 1 → subtract 2 → `perimeter = 12`

- `(3,1)` = 1 → +4 → `perimeter = 16`
    - Below → outside grid → no subtraction.
    - Right `(3,2)` = 0 → no subtraction.


## **Final Answer:**
`perimeter = 16`


Alright — let’s go through your **`islandPerimeter`** code **step-by-step**, so you fully understand exactly how it works.  

This code solves the **"Island Perimeter"** problem — given a rectangular grid of `0` (water) and `1` (land), it calculates the total perimeter of the single island.

### Java Implementation 

## **Step 1 — Variables Setup**
```java
int perimeter = 0;
int rows = grid.length;
int cols = grid[0].length;
```
- `perimeter` → will store our final answer, starting at **0**.
- `rows` → number of rows in the grid.
- `cols` → number of columns in the grid.



## **Step 2 — Loop Through Each Cell**
```java
for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        ...
    }
}
```
- The **outer loop** goes through each `row` index `i`.
- The **inner loop** goes through each `column` index `j` for that row.
- Together, `(i, j)` visits every cell in the grid.



## **Step 3 — Check for a Land Cell**
```java
if (grid[i][j] == 1) {
```
- We only care about **land cells** (`1`).
- Water cells (`0`) don’t contribute to the perimeter.


## **Step 4 — Add Initial Perimeter for the Land Cell**
```java
perimeter += 4;
```
- If this was an **isolated** land cell surrounded by water, its perimeter would be **4 sides** (up, down, left, right all exposed).



## **Step 5 — Remove Shared Edges with Cell Below**
```java
if (i < rows - 1 && grid[i + 1][j] == 1) {
    perimeter -= 2;
}
```
- If there’s another land cell **directly below**:
  - The current cell’s **bottom** and the neighbor’s **top** edges are **shared** — so, subtract **2** from the perimeter (one for each cell’s side).
- The check `i < rows - 1` ensures we don’t go outside the grid.


## **Step 6 — Remove Shared Edges with Cell to the Right**
```java
if (j < cols - 1 && grid[i][j + 1] == 1) {
    perimeter -= 2;
}
```
- If there’s another land cell **to the right**:
  - The current cell’s **right** and neighbor’s **left** edges are **shared**, so subtract **2** from the perimeter.
- The check `j < cols - 1` prevents going out of bounds.



## **Step 7 — Continue Loop for All Cells**

After looping through **all cells**, the `perimeter` will hold the total perimeter for the entire island.



## **Example Walkthrough**
### Grid:
```
0 1 0 0
1 1 1 0
0 1 0 0
1 1 0 0
```
- Start at `(0,1)`: land → `+4`, and below `(1,1)` is land → `-2`.
- At `(1,0)`: land → `+4`, right `(1,1)` is land → `-2`.
- This process repeats… each time we add **4** for a land cell and subtract **2** for any shared edge (avoiding double-subtraction by only checking **down** and **right**).

Final `perimeter = 16`.



## **Complexity**
- **Time Complexity:** `O(rows × cols)` — every cell is visited once.
- **Space Complexity:** `O(1)` — uses only constant extra space.



✅ **Key idea:** Add 4 for each land cell and subtract 2 for each shared edge (once per neighbor pair).  
This ensures you count only the visible edges of the island.

***


# 📊 Problem 4: find the paths if exist

[🔗 Path Exists solution](https://leetcode.com/problems/find-if-path-exists-in-graph/description/)



Alright — let’s go step-by-step through your **`validPath`** Java program so you fully understand exactly what it’s doing.

This solves the **LeetCode 1971 — Find if Path Exists in Graph** problem using **BFS (Breadth-First Search)**.



## 1️⃣ **Understanding the Problem**

We have:
- `n` = number of vertices (labeled **0 … n-1**)
- `edges` = list of undirected connections between nodes  
  (`[u, v]` means you can travel from u to v **and** from v to u).
- `source` and `destination` nodes.
- Task: Check **if there is a path** from `source` to `destination`.


## 2️⃣ **Step-by-step Code Walkthrough**

### Step 1 — Build the Graph (Adjacency List)
```java
List> graph = new ArrayList<>();
for (int i = 0; i ());
}
for (int[] edge : edges) {
    graph.get(edge[0]).add(edge[1]);
    graph.get(edge[1]).add(edge[0]); // because undirected
}
```
**What happens here:**
- We create an **adjacency list** representation of the graph:
  - `graph` has `n` lists inside it → one list for each vertex.
- For each edge `[u, v]`:
  - Add `v` to `u`’s neighbor list
  - Add `u` to `v`’s neighbor list (because undirected graph means both directions are valid).

**Example 1:**
```
n = 3
edges = [[0,1],[1,2],[2,0]]

After building:
graph[0] = [1, 2]
graph[1] = [0, 2]
graph[2] = [1, 0]
```



### Step 2 — BFS Initialization
```java
boolean[] visited = new boolean[n];
Queue queue = new LinkedList<>();
queue.add(source);
visited[source] = true;
```
**What happens:**
- `visited[]` → prevents re-visiting the same node and infinite loops.
- `queue` → stores nodes to explore next (FIFO order is essential for BFS).
- Start BFS:
  - Put `source` node into the queue.
  - Mark `source` as visited.



### Step 3 — BFS Loop
```java
while (!queue.isEmpty()) {
    int node = queue.poll(); // take first item
    if (node == destination) return true; // path found

    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            visited[neighbor] = true;
            queue.add(neighbor);
        }
    }
}
```
**How BFS works here:**
1. Take a node from the queue.
2. If it is `destination`, **path exists → return true**.
3. Otherwise, look at all of its neighbors:
   - If a neighbor is not visited yet, mark it visited and add it to the queue.
4. Repeat until:
   - Destination found → `true`
   - Queue becomes empty → No path → `false`



### Step 4 — No path found
```java
return false;
```
If BFS completes without finding the destination, return `false`.



## 3️⃣ **Dry Run Example**

**Input:**
```
n = 3
edges = [[0,1],[1,2],[2,0]]
source = 0
destination = 2
```

**Execution:**
- Graph:
```
0: [1, 2]
1: [0, 2]
2: [1, 0]
```
- Start: queue = ``, visited = `{0}`
- Dequeue `0`:
  - Neighbors: `1` (add to queue, visited), `2` (add to queue, visited)
- Now queue = ``
- Dequeue `1`:
  - Neighbors already visited.
- Dequeue `2`:
  - `2 == destination` → return **true**



**Second Example:**
```
n = 6
edges = [[0,1],[0,2],[3,5],[5,4],[4,3]]
source = 0
destination = 5
```
Graph components:
- `{0, 1, 2}` and `{3, 4, 5}` are disconnected.
BFS from `0` only visits `{0, 1, 2}`, never reaches `5` → queue ends empty → return **false**.



## 4️⃣ **Complexity**
- **Time:** `O(V + E)` — visit each vertex and edge once.
- **Space:** `O(V + E)` — adjacency list + visited array + BFS queue.



✅ **Summary:**
- Step 1: Build adjacency list.
- Step 2: BFS from `source` → explore all reachable nodes.
- Step 3: If we find `destination` → return true, else false.

***


# 📊 Problem 4: Clone the graph

[🔗 CLone graph solution](https://leetcode.com/problems/clone-graph/)


Alright — let’s walk through your **`cloneGraph`** BFS solution **step-by-step** so you see exactly how it works for cloning an undirected graph.

This is solving the **"Clone Graph"** problem:
> Given a reference to a node in a connected undirected graph, return a deep copy of the graph.



## **1️⃣ The Problem Reminder**
- We have a graph node structure:
  ```java
  class Node {
      public int val;
      public List neighbors;
  }
  ```
- We are given a **reference** to one node.
- The graph may have cycles, so visiting nodes more than once can happen.
- We need to make a **deep copy**:
  - Create **new Node objects** (no sharing of original ones).
  - Preserve the structure (same neighbor connections).



## **2️⃣ Step-by-Step Walkthrough of the Code**

### **Step 1 — Handle empty graph**
```java
if (node == null) return null;
```
- If the starting node is `null`, there’s nothing to clone — return `null`.



### **Step 2 — Setup data structures**
```java
Map visited = new HashMap<>();
Queue queue = new LinkedList<>();
```
- **`visited` map:**  
  Key → original node  
  Value → cloned node  
  Used to:
  - Avoid cloning the same node multiple times (important for cycles).
  - Find the corresponding cloned node for any original node.

- **`queue`:** for BFS — nodes to process in **FIFO** order.



### **Step 3 — Clone the starting node**
```java
Node cloneNode = new Node(node.val, new ArrayList<>());
visited.put(node, cloneNode);
queue.add(node);
```
- Create a **new Node** (`cloneNode`) for the starting node.
- Add the mapping: `(original node → clone node)` into `visited`.
- Put the original node into the BFS queue so we can process **its neighbors**.



### **Step 4 — BFS traversal loop**
```java
while (!queue.isEmpty()) {
    Node current = queue.poll();
```
- While there are unprocessed original nodes:
  - Remove the **first node** from the queue (`current`).
  - We’ll use it to find all its neighbors and process them.



### **Step 5 — Process neighbors**
```java
for (Node neighbor : current.neighbors) {
    if (!visited.containsKey(neighbor)) {
        // Clone and put in map
        visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
        queue.add(neighbor);
    }
    // Add cloned neighbor to current clone's neighbor list
    visited.get(current).neighbors.add(visited.get(neighbor));
}
```
For **each neighbor** of `current`:
1. **If the neighbor is not cloned yet** (`!visited.containsKey(neighbor)`):
   - Create a clone for it: `new Node(neighbor.val, new ArrayList<>())`.
   - Save `(neighbor → its clone)` in the map.
   - Add the original neighbor into the BFS queue to process its own neighbors later.
   
2. **Link the clones together**:
   - Get the **clone of current** node: `visited.get(current)`
   - Add the **clone of neighbor**: `visited.get(neighbor)` to its `.neighbors` list.
   - This builds the same edges in the clone graph as in the original.



### **Step 6 — Return result**
```java
return cloneNode;
```
- After BFS finishes, all nodes reachable from the original starting node are cloned and all edges are set.
- Return the **clone** of the original starting node — this is the reference to the entire cloned graph.



## **3️⃣ Example Dry Run**

### Input Graph (Adjacency List):
```
1: [2, 4]
2: [1, 3]
3: [2, 4]
4: [1, 3]
```
### BFS steps:
- Clone node 1 → visited = { 1 → 1' }, queue =
- Process node 1:
  - Neighbor 2:
    - Not visited → clone → visited = {1 → 1', 2 → 2'}, queue =
    - Add `2'` to `1'`'s neighbor list
  - Neighbor 4:
    - Not visited → clone → visited = {1 → 1', 2 → 2', 4 → 4'}, queue =
    - Add `4'` to `1'`'s neighbor list
- Process node 2:
  - Neighbor 1 → already visited → add `1'` to `2'`'s neighbors
  - Neighbor 3 → not visited → clone (3'), queue =
    - Add `3'` to `2'`'s neighbors
- Process node 4:
  - Neighbor 1 → visited → add `1'`
  - Neighbor 3 → visited → add `3'`
- Process node 3:
  - Neighbor 2 → visited → add `2'`
  - Neighbor 4 → visited → add `4'`

✅ All connections are now mirrored in the clone.



## **4️⃣ Complexity**
- **Time:** O(V + E) — visits each node/edge once.  
- **Space:** O(V) — for queue + visited map.

***


# Intermediate Pbms

# 📊 Problem 5: Rotting Oranges per minute

[🔗 Rotting Oranges solution](https://leetcode.com/problems/rotting-oranges/description/)


let’s go through this **Rotting Oranges** BFS solution **step-by-step** so you understand exactly what’s happening in each part.  

This is the **Breadth-First Search (BFS)** solution to LeetCode **994: Rotting Oranges**.



## **1️⃣ Problem Recap**
We have a grid:
- `0` → Empty cell
- `1` → Fresh orange
- `2` → Rotten orange  
Every **minute**: all fresh oranges **directly next to** a rotten orange (up, down, left, right) become rotten.

Goal: **Find the minimum minutes until no fresh orange remains**.  
If impossible, return `-1`.



## **2️⃣ Code Walkthrough**

### **Step A: Handle Edge Cases**
```java
if (grid == null || grid.length == 0) return 0;
```
- If the grid is `null` or has no rows, return `0` — nothing to rot.



### **Step B: Initialize Variables**
```java
int rows = grid.length;
int cols = grid[0].length;
int fresh = 0;
Queue queue = new LinkedList<>();
```
- `rows`, `cols` → grid dimensions.
- `fresh` → number of fresh oranges.
- `queue` → BFS processing queue.  
  Each element will be an `int[] { row, col, minutesPassed }`.


### **Step C: Find All Rotten Oranges & Count Fresh**
```java
for (int r = 0; r = 0 && newRow = 0 && newCol < cols &&
        grid[newRow][newCol] == 1) {

        grid[newRow][newCol] = 2; // make rotten
        fresh--; // one less fresh orange

        queue.offer(new int[]{newRow, newCol, time + 1});
    }
}
```
- For each of the **4 directions**:
  - Check if neighbor is **inside the grid** and **fresh** (`1`).
  - If so:
    - Make it rotten (`2`) — prevents revisiting.
    - Decrease `fresh` count.
    - Add it to the queue with `time + 1` (minute later).



### **Step H: After BFS Ends**
```java
return fresh == 0 ? minutes : -1;
```
- If all fresh oranges have been rotted (`fresh == 0`) → return `minutes` (the last time we rotted an orange).
- If some fresh oranges remain → return `-1` (impossible to rot all).



## **3️⃣ Example Walkthrough**
**Input:**
```
[ [2,1,1],
  [1,1,0],
  [0,1,1] ]
```

- Start:
  - Rotten: `(0,0)` at time 0.
  - Fresh count = 6.

**Minute 0 → 1:** rot `(0,1)` and `(1,0)` → fresh = 4  
**Minute 1 → 2:** rot `(0,2)` and `(1,1)` → fresh = 2  
**Minute 2 → 3:** rot `(2,1)` → fresh = 1  
**Minute 3 → 4:** rot `(2,2)` → fresh = 0 ✅

Returned time = **4**.



## **4️⃣ Complexity**
- **Time Complexity:** O(m × n) — each cell processed once.
- **Space Complexity:** O(m × n) — queue for BFS.

***

# 📊 Problem 6: Network Delay Time


[🔗 Network Delay Solution](https://leetcode.com/problems/network-delay-time/description/)



Alright — let’s go through this **`networkDelayTime`** code **step-by-step** so you clearly understand what every part does.

This is solving **LeetCode 743 – Network Delay Time** using **Dijkstra’s algorithm** with a priority queue (min-heap).



## **📌 Problem Recap**
We have:
- `n` nodes (`1` to `n`)
- `times` list of directed edges in the form `(u, v, w)` →  
  Signal can go from `u` to `v` in `w` minutes.
- We start sending a signal from node `k`.
- We need to find the **minimum time** required for **all nodes** to get the signal.
- If some node can’t get the signal → return `-1`.

Essentially, you’re finding **the longest shortest path** from `k` to all nodes.



## **🛠 Step-by-Step Walkthrough**

### **Step 1 — Build an adjacency list**
```java
List> graph = new ArrayList<>();
for (int i = 0; i ());
}
for (int[] time : times) {
    int u = time[0], v = time[1], w = time[2];
    graph.get(u).add(new int[] {v, w});
}
```
- We create `graph` where:
  - `graph.get(u)` returns a list of `{neighbor, weight}` pairs.
- Outer loop builds empty lists for all nodes (index `0` is unused since nodes are `1`–`n`).
- Second loop fills neighbors from the `times` input.
  
**Example:**
For:
```
times = [[2,1,1],[2,3,1],[3,4,1]], n=4
```
`graph` becomes:
```
1: []
2: [[1,1], [3,1]]
3: [[4,1]]
4: []
```
This means:
- From `2` → can go to `1` (cost 1), `3` (cost 1)
- From `3` → can go to `4` (cost 1)



### **Step 2 — Distance array**
```java
int[] dist = new int[n + 1];
Arrays.fill(dist, Integer.MAX_VALUE);
dist[k] = 0; 
```
- `dist[i]` stores the **shortest known time** from `k` to node `i`.
- Initially set to `∞` (unreachable).
- Start node `k` gets `0` because distance from `k` to itself is `0`.


### **Step 3 — Priority queue setup**
```java
PriorityQueue pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
pq.offer(new int[] {0, k});
```
- `pq` stores `{currentDistance, node}` pairs sorted by `currentDistance` (min-heap).
- Start by pushing `{0, k}` meaning "to reach `k` takes 0 minutes".



### **Step 4 — Dijkstra’s BFS**
```java
while (!pq.isEmpty()) {
    int[] curr = pq.poll();
    int currDist = curr[0], node = curr[1];
    
    if (currDist > dist[node]) continue; 
```
- Get the **closest unvisited** node from the queue.
- If we already have a **better distance** recorded for this node, skip it.


### **Step 5 — Relaxation**
```java
    for (int[] edge : graph.get(node)) {
        int neighbor = edge[0];
        int weight = edge[1];
        
        if (dist[node] + weight < dist[neighbor]) {
            dist[neighbor] = dist[node] + weight;
            pq.offer(new int[] {dist[neighbor], neighbor});
        }
    }
}
```
- For each neighbor of the current node:
  - If going through `node` gives a **shorter path** than current known distance:
    - Update `dist[neighbor]`
    - Push `{newDistance, neighbor}` into the queue.
- This ensures BFS-like expansion but in **order of shortest distance first** (Dijkstra’s property).



### **Step 6 — Find the answer**
```java
int maxDist = 0;
for (int i = 1; i <= n; i++) {
    if (dist[i] == Integer.MAX_VALUE) return -1; // unreachable
    maxDist = Math.max(maxDist, dist[i]);
}
return maxDist;
```
- Scan through distances from `k` to all nodes:
  - If any node is still `∞`, it means we couldn’t reach it → return `-1`.
  - Otherwise, the answer is the **maximum shortest distance** (the last node to receive the signal).



## **🔍 Example Run**
Input:
```
times = [[2,1,1],[2,3,1],[3,4,1]]
n = 4
k = 2
```
Processing:
1. Start at `2` → distance = 0
2. From `2`:
   - Update `1` to `1`
   - Update `3` to `1`
3. From `3`:
   - Update `4` to `2`
4. Max of distances = `max(1, 1, 2) = 2` → Answer = 2 minutes.


## **⏳ Complexity**
- **Time:** O((V + E) log V)  
  - V = n (nodes), E = edges in `times`
- **Space:** O(V + E) for adjacency list, distance array, and priority queue.



✅ **Summary:**  
- Build graph using adjacency list.
- Use Dijkstra’s algorithm from `k` to compute shortest times.
- Return the longest shortest time, or `-1` if unreachable.

***


# 📊 Problem 7:  Course Schedule

[🔗  Course Schedule solution](https://leetcode.com/problems/course-schedule/description/)

let’s go through your **Course Schedule – `canFinish`** code **step-by-step** so you understand each part and how it solves the problem.

This solution is using **Topological Sorting (Kahn’s Algorithm)** to detect if it’s possible to take all courses (i.e., if the graph has no cycles).


## **📌 Problem in simple terms**
- We have `numCourses` courses labeled `0` to `numCourses-1`.
- `prerequisites[i] = [a, b]` means: to take course `a`, you must first take course `b`.
- The courses and prerequisites form a **directed graph**:  
  An edge from `b → a`.

**Goal**:  
Return `true` if we can finish all courses (no cycle in this graph), otherwise `false`.



## **1️⃣ Step 1: Build the Graph (Adjacency List) and Indegree Array**
```java
List> graph = new ArrayList<>();
int[] indegree = new int[numCourses];

for (int i = 0; i ());
}

for (int[] pre : prerequisites) {
    int course = pre[0];
    int prereq = pre[1];
    graph.get(prereq).add(course);
    indegree[course]++;
}
```

### What’s happening:
- **`graph`**: Adjacency list where `graph[u]` contains all courses that depend on course `u`.
- **`indegree[i]`**: The number of prerequisites course `i` still needs before it can be taken.

**Example:**
```
numCourses = 2
prerequisites = [[1,0]]
```
This means:
- To take course `1`, you must complete course `0`.

Graph:
```
0 → 1
```
Array:
```
indegree[0] = 0  (course 0 has no prereqs)
indegree[1] = 1  (course 1 depends on 0)
```


## **2️⃣ Step 2: Find the Starting Point (Queue Initialization)**
```java
Queue queue = new LinkedList<>();
for (int i = 0; i < numCourses; i++) {
    if (indegree[i] == 0) {
        queue.add(i);
    }
}
```

- We add **all courses with `indegree = 0`** into the `queue` → these can be taken right away because they have **no prerequisites**.
- Starting points for BFS.

In the example:
```
queue = [0]  // only course 0 has no prerequisites
```



## **3️⃣ Step 3: BFS Processing (Kahn’s Algorithm Loop)**
```java
int finishedCourses = 0;
while (!queue.isEmpty()) {
    int current = queue.poll();
    finishedCourses++;
            
    for (int neighbor : graph.get(current)) {
        indegree[neighbor]--;
        if (indegree[neighbor] == 0) {
            queue.add(neighbor);
        }
    }
}
```

### Step-by-step:
- Take a course from the queue → **count it as finished** (`finishedCourses++`).
- Look at all the courses that depend on the current course (**its neighbors** in the graph).
- Reduce their `indegree` by 1 (one prereq completed).
- If any neighbor’s `indegree` becomes 0 → add it to the queue (now ready to take).

**Example:**
1. `queue = `, `finishedCourses = 0`
2. Poll `0` → increment `finishedCourses = 1`
   - Neighbor: `1` → `indegree` becomes 0 → Add `1` to queue.
3. `queue = `
4. Poll `1` → increment `finishedCourses = 2`
   - No neighbors.

End of BFS.



## **4️⃣ Step 4: Final Check**
```java
return finishedCourses == numCourses;
```
- If we processed all `numCourses` (i.e., `finishedCourses == numCourses`), then **no cycle exists** → all courses are finishable.
- If some courses still have non-zero indegree, there’s a **cycle** → return `false`.

Example 1:
```
finishedCourses = 2
numCourses = 2
Return true ✅
```



## **📍 Why this works**
- In topological sorting:
  - If the graph has **no cycle**, we can keep removing courses with `indegree = 0` until all are processed.
  - If the graph has a **cycle**, some courses will never reach `indegree = 0` (stuck waiting forever) → not all courses can be completed.


## **Example 2 (Cycle case)**
```
numCourses = 2
prerequisites = [[1,0],[0,1]]
Graph:
0 → 1
1 → 0
Indegree: [1, 1]

Queue = []  // no node has indegree=0
BFS won't run
finishedCourses = 0
Return false ❌
```



## **⏳ Complexity**
- **Time:** O(V + E) — V = courses, E = prerequisites  
- **Space:** O(V + E) — adjacency list + indegree array + queue

✅ **Summary of the Algorithm**:
1. Build graph & indegree array.
2. Start with nodes (courses) having indegree 0.
3. BFS: remove from queue, reduce indegrees of neighbors, add new zeros to queue.
4. If all courses processed → true, else false.

***



# 📊 Problem 8: Redundant Connection


[🔗 Redundant Connection solution](https://leetcode.com/problems/redundant-connection/description/)


let’s break this **`findRedundantConnection`** solution down **step-by-step** so it’s crystal clear.  
This is solving **LeetCode 684 – Redundant Connection** using the **Union-Find (Disjoint Set Union)** algorithm.



## **1️⃣ Problem Recap**
We have:
- `n` nodes (1 to n) forming a tree **plus one extra edge**, which creates exactly **one cycle**.
- We need to **find and return the edge** that, if removed, makes the graph a tree again.
- If there are multiple answers, return the one that appears **last** in the input.



## **2️⃣ How Union-Find Helps**
- Union-Find helps us track connected components.
- **If** two nodes are already connected and we try to connect them again, it **creates a cycle**.
- That edge is our **redundant connection**.



## **3️⃣ Code Walkthrough**

```java
private int[] parent;
```
- `parent[i]` → stores the **representative parent** of node `i`.
- For Union-Find, each node starts as its **own parent**.



### **Step A — Find function**
```java
private int find(int x) {
    if (parent[x] != x) {
        parent[x] = find(parent[x]);
    }
    return parent[x];
}
```
**Purpose:** Find the **root** of `x`’s set.  
- If `parent[x] == x`, `x` is the root.
- Otherwise, recurse up the tree until the root is found.  
- **Path compression**: update `parent[x]` to the root so that next time it’s faster.

Example:
```
Before path compression: 4 → 2 → 1 (root)
After path compression: parent[4] = 1
```


### **Step B — Union function**
```java
private boolean union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    
    if (rootX == rootY) {
        return false; // cycle detected
    }
    parent[rootY] = rootX; // merge sets
    return true;
}
```
**Purpose:** Connect two sets by linking their roots.
- If both nodes have the same root → they are already connected → adding this edge makes a cycle → return `false`.
- If roots differ → connect them (`rootY` → `rootX`) → return `true`.



### **Step C — Initialize Union-Find**
```java
int n = edges.length;  // Tree had n nodes, so edges.size() = n
parent = new int[n + 1]; // Index 1..n

for (int i = 1; i <= n; i++) {
    parent[i] = i;  // initially, each node is its own parent
}
```
We use `n+1` so we can use **1-based indexing** (ignore index 0).



### **Step D — Process Edges**
```java
for (int[] edge : edges) {
    int u = edge[0], v = edge[1];
    if (!union(u, v)) { // union failed → cycle found
        return edge; // this edge is redundant
    }
}
```
- For each edge `(u, v)`:
  1. Try to union them.
  2. If `union` returns `false` → they were already connected → this edge creates the cycle → **return it immediately**.
- Since we go in order, the problem’s “return last possible edge” is satisfied (processing order ensures the latest cycle-forming edge will be found).



### **Step E — Default Return (Shouldn’t Happen Here)**
```java
return new int[0];
```
This is just a fallback; the problem guarantees one redundant edge.



## **4️⃣ Example Walkthrough**

### Input:
```
edges = [[1,2], [1,3], [2,3]]
```

- Start:
```
parent = [0,1,2,3]
```


1. **Edge (1,2)**:
   - find(1) = 1, find(2) = 2 → different → union
   - parent =  ✅

2. **Edge (1,3)**:
   - find(1) = 1, find(3) = 3 → different → union
   - parent =  ✅

3. **Edge (2,3)**:
   - find(2) → root = 1, find(3) → root = 1 → **same root** → cycle detected 🔄
   - Return ``



## **5️⃣ Complexity**
- **Time:** O(n α(n)) ≈ O(n) — `α()` = very slow-growing inverse Ackermann function from Union-Find.
- **Space:** O(n) — for `parent` array.


✅ **Summary:**  
- Use Union-Find to detect the first time two nodes already belong to the same connected group.
- That edge is the extra one creating the cycle → return it.

***





# 📊 Problem 9: 797. All Paths From Source to Target

[🔗 All paths solution](https://leetcode.com/problems/all-paths-from-source-to-target/description/)

 let’s go through your **`allPathsSourceTarget`** code **step-by-step** so it’s fully clear how it finds all paths in the **DAG** from node `0` to node `n-1`.  

This is the **LeetCode 797 – All Paths from Source to Target** problem, solved with **DFS + Backtracking**.


## **1️⃣ Method Overview**
```java
public List> allPathsSourceTarget(int[][] graph) {
    List> result = new ArrayList<>();
    List path = new ArrayList<>();
    dfs(graph, 0, path, result);
    return result;
}
```

- **`result`** → stores all found paths (`List>`).
- **`path`** → used to hold the current exploration path.
- Start DFS from node `0`.
- Return collected paths after DFS finishes.



## **2️⃣ The DFS Function**
```java
private void dfs(int[][] graph, int node, List path, List> result) {
    // Add current node to the path
    path.add(node);
```
- Add the **current node** to the active path.



```java
    // If we reached the target node (n - 1)
    if (node == graph.length - 1) {
        result.add(new ArrayList<>(path)); // store copy
    } else {
        // Explore each neighbor
        for (int next : graph[node]) {
            dfs(graph, next, path, result);
        }
    }
```
- **Base case:** If `node == n-1` (last node), we’ve reached the target:
  - Add a **copy** of `path` to `result` (`new ArrayList<>(path)` ensures we don’t modify stored paths later).
- **Recursive case:** Otherwise, explore all neighbors of this node (from adjacency list `graph[node]`), calling DFS on each.



```java
    // Backtrack - remove current node before going back
    path.remove(path.size() - 1);
}
```
- **Backtracking step:**
  - Before returning to the previous DFS level, remove the last node from `path`.
  - This restores `path` to the state it had **before visiting this node** so the next branch can use it fresh.


## **3️⃣ How It Works – Dry Run Example**
### **Example input:**
```
graph = [[1,2],[3],[3],[]]
```
- Graph:
```
0 → 1 → 3
 ↘︎
  2 → 3
```
- `n = 4` → nodes 0, 1, 2, 3.



### DFS Walkthrough:

**Call:** `dfs(graph, 0, [], result)`

1. `path = `, node = 0 → not target → explore neighbors `1` and `2`.



**Branch 1 to node 1**:
- `path = `, node = 1 → not target → explore neighbor `3`.

**Reach node 3**:
- `path = `, node = 3 → target → add `[0, 1,esult.
- Backtrack: remove `3` → `path = `.
- Finish node 1’s neighbors, backtrack: `path = `.



**Branch 2 to node 2**:
- `path = `, node = 2 → not target → explore neighbor `3`.

**Reach node 3**:
- `path = `, node = 3 → target → add `[0, 2,esult.
- Backtrack: remove `3` → `path = `.
- Finish node 2’s neighbors, backtrack: `path = `.



**Backtrack final** → `path = []`.



**Result after DFS:**
```
[[0, 1, 3], [0, 2, 3]]
```



## **4️⃣ Complexity**
- **Time Complexity:** In worst case, can explore all possible paths → complexity is `O(P * L)`  
  - `P` = number of distinct paths
  - `L` = average length of a path
- **Space Complexity:** `O(L)` for the recursion + storing output.



## **5️⃣ Summary Flow**
1. Start from node `0`
2. Keep adding nodes to `path`.
3. If you reach node `n-1`, save a copy of `path` to `result`.
4. Otherwise, DFS deeper into all neighbors.
5. Backtrack to explore other paths.

***


# 📊 Problem 10: is-graph-bipartite

[🔗 is-graph-bipartite solution](https://leetcode.com/problems/is-graph-bipartite/description/)

let’s go through your **`isBipartite`** code step-by-step, very clearly, so you understand exactly how it works.  
This is solving the **LeetCode 785 – Is Graph Bipartite?** problem using **DFS + 2-coloring**.


## **1️⃣ Problem Understanding**
We have:
- An **undirected** graph given as an adjacency list `graph[]`.
- `graph[u]` contains all nodes directly connected to `u`.
- A graph is **bipartite** if we can split all nodes into **two groups** (`Set A` and `Set B`) so that **no edge connects two nodes in the same group**.

We can think of this as a **two-color problem**:
- Assign each node a color: say **1** and **-1**.
- If we can color all nodes such that no adjacent nodes have the same color → graph is bipartite.
- If a conflict appears (an edge with both endpoints having the same color) → **not bipartite**.



## **2️⃣ Variables**
```java
int n = graph.length;
int[] color = new int[n]; // 0 = uncolored, 1 = one color, -1 = the other color
```
- `n` is the total number of nodes in the graph.
- `color[i]`:
  - `0` → node is not yet colored.
  - `1` → node is in set A.
  - `-1` → node is in set B.



## **3️⃣ Main Loop – Processing Each Node**
```java
for (int i = 0; i < n; i++) {
    if (color[i] == 0 && !dfs(graph, color, i, 1)) {
        return false;
    }
}
```
Why loop over all nodes?
- The graph might be **disconnected** (more than one component).
- We must check each component separately.

Logic:
- If a node is **uncolored** (`color[i] == 0`), start DFS from it and try to color it starting with `1`.
- If DFS returns `false` for a component → immediately return `false`.



## **4️⃣ DFS Function**
```java
private boolean dfs(int[][] graph, int[] color, int node, int c) {
    if (color[node] != 0) return color[node] == c;
```
- **If the node is already colored**:
  - If the existing color matches the expected `c` → okay → return `true`.
  - If it doesn’t match → conflict → return `false` (graph is not bipartite).



```java
color[node] = c; // assign color c
```
- Assign the current node to the given color `c`.


```java
for (int neighbor : graph[node]) {
    if (!dfs(graph, color, neighbor, -c)) {
        return false;
    }
}
```
- Explore each neighbor of the current node.
- We pass `-c` as the color for neighbors (opposite of current node’s color).
- If **any** neighbor DFS call returns `false` → conflict detected → return `false`.



```java
return true;
```
- If all neighbors are colored successfully without conflict → return `true`.



## **5️⃣ Dry Run Example**
### Example:  
```
graph = [[1,3],[0,2],[1,3],[0,2]]
```
(which means:  
0 ↔ 1  
1 ↔ 2  
2 ↔ 3  
3 ↔ 0  
Square shape)



**Step 1:**  
- i = 0, `color == 0` → DFS(0, color=1)
- color = 1 → neighbors: 1 and 3

**Step 2 (DFS for neighbor 1):**  
- color = -1 → neighbor: 0 (already color 1 ✅) → neighbor: 2
- DFS(2, color = 1)

**Step 3 (DFS for neighbor 2):**  
- color = 1 → neighbor: 1 (already -1 ✅) → neighbor: 3
- DFS(3, color = -1)

**Step 4 (DFS for neighbor 3):**  
- color = -1 → neighbor: 0 (already 1 ✅) → neighbor: 2 (already 1 ✅)

✅ All okay → graph is bipartite → return true.



## **6️⃣ Complexity**
- **Time:** O(V + E) → each node and edge visited once in DFS.
- **Space:**  
  - O(V) for `color[]`
  - O(V) recursion stack in worst case (deep DFS).



## **7️⃣ Summary**
- **Idea:** DFS with two-color assignment.
- **Process:** Color current node, then recursively color neighbors with opposite color.
- **Check:** If any neighbor already has the same color → not bipartite.
- **Loop:** Needed because the graph could be disconnected.

***





# Advanced :




# 📊 Problem 11: Minimu Cost to make one Valid Path

[🔗 solution](https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/)


***

# 📊 Problem 12: Critcal Connection In a network

[🔗 solution](https://leetcode.com/problems/critical-connections-in-a-network/description/)

***

# 📊 Problem 13: FInd Pacifi Atlantic water flow

[🔗 solution](https://leetcode.com/problems/pacific-atlantic-water-flow/description/)

***

# 📊 Problem 14: Dind the max area of the Island

[🔗 solution](https://leetcode.com/problems/max-area-of-island/description/)

***

# 📊 Problem 15: Evalauate Division

[🔗 solution](https://leetcode.com/problems/evaluate-division/description/)




***
# 📊 Problem 16: Reorder Routes to make all paths lead to the city zero

[🔗 solution](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/)

