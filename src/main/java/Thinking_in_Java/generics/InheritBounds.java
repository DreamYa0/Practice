package Thinking_in_Java.generics;

import java.awt.*;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/11/17.
 *         P388 泛型边界，添加边界限制
 */
public class InheritBounds {
    public static void main(String[] args) {
        Soild2<Bounded> soild2 = new Soild2<>(new Bounded());
        soild2.color();
        soild2.getY();
        soild2.weight();
    }
}

class HoldItem<T> {
    T item;

    HoldItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}

class Colored2<T extends HasColor> extends HoldItem<T> {

    Colored2(T item) {
        super(item);
    }

    Color color() {
        return item.getColor();
    }
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> {

    ColoredDimension2(T item) {
        super(item);
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

class Soild2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {
    Soild2(T item) {
        super(item);
    }

    int weight() {
        return item.weight();
    }
}