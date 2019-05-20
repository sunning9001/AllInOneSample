package com.sun.demo;

import ch.hsr.geohash.GeoHash;
import ch.hsr.geohash.queries.GeoHashBoundingBoxQuery;
import ch.hsr.geohash.queries.GeoHashCircleQuery;

public class GeoHashSample {

	public static void main(String[] args) {
		
		
		double xzlatitude = 34.195298; // 纬度坐标
        double xzlongitude = 117.088845; // 经度坐标
        
    
    	double wxlatitude = 31.547665; // 纬度坐标
        double wxlongitude = 120.380646; // 经度坐标
        
        

        int numberOfCharacters = 8; 
        
        
	     GeoHash xz = GeoHash.withCharacterPrecision(xzlatitude, xzlongitude, numberOfCharacters);
	     
	     
	     
	     GeoHash wx = GeoHash.withCharacterPrecision(wxlatitude, wxlongitude, numberOfCharacters);
	     
	     
	    
	 
	 
	}
}
