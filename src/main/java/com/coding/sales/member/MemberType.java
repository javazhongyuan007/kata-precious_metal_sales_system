package com.coding.sales.member;

import java.math.BigDecimal;

public enum MemberType {

        General("普卡",0,new BigDecimal(1.0)),
        Gold("金卡",10000,new BigDecimal(1.5)),
        Platinum("白金卡",50000,new BigDecimal(1.8)),
        Diamond("钻石卡",100000,new BigDecimal(2));

        private String name;
        private int point;
        private BigDecimal times;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getPoint() {
                return point;
        }

        public void setPoint(int point) {
                this.point = point;
        }

        public BigDecimal getTime() {
                return times;
        }

        public void setTime(BigDecimal time) {
                this.times = time;
        }


        private MemberType(String name,int point,BigDecimal times){
                this.name = name;
                this.point = point;
                this.times = times;
        }
}
