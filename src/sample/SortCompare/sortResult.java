package sample.SortCompare;

import java.util.ArrayList;

public class sortResult {
    String sortname;
    String sorttime;
    ArrayList<int[]> sortres = new ArrayList<>();

    public ArrayList<int[]> getSortres() {
        return this.sortres;
    }

    public void setSortres(ArrayList<int[]> sortres) {
        this.sortres = sortres;
    }

    public void setSorttime(String sorttime) {
        this.sorttime = sorttime;
    }

    public String getSorttime() {
        return this.sorttime;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getSortname() {
        return this.sortname;
    }
}
