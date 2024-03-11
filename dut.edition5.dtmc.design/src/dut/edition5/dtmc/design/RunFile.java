package dut.edition5.dtmc.design;

import java.io.File;

import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.emc.emf.EmfModel;

public class RunFile {
	public static void main(String[] args) throws Exception {
		EgxModule module = new EgxModule(new EglFileGeneratingTemplateFactory());
		module.parse(new File("E:\\Dtmc\\Edition5-runtime-EclipseApplication\\dut.edition5.dtmc.design\\model\\dtmc2pm.egx").getAbsoluteFile());		
		if (!module.getParseProblems().isEmpty()) {
			System.out.println("Syntax errors found. Exiting.");
			return;
		}		
		// Load the EMF document
		EmfModel model = new EmfModel();
		model.setModelFile("E:\\Dtmc\\Edition5-runtime-EclipseApplication\\runtime-New_Configuration\\DistanDTMC\\Distance.dtmc");
		model.setName("mc");		
		model.setMetamodelFile("E:\\Dtmc\\Edition5\\dut.edition5.dtmc\\dtmc.ecore");
		model.load();	
		// Make the document visible to the EGX program
		module.getContext().getModelRepository().addModel(model);
		// ... and execute
		module.execute();
	}
}
