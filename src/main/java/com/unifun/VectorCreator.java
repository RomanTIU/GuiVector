package com.unifun;

public class VectorCreator {
    public static Vector returnVector(String[] s ){
        Point startPoint = new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        Point endPoint = new Point(Integer.parseInt(s[2]), Integer.parseInt(s[3]));
       return new Vector(startPoint, endPoint);
    }
    public static Vector returnSecondVector(String [] s){
        Point startPoint = new Point(Integer.parseInt(s[4]), Integer.parseInt(s[5]));
        Point endPoint = new Point(Integer.parseInt(s[6]), Integer.parseInt(s[7]));
        return new Vector(startPoint, endPoint);
    }
}
