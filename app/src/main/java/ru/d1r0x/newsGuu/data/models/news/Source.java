package ru.d1r0x.newsGuu.data.models.news;

public class Source {
    private final String id, name;

    public Source(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
