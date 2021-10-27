package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka, krajnjaTacka;
    private boolean pocTackaPripada, krajTackaPripada;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocTackaPripada, boolean krajTackaPripada) {
        if (krajnjaTacka < pocetnaTacka) {
            throw new IllegalArgumentException("Krajnja tacka veca od pocetne");
        }

        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pocTackaPripada = pocTackaPripada;
        this.krajTackaPripada = krajTackaPripada;

    }

    public Interval() {
        pocetnaTacka = 0;
        krajnjaTacka = 0;
        pocTackaPripada = false;
        krajTackaPripada = false;
    }

    public double getPocetak() {
        return pocetnaTacka;
    }

    public double getKraj() {
        return krajnjaTacka;
    }

    public boolean getPocPripada() {
        return pocTackaPripada;
    }

    public boolean getKrajPripada() {
        return krajTackaPripada;
    }

    public boolean isNull() {
        if (pocetnaTacka == 0 &&
                krajnjaTacka == 0 &&
                pocTackaPripada == false &&
                krajTackaPripada == false) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isIn(double tacka) {
        if (((pocTackaPripada && tacka >= pocetnaTacka) || (!pocTackaPripada && tacka > pocetnaTacka)) && ((krajTackaPripada && tacka <= krajnjaTacka) || (!krajTackaPripada && tacka < krajnjaTacka))) {
            return true;
        } else {
            return false;
        }
    }

    public Interval intersect(Interval int2) {
        double noviPocetak, noviKraj;
        boolean noviPocJeUklj, noviKrajJeUklj;

        if (pocetnaTacka > int2.getPocetak()) {
            noviPocetak = pocetnaTacka;
            noviPocJeUklj = pocTackaPripada;
        } else {
            noviPocetak = int2.getPocetak();
            noviPocJeUklj = int2.getPocPripada();
        }

        if (krajnjaTacka < int2.getKraj()) {
            noviKraj = krajnjaTacka;
            noviKrajJeUklj = krajTackaPripada;
        } else {
            noviKraj = int2.getKraj();
            noviKrajJeUklj = int2.getKrajPripada();
        }

        return new Interval(noviPocetak, noviKraj, noviPocJeUklj, noviKrajJeUklj);
    }

    public static Interval intersect(Interval interval1, Interval interval2) {
        double noviPocetak, noviKraj;
        boolean noviPocJeUklj, noviKrajJeUklj;

        if (interval1.getPocetak() > interval2.getPocetak()) {
            noviPocetak = interval1.getPocetak();
            noviPocJeUklj = interval1.getPocPripada();
        } else {
            noviPocetak = interval2.getPocetak();
            noviPocJeUklj = interval1.getPocPripada();
        }

        if (interval1.getKraj() < interval2.getKraj()) {
            noviKraj = interval1.getKraj();
            noviKrajJeUklj = interval1.getKrajPripada();
        } else {
            noviKraj = interval2.getKraj();
            noviKrajJeUklj = interval2.getKrajPripada();
        }

        return new Interval(noviPocetak, noviKraj, noviPocJeUklj, noviKrajJeUklj);
    }

    @Override
    public String toString() {
        if (this.isNull()) {
            return "()";
        }

        String genStr = "";

        if (pocTackaPripada) {
            genStr = genStr + "[";
        } else {
            genStr = genStr + "(";
        }

        genStr = genStr + pocetnaTacka + "," + krajnjaTacka;

        if (krajTackaPripada) {
            genStr = genStr + "]";
        } else {
            genStr = genStr + ")";
        }

        return genStr;
    }
}
