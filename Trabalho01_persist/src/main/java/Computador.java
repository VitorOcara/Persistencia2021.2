public class Computador {
    private String gabinete, placaMae, placaDeVideo, processador, hd, ram;

    public Computador(String gabinete, String placaMae, String placaDeVideo, String processador, String hd, String ram) {
        this.gabinete = gabinete;
        this.placaMae = placaMae;
        this.placaDeVideo = placaDeVideo;
        this.processador = processador;
        this.hd = hd;
        this.ram = ram;
    }
    public Computador(){
    }

    @Override
    public String toString() {
        return "Computador{" +
                "gabinete='" + gabinete + '\'' +
                ", placaMae='" + placaMae + '\'' +
                ", placaDeVideo='" + placaDeVideo + '\'' +
                ", processador='" + processador + '\'' +
                ", hd='" + hd + '\'' +
                ", ram='" + ram + '\'' +
                '}';
    }

    public String getGabinete() {
        return gabinete;
    }

    public void setGabinete(String gabinete) {
        this.gabinete = gabinete;
    }

    public String getPlacaMae() {
        return placaMae;
    }

    public void setPlacaMae(String placaMae) {
        this.placaMae = placaMae;
    }

    public String getPlacaDeVideo() {
        return placaDeVideo;
    }

    public void setPlacaDeVideo(String placaDeVideo) {
        this.placaDeVideo = placaDeVideo;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
