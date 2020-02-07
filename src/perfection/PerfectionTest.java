package perfection;

import practice.iterator.MetricsCollector;
import practice.iterator.MetricsStorage;
import practice.iterator.RedisMetricsStorage;
import practice.iterator.RequestInfo;

/**
 * Created by WenTaoKing on 2020/2/7
 * description: 运用学过的设计原则和思想重构之前讲的性能计数器项目
 */
public class PerfectionTest {

    public static void main(String[] args) {
        MetricsStorage metricsStorage = new RedisMetricsStorage();
        Aggregator aggregator = new Aggregator();

        // 定时触发统计并将结果显示到终端
        ConsoleViewer consoleViewer = new ConsoleViewer();
        ConsoleReporter consoleReporter = new ConsoleReporter(metricsStorage, aggregator, consoleViewer);
        consoleReporter.startRepeatedReport(1, 1);

        //定时触发统计并将结果输出到邮件
        EmailViewer emailViewer = new EmailViewer();
        emailViewer.addToAddress("wentaoking@qq.com");
        EmailReporter emailReporter = new EmailReporter(metricsStorage, aggregator, emailViewer);
        emailReporter.startDailyReport();

        // 收集接口访问数据
        MetricsCollector collector = new MetricsCollector(metricsStorage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


// Note:
  /*    1.Aggregator 类从一个只包含一个静态函数的工具类，变成了一个普通的聚合统计类。
        现在，我们可以通过依赖注入的方式，将其组装进 ConsoleReporter 和 EmailReporter 类中，这样就更加容易编写单元测试。

        2.Aggregator 类在重构前，所有的逻辑都集中在 aggregate()函数内，代码行数较多，
        代码的可读性和可维护性较差。在重构之后，我们将每个统计逻辑拆分成独立的函数，aggregate()函数变得比较单薄，可读性提高了。
        尽管我们要添加新的统计功能，还是要修改 aggregate()函数，但现在的 aggregate()函数代码行数很少，结构非常清晰，修改起来更加容易，可维护性提高。
        3.目前来看，Aggregator 的设计还算合理。但是，如果随着更多的统计功能的加入，Aggregator 类的代码会越来越多。

        这个时候，我们可以将统计函数剥离出来，设计成独立的类，以解决 Aggregator 类的无限膨胀问题。
        不过，暂时来说没有必要这么做，毕竟将每个统计函数独立成类，会增加类的个数，也会影响到代码的可读性和可维护性。*/