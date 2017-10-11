package com.lombok;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class User {

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String surname;

    @Setter
    @Getter
    private int age;

    public static void main(String[] args) {
		
    	
	}
}