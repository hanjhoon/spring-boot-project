package com.playdata.springbootproject.web.dto;

import com.playdata.springbootproject.domain.pmntn.Pmntn;
import lombok.Getter;

@Getter
public class PmntnResponseDto {
    private Integer pmntnSn;
    private String mntnCode;

    private String mntnNm;
    private String pmntnNm;
    private String pmntnMain;
    private Double pmntnLt;
    private Integer pmntnDffl;
    private Integer pmntnTm;
    private String pmntnRisk;
    private String pmntnReco;

    public PmntnResponseDto(Pmntn entity) {
        this.pmntnSn = entity.getPmntnSn();
        this.mntnCode = entity.getMntnCode();
        this.mntnNm = entity.getMntnNm();
        this.pmntnNm = entity.getPmntnNm();
        this.pmntnMain = entity.getPmntnMain();
        this.pmntnLt = entity.getPmntnLt();
        this.pmntnDffl = entity.getPmntnDffl();
        this.pmntnTm = entity.getPmntnTm();
        this.pmntnRisk = entity.getPmntnRisk();
        this.pmntnReco = entity.getPmntnReco();
    }
}
