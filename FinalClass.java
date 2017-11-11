package com.immutable;

import java.util.HashMap;
import java.util.Iterator;

public final class FinalClass {
	
	private final int id;
	private final String str;
	private final MutableReferenceInFinalClass mutable;
	private final HashMap<String, String> hashMap;
	public int getId() {
		return id;
	}

	public String getStr() {
		return str;
	}

	public MutableReferenceInFinalClass getMutable() {
		return mutable;
	}
	//deep copy constructor
	public FinalClass(int i, String str, MutableReferenceInFinalClass mutable, HashMap<String, String> hm){
		System.out.println("Performing Deep Copy for Object initialization");
		this.id=i;
		this.str=str;
		this.mutable = mutable;
		/*HashMap<String,String> tempMap=new HashMap<String,String>();
		String key;
		//Due to this deep copy of code is given
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()){
			key=it.next();
			tempMap.put(key, hm.get(key));
		}*/
		this.hashMap = hm;
	}
	//
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MutableReferenceInFinalClass mutable = new MutableReferenceInFinalClass();
		String str = "str";
		int id = 1;
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("One", "Kiran");
		FinalClass fc = new FinalClass(id, str, mutable,hm);
		System.out.println(str == fc.getStr());
		System.out.println(id == fc.getId());
		System.out.println(mutable);
		System.out.println(mutable == fc.getMutable());
		System.out.println(hm=fc.getHashMap());
		id = 30;
		str = "strstr";
		mutable = new MutableReferenceInFinalClass();
		hm.put("Two", "Abhii");
		System.out.println("After value change"+fc.getStr());
		System.out.println("After value change"+fc.getId());
		System.out.println("After value change"+fc.getHashMap());
		System.out.println("After value change"+fc.getMutable());
		HashMap<String, String> hmTest =  fc.getHashMap();//Due to this shallow copy of Hashmap is returned
		hmTest.put("Three", "Jyoti");
		System.out.println("after changing variable accesor"+fc.getHashMap());
	}

	public HashMap<String, String> getHashMap() {
		//return hashMap;
		return (HashMap<String, String>) hashMap.clone();
	}

}
class MutableReferenceInFinalClass{
	public MutableReferenceInFinalClass(){
		
	}
}
