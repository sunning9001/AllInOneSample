import java.util.List;
import java.util.concurrent.TimeUnit;

import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
//http://docs.grafana.org/features/datasources/influxdb/
public class Sample3 {

	public static void main(String[] args) {
		InfluxDB influxDB = InfluxDBFactory.connect("http://192.168.1.36:8086", "admin", "123456");

		String dbName = "mydb";
		influxDB.createDatabase(dbName);
		influxDB.setDatabase(dbName);
		influxDB.enableBatch(BatchOptions.DEFAULTS);

		Point point = Point.measurement("cpoint")
				 .tag("color", "red")
				.addField("x", 1).addField("y", 2)
				.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
				.build();
		influxDB.write(point);

		Query cpointQuery = new Query("select * from cpoint ", dbName);
		QueryResult queryResult = influxDB.query(cpointQuery);

		System.out.println("tps query CommandWithUrlEncoded result:" + cpointQuery.getCommandWithUrlEncoded());
		System.out.println("tps query Command result:" + cpointQuery.getCommand());
		System.out.println("tps query Database result:" + cpointQuery.getDatabase());

		
		InfluxDBResultMapper resultMapper = new InfluxDBResultMapper(); // thread-safe - can be reused
		List<CPoint> cpuList = resultMapper.toPOJO(queryResult, CPoint.class);
		
		for (CPoint cPoint : cpuList) {
			 System.out.println(cPoint);
		}
		
		influxDB.close();

	}
}
