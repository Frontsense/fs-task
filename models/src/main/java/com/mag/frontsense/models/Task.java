package com.mag.frontsense.models;

public class Task {
    private int taskId;
    private String desc;
    private String sensorType;
    private double lat;
    private double lng;
    private double radius;

    Task(int taskId, String desc, String sensorType, double lat, double lng, double radius) {
        this.taskId = taskId;
        this.desc = desc;
        this.sensorType = sensorType;
        this.lat = lat;
        this.lng = lng;
        this.radius = radius;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
