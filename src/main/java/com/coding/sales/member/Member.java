package com.coding.sales.member;

import com.coding.sales.discount.DiscountCard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Member {
    private String memberNo;
    private String memberName;
    private MemberType oldMemberType;
    private MemberType newMemberType;
    private int memberPointsIncreased;
    private int memberPoints;
    private List<DiscountCard> discountCards;

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public MemberType getOldMemberType() {
        return oldMemberType;
    }

    public void setOldMemberType(MemberType oldMemberType) {
        this.oldMemberType = oldMemberType;
    }

    public MemberType getNewMemberType() {
        return newMemberType;
    }

    public void setNewMemberType(MemberType newMemberType) {
        this.newMemberType = newMemberType;
    }

    public int getMemberPointsIncreased() {
        return memberPointsIncreased;
    }

    public void setMemberPointsIncreased(int memberPointsIncreased) {
        this.memberPointsIncreased = memberPointsIncreased;
    }

    public int getMemberPoints() {
        return memberPoints;
    }

    public void setMemberPoints(int memberPoints) {
        this.memberPoints = memberPoints;
    }

    public List<DiscountCard> getDiscountCards() {
        return discountCards;
    }

    public void setDiscountCards(List<DiscountCard> discountCards) {
        this.discountCards = discountCards;
    }

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
