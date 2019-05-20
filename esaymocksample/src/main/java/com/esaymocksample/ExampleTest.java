/**
 * @CreateTime: sunning2018年9月13日
 * @CreateUser: sunning
 * @Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
 */

package com.esaymocksample;

import static org.easymock.EasyMock.*;
import org.easymock.*;
import org.junit.*;

/**
 * @author sunning
 * @date 2018/09/13
 */
public class ExampleTest extends EasyMockSupport {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private Collaborator collaborator; // 1

    @TestSubject
    private ClassTested classUnderTest = new ClassTested(); // 2

    @Test
    public void addDocument() {
        collaborator.documentAdded("New Document"); // 3
        replayAll(); // 4
        classUnderTest.addDocument("New Document", "content"); // 5
        verifyAll(); // 6
    }

}
