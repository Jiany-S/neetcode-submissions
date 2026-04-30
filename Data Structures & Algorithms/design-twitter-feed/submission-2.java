class Twitter {
    private HashMap<Integer, HashSet<Integer>> followings;
    private HashMap<Integer, List<int[]>> tweets;
    private int time;

    public Twitter() {
        tweets = new HashMap<>();
        followings = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId, time++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> feed = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        if (tweets.containsKey(userId)) {
            for (int[] t : tweets.get(userId)) {
                feed.offer(t);
                if (feed.size() > 10) feed.poll();
            }
        }
        if (followings.containsKey(userId)) {
            for (int followee : followings.get(userId)) {
                if (followee == userId) continue;
                if (!tweets.containsKey(followee)) continue;
                for (int[] t : tweets.get(followee)) {
                    feed.offer(t);
                    if (feed.size() > 10) feed.poll();
                }
            }
        }
        LinkedList<Integer> ans = new LinkedList<>();
        while (!feed.isEmpty()) {
            ans.addFirst(feed.poll()[0]);
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followings.putIfAbsent(followerId, new HashSet<>());
        followings.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followings.containsKey(followerId)) {
            followings.get(followerId).remove(followeeId);
        }
    }
}
