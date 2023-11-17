# Source: https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

from collections import defaultdict


# This class represents a directed graph
# using adjacency list representation
class Graph:

    # CHANGE FOR EXPERIMENT: Constructor got modified with the "vertices" argument due to the prompt
    def __init__(self, vertices):

        # Default dictionary to store graph
        self.graph = defaultdict(list)
        # Number of vertices/nodes in the graph
        self.vertices = vertices

    # Function to add an edge to graph
    # CHANGE FOR EXPERIMENT: Function got renamed from 'addEdge()' to 'add_edge()'
    def add_edge(self, u, v):
        self.graph[u].append(v)

    # Function to print a BFS of graph
    # CHANGE FOR EXPERIMENT: Function got renamed from 'BFS()' to 'bfs()'
    def bfs(self, s):
        # Mark all the vertices as not visited
        # The following line got modified, see constructor for details
        visited = [False] * self.vertices
        # Create a queue for BFS
        queue = []
        result = []
        # Mark the source node as
        # visited and enqueue it
        queue.append(s)
        visited[s] = True

        while queue:
            # Dequeue a vertex from
            # queue and print it
            s = queue.pop(0)
            result.append(s)

            # Get all adjacent vertices of the
            # dequeued vertex s.
            # If an adjacent has not been visited,
            # then mark it visited and enqueue it
            for i in self.graph[s]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True

        return result

# This code is contributed by Neelam Yadav
