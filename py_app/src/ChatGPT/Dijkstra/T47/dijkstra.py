import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source].append((destination, weight))
        self.graph[destination].append((source, weight))  # Assuming an undirected graph

    def find_shortest_paths(self, source):
        # Initialize distances and visited status for all vertices
        distances = [float('inf')] * self.vertices
        visited = [False] * self.vertices

        # Initialize the distance for the source vertex
        distances[source] = 0

        # Create a priority queue (min heap) to store vertices and their distances
        priority_queue = [(0, source)]

        shortest_paths = {}

        while priority_queue:
            # Get the vertex with the smallest distance from the priority queue
            current_distance, current_vertex = heapq.heappop(priority_queue)

            # If the vertex has already been visited, skip it
            if visited[current_vertex]:
                continue

            # Mark the current vertex as visited
            visited[current_vertex] = True

            # Update the distances and shortest_paths for neighboring vertices
            for neighbor, weight in self.graph[current_vertex]:
                distance = current_distance + weight

                # If this path is shorter than the previously known distance, update it
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    shortest_paths[neighbor] = [current_vertex]

                    # Add the neighbor to the priority queue for further exploration
                    heapq.heappush(priority_queue, (distance, neighbor))

                # If there is a tie in distances, append the neighbor to the shortest_paths
                elif distance == distances[neighbor]:
                    shortest_paths[neighbor].append(current_vertex)

        # Convert the shortest_paths dictionary to the desired format
        result = {}
        for vertex, path in shortest_paths.items():
            if vertex != source:
                result[vertex] = path[::-1]  # Reverse the path to get the correct order

        return result
