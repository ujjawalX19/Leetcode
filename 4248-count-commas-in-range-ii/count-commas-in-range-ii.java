class Solution {
    public long countCommas(long n) {
         long count = 0;

    
      long place = 1000;

        while (place <= n) {
            count += n - place + 1;
            place *= 1000;
        }
        return count;
    }
}