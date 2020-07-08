package com.unifun;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class Vector {
    private Point startPoint;
    private Point endPoint;

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

        return new Vector(secondPoint, firstPoint );
    }
}

