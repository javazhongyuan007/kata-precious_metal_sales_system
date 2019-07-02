package com.coding.sales.member;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {

    @Test
    public void should_return_gold_addPoints_from_0_to_10000() {
        Member member = new Member();
        member.addPoints(10000);
        Assert.assertEquals( "金卡",member.getNewMemberType().getName());
    }

    @Test
    public void should_return_geneal_old_from_0_to_10000() {
        Member member = new Member();
        member.addPoints(10000);
        Assert.assertEquals( "普卡",member.getOldMemberType().getName());
    }

    @Test
    public void should_return_Platinum_addPoints_from_0_to_50000() {
        Member member = new Member();
        member.addPoints(50000);
        Assert.assertEquals("白金卡",member.getNewMemberType().getName());
    }

    @Test
    public void should_return_Diamon_addPoints_from_0_to_100000() {
        Member member = new Member();
        member.addPoints(100000);
        Assert.assertEquals("钻石卡",member.getNewMemberType().getName());
    }

    @Test
    public void should_return_Diamon_addPoints_from_10000_to_100000() {
        Member member = new Member();
        member.addPoints(100000);
        Assert.assertEquals("钻石卡",member.getNewMemberType().getName());
    }

    @Test
    public void should_return_Diamon_old_addPoints_from_10000_to_100000() {
        Member member = new Member();
        member.addPoints(10000);
        member.addPoints(100000);
        Assert.assertEquals("金卡",member.getOldMemberType().getName());
    }
}