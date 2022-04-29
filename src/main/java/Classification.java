import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class Classification {
    private final Instances data;
    public final int numberOfInstances;
    private final LinearRegression model;
    public Classification(String fileName) throws Exception {
        ConverterUtils.DataSource source = new ConverterUtils.DataSource(fileName);
        data = source.getDataSet();
        numberOfInstances = data.size();
        System.out.println(data.numInstances() + " instances loaded.");
        int classIndex = data.numAttributes() - 1;
        data.setClassIndex(classIndex);
        model = new LinearRegression();
        model.buildClassifier(data);
        System.out.println(model);
    }

    public void classifyInstance(int indexOfInstance) throws Exception {
        Instance instance = data.instance(indexOfInstance);
        double result = model.classifyInstance(instance);
        System.out.println("Classification:\n" +
                "Instance -  (" + instance + "): \n" +
                "current result: " + result + "\n" +
                "expected result: " + instance.classValue() + "\n");
    }
}
