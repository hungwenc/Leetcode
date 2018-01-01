/*L264. Ugly Number II
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
*/
// Heap + HashMap  time: O(nlogn) 
public class Solution {
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        PriorityQueue<Long> pq = new PriorityQueue<>(); // 用heap取最小
        Set<Long> set = new HashSet<>(); // 用set來去重
        long[] primes = new long[3];

        primes[0] = (2);
        primes[1] = (3);
        primes[2] = (5);
        for (int i = 0; i < primes.length; i++) {
            pq.add(primes[i]);
            set.add(primes[i]);
        }

        long result = 1;
        for (int i = 1; i < n; i++) { // assign i = 1 because if n == 1 should return 1
            result = pq.poll();
            for (int j = 0; j < primes.length; j++) {
                if (!set.contains(result * primes[j])) {
                    pq.add(result * primes[j]);
                    set.add(result * primes[j]);
                }
            }
        }
        return (int)result;
    }
}
