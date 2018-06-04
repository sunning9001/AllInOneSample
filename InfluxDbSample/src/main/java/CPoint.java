import java.time.Instant;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

@Measurement(name = "cpoint")
public class CPoint {
	@Column(name = "x")
	private int x = 0;
	@Column(name = "x")
	private int y = 0;
	@Column(name = "color", tag = true)
	private String color = "";
	@Column(name = "time")
	private Instant time;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CPoint [x=" + x + ", y=" + y + ", color=" + color + ", time=" + time + "]";
	}

}