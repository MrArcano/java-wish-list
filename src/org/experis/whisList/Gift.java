package org.experis.whisList;

public class Gift implements Comparable<Gift> {
    private String name;

    public Gift(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Gift o) {
        return this.getName().compareTo(o.getName());
    }
}
