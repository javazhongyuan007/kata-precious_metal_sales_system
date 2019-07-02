package com.coding.sales.member;

import com.sun.tools.javac.comp.Check;

public enum MemberType {

        General("普卡",0,1.0),
        Gold("金卡",10000,1.5),
        Platinum("白金卡",500000,1.8),
        Diamond("钻石卡",1000000,2.0);

        private String name;
        private int point;
        private double times;

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

        public double getTime() {
                return times;
        }

        public void setTime(double time) {
                this.times = time;
        }


        private MemberType(String name,int point,double times){
                this.name = name;
                this.point = point;
                this.times = times;
        }
}
