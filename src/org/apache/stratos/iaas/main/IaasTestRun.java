package org.apache.stratos.iaas.main;

import java.io.File;

import org.apache.stratos.iaas.shell.CommandLineExecutor;

public class IaasTestRun {

	public static void main(String[] args) {

		int size = System.getProperties().size()+2;
		String[] envs = new String[size];
		envs[0] = "VAGRANT_CWD=/Volumes/personal/stratos-iaas/src/main/resources";
		envs[1] = "VAGRANT_LOG=info";
		int i=2;
		for (Object obj : System.getProperties().keySet()) {
			String key = (String) obj;
			envs[i] = key+"="+System.getProperty(key);
			i++;
		}
		
		File dir = new File("/Volumes/personal/stratos-iaas/src/main/resources");
		String command = "vagrant up --provision --machine-readable";
		
//		String command = "; vagrant up --machine-readable";
		System.out.println(CommandLineExecutor.executeCommand(command, dir));
	}

}
