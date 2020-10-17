import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FirstComparator extends WritableComparator {
    protected FirstComparator() {
        super(TextPair.class, true);
    }
    @Override
    public int compare(WritableComparable o1, WritableComparable o2) {
        return ((TextPair)o1).getFirst().compareTo(((TextPair)o2).getFirst());
    }
}
