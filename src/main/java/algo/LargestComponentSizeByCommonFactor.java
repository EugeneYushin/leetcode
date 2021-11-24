package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestComponentSizeByCommonFactor {
    class Node {
        int val;
        int count;
        Node parent;

        public Node(int n) {
            this.val = n;
            this.count = 0;
        }
    }

    class UnionFind {
        public Map<Integer, Node> mapping = new HashMap<>();

        public void makeSet(int n, int count) {
            Node node = find(n);
            if (node == null) {
                node = new Node(n);
                mapping.put(n, node);
            }

            node.count += count;
        }

        public Node find(int n) {
            if (mapping.containsKey(n)) {
                Node node = mapping.get(n);
                if (node.parent == null) return node;
                else return find(node.parent.val);
            } else {
                return null;
            }
        }

        public void union(int x, int y) {
            Node parentX = find(x);
            Node parentY = find(y);

            if (parentX == parentY) return;

            Node tmp = parentX;
            parentX = parentX.count >= parentY.count ? parentX : parentY;
            if (parentX != tmp) {
                parentY = tmp;
            }

            parentX.count += parentY.count;
            parentY.parent = parentX;
        }
    }

    public int largestComponentSize(int[] nums) {
        UnionFind unionFind = new UnionFind();

        for (int n : nums) {
            if (n == 1) {
                unionFind.makeSet(1, 1);
                continue;
            }

            List<Integer> factors = factorize(n);
            unionFind.makeSet(factors.get(0), 1);

            for (int i = 1; i < factors.size(); i++) {
                unionFind.makeSet(factors.get(i), 0);
                unionFind.union(factors.get(i - 1), factors.get(i));
            }
        }

        int maxSize = 0;

        for (Node n : unionFind.mapping.values()) {
            if (n.parent == null) {
                maxSize = Math.max(maxSize, n.count);
            }
        }

        return maxSize;
    }

    public List<Integer> factorize(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n % 2 == 0) factors.add(2);
        while (n % 2 == 0) {
            n >>= 1;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) factors.add(i);
            while (n % i == 0) {
                n /= i;
            }
        }

        if (n > 1) factors.add(n);
        return factors;
    }
}
