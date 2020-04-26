/**
 * 
 */
package dijkstrasalgorithm;

/**
 * Vertex class is used to create Vertex objects that will be used to create and traverse graphs
 * 
 * @author Brandon Schmidt
 *
 */
public class Vertex implements Comparable<Vertex>{

  /**
   * WHITE, GREEN, and BLACK are constant color variables used for BFS search
   * algorithm
   */
  public static final int WHITE = 1;
  public static final int GREEN = 2;
  public static final int BLACK = 3;

  /**
   * mName variable is used to store the name of a Vertex 
   * mColor variable is used to store the current color of a Vertex 
   * mVisited variable is used to store if the vertex has been visited yet or not
   * mDistance variable is used to store the distance from the source node in Dijkstra's algorithm
   */
  private String mName;
  private int mColor;
  private boolean mVisited;
  private int mDistance;

  /**
   * Vertex constructor to set the Vertex's mName, mColor, and mVisited
   * 
   * @param name - the name to be given to the new vertex
   */
  public Vertex(String name) {
    this.mName = name;
    mColor = 0;
    mVisited = false;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   * Compare the distance of 2 vertices and return -1 if the calling vertex is closer or 1 if calling vertex is farther
   */
  @Override
  public int compareTo(Vertex o) {
    int value = 0;
    if(this.mDistance < o.getDistance()) {
      value = -1;
    }
    else if (this.mDistance > o.getDistance()) {
      value = 1;
    }
    return value;
  }
  
  // getter and setter methods
  public int getDistance() {
    return this.mDistance;
  }
  
  public void setDistance(int distance) {
    this.mDistance = distance;
  }
  public String getName() {
    return this.mName;
  }

  public int getColor() {
    return this.mColor;
  }

  public void setColor(int color) {
    this.mColor = color;
  }

  public void setVisited(boolean visited) {
    this.mVisited = visited;
  }

  /**
   * isVisited method checks if a given node has been visited yet
   * 
   * @return true if the node has been visited, false otherwise
   */
  public boolean isVisited() {
    return mVisited;
  }

  public String toString() {
    return mName;
  }
}
