package chapters.c5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.compilerError;

public interface IB {

	default int m(){
		System.out.println("IB m");
		return 1;
	}
}
