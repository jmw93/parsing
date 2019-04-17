package com.example.myapp6;

public class lating {
    String name;
    String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "lating{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public lating(String name, String content) {
        this.name = name;
        this.content = content;

    }
}
