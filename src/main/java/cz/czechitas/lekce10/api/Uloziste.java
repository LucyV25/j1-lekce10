package cz.czechitas.lekce10.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Uloziste {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private Cat cat;
    private Mouse mouse;


    public void nacistPlochuZeSouboru(Path path) throws IOException {
        UlozenaPlocha ulozenaPlocha = objectMapper.readValue(path.toFile(), UlozenaPlocha.class);
        cat = new Cat(ulozenaPlocha.getCat());
        mouse = new Mouse(ulozenaPlocha.getMouse());
        for (Point treePoint : ulozenaPlocha.getTrees()) {
            new Tree(treePoint);
        }
        new Cheese(ulozenaPlocha.getCheese());
        new Meat(ulozenaPlocha.getMeat());
    }

    public void nacistPlochuZeSouboru() throws IOException {
        nacistPlochuZeSouboru(Path.of("level-01.json"));
    }

    public void nacistStavZeSouboru(Path path)  throws IOException {
        // TODO
        // Načíst objekt UlozenyStav pomocí objectMapper.readValue(file, UlozenyStav.class)
        // Získat z UlozenyStav souřadnice kočky a myši
        // Zapsat tyto souřadnice do objektů kočky a myši pomocí setLocation()
        UlozenyStav ulozenyStav = objectMapper.readValue(path.toFile(), UlozenyStav.class);
        Point kocka=ulozenyStav.getCat();
        Point mys=ulozenyStav.getMouse();
        cat.setLocation(kocka);
        mouse.setLocation(mys);


    }

    public void nacistStavZeSouboru() throws IOException {
        nacistStavZeSouboru(Paths.get("stav.json"));
    }

    public void ulozitStavDoSouboru(Path path)  throws IOException {
        // TODO
        // Vytvořit objekt UlozenyStav
        // Uložit do něj souřadnice kočky a myši – souřadnice získáte voláním getLocation()
        // Uložit objekt UlozenyStav do souboru pomocí objectMapper.writeValue(file, object)
        UlozenyStav ulozenyStav=new UlozenyStav();
        ulozenyStav.setCat(cat.getLocation());
        ulozenyStav.setMouse(mouse.getLocation());
        objectMapper.writeValue(path.toFile(),ulozenyStav);

    }

    public void ulozitStavDoSouboru() throws IOException {
        ulozitStavDoSouboru(Paths.get("stav.json"));
    }

    public Cat getCat() {
        return cat;
    }

    public Mouse getMouse() {
        return mouse;
    }


}
