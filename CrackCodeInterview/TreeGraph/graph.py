from collections import defaultdict
from collections import deque
class Graph:
    def __init__(self, edgelist):
        self.graph = defaultdict(list)
        self.createGraph(edgelist)


    def createGraph(self, edgelist):
        for edge in edgelist:
            self.graph[edge[0]].append(edge[1])
            self.graph[edge[1]].append(edge[0])


    def addNode(self, node):
        self.graph.setdefault(node, [])


    def addEdge(self, edge):
        self.graph[edge[0]].append(edge[1])
        self.graph[edge[1]].append(edge[0])


    def nodes(self):
        return self.graph.keys()


    def adjencyMatirx(self):
        size = len(self.graph)
        matrix = [[0 for _ in range(size)] for _ in range(size)]
        for row in self.graph:
            for col in self.graph[row]:
                matrix[row][col] = 1

        return matrix


def depthFirst(graph, source, visited):
    if source is None:
        return
    # visited = set()
    print(source)
    visited.add(source)
    for n in graph[source]:
        if n not in visited:
            depthFirst(graph, n, visited)


def breadthFirst(graph, source, visited):
    queue = deque()
    visited.add(source)
    queue.append(source)

    while queue:
        value = queue.popleft()
        print(value)
        for neighbor in graph[value]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)


def findPath(graph, src, des):
    visited = set()
    return findPathHelper(graph, src, des, visited)


def findPathHelper(graph, src, des, visited):
    queue = deque()
    visited.add(src)
    queue.append(src)

    while queue:
        value = queue.popleft()
        if value == des:
            return True
        for n in graph[value]:
            if n not in visited:
                visited.add(n)
                queue.append(n)

    return False


edges = [(0, 1), (1, 2), (1, 3), (2, 7), (2, 8), (4, 5), (5, 6)]
g = Graph(edges)
print(findPath(g.graph, 2, 2))

