package aopasmsample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class SecurityProxyInvocationHandler implements InvocationHandler { 
    private Object proxyedObject; 
    public SecurityProxyInvocationHandler(Object o) { 
        proxyedObject = o; 
    } 
        
    public Object invoke(Object object, Method method, Object[] arguments) 
        throws Throwable {             
        SecurityChecker.checkSecurity(); 
        return method.invoke(proxyedObject, arguments); 
    } 
    
    public static void main(String[] args) { 
        Account account = (Account) Proxy.newProxyInstance( 
            Account.class.getClassLoader(), 
            new Class[] { Account.class }, 
            new SecurityProxyInvocationHandler(new AccountImpl()) 
        ); 
        account.operation();
    }
}