package com.hyejineee.design.adapter;

public class Main {
    public static void main(String[] args) {
        HairDryer h = new HairDryer();
        VacuumCleaner v = new VacuumCleaner();

        plugIn(h);

        Adapter adapter = new Adapter(v);
        plugIn(adapter);

//        콘센트에 꽂을 수 있는 v가 다르기 때문에 에러 발생 -> 어댑터가 필요한 시점
//        plugIn(v);
    }

    public static void plugIn(Electronic110v product){
        product.powerOn();
    }
}
