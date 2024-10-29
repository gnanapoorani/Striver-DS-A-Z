package SystemDesign;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class ConsistentHashing {

    // Consistent Hashing with Ring having 50 buckets.
    final static int LIMIT = 50;

    // Sorted Map.
    final static SortedMap<Integer, String> bucketIdToServer = new TreeMap<>();

    public static void main(String[] args) throws InterruptedException {

        // Hash function to calculate hashes for serverId and the userId.
        final HashFunction hashFunction = new HashFunction(61, 59);

        // Setup the servers
        for (int i = 1; i <= 10; i++) {
            final String server = "Server : " + i;
            // Can be situation of hash collision, which would override the previous server. Else again hash with some other function.
            bucketIdToServer.put(hashFunction.getHashValue(server), server);
        }

        // Load balancer assigning the users to specific server.
        Thread loadBalancerAssigningUsersToParticularServer = new Thread(new LoadBalancerTask(bucketIdToServer, hashFunction));

        loadBalancerAssigningUsersToParticularServer.start();

        loadBalancerAssigningUsersToParticularServer.join();

    }

    public static class HashFunction {

        private long prime;
        private long odd;

        public HashFunction(final long prime, final long odd) {
            this.prime = prime;
            this.odd = odd;
        }

        public int getHashValue(final String word) {
            int hash = word.hashCode();
            if (hash < 0) {
                hash = Math.abs(hash);
            }
            return calculateHash(hash, prime, odd);
        }

        private int calculateHash(final int hash, final long prime, final long odd) {
            return (int)((((hash % LIMIT) * prime) % LIMIT) * odd) % LIMIT;
        }

    }
}

 class LoadBalancerTask implements Runnable {

    final SortedMap<Integer, String> bucketIdToServer;
    final ConsistentHashing.HashFunction hashFunction;

    public LoadBalancerTask(final SortedMap<Integer, String> bucketIdToServer, final ConsistentHashing.HashFunction hashFunction) {
        this.bucketIdToServer = bucketIdToServer;
        this.hashFunction = hashFunction;
    }

    @Override
    public void run() {

        while (true) {
            final int randomUserId = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
            final int userBucket = hashFunction.getHashValue(String.valueOf(randomUserId));

            final SortedMap<Integer,String> mapViewWithKeyGreaterThanUserBucket = bucketIdToServer.tailMap(userBucket);

            final Integer bucketIdWhichWillHandleTheUser = mapViewWithKeyGreaterThanUserBucket.isEmpty() ?
                    bucketIdToServer.firstKey() : mapViewWithKeyGreaterThanUserBucket.firstKey();

            final String serverWhichWillHandleTheUser = bucketIdToServer.get(bucketIdWhichWillHandleTheUser);

            System.out.println("--------------------------------------------------------------------------");

            System.out.println("random user id : "+ randomUserId +" user bucket : "+userBucket);
            System.out.println("User ID : " + randomUserId + " has been assigned to " + serverWhichWillHandleTheUser);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
