class SegmentTree {
    int[] tree, lazy;
    int n;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        lazy = new int[4 * n];
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

    private void push(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += lazy[node];

            if (start != end) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }

            lazy[node] = 0;
        }
    }

    public void update(int l, int r, int val) {
        updateUtil(0, 0, n - 1, l, r, val);
    }

    private void updateUtil(int node, int start, int end, int l, int r, int val) {
        push(node, start, end);

        if (r < start || end < l) return;

        if (l <= start && end <= r) {
            lazy[node] += val;
            push(node, start, end);
            return;
        }

        int mid = (start + end) / 2;

        updateUtil(2 * node + 1, start, mid, l, r, val);
        updateUtil(2 * node + 2, mid + 1, end, l, r, val);

        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public int query(int l, int r) {
        return queryUtil(0, 0, n - 1, l, r);
    }

    private int queryUtil(int node, int start, int end, int l, int r) {
        push(node, start, end);

        if (r < start || end < l) return Integer.MIN_VALUE;

        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;

        int left = queryUtil(2 * node + 1, start, mid, l, r);
        int right = queryUtil(2 * node + 2, mid + 1, end, l, r);

        return Math.max(left, right);
    }
}

public class LazyPropagation {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 9, 3};

        SegmentTree st = new SegmentTree(arr);

        System.out.println(st.query(1, 4)); // 9

        st.update(1, 3, 3);
        System.out.println(st.query(1, 4)); // 9

        st.update(2, 5, 5);
        System.out.println(st.query(0, 5)); // 14
    }
}