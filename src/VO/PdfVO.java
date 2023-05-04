package VO;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class PdfVO extends RecursiveTreeObject<PdfVO> {

    /*Todo los atributos*/
    int codigopdf;
    String nombrepdf;
    byte[] archivopdf;
    boolean di;
    boolean sge;
    boolean hlc;
    boolean pmm;
    boolean psp;
    boolean ad;
    boolean emp;

    public PdfVO() {
    }

    /*Todo los codigos get*/
    public int getCodigopdf() {
        return codigopdf;
    }

    public String getNombrepdf() {
        return nombrepdf;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }

    public boolean getDi(){return di;}

    public boolean getSge() {return sge;}

    public boolean getHlc() {return hlc;}

    public boolean getPmm() {return pmm;}

    public boolean getPsp() {return psp;}

    public boolean getAd() {return ad;}

    public boolean getEmp() {return emp;}

    /*Todo los codigos set*/
    public void setCodigopdf(int codigopdf) {
        this.codigopdf = codigopdf;
    }

    public void setNombrepdf(String nombrepdf) {
        this.nombrepdf = nombrepdf;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }
    public void setDi(boolean di){this.di = di;}
    public void setSge(boolean sge){this.sge = sge;}
    public void setHlc(boolean hlc){this.hlc = hlc;}
    public void setPmm(boolean pmm){this.pmm = pmm;}
    public void setPsp(boolean psp){this.psp = psp;}
    public void setAd(boolean ad){this.ad = ad;}
    public void setEmp(boolean emp){this.emp = pmm;}

}

