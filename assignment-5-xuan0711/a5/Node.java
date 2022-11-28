package a5;

import java.util.HashMap;

import java.util.HashMap;
import java.util.List;

public interface Node extends Comparable<Node> {

     /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

     /**
      * @return the name of the node
      */
     String getName();

     public HashMap<String, Edge> getInEdges();

     public HashMap<String, Edge> getOutEdges();

     public void addInEdge(Edge inEdge);

     public void removeInEdge(Edge inEdge);

     public void addOutEdge(Edge outEdge);

     public void removeOutEdge(Edge outEdge);
     public List<Edge> getEdge();
     public boolean isKnown();

     public void setKnown(boolean known);
     public void incInDegree ();
     public void devInDegree();
     int getInDegree();

     Node getPn();

     void setPn(Node pn);

     double getDv();

     void setDv(double dv);

     int compareTo(Node n);
}