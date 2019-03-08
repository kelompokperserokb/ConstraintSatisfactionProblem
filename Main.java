import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static Main main;
    public static Graph graph;
    public static CSPProblem cspSolving = new CSPProblem();
    public static Variable root;
    static List<Variable> var = new ArrayList<>();

    public static void main(String[] args)
    {
        main = new Main();
        main.Initialize();
        cspSolving.startCSP(root);
        main.print();
    }

    public void Initialize(){
        graph = new Graph();
        String r = "MERAH";
        String g = "HIJAU";
        String b = "BIRU";

        /**0*/ Variable A = graph.setVariable("Aceh",new Domain(new String[]{r,g,b}));
        /**1*/ Variable SU = graph.setVariable("Sumatera Utara",new Domain(new String[]{r,g,b}));
        /**2*/ Variable R = graph.setVariable("Riau",new Domain(new String[]{r,g,b}));
        /**3*/ Variable SB = graph.setVariable("Sumatera Barat",new Domain(new String[]{r,g,b}));
        /**4*/ Variable J = graph.setVariable("Jambi",new Domain(new String[]{r,g,b}));
        /**5*/ Variable B = graph.setVariable("Bengkulu",new Domain(new String[]{r,g,b}));
        /**6*/ Variable SS = graph.setVariable("Sumatera Selatan",new Domain(new String[]{r,g,b}));
        /**7*/ Variable L = graph.setVariable("Lampung",new Domain(new String[]{r,g,b}));

        var.add(A);
        var.add(SU);
        var.add(R);
        var.add(SB);
        var.add(J);
        var.add(B);
        var.add(SS);
        var.add(L);

        root = A; //For initialize root of CSP

        boolean[][] adjacent = {
                {false,true,false,false,false,false,false,false},
                {true,false,true,true,false,false,false,false},
                {false,true,false,true,true,false,false,false},
                {false,true,true,false,true,true,false,false},
                {false,false,true,true,false,true,true,false},
                {false,false,false,true,true,false,true,false},
                {false,false,false,false,true,true,false,true},
                {false,false,false,false,false,false,true,false},
        }; //For connecting node (Adjacency Matrix)

        graph.setAdjacent(adjacent);
    }

    boolean foundSolution(){
        for (Variable node:var) {
            if (node.color == null) return false;
        }
        return true;
    }

    public void print(){
        if (foundSolution()) {
            for (Variable node:var) {
                System.out.println("Kota "+node.name+" berwarna "+node.color);
            }
        } else {
            System.out.println("Tidak ditemukan solusi");
        }
    }
}
