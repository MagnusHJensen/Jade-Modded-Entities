package dk.magnusjensen.jademoddedentities.utilities;

public class Utils {
    public static String titleCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Replace all underscores with spaces
        input = input.replace("_", " ");
        StringBuilder titleCased = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                capitalizeNext = true;
                titleCased.append(c);
            } else if (capitalizeNext) {
                titleCased.append(Character.toTitleCase(c));
                capitalizeNext = false;
            } else {
                titleCased.append(Character.toLowerCase(c));
            }
        }
        return titleCased.toString();
    }
}
