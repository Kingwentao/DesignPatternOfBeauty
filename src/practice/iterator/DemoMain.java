package practice.iterator;

/**
 * author: WentaoKing
 * created on: 2020/1/2
 * description:
 */
public class DemoMain {
    public static void main(String[] args) {
        MetricsStorage metricsStorage = new RedisMetricsStorage();
        MetricsCollector collector = new MetricsCollector(metricsStorage);
        ConsoleReporter consoleReporter = new ConsoleReporter(metricsStorage);
        consoleReporter.startRepeatedReport(60, 60);

        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


