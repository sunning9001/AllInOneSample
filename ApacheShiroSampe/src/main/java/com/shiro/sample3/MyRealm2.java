/**
 * @CreateTime: sunning2018年10月23日
 * @CreateUser: sunning
 * @Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
 */

package com.shiro.sample3;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * @author sunning
 * @date 2018/10/23
 */
public class MyRealm2 implements Realm {
  

  
  
    public String getName() {
        // TODO Auto-generated method stub
         return "myrealm2";
    }


    /* (non-Javadoc)
     * @see org.apache.shiro.realm.Realm#getAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
     */
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        String username = (String)token.getPrincipal(); // 得到用户名
        String password = new String((char[])token.getCredentials()); // 得到密码
        if (!"sunning".equals(username)) {
            throw new UnknownAccountException(); // 如果用户名错误
        }
        if (!"qingqing".equals(password)) {
            throw new IncorrectCredentialsException(); // 如果密码错误
        }
        // 如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    
    }


    /* (non-Javadoc)
     * @see org.apache.shiro.realm.Realm#supports(org.apache.shiro.authc.AuthenticationToken)
     */
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken; // 仅支持UsernamePasswordToken类型的Token
    }

}