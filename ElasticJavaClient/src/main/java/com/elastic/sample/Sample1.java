/**
 * @CreateTime: sunning2019年2月27日
 * @CreateUser: sunning
 * @Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
 */

package com.elastic.sample;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.common.Strings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

/**
 * @author sunning
 * @date 2019/02/27
 */
public class Sample1 {

    public static void main(String[] args) throws IOException {
        
        
        //indexTest();
        
       //getTest();
        searchTest();
    }
    
    public static void searchTest() throws IOException {
        

        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
            .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
        
        SearchResponse response = client.prepareSearch("twitter")
            .setQuery(QueryBuilders.matchQuery("user", "kimchy"))   
            .get();
        
        System.out.println("SearchResponse  ->"+response  );
    }
    public static void getTest() throws UnknownHostException {
        

        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
            .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

        GetResponse response = client.prepareGet("twitter", "_doc", "zHqrLmkBnf6XViWT64Tx").get();
        
        System.out.println("GetResponse ->" + response);
    }
    

    public static void indexTest() throws IOException {

        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
            .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

        XContentBuilder builder = XContentFactory.jsonBuilder()
            .startObject()
                .field("user", "kimchy")
                .field("postDate", new Date())
                .field("message", "trying out Elasticsearch")
            .endObject();

        String json = Strings.toString(builder);

        IndexResponse response = client.prepareIndex("twitter", "_doc").setSource(json, XContentType.JSON).get();

        
        System.out.println(" IndexResponse : --->" + response);
        // Index name
        String _index = response.getIndex();
        // Type name
        String _type = response.getType();
        // Document ID (generated or not)
        String _id = response.getId();
        // Version (if it's the first time you index this document, you will get: 1)
        long _version = response.getVersion();
        // status has stored current instance statement.
        RestStatus status = response.status();

    }
}
