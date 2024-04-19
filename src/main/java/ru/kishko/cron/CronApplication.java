package ru.kishko.cron;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kishko.cron.services.Impl.ScheduledServiceImpl;

@SpringBootApplication
@RequiredArgsConstructor
public class CronApplication implements CommandLineRunner {
    private final ScheduledServiceImpl scheduledService;

    public static void main(String[] args) {
        SpringApplication.run(CronApplication.class, args);
    }

    @Override
    public void run(String... args) {
        scheduledService.script();
    }
}