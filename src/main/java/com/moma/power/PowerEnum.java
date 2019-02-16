package com.moma.power;

public enum PowerEnum {
    LEVEL_SON(8),
    LEVEL_FATHER(7758258);

    private Integer level;

    PowerEnum(Integer level){
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
