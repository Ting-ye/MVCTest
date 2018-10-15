package com.dy.pojo;

import java.util.List;

public class DemoLi {
    @Override
    public String toString() {
        return "DemoLi{" +
                "peo=" + peo +
                '}';
    }

    public List<People> getPeo() {
        return peo;
    }

    public void setPeo(List<People> peo) {
        this.peo = peo;
    }

    private List<People> peo;
}
