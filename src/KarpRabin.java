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
        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            if (i == 0) {
                hash = hashFunction(text.substring(i, i + pattern.length()));
            } else {
                hash = rollingHashFunction(hash, text.charAt(i-1), text.charAt(i + pattern.length() - 1));
            }
            if (hash == patternHash) {
                if(text.substring(i, i+pattern.length()).equals(pattern)) {
                    System.out.println("Math Found at index: " + i);
                }
            }

        }
    }

    private int hashFunction(String input) {
        int hash = 0;
        for (int i = 0; i < input.length(); i++) {
            hash += (int) (input.charAt(i) * Math.pow(b, pattern.length()-i-1) % p);
        }
        return hash;
    }
    private int rollingHashFunction(int previousHash, char firstCharOfPreviousString, char lastCharOfNewString) {
        int hash = previousHash;

        hash -= (int) (firstCharOfPreviousString * Math.pow(b, pattern.length() - 1));
        hash *= 3;
        hash += lastCharOfNewString;
        hash %= p;
        return hash;
    }
}
