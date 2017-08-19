package sample;

import java.util.UUID;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

public class UuidSample {

	public static void main(String[] args) {

		
		TimeBasedGenerator gen = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
		
		System.out.println(Long.toString(System.currentTimeMillis()).length());
	
	}
}
