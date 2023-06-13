package edu.wat.tim.lab2.repository;

import edu.wat.tim.lab2.model.KlientEntity;
import edu.wat.tim.lab2.model.KomentarzEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KomentarzEntityRepository extends JpaRepository<KomentarzEntity, Long> {

    // Dostępne słowa kluczowe https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords

}
