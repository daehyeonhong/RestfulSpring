package com.spring.restfulwebservicegrepp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class DepositTests {
    final int[] deposit1 = {500, 1000, -300, 200, -400, 100, -100};
    final int[] deposit2 = {500, 1000, 2000, -1000, -1500, 500};

    @Test
    public void solutionTest() {
        int[] result1 = solution(deposit1);
        int[] result2 = solution(deposit2);
        log.info("result1 : {}, result2 : {}", result1, result2);
//        Assertions.assertThat(result1).isEqualTo(result2).isEqualTo(result3);
    }

    public int[] solution(int[] deposit) {
        int[] answer = {};
        for (int i : deposit) {
            int n = answer.length;
            if (i > 0) {
                n += 1;
                answer = copyOf(answer, n);
                answer[n - 1] = i;
            } else {
                while (i != 0) {
                    n -= 1;
                    if (i + answer[n] < 0) {
                        i += answer[n];
                        answer = copyOf(answer, n);
                    } else {
                        answer[n] += i;
                        i = 0;
                        if (answer[n] == 0)
                            answer = copyOf(answer, n);
                    }
                }
            }
        }
        return answer;
    }

    public static int[] copyOf(int[] original, int newLength) {
        int[] copy = new int[newLength];
        System.arraycopy(original, 0, copy, 0,
                Math.min(original.length, newLength));
        return copy;
    }
//    public int[] solution(int[] deposit) {
//        int[] answer = {};
//        int[] modify;
//        for (int i : deposit) {
//            int n = answer.length;
//            if (i > 0) {
//                n += 1;
//                modify = new int[answer.length + 1];
//                for (int j = 0; j < modify.length; j++) {
//                    if (j == modify.length)
//                        modify[j] = i;
//                    else
//                        modify[j] = answer[j];
//                }
//                answer[n - 1] = i;
//            } else {
//                while (i != 0) {
//                    n -= 1;
//                    if (i + answer[n] < 0) {
//                        i += answer[n];
//                        modify = new int[answer.length -1];
//                        for (int j = 0; j < modify.length; j++) {
//                            if (j == modify.length)
//                                modify[j] = i;
//                            else
//                                modify[j] = answer[j];
//                        }
//                    } else {
//                        answer[n] += i;
//                        i = 0;
//                        if (answer[n] == 0)
//                            answer = copyOf(answer, n);
//                    }
//                }
//            }
//        }
//        return answer;
//    }

}