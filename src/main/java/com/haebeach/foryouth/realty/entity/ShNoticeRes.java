package com.haebeach.foryouth.realty.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "tb_sh_notice")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ShNoticeRes {

    @Id
    @Column(name = "seq")
    private int seq;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "dep_nm", length = 100)
    private String depNm;

    @Column(name = "first_cret_dt")
    private Date firstCretDt;

    @Column(name = "inq_cnt")
    private int inqCnt;

    @Column(name = "rnum")
    private int rnum;

    @Column(name = "all_cnt", length = 10)
    private String allCnt;

}
