package com.zzz.util;

public class TestHash {
    private String key;

    public TestHash(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestHash testHash = (TestHash) o;

        return key != null ? key.equals(testHash.key) : testHash.key == null;
    }

   /* @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }*/
}
