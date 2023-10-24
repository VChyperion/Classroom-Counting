import java.util.*;

public class ArrayBag {
    private ArrayList<String> bag;

    // Use constructor to initialise the ArrayList
    public ArrayBag() {
        bag = new ArrayList<>();
    }

    // Add an item to the bag
    public void add(String item) {
        bag.add(item);
    }

    // Print statement to show the contents in the bag
    public void displayBagContents() {
        for (String item : bag) {
            System.out.println(item);
        }
    }

    // Finds the most frequently occurring name
    public String findMostFrequentName() {
        // Use a hashmap to store how many name occurrences
        HashMap<String, Integer> nameAppears = new HashMap<>();

        // For line to count occurrences of each name
        for (String name : bag) {
            nameAppears.put(name, nameAppears.getOrDefault(name, 0) + 1);
        }

        /* happensTheMost variable to store maximum occurrence count of the student name
        using the collections.max function */
        int happensTheMost = Collections.max(nameAppears.values());

        // Use stringbuilder to build the resulting string
        StringBuilder result = new StringBuilder("Here are the most frequent names. These will be removed from the list:\n");

        // Iterate thru the hashmap ti find the most frequently occurring names
        for (Map.Entry<String, Integer> entry : nameAppears.entrySet()) {
            if (entry.getValue() == happensTheMost) {
                result.append(entry.getKey()).append(" (Occurrences: ").append(happensTheMost).append(")\n");
            }
        }

        return result.toString();
    }

    // Deletes all occurrences of the name taken from the bag
    public void removeAllOccurrences(String name) {
        bag.removeIf(item -> item.equals(name));
    }

    // Second hashmap with name occurrences
    public HashMap<String, Integer> generateNameTable() {
        HashMap<String, Integer> nameAppears = new HashMap<>();

        for (String name : bag) {
            nameAppears.put(name, nameAppears.getOrDefault(name, 0) + 1);
        }

        return nameAppears;
    }

    // Extra code to access the bag
    public ArrayList<String> getBag() {

        return bag;
    }
}
