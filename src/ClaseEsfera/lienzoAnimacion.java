package ClaseEsfera;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

public class lienzoAnimacion extends javax.swing.JPanel implements Runnable {

    private ArrayList<EsferaHilo> listaEsferas;
    private EsferaHilo esfera;
    private boolean run;


    public lienzoAnimacion() {
        initComponents();
        this.listaEsferas = new ArrayList();
        this.run = true;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void addEsfera(int px, int py, int radio, int limX, int limY) {
        this.listaEsferas.add(new EsferaHilo(px, py, radio, limX, limY));
        getUltimaEsfera().start();
    }

    public EsferaHilo getUltimaEsfera() {
        return this.listaEsferas.get(this.listaEsferas.size() - 1);
    }

    public EsferaHilo getObjEsfera(int idx) {
        return this.listaEsferas.get(idx);
    }

    public void correrEsfera(int idx) {
        getObjEsfera(idx).correr();
    }

    public void detenerEsfera(int idx) {
        getObjEsfera(idx).detener();
    }

    public void marcaEsfera(int idx) {
        getObjEsfera(idx).setMarcada(true);
    }

    public void desmarcarEsfera(int idx) {
        getObjEsfera(idx).setMarcada(false);
    }

    public void desMarcarEsferas() {
        for (int i = 0; i < this.listaEsferas.size(); i++) {
            getObjEsfera(i).setMarcada(false);
        }
    }

    public void detenerAnimacion() {
        for (int i = 0; i < this.listaEsferas.size(); i++) {
            getObjEsfera(i).detener();
        }
    }

    public void correrAnimacion() {
        for (int i = 0; i < this.listaEsferas.size(); i++) {
            getObjEsfera(i).correr();
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < this.listaEsferas.size(); i++) {
            this.esfera = getObjEsfera(i);
            g.setColor(this.esfera.getColor());
            g2d.setStroke(new BasicStroke(5.0f));
            if (esfera.isMarcada()) {
                g.fillOval(esfera.getPx(), esfera.getPy(), esfera.getRadio() * 2, esfera.getRadio() * 2);
            } else {
                g.drawOval(esfera.getPx(), esfera.getPy(), esfera.getRadio() * 2, esfera.getRadio() * 2);
            }
        }
    }

    public void init() {
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(lienzoAnimacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
