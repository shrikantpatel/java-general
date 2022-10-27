package com.shri.demo.leet;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/race-car/
 * <p>
 * 818. Race Car
 * Hard
 * <p>
 * 1442
 * <p>
 * 145
 * <p>
 * Add to List
 * <p>
 * Share
 * Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into negative positions. Your car drives automatically according to a sequence of instructions 'A' (accelerate) and 'R' (reverse):
 * <p>
 * When you get an instruction 'A', your car does the following:
 * position += speed
 * speed *= 2
 * When you get an instruction 'R', your car does the following:
 * If your speed is positive then speed = -1
 * otherwise speed = 1
 * Your position stays the same.
 * For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 --> 3, and your speed goes to 1 --> 2 --> 4 --> -1.
 * <p>
 * Given a target position target, return the length of the shortest sequence of instructions to get there.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 3
 * Output: 2
 * Explanation:
 * The shortest instruction sequence is "AA".
 * Your position goes from 0 --> 1 --> 3.
 * Example 2:
 * <p>
 * Input: target = 6
 * Output: 5
 * Explanation:
 * The shortest instruction sequence is "AAARA".
 * Your position goes from 0 --> 1 --> 3 --> 7 --> 7 --> 6.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= target <= 104
 * Accepted
 * 63,410
 * Submissions
 * 145,306
 * Seen this question in a real interview before?
 * <p>
 * Yes
 * <p>
 * No
 * 0 ~ 6 months
 */
public class Race_Car {

    public int solution(int target) {

        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        queue.offer(new Pair<>(0, 1));
        visited.add(queue.peek());
        int size = 1;
        int instructions = 0;

        //time complexity = O(t * log t)
        //space complexity = O(t * log t)

        while (!queue.isEmpty()) {

            Pair<Integer, Integer> node = queue.poll();
            int position = node.getKey();
            int speed = node.getValue();

            if (position == target) {
                return instructions;
            }

            //A
            offer(queue, visited, position + speed, speed * 2, target);

            //R
            offer(queue, visited, position, speed > 0 ? -1 : 1, target);

            if (--size == 0) {
                size = queue.size();
                ++instructions;
            }
        }
        return -1;
    }

    public void offer(Queue<Pair<Integer, Integer>> queue, Set<Pair<Integer, Integer>> visited, int position, int speed, int target) {

        Pair<Integer, Integer> node = new Pair<>(position, speed);
        if (position >= 0 && position < 2 * target && !visited.contains(node)) {
            queue.offer(node);
            visited.add(node);
        }
    }

    @Test
    public void test1() {
        Race_Car raceCar = new Race_Car();
        int output = raceCar.solution(3);
        Assert.assertEquals(2, output);
    }

    @Test
    public void test2() {
        Race_Car raceCar = new Race_Car();
        int output = raceCar.solution(6);
        Assert.assertEquals(5, output);
    }
}


