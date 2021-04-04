import java.util.ArrayList;
class SListIterator<T> {

    public SList<T> currentNode;

    public SListIterator(SList<T> slist)
    {
        currentNode = slist;
    }

    public boolean hasNext()
    {
        return (currentNode != null);
    }

    public SList<T> next()
    {
        SList<T> node = currentNode;
        currentNode = currentNode.next;

        return node;
    }
}

public class SList <T> {
    private T value;
    public SList next;

    public SList()
    {
        this.value = null;
        next = null;
    }
    public SList(T value)
    {
        this.value = value;
        next = null;
    }

    public SListIterator iterator()
    {
        return new SListIterator(this);
    }

    public String toString()
    {
        String nodeString = "Node value: " + value.toString();

        return nodeString;
    }
}
class Main {

    public static void main(String[] args) {
        int[] intarr = {1, 2, 13, 42, 54};
        SList<Integer> integerSList = new SList<>();

        SList<Integer> currList = integerSList;

        for (int i = 0; i < intarr.length; i++) {
            currList.next = new SList(intarr[i]);
            currList = currList.next;
        }

        integerSList = integerSList.next;

        SListIterator<Integer> iterator = integerSList.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
