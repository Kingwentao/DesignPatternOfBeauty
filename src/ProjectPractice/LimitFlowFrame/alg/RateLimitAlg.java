package ProjectPractice.LimitFlowFrame.alg;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: WentaoKing
 * created on: 2020/6/3
 * description: 限流规则算法
 * 实现了最简单的固定时间窗口限流算法。
 * 每个接口都要在内存中对应一个 RateLimitAlg 对象，记录在当前时间窗口内已经被访问的次数
 */
public class RateLimitAlg {

    private static final long TRY_LOCK_TIMEOUT = 200L; // 200ms.
    private StopWatch stopwatch;
    private AtomicInteger currentCount = new AtomicInteger(0);
    private final int limit;
    private Lock lock = new ReentrantLock();

    public RateLimitAlg(int limit) {
        this(limit, StopWatch.createStarted());
    }

    protected RateLimitAlg(int limit, StopWatch stopwatch) {
        this.limit = limit;
        this.stopwatch = stopwatch;
    }

    public boolean tryAcquire() throws InternalException {
        int updatedCount = currentCount.incrementAndGet();
        if (updatedCount <= limit) {
            return true;
        }
        try {
            if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
                try {
                    if (stopwatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.SECONDS.toMillis(1)) {
                        currentCount.set(0);
                        stopwatch.reset();
                    }
                    updatedCount = currentCount.incrementAndGet();
                    return updatedCount <= limit
                } finally {
                    lock.unlock();
                }
            } else {
                throw new InternalException("tryAcquire() wait lock too long:" + TRY_LOCK_TIMEOUT + "ms");
            }
        } catch (InternalException | InterruptedException e) {
            throw new InternalException("tryAcquire() is interrupted by lock-time-out.");
        }
    }
}
