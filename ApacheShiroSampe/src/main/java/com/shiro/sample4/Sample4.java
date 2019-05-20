/**
@CreateTime: sunning2018年10月23日
@CreateUser: sunning 
@Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
*/

 package com.shiro.sample4;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;

/**
 * @author sunning
 * @date 2018/10/23
 */
public class Sample4 {

    public static void main(String[] args) {
        

        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        //设置authenticator
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        securityManager.setAuthenticator(authenticator);

        //设置authorizer
        ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
        authorizer.setPermissionResolver(new WildcardPermissionResolver());
        securityManager.setAuthorizer(authorizer);
        
        //设置cache
        MemoryConstrainedCacheManager memory =new MemoryConstrainedCacheManager();
        securityManager.setCacheManager(memory);

        //设置Realm
        securityManager.setRealms(Arrays.asList((Realm)new MyRealm4() ));

        //将SecurityManager设置到SecurityUtils 方便全局使用
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        try {
            UsernamePasswordToken token = new UsernamePasswordToken("sunning", "qingqing");
            subject.login(token);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(subject.isAuthenticated());


    }
}
