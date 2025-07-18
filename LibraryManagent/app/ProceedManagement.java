package org.LibraryManagent.app;

public class ProceedManagement {

	public static LibraryManagement getObject() {
		LibraryManagement lb1=new ImplementLibraryManagement();
		return lb1;
	}

}
