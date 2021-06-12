package org.example;

public class ModelTable {
    int klient_id,pesel,numerDomu;
    String nazwisko,imie,miejscowosc,ulica;

    public ModelTable(int klient_id, String nazwisko, String imie, int pesel, String miejscowosc, String ulica, int numerDomu) {
        this.klient_id = klient_id;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pesel = pesel;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
    }

    public int getKlient_id() {
        return klient_id;
    }

    public void setKlient_id(int klient_id) {
        this.klient_id = klient_id;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public int getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(int numerDomu) {
        this.numerDomu = numerDomu;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }
}
