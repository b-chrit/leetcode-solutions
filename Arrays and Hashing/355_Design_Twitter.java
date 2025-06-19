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
}
