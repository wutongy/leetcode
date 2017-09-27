class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); ++i) {
            String[] a = timePoints.get(i).split("\\:");
            String[] b = timePoints.get((i + 1) % timePoints.size()).split("\\:");
            if (i == timePoints.size() - 1) {
                b[0] = String.valueOf(Integer.valueOf(b[0]) + 24);
            }
            res = Math.min(res, Math.abs(Integer.valueOf(a[0]) * 60 + Integer.valueOf(a[1]) - Integer.valueOf(b[0]) * 60 - Integer.valueOf(b[1])));
        }
        return res;
    }
}
