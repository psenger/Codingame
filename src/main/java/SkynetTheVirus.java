import org.graphstream.graph.implementations.SingleGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * <p></p>
 *
 * @author psenger
 * @version 1.0
 * @see
 * @since 12/8/15
 */
public class SkynetTheVirus {
    private static final int INFINITY = 100;

    public static class Graph {
        public Map<Integer, Vertex> vertices = new HashMap<>();
        public void reset() {
            for (Integer key : vertices.keySet()) {
                vertices.get(key).minDistance = INFINITY;
                vertices.get(key).previous = null;
            }
        }
    }

    public static class Vertex implements Comparable<Vertex> {
        public Vertex(Integer id) {
            this.id = id;
        }
        public Integer id = null;
        public Integer minDistance = INFINITY;
        public Vertex previous = null;
        public TreeSet<Vertex> adjacent = new TreeSet<>((o1, o2) -> {
            if (o1.minDistance > o2.minDistance) {
                return 1;
            } else {
                return -1;
            }
        });

        @Override
        public int compareTo(Vertex other) {
            return this.minDistance.compareTo(other.minDistance);
        }
    }

    public static class smVert implements Comparator<Vertex>{
        public int compare(Vertex o1, Vertex o2) {
            if (o1.minDistance > o2.minDistance) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static List<Vertex> dikstra(Graph g, Integer s, Integer e) {

        g.reset();

        Queue<Vertex> unvisited = new PriorityQueue<Vertex>(new smVert());

        Vertex source = g.vertices.get(s);
        source.minDistance = 0;
        source.previous = null;

        //unvisited.addAll( g.vertices.values() );
        unvisited.add( source );

        while (!unvisited.isEmpty()) {
            Vertex currentNode = unvisited.poll();
            unvisited.remove(currentNode);

            System.out.println("currentNode = " + currentNode.id + "   unvisited.size = " + unvisited.size() );

            for (Vertex neighbor : currentNode.adjacent) {

                    System.out.println("  neighbor = " + neighbor.id);
                    System.out.println("    currentNode.minDistance + 1 = " + ( currentNode.minDistance + 1 ) );
                    System.out.println("    neighbor.minDistance = " + neighbor.minDistance);

                    if (currentNode.minDistance + 1 < neighbor.minDistance) {

                        neighbor.minDistance = currentNode.minDistance + 1;
                        neighbor.previous = currentNode;

                        unvisited.add(neighbor);
                    }
            }
        }

        List<Vertex> results = new ArrayList<>();
        Vertex x = g.vertices.get(e);
        while ( x != null ) {
            results.add( x );
            x = x.previous;
        }
        return results;
    }

    public static void main(String args[]) throws FileNotFoundException {
         SingleGraph graph = new SingleGraph("My Graph");
        // FileSinkImages pic = new FileSinkImages(FileSinkImages.OutputType.PNG, FileSinkImages.Resolutions.HD720);
        // pic.setLayoutPolicy(FileSinkImages.LayoutPolicy.COMPUTED_AT_NEW_IMAGE);

        Scanner in = /** new Scanner(System.in); **/ new Scanner(new File("/Users/psenger/Documents/Dev/Codingame/sample/SkynetTheVirus/3.txt"));
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        System.err.println(N + " " + L + " " + E);

        Graph g = new Graph();
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();

            System.err.println(N1 + " " + N2);

            if (!g.vertices.containsKey(N1)) {
                g.vertices.put(N1, new Vertex(N1));
                graph.addNode( String.valueOf(N1) );
            }
            if (!g.vertices.containsKey(N2)) {
                g.vertices.put(N2, new Vertex(N2));
                graph.addNode(String.valueOf(N2));
            }
            g.vertices.get(N1).adjacent.add(g.vertices.get(N2));
            g.vertices.get(N2).adjacent.add(g.vertices.get(N1));

            graph.addEdge(String.valueOf(N1)+String.valueOf(N2), String.valueOf(N1), String.valueOf(N2));

        }

        graph.display();

        List<Integer> EI = new ArrayList<>(); // the index of a gateway node
        for (int i = 0; i < E; i++) {
            int gateway = in.nextInt();
            EI.add(gateway);

            System.err.println(gateway);
        }

        // in.nextLine();
        // System.err.println();

        while (true) {
            int SI = in.nextInt();// in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            System.err.println("Agent moved to >" + SI);
            List<List<Vertex>> paths = new ArrayList<>();

            for (Integer nextGateway : EI) {
                //int SI = in.nextInt();// in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
                //System.err.println(">" + SI);
                List<Vertex> path = dikstra(g, nextGateway, SI);

                String glue = "";
                for (Vertex next : path) {
                    System.err.print(glue + next.id);
                    glue = " - ";
                }
                System.err.println();
                paths.add(path);
                //System.out.println(path.get(0).id + " " + path.get(1).id);
                g.reset();
            }

            Collections.sort(paths, (o1, o2) -> (o1.size()>o2.size())?1:-1);
            List<Vertex> path = paths.get(0);
            System.out.println(path.get(0).id + " " + path.get(1).id);
        }

    }
}