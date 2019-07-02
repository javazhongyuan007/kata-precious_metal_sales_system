package com.coding.sales.member;

import com.coding.sales.discount.DiscountCard;
import sun.tools.tree.IfStatement;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class Member {

    private String memberNo;
    private String memberName;
    private MemberType oldMemberType;
    private MemberType newMemberType;
    private int memberPointsIncreased;
    private int memberPoints;
    private List<DiscountCard> discountCards;
    private Map<String,Integer> memberTypePoint;

    public Member(){
        this.oldMemberType = MemberType.General;
        this.newMemberType = MemberType.General;
        this.memberPoints = 0;
    }

    public void addPoints( int memberPointsIncreased){
        this.memberPointsIncreased = memberPointsIncreased;
        this.memberPoints += memberPointsIncreased;
        checkLevel();
    }

    public void checkLevel(){
        this.oldMemberType = this.newMemberType;
        MemberType [] memberTypes = MemberType.values();
        for (int i = memberTypes.length-1;i>=0;i--){
            if (this.memberPoints>=memberTypes[i].getPoint()){
                this.newMemberType = memberTypes[i];
                return;
            }
        }
    }
}
