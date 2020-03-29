package miller_problem1;

public class Application {
	
	public static void main(String[] args) {
		
		DuplicateRemover duplicateRemover = new DuplicateRemover();//create object
		duplicateRemover.remove("problem1.txt");//call both methods
		duplicateRemover.write("unique_words.txt");
	}
}
