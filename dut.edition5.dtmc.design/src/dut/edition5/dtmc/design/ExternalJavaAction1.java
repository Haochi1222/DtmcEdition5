package dut.edition5.dtmc.design;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

public class ExternalJavaAction1 implements IExternalJavaAction {

	public ExternalJavaAction1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		EgxModule module = new EgxModule(new EglFileGeneratingTemplateFactory());
		try {
			module.parse(new File("E:\\Dtmc\\Edition5-runtime-EclipseApplication\\dut.edition5.dtmc.design\\model\\dtmc2pm.egx").getAbsoluteFile());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		if (!module.getParseProblems().isEmpty()) {
			System.out.println("Syntax errors found. Exiting.");
			return;
		}		
		// Load the EMF document
		EmfModel model = new EmfModel();
		model.setModelFile("E:\\Dtmc\\Edition5-runtime-EclipseApplication\\runtime-New_Configuration\\DistanDTMC\\Distance.dtmc");
		model.setName("mc");		
		model.setMetamodelFile("E:\\Dtmc\\Edition5\\dut.edition5.dtmc\\dtmc.ecore");
		try {
			model.load();
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		// Make the document visible to the EGX program
		module.getContext().getModelRepository().addModel(model);
		// ... and execute
		try {
			module.execute();
		} catch (EolRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String str = GetPath
		Test test = new Test();
		System.out.println("Transform successfully!");
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		// TODO Auto-generated method stub
		return true;
	}

}