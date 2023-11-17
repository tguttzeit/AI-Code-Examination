# Source: https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/

from collections import defaultdict


# This class represents a directed graph
# using adjacency list representation
class DepthFirstSearch:

    # Constructor
    def __init__(self):

        # Default dictionary to store graph
        self.graph = defaultdict(list)
        # Set to store visited nodes
        # CHANGE FOR EXPERIMENT: Changed set() to list()
        self.visited_nodes = list()

    # Function to add an edge to graph
    # Function got renamed from 'addEdge()' to 'add_edge()'
    # Renamed 'u' to 'source'
    # Renamed 'v' to 'destination'
    def add_edge(self, source, destination):
        self.graph[source].append(destination)

    # Renamed function from 'DFSUtil()' to 'dfs()'
    # Renamed 'v' to 'start_node'
    # Removed 'visited' to 'discovered'
    def dfs(self, start_node):

        # Mark the current node as visited
        self.visited_nodes.append(start_node)

        # Recur for all the vertices
        # adjacent to this vertex
        for neighbour in self.graph[start_node]:
            if neighbour not in self.visited_nodes:
                self.dfs(neighbour)

        # CHANGE FOR EXPERIMENT: Added return statement
        return self.visited_nodes
