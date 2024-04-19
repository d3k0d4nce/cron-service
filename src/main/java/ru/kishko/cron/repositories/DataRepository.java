package ru.kishko.cron.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kishko.cron.entities.Data;

public interface DataRepository extends JpaRepository<Data, Long> {
}
