import java.util.Scanner;


class AlphaNeuralNetwork {
    private int numLayers;
    private int[] numNodes;
    private double[][][] weights;

    
    public AlphaNeuralNetwork(int numLayers, int[] numNodes) {
        this.numLayers = numLayers;
        this.numNodes = numNodes;
        this.weights = new double[numLayers - 1][][];
    }

    
    public void alphaSetWeights() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numLayers - 1; i++) {
            weights[i] = new double[numNodes[i]][numNodes[i + 1]];
            System.out.println("Enter weights for edges between layer " + i + " and layer " + (i + 1) + ":");
            for (int j = 0; j < numNodes[i]; j++) {
                for (int k = 0; k < numNodes[i + 1]; k++) {
                    System.out.print("Weight for edge (" + j + "," + k + "): ");
                    weights[i][j][k] = scanner.nextDouble();
                }
            }
        }
    }

    
    public double alphaGetWeight(int fromNode, int toNode, int layer) {
        return weights[layer][fromNode][toNode];
    }
}

public class AlphaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of layers in the neural network: ");
        int alphaNumLayers = scanner.nextInt();

        int[] alphaNumNodes = new int[alphaNumLayers];
        for (int i = 0; i < alphaNumLayers; i++) {
            System.out.print("Enter the number of nodes in layer " + i + ": ");
            alphaNumNodes[i] = scanner.nextInt();
        }

        AlphaNeuralNetwork alphaNeuralNetwork = new AlphaNeuralNetwork(alphaNumLayers, alphaNumNodes);
        alphaNeuralNetwork.alphaSetWeights();

        
        System.out.print("Enter the layer number where the edge is present: ");
        int alphaLayer = scanner.nextInt();
        System.out.print("Enter the from node number: ");
        int alphaFromNode = scanner.nextInt();
        System.out.print("Enter the to node number: ");
        int alphaToNode = scanner.nextInt();
        System.out.println("Weight of edge (" + alphaFromNode + "," + alphaToNode + ") in layer " + alphaLayer + ": " +
                alphaNeuralNetwork.alphaGetWeight(alphaFromNode, alphaToNode, alphaLayer));
    }
}
