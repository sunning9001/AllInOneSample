package com.netflix.ribbon.examples.loadbalancer;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.netflix.client.DefaultLoadBalancerRetryHandler;
import com.netflix.client.RetryHandler;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.LoadBalancerStats;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerStats;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;

import rx.Observable;

/**
 *
 * @author Allen Wang
 *
 */
public class URLConnectionLoadBalancer {
   
    private final ILoadBalancer loadBalancer;
    // retry handler that does not retry on same server, but on a different server
    private final RetryHandler retryHandler = new DefaultLoadBalancerRetryHandler(0, 1, true);
    
    public URLConnectionLoadBalancer(List<Server> serverList) {
        loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(serverList);
    }
    
    public String call(final String path) throws Exception {
        return LoadBalancerCommand.<String>builder()
                .withLoadBalancer(loadBalancer)
                .build()
                .submit(new ServerOperation<String>() {
            @Override
            public Observable<String> call(Server server) {
                URL url;
                try {
                    url = new URL("http://" + server.getHost() + ":" + server.getPort() + path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    return Observable.just(conn.getResponseMessage());
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }
        }).toBlocking().first();
    }
    
    public LoadBalancerStats getLoadBalancerStats() {
        return ((BaseLoadBalancer) loadBalancer).getLoadBalancerStats();
    }

    public static void main(String[] args) throws Exception {
        URLConnectionLoadBalancer urlLoadBalancer = new URLConnectionLoadBalancer(Lists.newArrayList(
                new Server("www.jd.com", 80),
                new Server("www.baidu.com", 80),
                new Server("www.autohome.com.cn", 80)));
        for (int i = 0; i < 60; i++) {
            System.out.println(urlLoadBalancer.call("/"));
        }
        System.out.println("=== Load balancer stats ===");
       Map<Server, ServerStats> map = urlLoadBalancer.getLoadBalancerStats().getServerStats();
       for(Map.Entry<Server, ServerStats> e:map.entrySet()){
    	   System.out.println(">>>>>>>> Server" +e.getKey()+ " >>>>>>" + e.getValue());
       }
    }
}
