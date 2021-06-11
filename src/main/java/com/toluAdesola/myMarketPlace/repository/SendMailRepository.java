package com.toluAdesola.myMarketPlace.repository;

import com.toluAdesola.myMarketPlace.model.SendMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendMailRepository extends JpaRepository<SendMail, Long> {
    SendMail findAllByCompanyId(Long id);
}
