package com.unifun;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class Vector {
    private Point startPoint;
    private Point endPoint;


    public double lengthVector() {
        return Math.abs(Math.sqrt(Math.pow(endPoint.getX() - startPoint.getX(), 2) +
                Math.pow(endPoint.getY() - startPoint.getY(), 2)));

    }

    public static Vector sumVector(Vector prim, Vector second) throws Exception {
        if ((prim.startPoint.getX() == prim.endPoint.getX() &
                prim.startPoint.getY() == prim.endPoint.getY()) ||

                (second.startPoint.getX() == second.endPoint.getX() &
                        second.startPoint.getY() == second.endPoint.getY())) {

            throw new Exception("Vectorii trebuie sa fie de lungime nenula");
        }

        Point firstPoint = new Point(prim.startPoint.getX(), prim.startPoint.getY());
        Point secondPoint = new Point(prim.endPoint.getX() + (second.endPoint.getX() - second.startPoint.getX()),
                                      prim.endPoint.getY() + (second.endPoint.getY() - second.startPoint.getY()));

        return new Vector(firstPoint, secondPoint);
    }

    public static Vector diffVector(Vector prim, Vector second) throws Exception {
        if ((prim.startPoint.getX() == prim.endPoint.getX() &
                prim.startPoint.getY() == prim.endPoint.getY()) ||

                (second.startPoint.getX() == second.endPoint.getX() &
                        second.startPoint.getY() == second.endPoint.getY())) {

            throw new Exception("Vectorii trebuie sa fie de lungime nenula");

        }

        Point firstPoint = new Point(prim.endPoint.getX(), prim.endPoint.getY());
        Point secondPoint = new Point((prim.startPoint.getX() + (second.endPoint.getX() - second.startPoint.getX())),
                                    prim.startPoint.getY() + (second.endPoint.getY() - second.startPoint.getY()));

        return new Vector(firstPoint, secondPoint);
    }

    public Point returnProiection() {
        return new Point(this.endPoint.getX() - this.startPoint.getX(),
                this.endPoint.getY() - this.startPoint.getY());
    }

    public static double degreesTwoVectors(Vector prim, Vector second) {
        Point proiectionPrim = prim.returnProiection();
        Point proiectionSecond = second.returnProiection();
        return Math.toDegrees(Math.acos(((proiectionPrim.getX() * proiectionSecond.getX()) +
                (proiectionPrim.getY() * proiectionSecond.getY())) /
                (prim.lengthVector() * second.lengthVector())));
    }


    public double oneVectorDegrees() {

        Vector rootZero = new Vector(new Point(0, 0),
                new Point(this.endPoint.getX() - this.startPoint.getX(),
                        this.endPoint.getY() - this.startPoint.getY()));

        if (rootZero.endPoint.getX() >= 0 & rootZero.endPoint.getY() > 0) {
            Vector translationVectorOX = new Vector(this.startPoint, new Point(this.endPoint.getX(), 0));
            return Math.toDegrees(Math.acos((translationVectorOX.lengthVector()) / this.lengthVector()));

        }
        if (rootZero.endPoint.getX() >= 0 & rootZero.endPoint.getY() < 0) {
            Vector translationVectorOX = new Vector(this.startPoint, new Point(this.endPoint.getX(), 0));
            return 270 + Math.toDegrees(Math.acos((translationVectorOX.lengthVector()) / this.lengthVector()));
        }
        if (rootZero.endPoint.getX() <= 0 & rootZero.endPoint.getY() < 0) {
            Vector translationVectorOX = new Vector(this.startPoint, new Point(this.endPoint.getX(), 0));
            return 180 + Math.toDegrees(Math.acos((translationVectorOX.lengthVector()) / this.lengthVector()));
        }
        if (rootZero.endPoint.getX() <= 0 & rootZero.endPoint.getY() > 0) {
            Vector translationVectorOX = new Vector(this.startPoint, new Point(this.endPoint.getX(), 0));
            return 90 + Math.toDegrees(Math.acos((translationVectorOX.lengthVector()) / this.lengthVector()));
        }
        return 1000;
    }




}

