/**
@CreateTime: sunning2018年9月13日
@CreateUser: sunning 
@Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
*/

 package com.esaymocksample;

 /**
 * @author sunning
 * @date 2018/09/13
 */
 public interface Collaborator {
     void documentAdded(String title);

     void documentChanged(String title);

     void documentRemoved(String title);

     byte voteForRemoval(String title);

     byte voteForRemovals(String... titles);
 }