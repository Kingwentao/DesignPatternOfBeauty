package perfection;

import practice.iterator.RequestStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by WenTaoKing on 2020/2/7
 * description: email 控制台view
 */
public class EmailViewer implements StatViewer {
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailSender(/*省略参数*/);
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public EmailViewer(List<String> emailAddress){
        toAddresses.addAll(emailAddress);
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        System.out.println("send email...");
    }
}
