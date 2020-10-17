import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FirstComparator extends WritableComparator {
    @Override
    public int compare(WritableComparable o1, WritableComparable o2) {
        return ((TextPair)o1).getFirst().compareTo(o2.getFirst());
    }
}
