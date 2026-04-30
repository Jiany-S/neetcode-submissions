class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] sol = new int[n + 1];
        Arrays.fill(sol, -1);
        return help(sol, cost, n);
    }

    public int help(int[] sol, int[] cost, int i) {
        if (i <= 1) return 0;
        if (sol[i] != -1) return sol[i];

        sol[i] = Math.min(
            help(sol, cost, i - 1) + cost[i - 1],
            help(sol, cost, i - 2) + cost[i - 2]
        );
        return sol[i];
    }
}
