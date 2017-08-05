package MapDbSample;

import java.util.concurrent.ConcurrentMap;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import com.alibaba.fastjson.JSONObject;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		DB db = DBMaker
		        .fileDB("file.db")
		        .fileMmapEnable()
		        .make();
		ConcurrentMap<String,String> map = db
		        .hashMap("map", Serializer.STRING, Serializer.STRING)
		        .createOrOpen();
		
		
	/*	PriceIndex pi =new PriceIndex();
		pi.setContract("11111111111");

		map.put("something",  JSONObject.toJSONString(pi));
		
		pi.setContract("2222222222");
		map.put("something",  JSONObject.toJSONString(pi));
*/
		
		
		System.out.println(	JSONObject.parseObject(map.get("something"), PriceIndex.class));
		db.close();
	}
}
