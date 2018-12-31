package Record;

import java.util.LinkedList;

public class Record {
    public int index;
    public int row;
    public int col;
    public static LinkedList<Record> records = new LinkedList<Record>();
    public Record(int i, int r,int c)
    {
            index=i;
            row=r;
            col=c;
    }
}
