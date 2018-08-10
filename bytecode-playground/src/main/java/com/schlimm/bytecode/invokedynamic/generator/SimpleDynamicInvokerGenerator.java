package com.schlimm.bytecode.invokedynamic.generator;

import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.schlimm.bytecode.invokedynamic.linkageclasses.SimpleDynamicLinkageExample;
import org.objectweb.asm.MethodVisitor;

import com.schlimm.bytecode.invokedynamic.AbstractDynamicInvokerGenerator;

/**
 * Run this class and generate file target/classes/com/schlimm/bytecode/SimpleDynamicInvoker.class
 * Note target/classes/com/schlimm/bytecode/invokedynamic/linkageclasses/SimpleDynamicLinkageExample.class must exist after build this maven project
 * Then run class SimpleDynamicInvoker using
 * java -cp target/classes com.schlimm.bytecode.SimpleDynamicInvoker
 */
public class SimpleDynamicInvokerGenerator extends AbstractDynamicInvokerGenerator {

	@Override
	protected int addMethodParameters(MethodVisitor mv) {
		return 0;
	}

	public static void main(String[] args) throws IOException, Exception {
		String dynamicInvokerClassName = "com/schlimm/bytecode/SimpleDynamicInvoker";
		File file = new File("target/classes/" + dynamicInvokerClassName + ".class");
		FileOutputStream fos = new FileOutputStream(file);
		System.out.println(file.getAbsoluteFile());
		fos.write(new SimpleDynamicInvokerGenerator().dump(dynamicInvokerClassName,
				"com/schlimm/bytecode/invokedynamic/linkageclasses/SimpleDynamicLinkageExample",
				SimpleDynamicLinkageExample.BootstrapDynamicName, "()V"));
	}
	
}
