package com.haebeach.foryouth.realty.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tb_lh_notice")
@Data
@Entity
@NoArgsConstructor
public class LhNoticeRes {

    @Id
    @Column(name = "seq")
    private int seq;            // 순번

    @Column(name = "link_url", length = 500)
    private String linkUrl;         // 공지사항상세URL

    @Column(name = "page", length = 10)
    private String page;            // 페이지번호

    @Column(name = "rnum", length = 10)
    private int rnum;

    @Column(name = "bbs_wou_dttm", length = 10)
    private String bbsWouDttm;      // 등록일

    @Column(name = "all_cnt", length = 10)
    private String allCnt;          // 전체조회건수

    @Column(name = "bbs_sn", length = 10)
    private String bbsSn;           // 번호

    @Column(name = "bbs_tl", length = 100)
    private String bbsTl;           // 제목

    @Column(name = "inq_cnt", length = 10)
    private String inqCnt;          // 조회수

    @Column(name = "ais_tp_cd_nm", length = 20)
    private String aisTpCdNm;       // 유형

    @Column(name = "ccr_cnnt_sys_ds_cd", length = 2)
    private String ccrCnntSysDsCd;  // 고객센터연계시스템구분코드

    @Column(name = "dep_nm", length = 100)
    private String depNm;           // 담당부서

    @Builder
    public LhNoticeRes(int seq, String linkUrl, String page, int rnum, String bbsWouDttm, String allCnt, String bbsSn, String bbsTl, String inqCnt, String aisTpCdNm, String ccrCnntSysDsCd, String depNm) {
        this.linkUrl = linkUrl;
        this.page = page;
        this.rnum = rnum;
        this.seq = seq;
        this.bbsWouDttm = bbsWouDttm;
        this.allCnt = allCnt;
        this.bbsSn = bbsSn;
        this.bbsTl = bbsTl;
        this.inqCnt = inqCnt;
        this.aisTpCdNm = aisTpCdNm;
        this.ccrCnntSysDsCd = ccrCnntSysDsCd;
        this.depNm = depNm;
    }
}
