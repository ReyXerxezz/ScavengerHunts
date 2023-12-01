/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import dungeons.gui.Drawable;
import Knight.Assasin;
import Knight.Barbarian;
import Knight.Magician;
import Knight.Tank;
import Knight.SwordMan;
import Knight.Archer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 *
 * @author User
 */
public class Dungeon extends Sprite implements Drawable, Boundable{

    private LivingBeing arthur;
    private Drawable drawable;
    private LectorArchivo lector;
    private ArrayList<Wall> Muros;
    private ArrayList<LivingBeing> creatures;
    private String nivel;
    private ImageIcon fondo = new ImageIcon("Background.png");
    

    public Dungeon(int x, int y, int width, int height, String type, String nivel) {
        super(x, y, width, height, new Color(186, 222, 248  ));
        arthur = createKnight(40, 40, type);
        arthur.setDrawable(this);
        arthur.setBoundable(this);
        lector = new LectorArchivo(nivel);
        Muros = new ArrayList<>();
        creatures = new ArrayList<>(); 
        mapearDungeon();
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
    
    private void mapearDungeon() {
        this.Muros = lector.leerMapa();
        this.creatures = lector.leerMonstruos();
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
        fondo.paintIcon(null, g, x, y);

        arthur.draw(g);
        for (Wall muro : Muros){
            g.setColor(muro.getColor());
            g.fillRect(muro.getX(), muro.getY(), muro.getWidth(), muro.getHeight());
            muro.draw(g);
        }
        for (LivingBeing monstruo : creatures) {
            monstruo.draw(g);
        }
    }

    public void actKnight(int key){
        if(key == KeyEvent.VK_W |
           key == KeyEvent.VK_S |
           key == KeyEvent.VK_A | 
           key == KeyEvent.VK_D)
        {
            arthur.actionHandle(key, Muros);
            drawable.redraw();  // TODO
        }
    }
    @Override
    public void redraw() {
         
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
