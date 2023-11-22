/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Knight.Assasin;
import Knight.Barbarian;
import Knight.Magician;
import Knight.Tank;
import Knight.SwordMan;
import Knight.Archer;
import Dungeons.gui.Drawable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.InstantSource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Dungeon extends Sprite implements Drawable, Boundable{

    private LivingBeing arthur;
    private Drawable drawable;
    private LectorArchivo lector;
    private List<Wall> Muros;
    private String nivel;

    public Dungeon(int x, int y, int width, int height, String type, String nivel) {
        super(x, y, width, height, Color.BLACK);
        arthur = createKnight(40, 50, type);
        arthur.setDrawable(this);
        arthur.setBoundable(this);
        lector = new LectorArchivo(nivel);
        Muros = new ArrayList<>();
        mapearDungeon();
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
    
    private void mapearDungeon() {
        System.out.println("leyendo archivo");
        this.Muros = lector.leerMapa();

    }
    
    public LivingBeing createKnight (int x, int y, String type){
        LivingBeing knight = null;
        if (type.equals("Assasin")){
            knight = new Assasin(x, y);
        }
        else if (type.equals("Archer")){
            knight = new Archer(x, y);
        }
        else if (type.equals("Barbarian")){
            knight = new Barbarian(x, y);
        }
        else if (type.equals("Magician")){
            knight = new Magician(x, y);
        }
        else if (type.equals("SwordMan")){
            knight = new SwordMan(x, y);
        }
        else if (type.equals("Tank")){
            knight = new Tank(x, y);
        }
        return knight;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);

        arthur.draw(g);
        for (Wall muro : Muros){
            g.setColor(color);
            g.fillRect(x, y, width, height);
            muro.draw(g);
        }
    }

    public void actKnight(int key){
        if(key == KeyEvent.VK_W |
           key == KeyEvent.VK_S |
           key == KeyEvent.VK_A | 
           key == KeyEvent.VK_D)
        {
            arthur.actionHandle(key);
            drawable.redraw();  // TODO
        }
    }
    @Override
    public void redraw() {
        drawable.redraw();
    }

    @Override
    public boolean isValid(Sprite sprite) {
        if(sprite.getX() < this.getX() |
           sprite.getY() < this.getY() |
           sprite.getX()+sprite.getWidth() > this.getX()+this.getWidth() |
           sprite.getY()+sprite.getHeight() > this.getY()+this.getHeight())
            return false;

        return true;
    }
    
}
