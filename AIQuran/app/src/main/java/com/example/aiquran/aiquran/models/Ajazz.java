package com.example.aiquran.aiquran.models;

import java.io.Serializable;

public class Ajazz implements Serializable {
    private String joza;
    private String hezbTop;
    private String hezbBottom;
    private String top14;
    private String top12;
    private String top34;
    private String bottom14;
    private String bottom12;
    private String bottom34;

    public Ajazz(String joza, String hezbTop, String hezbBottom, String top14, String top12, String top34, String bottom14, String bottom12, String bottom34) {
        this.joza = joza;
        this.hezbTop = hezbTop;
        this.hezbBottom = hezbBottom;
        this.top14 = top14;
        this.top12 = top12;
        this.top34 = top34;
        this.bottom14 = bottom14;
        this.bottom12 = bottom12;
        this.bottom34 = bottom34;
    }

    public String getJoza() {
        return joza;
    }

    public void setJoza(String joza) {
        this.joza = joza;
    }

    public String getHezbTop() {
        return hezbTop;
    }

    public void setHezbTop(String hezbTop) {
        this.hezbTop = hezbTop;
    }

    public String getHeznBottom() {
        return hezbBottom;
    }

    public void setHeznBottom(String heznBottom) {
        this.hezbBottom = heznBottom;
    }

    public String getTop14() {
        return top14;
    }

    public void setTop14(String top14) {
        this.top14 = top14;
    }

    public String getTop12() {
        return top12;
    }

    public void setTop12(String top12) {
        this.top12 = top12;
    }

    public String getTop34() {
        return top34;
    }

    public void setTop34(String top34) {
        this.top34 = top34;
    }

    public String getBottom14() {
        return bottom14;
    }

    public void setBottom14(String bottom14) {
        this.bottom14 = bottom14;
    }

    public String getBottom12() {
        return bottom12;
    }

    public void setBottom12(String bottom12) {
        this.bottom12 = bottom12;
    }

    public String getBottom34() {
        return bottom34;
    }

    public void setBottom34(String bottom34) {
        this.bottom34 = bottom34;
    }
}
