package JolokiaSample;
/*
 *
 * Copyright 2016 Roland Huss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author roland
 * @since 08/08/16
 */
public class Application {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting up Spring sample application");
        
        // Get the Platform MBean Server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

       
        // Construct the ObjectName for the MBean we will register
        ObjectName name = new ObjectName("JolokiaSample:type=Hello");

        // Create the Hello World MBean
        Hello mbean = new Hello();
        mbean.setName("sunning");

        // Register the Hello World MBean
        mbs.registerMBean(mbean, name);
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        synchronized (ctx) {
            ctx.wait();
        }
    }
}
