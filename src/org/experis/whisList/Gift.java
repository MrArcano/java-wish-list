package org.experis.whisList;

public class Gift implements Comparable<Gift> {
    private String name;

    public Gift(String name) throws RuntimeException {
        if (name == null || name.trim().isEmpty()) {
            throw new RuntimeException("Gift name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Gift {" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gift o) {
        return this.getName().compareTo(o.getName());
    }
}
