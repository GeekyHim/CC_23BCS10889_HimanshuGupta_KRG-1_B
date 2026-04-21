class SegmentTree {
    int[] tree;
    int n;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;

            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);

            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }

    public int query(int l, int r) {
        return queryUtil(0, 0, n - 1, l, r);
    }

    private int queryUtil(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return Integer.MIN_VALUE;

        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;

        int left = queryUtil(2 * node + 1, start, mid, l, r);
        int right = queryUtil(2 * node + 2, mid + 1, end, l, r);

        return Math.max(left, right);
    }

    public void update(int idx, int value) {
        updateUtil(0, 0, n - 1, idx, value);
    }

    private void updateUtil(int node, int start, int end, int idx, int value) {
        if (start == end) {
            tree[node] = value;
        } else {
            int mid = (start + end) / 2;

            if (idx <= mid)
                updateUtil(2 * node + 1, start, mid, idx, value);
            else
                updateUtil(2 * node + 2, mid + 1, end, idx, value);

            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }
}

public class SegmentTreeMax {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 9, 3};

        SegmentTree st = new SegmentTree(arr);

        System.out.println("Initial max (1,4): " + st.query(1, 4)); // 9

        st.update(2, 10);

        System.out.println("After update index 2 -> 10, max (1,4): " + st.query(1, 4)); // 10
    }
}