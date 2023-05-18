package com.playdata.springbootproject.domain.pmntn;

import com.playdata.springbootproject.domain.AuditingEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Getter
@NoArgsConstructor
@Entity
public class Pmntn {

    @Id
    @Column(name = "pmntn_sn")
    private Integer pmntnSn;

    @Column(name = "mntn_code", columnDefinition = "TEXT", nullable=false)
    private String mntnCode;

    @Column(name="mntn_nm", columnDefinition = "TEXT")
    private String mntnNm;

    @Column(name = "pmntn_nm", columnDefinition = "TEXT", nullable=false)
    private String pmntnNm;

    @Column(name = "pmntn_main", length = 200, columnDefinition = "TEXT", nullable=false)
    private String pmntnMain;

    @Column(name = "pmntn_lt")
    private Double pmntnLt;

    @Column(name = "pmntn_dffl")
    private Integer pmntnDffl;

    @Column(name = "pmntn_tm")
    private Integer pmntnTm;

    @Column(name = "pmntn_risk", length = 200, columnDefinition = "TEXT")
    private String pmntnRisk;

    @Column(name = "pmntn_reco", length =1)
    private String pmntnReco;

    @Builder
    public Pmntn(Integer pmntnSn, String mntnCode, String mntnNm, String pmntnNm, String pmntnMain, Double pmntnLt, Integer pmntnDffl, Integer pmntnTm, String pmntnRisk, String pmntnReco) {
        this.pmntnSn = pmntnSn;
        this.mntnCode = mntnCode;
        this.mntnNm = mntnNm;
        this.pmntnNm = pmntnNm;
        this.pmntnMain = pmntnMain;
        this.pmntnLt = pmntnLt;
        this.pmntnDffl = pmntnDffl;
        this.pmntnTm = pmntnTm;
        this.pmntnRisk = pmntnRisk;
        this.pmntnReco = pmntnReco;
    }



}
