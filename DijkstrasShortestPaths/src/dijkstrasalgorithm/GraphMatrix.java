package dijkstrasalgorithm;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * GraphMatrix class is used to create a connected, weighted Graph Matrix and then runs Dijkstra's Algorithm
 *  to find the shortest paths to each vertex from a source vertex in the Graph. Once these paths are
 *  found, the minimum distance to each vertex from the source is displayed followed by the shortest paths to 
 *  follow to reach each vertex from the source vertex.
 * 
 * @author Brandon Schmidt
 *
 */
public class GraphMatrix {

  /**
   * mVertices - instance variable to store the array of all vertices in the graph
   * 
   * mEdgeWeights - instance variable to store the edge weights from Vertex to
   * Vertex. The indices in the array match the indices of the Vertex in the
   * vertices array
   */
  private Vertex[] mVertices;
  private int[][] mEdgeWeights;

  /**
   * GraphMatrix Constructor initializes the instance variables with the passed in
   * parameters
   * 
   * @param vertices  - all the vertices from the graph
   * @param distances - the distances between each connected Vertex
   */
  public GraphMatrix(Vertex[] vertices, int[][] distances) {
    // Store the vertices to the mVertices instance variable
    mVertices = new Vertex[vertices.length];
    for (int i = 0; i < vertices.length; i++) {
      mVertices[i] = vertices[i];
    }

    // Store the edge weights (distances) to the mEdgeWeights instance variable
    mEdgeWeights = new int[distances.length][];
    for (int i = 0; i < distances.length; i++) {
      mEdgeWeights[i] = new int[distances[i].length];
      for (int j = 0; j < mEdgeWeights[i].length; j++) {
        mEdgeWeights[i][j] = distances[i][j];
      }
    }
  } // end constructor

  /**
   * Dijkstra method is used to run Dijsktra's Shortest Paths Algorithms. Once the shortest path has
   *   been found for each vertex, the minimum distance from the source vertex to each other vertex
   *   is displayed followed by the shortest paths to follow from the source vertex to the others.
   * 
   * @param sourceIndex - The index of the Vertex we will be using as the source vertex for the shortest paths
   */
  public void Dijkstra(int sourceIndex) {
    Vertex source = mVertices[sourceIndex];   // Set the source vertex using the given index
    Vertex u; // Used to store the vertex with the minimum distance from the source
    int uIndex = -1;
    PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();  // Create PriorityQueue Q
    HashMap<Vertex, Vertex> predecessor = new HashMap<Vertex, Vertex>(); // Create HashMap predecessor

    // For each vertex in mVertices, set its distance to infinity (max integer
    // value) and add it to the PriorityQueue Q
    for (Vertex v : mVertices) {
      v.setDistance(Integer.MAX_VALUE);
      // If the vertex v is the source vertex, set the distance to 0
      if (v.equals(source)) {
        v.setDistance(0);
        source.setDistance(0);
      }
      Q.add(v); // add Vertex v to the PriorityQueue Q
    } // end for each loop

    while (Q.peek() != null) {
      u = Q.poll();   // Since priorityQueue, the minimum element should be listed first
                      // Q.poll should remove and return the head element from Q, which will be
                      // the vertex in Q with the minimum distance

      // Find the index of the Vertex u in the mVertices array (uIndex <- index of u
      // in vertices)
      uIndex = findIndex(u);

      // For each neighbor v of u do:
      // for(int i = 0; i < mEdgeWeights[uIndex].length; i++) {
      for (Vertex v : mVertices) {
        int vIndex = findIndex(v);

        // If v is still in Q and there is an edge from u to v
        if (Q.contains(v) && mEdgeWeights[uIndex][vIndex] > 0) {
          // alt <- dist[u] + length(u, v), the length of the path from the root/source
          // node to the neighbor node v if it were to go through u.
          int alt = u.getDistance() + mEdgeWeights[uIndex][vIndex];

          // If alt's path is shorter than the the current shortest path recorded for v,
          // the current path is replaced with this alt path
          if (alt < v.getDistance()) {
            // minimum distance node should be the head of the queue, so just remove the head
            Q.remove(v);                        
            v.setDistance(alt); // dist[v] <- alt
            Q.add(v);           // add v to Q
            predecessor.put(v, u); // set u to be the predecessor to v                                   
          } // end nested if statement
        } // end if statement
      } // end for loop
    } // end while loop

    // Print out the distance to each vertex from the source vertex
    System.out.println("\nDistances from source Vertex " + source + ":");
    for (Vertex v : mVertices) {
      int distance = v.getDistance();
      // If the vertex is not the source vertex, print off the vertex and it's distance from the source
      // Else, (if it's the source vertex) just print the vertex
      if (distance > 0)
        System.out.println(v + ", " + v.getDistance());
      else
        System.out.println(v);
    }

    // Print out the path from the source to each vertex
    String[] paths = new String[mVertices.length]; // Store the shortest path for each vertex in an Array
    int index = 0;
    String heading = "\nShortest paths from vertex " + source + ":";
    paths[index] = heading;
    String s = "";
  
    // For each vertex with a predecessor, display the shortest path to that vertex
    // from the source index by finding all predecessor(s) for each vertex besides
    // the source vertex.
    for (Vertex key : predecessor.keySet()) {
      //System.out.println("\nFINDING SHORTEST PATH TO VERTEX: " + key);
      s = "";
      Vertex vPreceded = key;
      Vertex uPredecessor = predecessor.get(key);
      Vertex predecessorsPredecessor;
      Vertex thirdPredecessor;
      //System.out.println("Key (preceded): " + vPreceded + " predecessor: " + uPredecessor);

      // If the predecessor is the source, the shortest path has been found - we are done
      if (uPredecessor == source) {
        s = uPredecessor + " -> " + vPreceded + ", " + vPreceded.getDistance();
      } else {
        // Else, keep finding and adding the predecessors predecessor to the shortest
        // path until the source vertex becomes the predecessor, which is when the
        // thirdPredecessor would equal null
        s = uPredecessor + ", " + uPredecessor.getDistance() + " -> " + vPreceded + ", " + vPreceded.getDistance();
        predecessorsPredecessor = predecessor.get(uPredecessor);
        thirdPredecessor = predecessor.get(predecessorsPredecessor);
        //System.out.println(uPredecessor + "'s predecessor: " + predecessorsPredecessor + " with predecessor: " + thirdPredecessor);
        // System.out.println(s);        
        do {
          if (predecessorsPredecessor.equals(source)) {
            // If the next predecessor is the source, do nothing, we have reached the end of
            // the path and the source vertex is added to the path after the do-while loop           
          }
          else {
            s = predecessorsPredecessor + ", " + predecessorsPredecessor.getDistance() + " -> " + s;
            //System.out.println(s);
            predecessorsPredecessor = thirdPredecessor;
            thirdPredecessor = predecessor.get(thirdPredecessor);
            //System.out.println("predecessorsPredecessor: " + predecessorsPredecessor);
            //System.out.println("thirdPredecessor: " + thirdPredecessor);
            //System.out.println("finalKey: " + finalKey);
          }
        } while (!(thirdPredecessor == null));
        
        s = predecessorsPredecessor + " -> " + s; 
      }
      index++;
      paths[index] = s;
    } // end for loop

    // Print the shortest paths stored in the array
    for (String y : paths) {
      System.out.println(y);
    }
  } // end Dijsktra's method

  /**
   * findIndex method finds the index of a given Vertex in the mVertices array
   * 
   * @param v - the Vertex we want to find the index of in the mVertices array
   * @return - the index of Vertex v in the array
   */
  public int findIndex(Vertex v) {
    int index = 0;
    boolean found = false;   // Used to find the index of the vertex with the shortest distance from the
                             // source vertex
    do {
      if (v.equals(mVertices[index])) {
        found = true;
      } else {
        index++;
      }
    } while (index < mVertices.length && found == false);

    return index;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString() toString method neatly formats the output of
   * our graph
   */
  public String toString() {
    String s = "\nAdjacency matrix for graph:\n";

    // For reach Vertex in mVertices, print off that vertex
    for (int i = 0; i < mVertices.length; i++) {
      s += mVertices[i];
      // For each weighted edge from the distances array for the given vertex, print
      // of each connected vertex and its corresponding weight (The two array's
      // indices match, so if we are writing the first Vertex (index 0 in mVertices),
      // we know its corresponding weighted edges are listed in the mEdgeWeights[i]
      // row.
      for (int j = 0; j < mEdgeWeights.length; j++) {
        try {
          if (mVertices[j].equals(mVertices[i])) {
            // do nothing, this is the Vertex we are printing the weights for
          } else {
            s += " -> " + mVertices[j] + ", ";
            s += mEdgeWeights[i][j];
          }
        } catch (Exception e) {

        }
      } // end inside for loop
      s += "\n";
    } // end outside for loop

    return s;
  }

}
