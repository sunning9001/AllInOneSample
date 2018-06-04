import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.dto.QueryResult.Result;

public class Sample2 {

	public static void main(String[] args) {
		InfluxDB influxDB = InfluxDBFactory.connect("http://192.168.1.36:8086", "admin", "123456");

		String dbName = "mydb";
		influxDB.createDatabase(dbName);
		influxDB.setDatabase(dbName);
		influxDB.enableBatch(BatchOptions.DEFAULTS);

		Point point = Point.measurement("tps").tag("application", "customer").tag("openday", "20180518")
				.addField("select", 22).addField("get", 22).time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
				.build();
		influxDB.write(point);

		Query tpsQuery = new Query("select * from tps ", dbName);
		influxDB.query(tpsQuery);

		System.out.println("tps query CommandWithUrlEncoded result:" + tpsQuery.getCommandWithUrlEncoded());
		System.out.println("tps query Command result:" + tpsQuery.getCommand());
		System.out.println("tps query Database result:" + tpsQuery.getDatabase());

		influxDB.query(tpsQuery, new Consumer<QueryResult>() {

			@Override
			public void accept(QueryResult t) {
				List<Result> rList = t.getResults();
				for (Result r : rList) {
                       System.out.println("result : " + r);
				}
			}
		}, new Consumer<Throwable>() {

			@Override
			public void accept(Throwable t) {
				System.out.println("Throwable : " + t.getMessage());

			}
		});
		influxDB.close();

	}
}
