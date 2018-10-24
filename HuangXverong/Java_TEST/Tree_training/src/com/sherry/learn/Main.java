package com.sherry.learn;

import java.io.File;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FreeClass freeClass = new FreeClass();
		File f = new File("C:");
		freeClass.printSysDictByDepth(f, 0);

	}

}
