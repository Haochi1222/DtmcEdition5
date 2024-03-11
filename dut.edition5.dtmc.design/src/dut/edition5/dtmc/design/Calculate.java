package dut.edition5.dtmc.design;

import java.io.File;
import java.io.FileNotFoundException;

import parser.ast.ModulesFile;
import parser.ast.PropertiesFile;
import prism.Prism;
import prism.PrismDevNullLog;
import prism.PrismException;
import prism.PrismLog;
import prism.Result;

public class Calculate {
	public static void main(String[] args)
    {
        new Calculate().run();
    }

    public void run()
    {
        try {
            // Create a log for PRISM output (hidden or stdout)
        	PrismLog mainLog = new PrismDevNullLog();
            //PrismLog mainLog = new PrismFileLog("stdout");

            // Initialise PRISM engine
            Prism prism = new Prism(mainLog);
            prism.initialise();

            // Parse and load a PRISM model from a file
            ModulesFile modulesFile = prism.parseModelFile(new File("E:\\Dtmc\\Edition5-runtime-EclipseApplication\\dut.edition5.dtmc.design\\model\\dtmc2.pm"));
            prism.loadPRISMModel(modulesFile);

            // Parse and load a properties model for the model
            PropertiesFile propertiesFile = prism.parsePropertiesFile(modulesFile, new File("E:\\\\Dtmc\\\\Edition5-runtime-EclipseApplication\\\\dut.edition5.dtmc.design\\\\model\\Distance_props.pctl"));

            // Model check the first property from the file


            for(int i = 0;i<propertiesFile.getNumProperties();i++){
                System.out.println(propertiesFile.getPropertyObject(i));
                Result result = prism.modelCheck(propertiesFile, propertiesFile.getPropertyObject(i));
                System.out.println(result.getResult());

            }
          //  Result result = prism.modelCheck(propertiesFile, propertiesFile.getPropertyObject(0));
            // Close down PRISM
            //  prism.closeDown();

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        } catch (PrismException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
