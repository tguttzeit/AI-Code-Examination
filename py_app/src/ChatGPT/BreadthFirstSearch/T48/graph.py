from collections import defaultdict

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = defaultdict(list)

    def add_edge(self, vertex1, vertex2):
        self.adjacency_list[vertex1].append(vertex2)
        self.adjacency_list[vertex2].append(vertex1)

    def bfs(self, start_vertex):
        visited = [False] * (self.vertices + 1)  # Initialize visited list
        result = []  # Initialize the result list to store visited nodes

        queue = [start_vertex]  # Create a queue for BFS
        visited[start_vertex] = True  # Mark the starting vertex as visited

        while queue:
            current_vertex = queue.pop(0)  # Dequeue a vertex from the queue
            result.append(current_vertex)  # Add the current vertex to the result list

            # Visit all adjacent vertices of the current vertex
            for neighbor in self.adjacency_list[current_vertex]:
                if not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True  # Mark the neighbor as visited

        return result
