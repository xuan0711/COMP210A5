package a5;

import java.util.*;

import java.util.Iterator;

public class GraphImpl implements Graph {
    Map<String, Node> nodes; //Do not delete.  Use this field to store your nodes.
    // key: name of node. value: a5.Node object associated with name

    HashSet<Edge> edges;

    public GraphImpl() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

    @Override
    public boolean addNode(String name) {
        if (nodes.containsKey(name) || name == null) {
            return false;
        }
        nodes.put(name, new NodeImpl(name));
        return true;
    }

    @Override
    public boolean addEdge(String src, String dest, double weight) {
        if (weight < 0 || !nodes.containsKey(src) || !nodes.containsKey(dest)) {
            return false;
        }
        if (nodes.containsKey(src) && nodes.containsKey(dest) && nodes.get(src).getOutEdges().containsKey(dest)) {
            return false;
        }
        Edge e = new EdgeImpl(src, dest, weight);
        nodes.get(src).addOutEdge(e);
        nodes.get(dest).addInEdge(e);
        edges.add(e);
        nodes.get(dest).incInDegree();
        return true;
    }

    @Override
    public boolean deleteNode(String name) {
        if (!nodes.containsKey(name)) {
            return false;
        }
        HashMap<String, Edge> relatives = nodes.get(name).getOutEdges();
        for (Map.Entry<String, Edge> entry : relatives.entrySet()) {
            Edge e = entry.getValue();
            deleteEdge(e.getSrc(), e.getDest());
        }
        relatives = nodes.get(name).getInEdges();
        for (Map.Entry<String, Edge> entry : relatives.entrySet()) {
            Edge value = entry.getValue();
            deleteEdge(value.getSrc(), value.getDest());
        }
        nodes.remove(name, nodes.get(name));
        return true;
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        if (!(nodes.containsKey(src) && nodes.get(src).getOutEdges().containsKey(dest))) {
            return false;
        }
        Edge e = nodes.get(src).getOutEdges().get(dest);
        nodes.get(src).removeOutEdge(e);
        nodes.get(dest).removeInEdge(e);
        edges.remove(e);
        nodes.get(dest).devInDegree();
        return true;
    }

    @Override
    public int numNodes() {
        return nodes.size();
    }

    @Override
    public int numEdges() {
        return edges.size();  //Dummy return value.  Remove when you implement!
    }
    /*
    public Stack<String> topoSort(){
        Stack<String> stack = new Stack<String>();
        Set<String> viewed=new HashSet<String>();
        while(viewed.size()< nodes.size()){
            for(Map.Entry<String,Node> mapElement:nodes.entrySet()){
                if(mapElement.getValue().getInDegree()==0&&!viewed.contains(mapElement.getValue().getName())){
                    stack.add(mapElement.getValue().getName());
                    viewed.add(mapElement.getValue().getName());
                    for(Edge e: mapElement.getValue().getEdge()){
                        e.getDest().decInDegree();
                    }
                }
            }
        }
        return stack;
    }

     */

    public Stack<String> topoSort() {
        Stack<String> stack = new Stack<String>();
        List<String> visited= new ArrayList<>();
    while(visited.size()<numNodes()) {
        Node next=null;
        //System.out.println("n");
        for (Node n : nodes.values()) {
            if (!n.isKnown()) {
                if (n.getInDegree()<=0) {
                    next=n;
                    }
                }
            }
        if(next==null){
            return stack;
        }
        System.out.println(next.getName());
        visited.add(next.getName());
        next.setKnown(true);
        stack.push(next.getName());
        //deleteNode(next.getName());
        for (Edge e : next.getOutEdges().values()) {
            nodes.get(e.getDest()).devInDegree();
        }
    }
        return stack;

    }

}
    /*
    public Stack<String> topoSort() {
        Stack<String> stack = new Stack<String>();
        Iterator<Node> n=nodes.values().iterator();
        while (n.hasNext()) {
            Node first = n.next();
            //System.out.println(first.getInEdges().isEmpty());
            if (!first.isKnown() && first.getInEdges().isEmpty()) {
                stack.push(first.getName());
                first.setKnown(true);
                n.remove();
                nodes.remove(first.getName());
                Iterator<Edge> e = first.getOutEdges().values().iterator();
                while (e.hasNext()) {
                    //e.next();
                    Edge one = e.next();
                    if (edges.contains(one)) {
                        edges.remove(one);
                        e.remove();
                    }
                }
            }
        }

        System.out.println(nodes.isEmpty());
        System.out.println(numEdges());
        System.out.println(numNodes());
        return stack;
    }
*/
    /*
    public Stack<String> topoSort() {
        Stack<String> stack = new Stack<String>();
        Iterator<Node> n=nodes.values().iterator();
        while (n.hasNext()) {
            Node first = n.next();
            //System.out.println(first.getInEdges().isEmpty());
            if (!first.isKnown() && first.getInEdges().isEmpty()) {
                stack.push(first.getName());
                first.setKnown(true);
                n.remove();
                nodes.remove(first.getName());
                Iterator<Edge> e = first.getOutEdges().values().iterator();
                while (e.hasNext()) {
                    //e.next();
                    Edge one = e.next();
                    if (edges.contains(one)) {
                        edges.remove(one);
                        e.remove();
                    }
                }
            }
        }

        System.out.println(nodes.isEmpty());
        System.out.println(numEdges());
        System.out.println(numNodes());
        return stack;
    }

}
*/

/*

 */

    /*
public Stack<String> topoSort() {

    Stack<String> stack = new Stack<>();
    Set<String> sta = new HashSet<>();

    for(Edge curr : edges) {
        String fir = curr.getSrc();
        int i = 0;
        for (Edge a : edges) {
            if(fir.equals(a.getDest())){
                i = 1;
            }
        }
        if(i == 0) {
            sta.add(fir);
        }
        for(Node cur : nodes.values()) {
            if(fir.equals(cur.getName())) {
                cur.setKnown(true);
            }
        }
    }

    for(String s : sta) {
        stack.push(s);
    }

    Set<String> stb = new HashSet<>();

    for(Edge curr : edges) {
        if(sta.contains(curr.getSrc())) {
            sta.add(curr.getDest());
            stb.add(curr.getDest());
        }
    }

    for(String st : stb) {
        stack.push(st);
    }

    return stack;
}
*/




/*
    public Stack<String> topoSort() {
        Stack<String> stack = new Stack<String>();
        for (Node j : nodes.values()) {
            if (!j.isKnown()) {
                if (j.getInEdges().isEmpty()) {
                    stack.push(j.getName());
                    //nodes.remove(j.getName());
                    j.setKnown(true);
                    Collection<Edge> e = j.getOutEdges().values();
                    while (e.iterator().hasNext()) {
                        Edge first = e.iterator().next();
                        deleteEdge(first.getSrc(), first.getDest());
                    }
                    //deleteNode(j.getName());

                }
            }
        }
        return stack;
    }
*/


/*
    public Stack<String> topoSort() {
        Stack<String> stack = new Stack<>();
        Iterator<Node> n = nodes.values().iterator();
        for (int i = 0; i < numNodes(); i++) {
            while(n.hasNext()) {
                Node first = n.next();
                if (!first.isKnown() && first.getInEdges().isEmpty()) {
                    stack.push(first.getName());
                    n.remove();
                    nodes.remove(first.getName());
                    Iterator<Edge> e = first.getOutEdges().values().iterator();
                    while (e.hasNext()) {
                        //e.next();
                        Edge one = e.next();
                        if (edges.contains(one)) {
                            edges.remove(one);
                            e.remove();
                        }
                    }
                }
            }
        }
        return stack;

 */

/*
    public Stack<String> topoSort() {
        Stack<String> stack = new Stack<>();
        Iterator<Node> n = nodes.values().iterator();
        while (n.hasNext()) {
            Node fst = n.next();
            if (!fst.isKnown() && fst.getInEdges().isEmpty()) {
                stack.push(fst.getName());
                fst.setKnown(true);
                n.remove();
                //deleteNode(fst.getName());
                Iterator<Edge> e = fst.getOutEdges().values().iterator();
                while (e.hasNext()) {
                    Edge first = e.next();
                    if (first.getDest()!=null) {
                        //e.next();
                        //Edge first =e.next();
                        //deleteEdge(first.getSrc(), first.getDest());
                        e.remove();

                    }

                }
            }
        }
            return stack;
        }
*/



