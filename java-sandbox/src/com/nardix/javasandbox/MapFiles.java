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
		String headersFileName = "C:/snardi/git-java-sandbox/java-sandbox/data/fields.csv";
		String dataFile = "C:/snardi/git-java-sandbox/java-sandbox/data/dig_inputFile.txt";
		
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
		
		//fieldNames.forEach((String s) -> (System.out.println(s)));
		int numFields = fieldNames.size();
		
		try (FileReader reader = new FileReader(new File(dataFile));
				BufferedReader br = new BufferedReader(reader);) {
			String line;
			while ((line = br.readLine()) != null) {
				String fields[] = line.split("\\|");
				System.out.println(fields.length);
				int i = 0;
				for (String name:fieldNames) {
					System.out.println(name + " -> " + (i >= fields.length ? "?????" : fields[i++]));
				}
			}
		}
		
	}
	
	
}
