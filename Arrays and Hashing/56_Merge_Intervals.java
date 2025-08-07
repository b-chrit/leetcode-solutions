class Solution {

    static class Pair {
        int start;
        int end;

        Pair(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Pair> pairs = new ArrayList<>();
        for (int[] interval : intervals) {
            pairs.add(new Pair(interval[0], interval[1]));
        }

        pairs.sort((a, b) -> Integer.compare(a.start, b.start));

        List<Pair> merged = new ArrayList<>();
        for (Pair curr : pairs) {
            if (merged.isEmpty() || merged.get(merged.size() - 1).end < curr.start) {
                merged.add(curr);
            } else {
                Pair last = merged.get(merged.size() - 1);
                last.end = Math.max(last.end, curr.end);
            }
        }

        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i][0] = merged.get(i).start;
            result[i][1] = merged.get(i).end;
        }

        return result;
    }
}
