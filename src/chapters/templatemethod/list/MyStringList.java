package chapters.templatemethod.list;

import java.util.AbstractList;

public class MyStringList extends AbstractList<String> {
    private String[] myList;

    public MyStringList(String[] Strings) {
        this.myList = Strings;
    }

    @Override
    public String get(int index) {
        return myList[index];
    }

    @Override
    public int size() {
        return myList.length;
    }

    public String set(int index, String item) {
        String oldString = myList[index];
        myList[index] = item;
        return oldString;
    }
}
