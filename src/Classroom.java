import java.util.*;

public class Classroom {
    public static void main(String[] args) {
        // Creating an array of unique student names
        String[] studNames = {"Emily", "Bob", "Henry", "Juan", "Sona",
                "Ben", "Isa", "Jenny", "Joesph", "Michelle"};

        // Creating an ArrayBag object to store student names
        ArrayBag students = new ArrayBag();

        /* Using random import to generate 100 random student names using the
        values in studNames and then adding them to the ArrayBag*/

        Random randNum = new Random();
        for (int i = 0; i < 100; i++) {
            String randomName = studNames[randNum.nextInt(studNames.length)];
            students.add(randomName);
        }

        // Print the student names that were generated
        System.out.println("Students Generated:\n");
        students.displayBagContents();

        // Find and print most frequently occurring name
        System.out.println("\n" + students.findMostFrequentName());

        // List the names that occur the most
        ArrayList<String> mostSeenNames = new ArrayList<>();
        HashMap<String, Integer> nameOccurrences = students.generateNameTable();

        int maxOccurrences = Collections.max(nameOccurrences.values());

        for (Map.Entry<String, Integer> entry : nameOccurrences.entrySet()) {
            if (entry.getValue() == maxOccurrences) {
                mostSeenNames.add(entry.getKey());
            }
        }

        // Remove the most frequently names from the array
        for (String name : mostSeenNames) {
            students.removeAllOccurrences(name);
        }

        // Print the number of names remaining inside the ArrayBag
        System.out.println("Number of names remaining in the bag: " + students.getBag().size());

        // Display a table of the remaining names in the bag, with their occurrences
        System.out.println("\nDisplaying a table of remaining names with number of occurrences:");
        nameOccurrences = students.generateNameTable();
        for (Map.Entry<String, Integer> entry : nameOccurrences.entrySet()) {
            System.out.println(entry.getKey() + " (Occurrences: " + entry.getValue() + ")");
        }
    }
}
