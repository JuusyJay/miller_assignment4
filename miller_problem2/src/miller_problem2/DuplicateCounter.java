package miller_problem2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicateCounter {
		
	Map<String, Integer> map = new HashMap<String, Integer>();//Map to store duplicate counts
	
	public void count(String dataFile) {
				
		try {	//try this else catch
			
			BufferedReader br = null;//initialize to null
			br = new BufferedReader( new FileReader(dataFile) );//use the dataFile path
            
            String currentLine = br.readLine();//currentLine is read in
            
     
            while (currentLine != null ) {            //if current isn't null continue    
              
                String[] words = currentLine.toLowerCase().split(" ");//split at spaces and make lower case
                
                for(String word : words) {//for the word in the array 
                						//put it down and adjust count if it already exists
                	 if(map.containsKey(word)) {
                     	map.put(word,  map.get(word) + 1);
                     }
                     else {
                     	map.put(word,  1);
                     }
                }
                
               currentLine = br.readLine();//get the next line if there is one
            }
            
            br.close();//close reader
            
            
			
		} catch (FileNotFoundException e) {//catch these exceptions and print message
			
		    e.printStackTrace();
		    
		} catch (SecurityException | IOException e ) {//catch these exceptions and print message
			
			System.out.println("An error occured!");
			e.printStackTrace();
		}
	}
	
	public void write(String outputFile) {
		
		try {
			
			File f = new File("unique_word_counts.txt");
			if(!f.exists()){
			  f.createNewFile();
			}
			
			 BufferedWriter br = null;//initialize to null
			 
			 br = new BufferedWriter( new FileWriter(outputFile) );//use the outputFile
			 
			 Set<Entry<String, Integer>> entrySet = map.entrySet();//create a set with the maps contents
	       
	            for(Entry<String, Integer> entry : entrySet){//for each entry in the set write the key and the value to the file
	                
	                br.write( entry.getKey() + " : " + entry.getValue() );
	                
	                br.newLine();//write a new line to file
	            }
	            
	            br.flush();//flush and close the writer
	            br.close();
	 			
		} catch (FileNotFoundException e) {//catch these exceptions and print message
			System.out.println("An error occured!");
			   e.printStackTrace();
			    
		} catch (SecurityException e){//catch these exceptions and print message
			 
			System.out.println("An error occured!");
			e.printStackTrace();
			
		} catch (IOException e) {//catch these exceptions and print message
			System.out.println("An error occured!");
			e.printStackTrace();
		}
		
		
	}
}
