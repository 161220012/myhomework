package Record;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecordTest {
    @Test
    public void run() {
        Record test=new Record(0,1,2);
        Record.records.add(test);
        assertEquals(Record.records.get(0).index,0);

    }
}
