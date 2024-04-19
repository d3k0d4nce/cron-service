package ru.kishko.cron.services.Impl;

import ch.qos.logback.core.testUtil.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kishko.cron.entities.Data;
import ru.kishko.cron.repositories.DataRepository;
import ru.kishko.cron.services.DataService;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;

    @Override
    public void saveData() {
        dataRepository.save(
                Data.builder()
                        .value(RandomUtil.getPositiveInt())
                        .build()
        );
    }

}
