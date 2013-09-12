package com.ara.gprider.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class Test {
	public static void main(String[] args) {
		
		
		List<BigDecimal> lists = new ArrayList<BigDecimal>();
		lists.add(new BigDecimal(10));
		lists.add(new BigDecimal(15));
		lists.add(null);
		
		BigDecimal bd = new BigDecimal(0);
		for (int i = 0; i < lists.size(); i++) {
			bd = lists.get(i);
			if(bd == null){
				bd = BigDecimal.ZERO;
			}
			if(bd.compareTo(new BigDecimal(10)) == 0){
				System.out.println("simpan");
			}else{
				System.out.println("tidak disimpan");
			}
		}
	}
}
