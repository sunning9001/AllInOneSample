/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * Main.java - main class for QueueSampler example. Create the Queue Sampler
 * MXBean, register it, then wait forever (or until the program is interrupted).
 */

package descriptors;

import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import javax.management.MBeanServer;
import javax.management.ObjectName;
//Descriptors allow you to give additional information about MBeans to management clients. 
///For example, a Descriptor on an MBean attribute might say what units it is measured in, or what its minimum and maximum possible values are.
//As of Java SE 6, Descriptors are an integrated part of the JMX API and are available in all types of MBeans.
public class Main {
    /* For simplicity, we declare "throws Exception".  Real programs
       will usually want finer-grained exception handling.  */
    public static void main(String[] args) throws Exception {
        // Get the Platform MBean Server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // Construct the ObjectName for the MBean we will register
        ObjectName name =
                new ObjectName("com.example.mxbeans:type=QueueSampler");

        // Create the Queue Sampler MXBean
        Queue<String> queue = new ArrayBlockingQueue<String>(10);
        queue.add("Request-1");
        queue.add("Request-2");
        queue.add("Request-3");
        QueueSampler mxbean = new QueueSampler(queue);

        // Register the Queue Sampler MXBean
        mbs.registerMBean(mxbean, name);

        // Wait forever
        System.out.println("Waiting...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
