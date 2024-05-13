package Model;

public class MainActivityModel {
    private int h;
    private int min;
    private int s;
    public int getHoras() {
        return h;
    }
    public void setHoras(int horas) {
        this.h = horas;
    }
    public int getMinutos() {
        return min;
    }
    public void setMinutos(int minutos) {
        this.min = minutos;
    }
    public int getSegundos() {
        return s;
    }
    public void setSegundos(int segundos) {
        this.s = segundos;
    }
    public MainActivityModel(String atleta, int minUno, int sUno, int minDos, int sDos) {
        int totalMin = minUno + minDos;
        int totalS = sUno + sDos;
        if (totalS >= 60) {
            totalMin += totalS / 60;
            totalS %= 60;
        }
        this.h = totalMin / 60;
        this.min = totalMin % 60;
        this.s = totalS;
    }
    public String calcular() {
        return "TIEMPO TOTAL \n" + h + "h \n" + min + "min \n" + s + "s";
    }
}
