package com.coding.sales.member;

import java.util.logging.Level;

public class Member {

    private MemberCard memberCard;
    private Integer points;

    public Member(){
        this.memberCard = MemberCard.General;
        this.points = 0;
    }

    public Integer addPoints( Integer newPoint){
        this.points += newPoint;
        LevelUp(this.points);
        return this.points;
    }

    public void LevelUp(Integer points){

    }
}
