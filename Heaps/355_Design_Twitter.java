class Twitter {
    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<Tweet>> tweets;
    private int timestamp;
    
    private class Tweet {
        int tweetId;
        int timestamp;
        
        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        
        if (tweets.containsKey(userId)) {
            maxHeap.addAll(tweets.get(userId));
        }
        
        if (following.containsKey(userId)) {
            for (int followeeId : following.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    maxHeap.addAll(tweets.get(followeeId));
                }
            }
        }
        
        List<Integer> newsFeed = new ArrayList<>();
        for (int i = 0; i < 10 && !maxHeap.isEmpty(); i++) {
            newsFeed.add(maxHeap.poll().tweetId);
        }
        
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            if (!following.containsKey(followerId)) {
                following.put(followerId, new HashSet<>());
            }
            following.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
