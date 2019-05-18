package com.ds.queue;

import java.util.PriorityQueue;

/**
 * 362. Design Hit Counter
 * <p>
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * <p>
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to
 * the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest
 * timestamp starts at 1.
 * <p>
 * It is possible that several hits arrive roughly at the same time.
 */
public class HitCounter {

    private PriorityQueue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        queue = new PriorityQueue<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        queue.add(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && (timestamp - queue.peek()) >= 300) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

// hit at timestamp 1.
        counter.hit(1);

// hit at timestamp 2.
        counter.hit(2);

// hit at timestamp 3.
        counter.hit(3);

// get hits at timestamp 4, should return 3.
        System.out.println(counter.getHits(4));

// hit at timestamp 300.
        counter.hit(300);

// get hits at timestamp 300, should return 4.
        System.out.println(counter.getHits(300));

// get hits at timestamp 301, should return 3.
        System.out.println(counter.getHits(301));
    }
}
