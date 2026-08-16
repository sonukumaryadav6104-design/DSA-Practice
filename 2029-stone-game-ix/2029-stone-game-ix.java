class Solution {

    public boolean stoneGameIX(int[] stones) {

        int[] cnt = new int[3];

        for (int x : stones) {
            cnt[x % 3]++;
        }

        int[] a = {cnt[0], cnt[1], cnt[2]};
        int[] b = {cnt[0], cnt[2], cnt[1]};

        return check(a) || check(b);
    }

    private boolean check(int[] c) {

        c[1]--;

        if (c[1] < 0) {
            return false;
        }

        int turns = 1 + Math.min(c[1], c[2]) * 2 + c[0];

        if (c[1] > c[2]) {
            c[1]--;
            turns++;
        }

        return turns % 2 == 1 && c[1] != c[2];
    }
}