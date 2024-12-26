import java.util.Scanner;
public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            totalMarks += marks[i];
        }
        int totalPossibleMarks = numSubjects * 100;
        double averagePercentage = ((double) totalMarks / totalPossibleMarks) * 100;
        String grade = "";
        if (averagePercentage >= 90) {
            	grade = "A";
        } 
	else if (averagePercentage >= 75) {       
		grade = "B";       
	 }
 	else if (averagePercentage >= 50) {
                 grade = "C"; 
	}
 	else {
                 grade = "D";
        }
        System.out.println("\nTotal Marks: " + totalMarks + "/" + totalPossibleMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        scanner.close();
   }
}
