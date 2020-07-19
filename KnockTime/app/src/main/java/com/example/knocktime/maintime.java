package com.example.knocktime;

public class maintime {

    String maintitle;
    String maindesc;
    String maindate;


    public maintime() {
    }

    public maintime(String maintitle, String maindesc, String maindate) {
        this.maintitle = maintitle;
        this.maindesc = maindesc;
        this.maindate = maindate;
    }


    public String getMaintitle() {
        return maintitle;
    }

    public void setMaintitle(String maintitle) {
        this.maintitle = maintitle;
    }

    public String getMaindate() {
        return maindate;
    }

    public void setMaindate(String maindate) {

        this.maindate = maindate;
    }

    public String getMaindesc() {
        return maindesc;
    }

    public void setMaindesc(String maindesc) {

        this.maindesc = maindesc;
    }
}
