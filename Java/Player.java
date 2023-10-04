package com.example.munsterrugby;

import java.io.Serializable;

public class Player implements Serializable {
    private String name, position, caps, image, points, honours, url;

    public Player(String name, String position, String caps, String image, String points, String honours, String url) {
        this.name = name;
        this.position = position;
        this.caps = caps;
        this.image = image;
        this.points = points;
        this.honours = honours;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaps() {
        return caps;
    }

    public void setCaps(String caps) {
        this.caps = caps;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getHonours() {
        return honours;
    }

    public void setHonours(String honours) {
        this.honours = honours;
    }
}
