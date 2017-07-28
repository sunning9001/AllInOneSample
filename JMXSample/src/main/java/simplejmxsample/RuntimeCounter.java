package simplejmxsample;

import com.j256.simplejmx.common.JmxAttributeField;
import com.j256.simplejmx.common.JmxAttributeMethod;
import com.j256.simplejmx.common.JmxOperation;
import com.j256.simplejmx.common.JmxResource;

@JmxResource(domainName = "j256")
public class RuntimeCounter {
	private long startMillis = System.currentTimeMillis();
	
	// we can annotate fields directly to be published, isReadible defaults to true
	@JmxAttributeField(description = "Show runtime in seconds", isWritable = true)
	private boolean showSeconds;
	
	// we can annotate getter methods
	@JmxAttributeMethod(description = "Run time in seconds or milliseconds")
	public long getRunTime() {
		long diffMillis = System.currentTimeMillis() - startMillis;
		return diffMillis / (showSeconds ? 1 : 1000);
	}
	
	// this is an operation that shows up in the operations tab in jconsole.
	@JmxOperation(description = "Reset our start time to the current millis")
	public String resetStartTime() {
		startMillis = System.currentTimeMillis();
		return "Timer has been reset to current millis";
	}
}