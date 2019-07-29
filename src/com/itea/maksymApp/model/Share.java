package com.itea.maksymApp.model;

import java.math.BigDecimal;

public class Share extends BaseModel {
    private String name;
    private int changeProbability;
    private BigDecimal satrtPrice;
    private int delta;

    public Share() {}

    public Share(long id, String name, int changeProbability, int delta) {
        super(id);
        this.name = name;
        this.changeProbability = changeProbability;
        this.delta = delta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChangeProbability() {
        return changeProbability;
    }

    public void setChangeProbability(int changeProbability) {
        this.changeProbability = changeProbability;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }
}