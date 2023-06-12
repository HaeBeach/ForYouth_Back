package com.haebeach.foryouth.realty.repository;

import com.haebeach.foryouth.realty.entity.ShNoticeRes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShNoticeResRepository extends JpaRepository<ShNoticeRes, Long> {

    List<ShNoticeRes> findAllByRnumBetween(int startSeq, int endSeq);

}
