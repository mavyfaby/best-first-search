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
public MavyGraphTraversal()
```

### Methods

#### public

- `int addPlace(String place, double h)` - Add place to the list of places.
- `int addPlace(String place, String label, double h)` - Add place to the list of places with label.
- `int connect(int v1, int v2, double weight)` - Connect 2 vertices with distance (Directed).
- `int connect(int v1, int v2, double weight, boolean isUndirected)` - Connect 2 vertices with distance (with option to make it undirected).
- `void GBFS(int startPlace, int goalPlace)` - Do a Greedy-Best First Search to the Graph.
- `void Astar(int startPlace, int goalPlace)` - Do an A* search to the graph.

### private

- `LinkedList<Node> getPath(Node n)` - Get path based on the parent.
- `Node getLowestF(LinkedList<Node> list)` -  Get the lowest f(n) value.
- `Node getLowestF(LinkedList<Node> list, boolean willRemoveFromList)` - Get the lowest f(n) value and add an option to remove it in the list.
- `void displayPath(LinkedList<Node> path)` - Display path.
- `void displayLabelWithName(LinkedList<Node> path)` - Display every place's label with name.
- `boolean isPlaceExist(String name)` - Check if place exist in the graph.
- `boolean isPlaceExist(LinkedList<Node> list, String name)` - Check if place exist in the given list.
- `boolean isOutOfRange(int index)` - Determine whether the given index is out of range.


### Node

```java
public Node(String name)
public Node(String name, String label) 
```

### Methods

#### public

- `int addNeighbor(Node n, double weight)` - Add neighbor to this node.
- `String getName()`
- `double getF()`
- `double getG()`
- `double getH()`
- `void setF(double f)`
- `void setG(double g)`
- `void setH(double h)`
- `Node getParent()`
- `void setParent(Node parent)`
- `boolean isVisited()`
- `void setVisited(boolean visited)`
- `LinkedList<Edge> getNeighbors(boolean visited)` - Get node's neighbors.
- `String getLabel()` - Get place label.
- `boolean isNeighbor(Node n)` - Check if the node already exist in the list of neighbors.


### Edge

```java
public Edge(Node n, double weight) 

```

### Methods

- `Node getNode()`
- `double getWeight()`


## LICENSE

Copyright (C) 2022 Maverick Fabroa <me@mavyfaby.me>

This file is part of the Best-First Search project.

The Best-First Search project can not be copied and/or distributed without the express
permission of Maverick Fabroa <me@mavyfaby.me>.
