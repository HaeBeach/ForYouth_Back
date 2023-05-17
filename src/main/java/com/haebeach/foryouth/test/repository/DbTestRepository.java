package com.haebeach.foryouth.test.repository;

import com.haebeach.foryouth.test.entity.DbTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbTestRepository extends JpaRepository<DbTest, Long> {

    DbTest findBySeq(int seq);

}
