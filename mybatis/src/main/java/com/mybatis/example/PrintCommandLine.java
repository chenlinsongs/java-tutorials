package com.mybatis.example;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

public class PrintCommandLine {

    public static void main(String[] args) {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        List<String> jvmArgs = bean.getInputArguments();

        for (int i = 0; i < jvmArgs.size(); i++) {
            System.out.println( jvmArgs.get( i ) );
        }
        System.out.println(" -classpath " + System.getProperty("java.class.path"));
        // print the non-JVM command line arguments
        // print name of the main class with its arguments, like org.ClassName param1 param2
        System.out.println(" " + System.getProperty("sun.java.command"));
    }
}
