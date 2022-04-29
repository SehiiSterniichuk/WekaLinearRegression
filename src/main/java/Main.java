import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "DataSetFunction3.arff";
        Classification classification = new Classification(fileName);
        int numberOfInstances = classification.numberOfInstances;
        System.out.print("Enter number for classification: ");
        int numberForClassification = (new Scanner(System.in)).nextInt();
        for(int i = numberOfInstances - 1; i > numberOfInstances - numberForClassification - 1 ; i--){
            System.out.println("Classification of class with index: " + i);
            classification.classifyInstance(i);
        }
    }
}
