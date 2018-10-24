package com.sherry.learn;

import java.io.File;

public class FreeClass {
	void printSysDictByDepth(File file,int depth) {
		if (file.isDirectory()) {
			File fileList[] = file.listFiles();
			if (fileList != null) {
				depth += 1;
				for(File f : fileList) {
					printSysDictByDepth(f, depth);
				}
			}
		}
		else {
			System.out.print(file.getName().substring(0,2)+"  ");
		}
	}
}
