package com.coding.sales.data;

import com.coding.sales.member.Member;
import com.coding.sales.member.MemberType;

import java.util.HashMap;
import java.util.Map;

public class MembersData {

    public static Map<String,Member> memberMap = new HashMap<String, Member>();

     static {
        Member m1 = new Member();
        m1.setMemberName("马丁");
        m1.setOldMemberType(MemberType.General);
        m1.setNewMemberType(MemberType.General);
        m1.setMemberNo("6236609999");
        m1.setMemberPoints(9860);
        Member m2 = new Member();
        m2.setMemberName("王立");
        m2.setOldMemberType(MemberType.Gold);
        m2.setNewMemberType(MemberType.Gold);
        m2.setMemberNo("6630009999");
        m2.setMemberPoints(48860);
        Member m3 = new Member();
        m3.setMemberName("李想");
        m3.setOldMemberType(MemberType.Platinum);
        m3.setNewMemberType(MemberType.Platinum);
        m3.setMemberNo("8230009999");
        m3.setMemberPoints(98860);
        Member m4 = new Member();
        m4.setMemberName("张三");
        m4.setOldMemberType(MemberType.Diamond);
        m4.setNewMemberType(MemberType.Diamond);
        m4.setMemberNo("9230009999");
        m4.setMemberPoints(198860);
        memberMap.put(m1.getMemberNo(), m1);
        memberMap.put(m2.getMemberNo(), m2);
        memberMap.put(m3.getMemberNo(), m3);
        memberMap.put(m4.getMemberNo(), m4);
    }
}
