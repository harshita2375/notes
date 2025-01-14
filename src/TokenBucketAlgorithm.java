import java.util.concurrent.TimeUnit;

public class TokenBucket {
    private final long capacity;
    private final long refillTokens;
    private final long refillIntervalInMillis;
    private long currentTokens;
    private long lastRefillTimestamp;

    public TokenBucket(long capacity, long refillTokens, long refillIntervalInMillis) {
        this.capacity = capacity;
        this.refillTokens = refillTokens;
        this.refillIntervalInMillis = refillIntervalInMillis;
        this.currentTokens = capacity;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest(int tokens) {
        refill();
        if (currentTokens >= tokens) {
            currentTokens -= tokens;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        if (now > lastRefillTimestamp) {
            long elapsedTime = now - lastRefillTimestamp;
            long tokensToAdd = (elapsedTime / refillIntervalInMillis) * refillTokens;
            currentTokens = Math.min(capacity, currentTokens + tokensToAdd);
            lastRefillTimestamp = now;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket = new TokenBucket(10, 1, TimeUnit.SECONDS.toMillis(1));

        // Simulate requests
        for (int i = 0; i < 15; i++) {
            if (tokenBucket.allowRequest(1)) {
                System.out.println("Request " + i + " allowed.");
            } else {
                System.out.println("Request " + i + " denied.");
            }
            Thread.sleep(200); // 200ms between requests
        }
    }
}