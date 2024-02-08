import java.util.Comparator;

public class SpecialComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) return 1;
        if (o1.length() < o2.length()) return -1;

        for (int i = 1; i < o1.length(); i++) {
            if (o1.charAt(i) > o2.charAt(i)) return 1;
            if (o1.charAt(i) < o2.charAt(i)) return -1;
        }

        return 0;
    }
}
