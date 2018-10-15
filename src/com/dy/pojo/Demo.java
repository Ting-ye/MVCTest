package com.dy.pojo;

public class Demo {
    private People peo;
    @Override
    public String toString() {
        return "Demo{" +
                "peo=" + peo +
                '}';
    }

    public People getPeo() {
        return peo;
    }

    public void setPeo(People peo) {
        this.peo = peo;
    }



}
