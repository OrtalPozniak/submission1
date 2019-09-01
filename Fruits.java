package com.example.sub1fruits;

public class Fruits {
    private String _name;
    private float _calories;
    private int _idimg;
    public Fruits(String name, float calories, int idimg){
        _name=name;
        _calories=calories;
        _idimg=idimg;
    }
    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public float get_calories() {
        return _calories;
    }

    public void set_calories(float _calories) {
        this._calories = _calories;
    }

    public int get_idimg() {
        return _idimg;
    }

    public void set_idimg(int _idimg) {
        this._idimg = _idimg;
    }

}
