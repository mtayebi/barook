package com.barook.accountservice.scheduledtasks;

import ch.qos.logback.core.util.FixedDelay;
import com.barook.accountservice.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MonitorTransactions {

    private final static Logger logger = LoggerFactory.getLogger(MonitorTransactions.class);

    TransactionService transactionService;

    public MonitorTransactions(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Scheduled(cron = "0 0 12 * * ?") // Fire at 12:00 PM every day
    public void DailyAmountOfTransactions(){
        Double result = transactionService.getTotalTransactionAmount();
        logger.info("The total value of transactions is: {}", result == null ? 0 : result);
    }


}
