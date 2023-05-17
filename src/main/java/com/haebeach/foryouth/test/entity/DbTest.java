package com.haebeach.foryouth.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Table(name = "tb_db_test")
@Data
@Entity
public class DbTest {

    @Id
    @Column(name = "seq")
    private int seq;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "first_cret_dt", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date firstCretDt;

    @Column(name = "last_chg_dt", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastChgDt;

}
