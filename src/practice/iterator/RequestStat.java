package practice.iterator;

/**
 * author: WentaoKing
 * created on: 2020/1/2
 * description:
 */
public class RequestStat {
    private double maxResponseTime;
    private double minResponseTime;
    private double avgResponseTime;

    public double getMaxResponseTime() {
        return maxResponseTime;
    }

    public RequestStat setMaxResponseTime(double maxResponseTime) {
        this.maxResponseTime = maxResponseTime;
        return this;
    }

    public double getMinResponseTime() {
        return minResponseTime;
    }

    public RequestStat setMinResponseTime(double minResponseTime) {
        this.minResponseTime = minResponseTime;
        return this;
    }

    public double getAvgResponseTime() {
        return avgResponseTime;
    }

    public RequestStat setAvgResponseTime(double avgResponseTime) {
        this.avgResponseTime = avgResponseTime;
        return this;
    }

    public double getP999ResponseTime() {
        return p999ResponseTime;
    }

    public RequestStat setP999ResponseTime(double p999ResponseTime) {
        this.p999ResponseTime = p999ResponseTime;
        return this;
    }

    public double getP99ResponseTime() {
        return p99ResponseTime;
    }

    public RequestStat setP99ResponseTime(double p99ResponseTime) {
        this.p99ResponseTime = p99ResponseTime;
        return this;
    }

    public long getCount() {
        return count;
    }

    public RequestStat setCount(long count) {
        this.count = count;
        return this;
    }

    public long getTps() {
        return tps;
    }

    public RequestStat setTps(long tps) {
        this.tps = tps;
        return this;
    }

    private double p999ResponseTime;
    private double p99ResponseTime;
    private long count;
    private long tps;
}
