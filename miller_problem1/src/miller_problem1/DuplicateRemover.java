package miller_problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DuplicateRemover {
	
	public Object[] uniqueWords;//create the array of objects to keep unique words
	
	public void remove(String dataFile) {
		
		Set<String> hash_Set = new HashSet<String>();//create the set
		
		try {			
			BufferedReader reader = new BufferedReader(new FileReader(dataFile));//create a reader with dataFIle
			
			String line = null;//set line to null
			while((line = reader.readLine()) != null) {//while line != null add them to the set
				hash_Set.add(line);
			}
			uniqueWords = hash_Set.toArray();//put unique words in the set
			reader.close();//close reader
			
		} catch (FileNotFoundException e) {//catch these exceptions and print message
			System.out.println("An error occured!");
		    e.printStackTrace();
		    
		} catch (SecurityException | IOException e ) {
			
			System.out.println("An error occured!");
			e.printStackTrace();
		}
	}
	
	public void write(String outputFile) {
		
		String[] words = new String[uniqueWords.length];//create string of words
		
		System.arraycopy(uniqueWords, 0, words, 0, uniqueWords.length);//copy uniqueWords into words
		
		try {
			
			File f = new File("unique_words.txt");
			if(!f.exists()){
			  f.createNewFile();
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));//create a writer
			
			writer.write(Arrays.toString(words));//write the words into the file
			
			writer.close();//close writer
			
		} catch (FileNotFoundException e) {//catch these exceptions and print message
			System.out.println("An error occured!");
			e.printStackTrace();
			    
		} catch (SecurityException | IOException e){
			 
			System.out.println("An error occured!");
			e.printStackTrace();
		}
		
		
	}
	
}
