public class exercise004 {
    public int mySqrt1(int x) {
        int r = x / 2;
        int max = x;
        int result = -1;
        if(x == 0 || x == 1) {
            return x;
        }

        while(r <= x) {
            if(mul(r) > x) {//太大了,减半
                if(mul(r - 1) < x) {
                    return r - 1;
                }
                max = r;
                r = r / 2;
            } else if(mul(r) < x) {//太小了，增大
                if(mul(r + 1) > x) {
                    return r;
                }
                r = (r + max) / 2;
            } else {
                return r;
            }
        }
        return -1;
    }

    public long mul(int i) {
        return (long) i * i;
    }

    class Solution02 {
        public int mySqrt(int x) {
            int l = 0;
            int r = x;

            while(l < r) {
                int mid = (l + r) / 2;
                if((long)mid * mid < x) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return (long)r*r <= x ? r : r - 1;
        }
    }
}
