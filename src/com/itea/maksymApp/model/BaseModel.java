package com.itea.maksymApp.model;

import java.util.Objects;

public class BaseModel {
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    BaseModel(){

    }

    BaseModel(long id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseModel)) return false;
        BaseModel baseModel = (BaseModel) o;
        return getId() == baseModel.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}


