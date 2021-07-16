package com.spring.restfulwebservice;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static com.spring.restfulwebservice.JavaSolutionTests.TestArray.create;

public class JavaSolutionTests {

    @Test
    public void solution() {
        String[] testArray = create();
        List<Integer> integers = new ArrayList<>();
        for (String s : testArray) {
            s = s.replace("[", "");
            s = s.replace("]", "");
            String[] ss = s.split(", ");
            integers.add(Integer.parseInt(ss[0]));
            integers.add(Integer.parseInt(ss[1]));
        }
        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }
    }

    static class TestArray {
        public static String[] create() {
            Integer first = (int) Math.floor(Math.random() * 100);
            Integer second = (int) Math.floor(Math.random() * 100);
            Integer third = (int) Math.floor(Math.random() * 100);
            Integer fourth = (int) Math.floor(Math.random() * 100);
            String[] testArray = new String[3];
            testArray[0] = String.format("[%s, %s]", first, third);
            testArray[1] = String.format("[%s, %s]", first, fourth);
            testArray[2] = String.format("[%s, %s]", second, third);
            for (String s : testArray) {
                System.out.println("s = " + s);
            }
            return testArray;
            /**
             * 1,1 2,1
             *
             * 1,0 2,0
             */
        }
    }


}
