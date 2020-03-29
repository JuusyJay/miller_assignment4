package miller_problem2;

public class Application {
	
	public static void main(String[] args) {
		
	DuplicateCounter duplicateCounter = new DuplicateCounter();//create object
	duplicateCounter.count("problem2.txt");//call both methods
	duplicateCounter.write("unique_word_counts.txt");

	}
	
}
