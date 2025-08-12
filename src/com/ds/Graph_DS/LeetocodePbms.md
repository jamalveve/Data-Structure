https://leetcode.com/problems/flood-fill/




https://leetcode.com/problems/number-of-islands/


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

***

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

***

### Step 2 — Continue scanning:

- `(1,3)` is `1`: Not connected to the first island (separated by `0`s).
  - Explore connected land for second island:
    - `(1,4)` = 1 → connected
- So, second island cells are `(1,3)` and `(1,4)`.

***

### Step 3 — Continue scanning:

- `(3,4)` is `1`: No adjacent connected lands.
- So, this cell `(3,4)` alone is the third island.

***

### Step 4 — Summary of islands:

| Island Number | Cells                               |
|---------------|------------------------------------|
| 1             | `(0,0),(0,1),(0,2),(1,0),(2,0),(2,1)` |
| 2             | `(1,3),(1,4)`                      |
| 3             | `(3,4)`                           |

***

### **Final Output:** Number of islands = **3**

***
### Java code Implemenentation



This is solving the **Number of Islands** problem using **Depth-First Search (DFS)**.  
Let’s go line-by-line.

***

## **1️⃣ Method: `numIslands`**

```java
public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;
```
- If the grid is **empty** (`null` or row count == 0), there are no islands, so return **0** immediately.

***

```java
    int islands = 0;
    int rows = grid.length;
    int cols = grid[0].length;
```
- `islands` → counter for how many islands we find.
- `rows` & `cols` store the grid dimensions.

***

```java
    for (int r = 0; r = grid.length || c >= grid[0].length) return;
```
- Stop if we go **outside** the grid.

***

```java
    // If water or already visited
    if (grid[r][c] == '0') return;
```
- If this cell is **water (`'0'`)** or we've already visited and marked it `'0'`, we **stop**.

***

```java
    // Mark current as visited (make it water)
    grid[r][c] = '0';
```
- Change this land cell to `'0'` so we **don’t visit** it again in the future.
- This effectively "removes" it from the island.

***

```java
    // Explore neighbors (up, down, left, right)
    dfs(grid, r + 1, c); // Down
    dfs(grid, r - 1, c); // Up
    dfs(grid, r, c + 1); // Right
    dfs(grid, r, c - 1); // Left
```
- Call DFS recursively in **all 4 directions**.
- This step **"flood fills"** the entire connected island.

***

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

***

## **4️⃣ Complexity**
- **Time Complexity**: O(m × n) — each cell is visited at most once.
- **Space Complexity**: O(m × n) in worst case (recursive DFS stack for the largest island) — if the island covers the whole grid.

***

✅ **Summary:**  
- The outer loops find a starting land cell.  
- Each DFS marks that entire island visited so it's counted only once.  
- `islands` keeps track of how many separate land groups exist.




https://leetcode.com/problems/island-perimeter/submissions/1731263397/

3.
***

## **Restating the Problem**
We have a grid:
- `1` = Land
- `0` = Water
- Land cells are connected only **up, down, left, right** (no diagonals).
- There is exactly **one island** and no lakes.
- We need to find the **perimeter** — the total number of edges of land that touch either water or the grid boundary.

***

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

***

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

***

### Step 1 — Start scanning from `(0,0)`:
- `(0,0)` = 0 → Ignore.
- `(0,1)` = 1 → Add 4 → `perimeter = 4`
    - Below `(1,1)` = 1 → subtract 2 → `perimeter = 2`
    - Right `(0,2)` = 0 → no subtraction.

***

### Step 2 — `(0,2)` = 0 → skip, `(0,3)` = 0 → skip.

***

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

***

### Step 4 — Third row:
- `(2,0)` = 0 → skip.
- `(2,1)` = 1 → +4 → `perimeter = 12`
    - Below `(3,1)` = 1 → subtract 2 → `perimeter = 10`
    - Right `(2,2)` = 0 → no subtraction.

***

### Step 5 — Fourth row:
- `(3,0)` = 1 → +4 → `perimeter = 14`
    - Below → outside grid → no subtraction.
    - Right `(3,1)` = 1 → subtract 2 → `perimeter = 12`

- `(3,1)` = 1 → +4 → `perimeter = 16`
    - Below → outside grid → no subtraction.
    - Right `(3,2)` = 0 → no subtraction.

***

## **Final Answer:**
`perimeter = 16`

***
Alright — let’s go through your **`islandPerimeter`** code **step-by-step**, so you fully understand exactly how it works.  

This code solves the **"Island Perimeter"** problem — given a rectangular grid of `0` (water) and `1` (land), it calculates the total perimeter of the single island.

***
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

***

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

***

## **Step 3 — Check for a Land Cell**
```java
if (grid[i][j] == 1) {
```
- We only care about **land cells** (`1`).
- Water cells (`0`) don’t contribute to the perimeter.

***

## **Step 4 — Add Initial Perimeter for the Land Cell**
```java
perimeter += 4;
```
- If this was an **isolated** land cell surrounded by water, its perimeter would be **4 sides** (up, down, left, right all exposed).

***

## **Step 5 — Remove Shared Edges with Cell Below**
```java
if (i < rows - 1 && grid[i + 1][j] == 1) {
    perimeter -= 2;
}
```
- If there’s another land cell **directly below**:
  - The current cell’s **bottom** and the neighbor’s **top** edges are **shared** — so, subtract **2** from the perimeter (one for each cell’s side).
- The check `i < rows - 1` ensures we don’t go outside the grid.

***

## **Step 6 — Remove Shared Edges with Cell to the Right**
```java
if (j < cols - 1 && grid[i][j + 1] == 1) {
    perimeter -= 2;
}
```
- If there’s another land cell **to the right**:
  - The current cell’s **right** and neighbor’s **left** edges are **shared**, so subtract **2** from the perimeter.
- The check `j < cols - 1` prevents going out of bounds.

***

## **Step 7 — Continue Loop for All Cells**

After looping through **all cells**, the `perimeter` will hold the total perimeter for the entire island.

***

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

***

## **Complexity**
- **Time Complexity:** `O(rows × cols)` — every cell is visited once.
- **Space Complexity:** `O(1)` — uses only constant extra space.

***

✅ **Key idea:** Add 4 for each land cell and subtract 2 for each shared edge (once per neighbor pair).  
This ensures you count only the visible edges of the island.

***





https://leetcode.com/problems/find-if-path-exists-in-graph/description/


Alright — let’s go step-by-step through your **`validPath`** Java program so you fully understand exactly what it’s doing.

This solves the **LeetCode 1971 — Find if Path Exists in Graph** problem using **BFS (Breadth-First Search)**.

***

## 1️⃣ **Understanding the Problem**

We have:
- `n` = number of vertices (labeled **0 … n-1**)
- `edges` = list of undirected connections between nodes  
  (`[u, v]` means you can travel from u to v **and** from v to u).
- `source` and `destination` nodes.
- Task: Check **if there is a path** from `source` to `destination`.

***

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

***

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

***

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

***

### Step 4 — No path found
```java
return false;
```
If BFS completes without finding the destination, return `false`.

***

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

***

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

***

## 4️⃣ **Complexity**
- **Time:** `O(V + E)` — visit each vertex and edge once.
- **Space:** `O(V + E)` — adjacency list + visited array + BFS queue.

***

✅ **Summary:**
- Step 1: Build adjacency list.
- Step 2: BFS from `source` → explore all reachable nodes.
- Step 3: If we find `destination` → return true, else false.

***



https://leetcode.com/problems/clone-graph/

Alright — let’s walk through your **`cloneGraph`** BFS solution **step-by-step** so you see exactly how it works for cloning an undirected graph.

This is solving the **"Clone Graph"** problem:
> Given a reference to a node in a connected undirected graph, return a deep copy of the graph.

***

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

***

## **2️⃣ Step-by-Step Walkthrough of the Code**

### **Step 1 — Handle empty graph**
```java
if (node == null) return null;
```
- If the starting node is `null`, there’s nothing to clone — return `null`.

***

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

***

### **Step 3 — Clone the starting node**
```java
Node cloneNode = new Node(node.val, new ArrayList<>());
visited.put(node, cloneNode);
queue.add(node);
```
- Create a **new Node** (`cloneNode`) for the starting node.
- Add the mapping: `(original node → clone node)` into `visited`.
- Put the original node into the BFS queue so we can process **its neighbors**.

***

### **Step 4 — BFS traversal loop**
```java
while (!queue.isEmpty()) {
    Node current = queue.poll();
```
- While there are unprocessed original nodes:
  - Remove the **first node** from the queue (`current`).
  - We’ll use it to find all its neighbors and process them.

***

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

***

### **Step 6 — Return result**
```java
return cloneNode;
```
- After BFS finishes, all nodes reachable from the original starting node are cloned and all edges are set.
- Return the **clone** of the original starting node — this is the reference to the entire cloned graph.

***

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

***

## **4️⃣ Complexity**
- **Time:** O(V + E) — visits each node/edge once.  
- **Space:** O(V) — for queue + visited map.

***


Intermediate

https://leetcode.com/problems/rotting-oranges/description/


Alright — let’s go through this **Rotting Oranges** BFS solution **step-by-step** so you understand exactly what’s happening in each part.  

This is the **Breadth-First Search (BFS)** solution to LeetCode **994: Rotting Oranges**.

***

## **1️⃣ Problem Recap**
We have a grid:
- `0` → Empty cell
- `1` → Fresh orange
- `2` → Rotten orange  
Every **minute**: all fresh oranges **directly next to** a rotten orange (up, down, left, right) become rotten.

Goal: **Find the minimum minutes until no fresh orange remains**.  
If impossible, return `-1`.

***

## **2️⃣ Code Walkthrough**

### **Step A: Handle Edge Cases**
```java
if (grid == null || grid.length == 0) return 0;
```
- If the grid is `null` or has no rows, return `0` — nothing to rot.

***

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

***

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

***

### **Step H: After BFS Ends**
```java
return fresh == 0 ? minutes : -1;
```
- If all fresh oranges have been rotted (`fresh == 0`) → return `minutes` (the last time we rotted an orange).
- If some fresh oranges remain → return `-1` (impossible to rot all).

***

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

***

## **4️⃣ Complexity**
- **Time Complexity:** O(m × n) — each cell processed once.
- **Space Complexity:** O(m × n) — queue for BFS.

***

https://leetcode.com/problems/network-delay-time/description/


https://leetcode.com/problems/course-schedule/description/



https://leetcode.com/problems/redundant-connection/description/

https://leetcode.com/problems/all-paths-from-source-to-target/description/


https://leetcode.com/problems/is-graph-bipartite/description/



Advanced

https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/

https://leetcode.com/problems/critical-connections-in-a-network/description/

https://leetcode.com/problems/redundant-connection-ii/description/
https://leetcode.com/problems/pacific-atlantic-water-flow/description/

https://leetcode.com/problems/max-area-of-island/description/


https://leetcode.com/problems/evaluate-division/description/

https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/