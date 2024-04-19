package ru.kishko.cron.services.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import ru.kishko.cron.services.DataService;
import ru.kishko.cron.services.ScheduledService;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ScheduledServiceImpl implements ScheduledService {

    private final StringRedisTemplate redisTemplate;
    private final DataService dataService;

    @Override
    public void script() {
        if (Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent("mutex", "LOCKED"))) {

            System.out.println("Lock acquired. Proceed with your work.");
            dataService.saveData();

            // Устанавливаем время жизни ключа "mutex" в 5 секунд
            redisTemplate.expire("mutex", 5, TimeUnit.SECONDS);
        } else {
            System.out.println("Another instance has the lock. Exiting.");
        }
    }



}
