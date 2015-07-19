package com.nardix.javasandbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MapFiles {
	
	public static void main(String argv[]) throws Exception {
		String headersFileName = "C:/snardi/ws_sns/Map/data/fields.csv";
		
		ArrayList<String> fieldNames = new ArrayList<>();
		
		
		
		try (FileReader reader = new FileReader(new File(headersFileName));
				BufferedReader br = new BufferedReader(reader);) {
			String line;
			Pattern p = Pattern.compile("[^,]*");
			while ((line = br.readLine()) != null) {
				Matcher matcher = p.matcher(line);
				if (matcher.find())
					fieldNames.add(matcher.group());
				else
					new Exception("Cannot read field name");
			}
		}
		
		for (String fieldName:fieldNames) {
			System.out.println(fieldName);
		}
	}
	
	
}
