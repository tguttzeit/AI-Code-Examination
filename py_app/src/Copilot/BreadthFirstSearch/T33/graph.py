class Graph:
    # Constructor
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for i in range(vertices)]

    # Method to add an edge
    def add_edge(self, u, v):
        self.adjacency_list[u].append(v)

    # Method to perform bfs
    def bfs(self, vertex):
        # Initialize the visited list
        visited = [False] * self.vertices
        # Initialize the queue
        queue = []
        # Initialize the result list
        result = []
        # Mark the vertex as visited
        visited[vertex] = True
        # Add the vertex to the queue
        queue.append(vertex)
        # Loop while queue is not empty
        while queue:
            # Pop the front element from the queue
            front = queue.pop(0)
            # Add the vertex to the result
            result.append(front)
            # For every adjacent vertex of the front vertex
            for i in self.adjacency_list[front]:
                # If the adjacent vertex is not visited
                if not visited[i]:
                    # Mark the adjacent vertex as visited
                    visited[i] = True
                    # Add the adjacent vertex to the queue
                    queue.append(i)
        # Return the result
        return result
