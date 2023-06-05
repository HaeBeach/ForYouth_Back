package com.haebeach.foryouth.realty.repository;

import com.haebeach.foryouth.realty.entity.LhNoticeRes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LhNoticeResRepository extends JpaRepository<LhNoticeRes, Long> {

    List<LhNoticeRes> findAllByRnumBetween(int startSeq, int endSeq);

}
