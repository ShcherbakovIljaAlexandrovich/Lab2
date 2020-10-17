import org.apache.hadoop.io.RawComparator;

public class FirstComparator implements RawComparator<TextPair> {
    @Override
    public int compare(TextPair o1, TextPair o2) {
        return o1.getFirst().equals(o2.getFirst());
    }
}
