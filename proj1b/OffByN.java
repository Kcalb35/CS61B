public class OffByN implements CharacterComparator {
    private final int distance;

    public OffByN(int n) {
        distance = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        return diff == distance;
    }
}
