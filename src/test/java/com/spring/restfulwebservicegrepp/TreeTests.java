package com.spring.restfulwebservicegrepp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TreeTests {

    final int[][] wires1 = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
    final int[][] wires2 = {{1, 2}, {2, 3}, {3, 4}};
    final int[][] wires3 = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};

    final int n1 = 9;
    final int n2 = 4;
    final int n3 = 7;

    @Test
    public void solutionTest() {
        int result1 = solution(wires1, n1);
        int result2 = solution(wires2, n2);
        int result3 = solution(wires3, n3);
        log.info("result1 : {}, result2 : {}, result3 : {}", result1, result2, result3);
//        Assertions.assertThat(result1).isEqualTo(result2).isEqualTo(result3);
    }

    public int solution(int[][] wires, int n) {
        int answer = -1;

        for (int[] wire : wires) {
            for (int i : wire) {

            }
        }
        return 0;
    }

}