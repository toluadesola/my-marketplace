package com.example.week8tasktoluadesola.repository;

import com.example.week8tasktoluadesola.model.SendMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendMailRepository extends JpaRepository<SendMail, Long> {
    SendMail findAllByCompanyId(Long id);
}
