package com.gopivotal.soleng.examples.springannotation;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={EnableExampleConfiguration.class})
public class EnableExampleTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void checkAnnotationHasLoadedBean() {
        assertTrue(context.containsBean("exampleParser"));

        ExampleParser bean = context.getBean("exampleParser", ExampleParser.class);
        assertNotNull(bean);

        bean.parse("foo");
    }

}
