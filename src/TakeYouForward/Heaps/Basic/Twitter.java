package TakeYouForward.Heaps.Basic;

import java.util.*;

/*** Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
public class Twitter {

    static Map<Integer, List<Integer>> followerList = new HashMap<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));

    public Twitter() {

    }

    public static void main(String[] args) {
        postTweet(12, 1);
        List<Integer> param_2 = getNewsFeed(12);
        follow(23, 12);
        unfollow(23, 234);
    }

    public static void postTweet(int userId, int tweetId) {
        pq.offer(new int[]{userId, tweetId});
    }

    public static List<Integer> getNewsFeed(int userId) {
        List<Integer> recentPost= new ArrayList<>();
        if (followerList.containsKey(userId)) {
            List<Integer> d = followerList.get(userId);

        }
        return recentPost;
    }

    public static void follow(int followerId, int followeeId) {
        if (followerList.containsKey(followeeId)) {
            List<Integer> followers = followerList.get(followeeId);
            followers.add(followerId);
            followerList.put(followeeId, followers);
        } else {
            List<Integer> followers = new ArrayList<>();
            followers.add(followerId);
            followerList.put(followeeId, followers);
        }
    }

    public static void unfollow(int followerId, int followeeId) {
        if (followerList.containsKey(followeeId)) {
            List<Integer> followers = followerList.get(followeeId);
            followers.remove(followerId);
            followerList.put(followeeId, followers);
        }
    }
}