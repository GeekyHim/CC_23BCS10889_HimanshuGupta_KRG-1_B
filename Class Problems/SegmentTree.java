class SegmentTree {
    int[] tree;
    int n;

    // Constructor
    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n]; // safe size
        build(arr, 0, 0, n - 1);
    }

    // Build Function
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start]; // leaf node
        } else {
            int mid = (start + end) / 2;

            // left child -> 2*node + 1
            // right child -> 2*node + 2
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);

            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    // Range Query (Sum)
    public int query(int l, int r) {
        return queryUtil(0, 0, n - 1, l, r);
    }

    private int queryUtil(int node, int start, int end, int l, int r) {
        // No overlap
        if (r < start || end < l) return 0;

        // Complete overlap
        if (l <= start && end <= r) return tree[node];

        // Partial overlap
        int mid = (start + end) / 2;
        int left = queryUtil(2 * node + 1, start, mid, l, r);
        int right = queryUtil(2 * node + 2, mid + 1, end, l, r);

        return left + right;
    }

    // Point Update (optional but important)
//    public void update(int idx, int value) {
//        updateUtil(0, 0, n - 1, idx, value);
//    }

//    private void updateUtil(int node, int start, int end, int idx, int value) {
//        if (start == end) {
//            tree[node] = value;
//        } else {
//            int mid = (start + end) / 2;
//
//            if (idx <= mid)
//                updateUtil(2 * node + 1, start, mid, idx, value);
//            else
//                updateUtil(2 * node + 2, mid + 1, end, idx, value);
//
//            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
//        }
//    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};

        SegmentTree st = new SegmentTree(arr);

        // Query sum from index 1 to 3 → (3 + 5 + 7 = 15)
        System.out.println(st.query(1, 3));

        // Update index 1 → value = 10
//        st.update(1, 10);

        // New query → (10 + 5 + 7 = 22)
        System.out.println(st.query(1, 3));
    }


}


