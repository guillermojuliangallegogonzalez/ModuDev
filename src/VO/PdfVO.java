package VO;

public class PdfVO {

    /*Todo los atributos*/
    int codigopdf;
    String nombrepdf;
    byte[] archivopdf;
    String asignaturapdf;

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

    public String getAsignaturapdf(){
        return asignaturapdf;
    }


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

    public void setAsignaturapdf(String asignaturapdf){
        this.asignaturapdf = asignaturapdf;
    }

}

