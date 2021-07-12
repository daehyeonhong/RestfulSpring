package com.spring.restfulwebservicegrepp;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class BoatTests {

    final int[] d1 = {1, 3, 2, 5, 4};
    final int m1 = 6;
    final int[] d2 = {2, 2, 4, 3};
    final int m2 = 6;
    final int[] d3 = {2, 2, 4, 3};
    final int m3 = 8;

    @Test
    public void solutionTest() {
        int result1 = solution(d1, m1);
        int result2 = solution(d2, m2);
        int result3 = solution(d3, m3);
        log.info("result1 : {}, result2 : {}, result3 : {}", result1, result2, result3);
//        Assertions.assertThat(result1).isEqualTo(result2).isEqualTo(result3);
    }

    public int solution(int[] d, int m) {
        int answer = 0, success = 0, luggage = 1;
        for (int i : d) {
            if (luggage <= i) {
                success += luggage;
                luggage *= 2;
            } else {
                luggage = 1;
            }
            answer++;
            if (success >= m)
                break;
        }
        if (success < m) {
            answer = -1;
        }
        return answer;
    }

}