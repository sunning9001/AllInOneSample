import java.util.concurrent.TimeUnit;

import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
//http://docs.grafana.org/features/datasources/influxdb/
public class Sample4 {

	public static void main(String[] args) {
		InfluxDB influxDB = InfluxDBFactory.connect("http://192.168.1.36:8086", "admin", "123456");

		String dbName = "mydb";
		influxDB.createDatabase(dbName);
		influxDB.setDatabase(dbName);
		influxDB.enableBatch(BatchOptions.DEFAULTS);

		
		for (int i = 0; i < 100000; i++) {
			
			Point point = Point.measurement("cpoin111t")
					.tag("color", "red")
					.addField("x",i ).addField("y", i+1000)
					.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
					.build();
			influxDB.write(point);
			
			try {
				Thread.sleep(300);
				System.out.println(" i -->>" + i );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		influxDB.close();

	}
}
