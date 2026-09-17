class Solution {
    
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(dst);
        }

        for (String key : adj.keySet()) {
            Collections.sort(adj.get(key));
        }

        dfs(adj, res, "JFK");
        Collections.reverse(res);

        if (res.size() != tickets.size() + 1) {
            return new ArrayList<>();
        }

        return res;
    }

    private void dfs(Map<String, List<String>> adj, List<String> result, String src) {
        if (adj.containsKey(src)) {
            List<String> destinations = new ArrayList<>(adj.get(src));
            while (!destinations.isEmpty()) {
                String dest = destinations.get(0);
                adj.get(src).remove(0);
                dfs(adj, result, dest);
                destinations = new ArrayList<>(adj.get(src));
            }
        }
        result.add(src);
    }
}