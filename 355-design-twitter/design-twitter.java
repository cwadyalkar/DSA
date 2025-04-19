class Tweet implements Comparable<Tweet> {
    int time;
    int tweetId;

    Tweet(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
    }

    public int compareTo(Tweet that) {
        return that.time - this.time; // descending order
    }
}

class User {
    int userId;
    Set<Integer> followees;
    List<Tweet> tweets;

    User(int userId) {
        this.userId = userId;
        followees = new HashSet<>();
        tweets = new LinkedList<>();
        follow(userId); // follow self by default
    }

    public void addTweet(Tweet t) {
        tweets.add(0, t);
    }

    public void follow(int followeeId) {
        followees.add(followeeId);
    }

    public void unfollow(int followeeId) {
        if (followeeId != this.userId) {
            followees.remove(followeeId);
        }
    }
}

class Twitter {
    Map<Integer, User> userMap;
    int timeStamp;

    public Twitter() {
        userMap = new HashMap<>();
        timeStamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        userMap.putIfAbsent(userId, new User(userId));
        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeStamp, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!userMap.containsKey(userId)) return result;

        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User user = userMap.get(userId);

        for (int followeeId : user.followees) {
            if (!userMap.containsKey(followeeId)) continue;
            List<Tweet> tweets = userMap.get(followeeId).tweets;
            int count = 0;
            for (Tweet tweet : tweets) {
                pq.offer(tweet);
                count++;
                if (count >= 10) break;
            }
        }

        int index = 0;
        while (!pq.isEmpty() && index < 10) {
            result.add(pq.poll().tweetId);
            index++;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */