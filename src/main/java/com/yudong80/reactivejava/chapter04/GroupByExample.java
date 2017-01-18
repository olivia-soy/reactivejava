package com.yudong80.reactivejava.chapter04;

import com.yudong80.reactivejava.common.CommonUtils;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class GroupByExample {
	public void basic() { 
		String[] objs = {"PUPPLE", "SKY", "YELLOW-T", "YELLOW", "PUPPLE-T", "SKY-T"};
		Observable<GroupedObservable<String, String>> source = 
				Observable.fromArray(objs)
				.groupBy(CommonUtils::getShape);
		
		source.subscribe(obj -> {
			obj.subscribe(val -> 
			System.out.println("GROUP:" + obj.getKey() + "\t Value:" + val));
		});
		CommonUtils.exampleComplete();
	}
	
	public void filterBallGroup() { 
		String[] objs = {"PUPPLE", "SKY", "YELLOW-T", "YELLOW", "PUPPLE-T", "SKY-T"};
		Observable<GroupedObservable<String, String>> source = 
				Observable.fromArray(objs)
				.groupBy(CommonUtils::getShape);
		
		source.subscribe(obj -> {
			obj.filter(val -> obj.getKey().equals("BALL"))
			.subscribe(val -> 
			System.out.println("GROUP:" + obj.getKey() + "\t Value:" + val));
		});	
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) { 
		GroupByExample demo = new GroupByExample();
		demo.basic();
		demo.filterBallGroup();
	}
}
