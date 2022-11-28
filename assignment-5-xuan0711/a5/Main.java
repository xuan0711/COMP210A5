package a5;
import java.util.Iterator;
public class Main {


    public static void main(String[] args) {

        //You are encouraged (but not required) to include your testing code here.

        //Hint: Try to test basic operations (e.g., adding a few nodes and edges to graphs)
        //before you implement more complex methods
        //exTest();
        // test1();
        test2();
        //Test1();
    }
    public static void Test1(){
        Graph d=new GraphImpl();
        d.addNode("a");
        d.addNode("b");
        d.addNode("c");
        d.addNode("d");
        d.addEdge("a", "b", 0);
        d.addEdge("a", "c", 0);
        d.addEdge("a", "d", 0);
        d.addEdge("b", "d", 0);
        d.addEdge("c", "d", 0);
        System.out.println("numEdges: " + d.numEdges());
        System.out.println("numNodes: " + d.numNodes());
        System.out.println(d.topoSort());

    }

    /* public static void exTest() {
         Graph d = new GraphImpl();
         d.addNode("f");
         d.addNode("s");
         d.addNode("t");
         d.addNode("fo");
         d.addNode("fi");
         d.addNode("si");
         d.addEdge("f", "s", 0);
         d.addEdge("f", "si", 0);
         d.addEdge("s", "t", 0);
         d.addEdge("fo", "fi", 0);
         d.addEdge("fi", "si", 0);
         System.out.println("numEdges: " + d.numEdges());
         System.out.println("numNodes: " + d.numNodes());

         d.deleteNode("fi"); //true
         d.deleteNode("si"); //true
         d.deleteNode("jeremy"); //false
         d.deleteEdge("f", "s"); //true
         d.deleteEdge("f", "si"); //false
         d.deleteEdge("s", "t"); // true
         System.out.println("numEdges: " + d.numEdges());
         System.out.println("numNodes: " + d.numNodes());
     }

     public static void test1() {
         System.out.println("start");
         long start = System.currentTimeMillis();
         Graph d = new GraphImpl();
         for (int i = 0; i < 1000000; i++) {
             d.addNode(i + "n");
             d.addEdge(i + "n", i - 1 + "n", i);
         }
         long end = System.currentTimeMillis();
         long elapsedTime = end - start;
         System.out.println(elapsedTime);
         //test shortestpathInfo efficiency
         //ShortestPathInfo[] test = d.shortestPath("999999n");
         //System.out.println("done");
         long end1 = System.currentTimeMillis();
         elapsedTime = end1 - end;
         System.out.println(elapsedTime); // total time in milliseconds
         System.out.println("numNodes: " + d.numNodes());
         System.out.println("numEdges: " + d.numEdges());
     }
 */
    public static void test2() {
        Graph d = new GraphImpl();

            d.addNode("f");
            d.addNode("s");
            d.addNode("t");
            d.addNode("fo");
            d.addNode("fi");
            d.addNode("si");
            //d.addNode("b");
            //d.addNode("a");
            d.addEdge("f", "s", 4);
            d.addEdge("f", "si", 10);
            d.addEdge("s", "t", 6);
            d.addEdge("fo", "fi", 4);
            d.addEdge("fi", "si", 3);
            //d.deleteEdge("fo", "fi");

            System.out.println("numEdges: " + d.numEdges());
            System.out.println("numNodes: " + d.numNodes());
            System.out.println(d.topoSort());


            //;


        /*d.deleteNode("jeremy"); //false
        d.deleteEdge("f", "s"); //true
        d.deleteEdge("f", "si"); //false
        d.deleteEdge("s", "t"); // true
        System.out.println("numEdges: " + d.numEdges());
        System.out.println("numNodes: " + d.numNodes());*/
            //;


    }
}
