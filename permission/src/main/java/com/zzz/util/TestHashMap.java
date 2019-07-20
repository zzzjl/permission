package com.zzz.util;

import com.zzz.beans.CacheKeyConstants;
import org.apache.commons.collections.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {


    public static void main(String[] args) {
        TestHash a = new TestHash("w");
        TestHash b = new TestHash("w");
        Map<TestHash,String> modelMap = new HashMap<TestHash,String>();
        modelMap.put(a,"a");
        modelMap.put(b,"b");
        System.out.println(a.hashCode()+":"+b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(modelMap.toString());
        System.out.println(modelMap.get(a));
        System.out.println(modelMap.get(b));
        String s = CacheKeyConstants.USER_ACLS.name();
        System.out.println(s);

    }
}
