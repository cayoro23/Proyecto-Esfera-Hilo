package ClaseEsfera;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EsferaHilo extends Thread {

    private long id;
    private int px;
    private int py;
    private int sentidoX;
    private int sentidoY;
    private int velocidadX, velocidadY;
    private int radio;
    private Color color;
    private boolean run;
    private int limX;
    private int limY;
    private static int cont;
    private boolean marcada;

    EsferaHilo(int px, int py, int radio, int limX, int limY) {
        cont++;
        this.id = cont;
        this.px = px;
        this.py = py;
        this.radio = radio;
        this.velocidadX = (int) (Math.random() * (5 - 0 + 1) + 0);
        this.velocidadY = (int) (Math.random() * (5 - 0 + 1) + 0);
        this.limX = limX;
        this.limY = limY;
        this.sentidoX = ((int) (Math.random() * 2) == 0) ? 1 : -1;
        this.sentidoY = ((int) (Math.random() * 2) == 0) ? 1 : -1;
        this.run = true;
        this.setColor();
    }

    public void setColor() {
        this.color = new Color((int) (Math.random() * 254), (int) (Math.random() * 254), (int) (Math.random() * 254));
    }

    public void mover() {
        this.px += this.velocidadX * this.sentidoX;
        this.py += this.velocidadY * this.sentidoY;
        if (this.px > (this.limX - this.radio * 2) || this.px < 0) {
            this.sentidoX *= -1;
        }
        if (this.py > (this.limY - this.radio * 2) || this.py < 0) {
            this.sentidoY *= -1;
        }
    }

    public void run() {
        while (true) {
            try {
                if (run) {
                    mover();
                }
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(EsferaHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void detener() {
        this.run = false;
    }

    public void correr() {
        this.run = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public int getLimX() {
        return limX;
    }

    public void setLimX(int limX) {
        this.limX = limX;
    }

    public int getLimY() {
        return limY;
    }

    public void setLimY(int limY) {
        this.limY = limY;
    }

    public boolean isMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }

}
