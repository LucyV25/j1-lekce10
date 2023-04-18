package cz.czechitas.lekce10.api;

import java.awt.*;

public class UlozenyStav {
    private Point mouse;
    private Point cat;

    public Point getMouse() {
        int mysX = mouse.getLocation().x;
        int mysY = mouse.getLocation().y;

        return mouse;
    }

    public void setMouse(Point mouse) {
        this.mouse = mouse;
    }

    public Point getCat() {
        int kockaX = cat.getLocation().x;
        int kockaY = cat.getLocation().y;

        return cat;
    }

    public void setCat(Point cat) {
        this.cat = cat;
    }
}
