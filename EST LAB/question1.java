public class question1 {

    static class SegmentTree {
        int[] sumTree;
        int[] minTree;
        int[] maxTree;
        int n;

        SegmentTree(int[] arr) {
            n = arr.length;
            sumTree = new int[4 * n];
            minTree = new int[4 * n];
            maxTree = new int[4 * n];
            build(arr, 0, 0, n - 1);
        }

        // Build all 3 trees
        void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                sumTree[node] = arr[start];
                minTree[node] = arr[start];
                maxTree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;

            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);

            sumTree[node] = sumTree[2 * node + 1] + sumTree[2 * node + 2];
            minTree[node] = Math.min(minTree[2 * node + 1], minTree[2 * node + 2]);
            maxTree[node] = Math.max(maxTree[2 * node + 1], maxTree[2 * node + 2]);
        }

        // SUM QUERY
        int querySum(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0; // no overlap

            if (l <= start && end <= r) return sumTree[node]; // complete overlap

            int mid = (start + end) / 2;

            return querySum(2 * node + 1, start, mid, l, r) +
                   querySum(2 * node + 2, mid + 1, end, l, r);
        }

        // MIN QUERY
        int queryMin(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return Integer.MAX_VALUE;

            if (l <= start && end <= r) return minTree[node];

            int mid = (start + end) / 2;

            return Math.min(
                queryMin(2 * node + 1, start, mid, l, r),
                queryMin(2 * node + 2, mid + 1, end, l, r)
            );
        }

        // MAX QUERY
        int queryMax(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return Integer.MIN_VALUE;

            if (l <= start && end <= r) return maxTree[node];

            int mid = (start + end) / 2;

            return Math.max(
                queryMax(2 * node + 1, start, mid, l, r),
                queryMax(2 * node + 2, mid + 1, end, l, r)
            );
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};

        SegmentTree st = new SegmentTree(arr);

        int l = 2, r = 4;

        System.out.println("Sum: " + st.querySum(0, 0, arr.length - 1, l, r));
        System.out.println("Min: " + st.queryMin(0, 0, arr.length - 1, l, r));
        System.out.println("Max: " + st.queryMax(0, 0, arr.length - 1, l, r));
    }
}