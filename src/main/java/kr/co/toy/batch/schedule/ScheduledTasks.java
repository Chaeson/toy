package kr.co.toy.batch.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class ScheduledTasks {

    //@Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        log.info("This Time: {}", new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
}
