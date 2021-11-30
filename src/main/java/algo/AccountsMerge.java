package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/accounts-merge/
 */
public class AccountsMerge {
    class Node {
        String email;
        String accName;
        // int rank;
        Node parent;

        public Node(String email, String accName) {
            this.email = email;
            this.accName = accName;
        }
    }

    class UnionFind {
        Map<String, Integer> mapping = new HashMap<>();
        List<Node> roots = new ArrayList<>();

        public Node makeSet(String email, String accName) {
            Node parent = find(email);
            if (parent == null) {
                parent = new Node(email, accName);
                mapping.put(email, roots.size());
                roots.add(parent);
            }

            return parent;
        }

        public Node find(String email) {
            if (mapping.containsKey(email)) {
                Node node = roots.get(mapping.get(email));
                if (node.parent == null) return node;
                else {
                    // path compression
                    node.parent = find(node.parent.email);
                    return node.parent;
                }
            }
            return null;
        }

        public void union(String x, String y) {
            Node xRoot = find(x);
            Node yRoot = find(y);

            if (xRoot == yRoot) return;

            // pre-sorted, it just works faster on leetcode test scenarios
            if (xRoot.email.compareTo(yRoot.email) > 0) {
                Node tmp = xRoot;
                xRoot = yRoot;
                yRoot = tmp;
            }

            yRoot.parent = xRoot;
        }
    }

    /**
     * Time complexity: O(N*logN), N - all emails
     * Space complexity: O(N)
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        for (List<String> acc : accounts) {
            String accName = acc.get(0);
            Node prev = uf.makeSet(acc.get(1), accName);
            for (int i = 2; i < acc.size(); i++) {
                Node current = uf.makeSet(acc.get(i), accName);
                uf.union(prev.email, current.email);
            }
        }

        Map<Node, List<String>> merged = new HashMap<>();
        for (String email : uf.mapping.keySet()) {
            Node root = uf.find(email);
            merged.putIfAbsent(root, new ArrayList<>());
            merged.get(root).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Node, List<String>> e : merged.entrySet()) {
            Collections.sort(e.getValue());
            List<String> account = new ArrayList<>();
            account.add(e.getKey().accName);
            account.addAll(e.getValue());
            result.add(account);
        }

        return result;
    }

    /*public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<SortedSet<String>>> m = new HashMap<>();

        nextAccount:
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            List<String> emails = acc.subList(1, acc.size());
            SortedSet<String> currentAccounts = new TreeSet<>(emails);
            SortedSet<String> dummy = new TreeSet<>(emails);

            List<SortedSet<String>> sortedSets = m.getOrDefault(name, new ArrayList<>());
            for (SortedSet<String> s : sortedSets) {
                dummy.retainAll(s);
                if (dummy.size() != 0) {
                    s.addAll(currentAccounts);
                    continue nextAccount;
                }
            }

            sortedSets.add(currentAccounts);
            m.putIfAbsent(name, sortedSets);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<SortedSet<String>>> stringListEntry : m.entrySet()) {
            for (SortedSet<String> emails : stringListEntry.getValue()) {
                ArrayList<String> acc = new ArrayList<>();
                acc.add(stringListEntry.getKey());
                acc.addAll(emails);
                res.add(acc);
            }
        }

        return res;
    }*/
}
