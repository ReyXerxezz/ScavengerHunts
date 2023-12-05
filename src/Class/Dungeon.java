/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;


import Creature.Dragon;
import Creature.MonsterThread;
import dungeons.gui.Drawable;
import Knight.Assasin;
import Knight.Barbarian;
import Knight.Magician;
import Knight.Tank;
import Knight.SwordMan;
import Knight.Archer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author User
 */
public class Dungeon extends Sprite implements Drawable, Boundable{

    private LivingBeing arthur;
    private Drawable drawable;
    private LectorArchivo lector;
    private ArrayList<Wall> muros;
    private ArrayList<LivingBeing> creatures;
    private String nivel;
    private ImageIcon fondo = new ImageIcon("Background.png");
    private int score;
    public Dungeon(int x, int y, int width, int height, String type, String nivel) {
        super(x, y, width, height, new Color(186, 222, 248  ));
        arthur = createKnight(40, 40, type);
        arthur.setDrawable(this);
        arthur.setBoundable(this);
        lector = new LectorArchivo(nivel);
        muros = new ArrayList<>();
        creatures = new ArrayList<>(); 
        score = 1200;
        mapearDungeon();
        //createWeaponThreads();
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
    
    private void mapearDungeon() {
        this.muros = lector.leerMapa();
        this.creatures = lector.leerMonstruos();
    }
    
    public LivingBeing createKnight (int x, int y, String type){
        LivingBeing knight = null;
        if (type.equals("Assasin")){
            knight = new Assasin(x, y);
            knight.setTargets(creatures);
        }
        else if (type.equals("Archer")){
            knight = new Archer(x, y);
            knight.setTargets(creatures);
        }
        else if (type.equals("Barbarian")){
            knight = new Barbarian(x, y);
            knight.setTargets(creatures);
        }
        else if (type.equals("Magician")){
            knight = new Magician(x, y);
            knight.setTargets(creatures);
        }
        else if (type.equals("SwordMan")){
            knight = new SwordMan(x, y);
            knight.setTargets(creatures);
        }
        else if (type.equals("Tank")){
            knight = new Tank(x, y);
            knight.setTargets(creatures);
        }
        knight.setDungeon(this);
        return knight;
    }
    @Override
    public void draw(Graphics g) {
        fondo.paintIcon(null, g, x, y);

        getArthur().draw(g);
        for (Wall muro : getMuros()){
            g.setColor(muro.getColor());
            g.fillRect(muro.getX(), muro.getY(), muro.getWidth(), muro.getHeight());
            muro.draw(g);
            if (arthur.getSword() != null){
                System.out.println("Espada");
                arthur.getSword().draw(g);
            }
        }
        for (LivingBeing monstruo : getCreatures()) {
            monstruo.draw(g);
            if (!monsterThreadIsRunning(monstruo)) {
                MonsterThread thread = new MonsterThread(this, monstruo);
                thread.start();
            }
            
        }
        for (LivingBeing creature : creatures) {
            if (creature instanceof Dragon) {
                for (Weapon weapon : ((Dragon) creature).getFireballs()) {
                    weapon.draw(g);
                }
            }
        }
        drawLife(g);
        drawScore(g);
    }
    
    private void drawLife(Graphics g){
        int[] pos = {10, 770};
        String lifeToString = Integer.toString(getArthur().getHealth());

        for (int i = 0; i < lifeToString.length(); i++) {
            int digit = Integer.parseInt(lifeToString.substring(i, i + 1));
            g.drawImage(Assets.numbers(digit), pos[0], pos[1], null);
            pos[0] = pos[0] + 20;
        }
    }
    
    public void drawScore(Graphics g){
        int[] pos = {580, 770};
        String scoreToString = Integer.toString(score);

        for (int i = 0; i < scoreToString.length(); i++) {
            int digit = Integer.parseInt(scoreToString.substring(i, i + 1));
            g.drawImage(Assets.numbers(digit), pos[0], pos[1], null);
            pos[0] = pos[0] + 20;
        }
    }

    public void actKnight(int key){
        if(key == KeyEvent.VK_W |
           key == KeyEvent.VK_S |
           key == KeyEvent.VK_A | 
           key == KeyEvent.VK_D |
           key == KeyEvent.VK_SPACE)       
        {
            getArthur().actionHandle(key, getMuros(), getCreatures());
            getDrawable().redraw(); // TODO
        }
    }
    @Override
    public void redraw() {
      
    
    }
    
    public void setScore(){
        score = score - 1;
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
    
    public void eliminarCreature(int index){
        this.getCreatures().remove(index);
    }

    /**
     * @return the arthur
     */
    public LivingBeing getArthur() {
        return arthur;
    }

    /**
     * @return the drawable
     */
    public Drawable getDrawable() {
        return drawable;
    }

    /**
     * @return the muros
     */
    public ArrayList<Wall> getMuros() {
        return muros;
    }

    /**
     * @return the creatures
     */
    public ArrayList<LivingBeing> getCreatures() {
        return creatures;
    }
    
    private boolean monsterThreadIsRunning(LivingBeing monstruo) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads, true);

        for (Thread thread : threads) {
            if (thread instanceof MonsterThread) {
                MonsterThread monsterThread = (MonsterThread) thread;
                if (monsterThread.getMonster() == monstruo) {
                    return true;
                }
            }
        }

        return false;
    }
    private void createWeaponThreads() {
    for (LivingBeing creature : creatures) {
        if (creature instanceof Dragon || creature instanceof Magician || creature instanceof Archer) {
            ShootThread thread = new ShootThread(creature, creatures);
            thread.start();
        }
    }
}

}
