# Best-First Search

Greedy Best First Search and A* Search implemented in Java

## Author
- **@mavyfaby** (Maverick Fabroa)

## Date
- November 6, 2022

## LICENSE

Copyright (C) 2022 Maverick Fabroa <me@mavyfaby.me>

This file is part of the Best-First Search project.

The Best-First Search project can not be copied and/or distributed without the express
permission of Maverick Fabroa <me@mavyfaby.me>.

## Index

- [Best-First Search](#best-first-search)
  - [Author](#author)
  - [Date](#date)
  - [LICENSE](#license)
  - [Index](#index)
  - [API](#api)
    - [MavyGraphTraversal](#mavygraphtraversal)
      - [int addPlace](#int-addplace)
      - [int addPlace](#int-addplace-1)
      - [int connect](#int-connect)
      - [int connect](#int-connect-1)
      - [void GBFS](#void-gbfs)
    - [void Astar](#void-astar)
    - [Node](#node)
      - [int addNeighbor](#int-addneighbor)
      - [String getName](#string-getname)
      - [double getF](#double-getf)
      - [double getG](#double-getg)
      - [double getH](#double-geth)
      - [void setF](#void-setf)
      - [void setG](#void-setg)
      - [void setH](#void-seth)
      - [Node getParent](#node-getparent)
      - [void setParent](#void-setparent)
      - [boolean isVisited](#boolean-isvisited)
      - [void setVisited](#void-setvisited)
      - [LinkedList\<Edge\> getNeighbors](#linkedlistedge-getneighbors)
      - [String getLabel](#string-getlabel)
      - [boolean isNeighbor](#boolean-isneighbor)
    - [Edge](#edge)
      - [Node getNode](#node-getnode)
      - [double getWeight](#double-getweight)
  - [LICENSE](#license-1)

## API

### MavyGraphTraversal

```java
MavyGraphTraversal()
```

#### int addPlace

```java
public int addPlace(String place, double h)
```

Add place to the list of places.

Parameters:
 - `place` - name of the place
 - `h` - heuristic value

Returns:
- `0` if successful, `-1` if not

#### int addPlace

```java
public int addPlace(String place, String label, double h)
```

Add place to the list of places.

Parameters:
- `place` - name of the place
- `label` - label of the place
- `h` - heuristic value

Returns:
- `0` if successful, `-1` if not

#### int connect

```java
public int connect(int v1, int v2, double weight)
```

Connect 2 vertices with distance (Directed)

Parameters:
- `v1` - place index 
- `v2` - place index
- `weight` - distance

Returns:
- `0` if successful, `-1` if not

#### int connect

```java
public int connect(int v1, int v2, double weight, boolean isUndirected)
```

Connect 2 vertices with distance (Undirected)

Parameters:
- `v1` - place index
- `v2` - place index
- `weight` - distance
- `isUndrected` - if connection is undirected

Returns:
- `0` if successful, `-1` if not

#### void GBFS

```java
public void GBFS(int startPlace, int goalPlace)
```

Do a Greedy-Best First Search to the Graph

Parameters:
- `startPlace` - starting place
- `goalPlace` - goal place

### void Astar

```java
public void Astar(int startPlace, int goalPlace)
```

Do an A* search to the graph

Parameters:
- `startPlace` - starting place
- `goalPlace` - goal place

### Node

```java
Node(String name)
Node(String name, String label) 
```

#### int addNeighbor

```java
public int addNeighbor(Node n, double weight)
```

Add neighbor to this node

Parameters:
- `n` - the node to be added to neighbors
- `weight` - distance from this node to n

Returns:
- `0` if successful, `-1` if not

#### String getName

```java
public String getName()
```

#### double getF

```java
public double getF()
```

#### double getG

```java
public double getG()
```

#### double getH

```java
public double getH()
```

#### void setF

```java
public void setF(double f)
```

#### void setG

```java
public void setG(double g)
```

#### void setH

```java
public void setH(double h)
```

#### Node getParent

```java
public double getParent()
```

#### void setParent

```java
public void setParent(Node parent)
```

#### boolean isVisited

```java
public boolean isVisited()
```

#### void setVisited

```java
public void setVisited(boolean visited)
```

#### LinkedList\<Edge\> getNeighbors

```java
public LinkedList<Edge> getNeighbors(boolean visited)
```

Get node's neighbors

Returns:
- list of places as nodes

#### String getLabel

```java
public String getLabel()
```

Get place label

Returns:
- name if no label, otherwise return label

#### boolean isNeighbor

```java
public boolean isNeighbor(Node n)
```

Check if the node already exist in the list of neighbors

Parameters:
- `n` - the node place


Returns:
- name if no label, otherwise return label

### Edge

```java
Edge(Node n, double weight) 
```

#### Node getNode

```java
public Node getNode()
```

Returns:
- the node connected to this edge

#### double getWeight

```java
public double getWeight()
```

Returns:
- the weight of this edge

## LICENSE

Copyright (C) 2022 Maverick Fabroa <me@mavyfaby.me>

This file is part of the Best-First Search project.

The Best-First Search project can not be copied and/or distributed without the express
permission of Maverick Fabroa <me@mavyfaby.me>.
