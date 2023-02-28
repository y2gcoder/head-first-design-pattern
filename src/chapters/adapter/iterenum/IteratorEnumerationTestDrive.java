package chapters.adapter.iterenum;

import java.util.ArrayList;
import java.util.Arrays;

public class IteratorEnumerationTestDrive {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(args));
        IteratorEnumeration iteratorEnumeration = new IteratorEnumeration(strings.iterator());
        while (iteratorEnumeration.hasMoreElements()) {
            System.out.println(iteratorEnumeration.nextElement());
        }
    }
}
