public class KarpRabin {

    private final int b;
    private final int p;
    private final String text;
    private final String pattern;

    public KarpRabin(String text, String pattern, int b, int p) {
        this.text = text;
        this.pattern = pattern;
        this.b = b;
        this.p = p;
    }

    public void findMatches() {
        int patternHash = hashFunction(pattern);
        int hash = -1;
        for (int i = 0; i < text.length() - pattern.length(); i++) {
            if (i == 0) {
                hash = hashFunction(text.substring(i, i+pattern.length()));
            } else {
                hash = rollingHashFunction(text.substring(i, i+pattern.length()), hash);
            }
            if (hash == patternHash) {
                if(text.substring(i, i+pattern.length()).equals(pattern)) {
                    System.out.println("Math Found at index: " + i);
                }
            }

        }
    }

    private int hashFunction(String input) {
        return 0;
    }
    private int rollingHashFunction(String input, int previousHash) {
        return 0;
    }
}
