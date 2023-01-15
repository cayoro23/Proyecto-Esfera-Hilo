package ClaseEsfera;

import javax.swing.DefaultListModel;

public class frmPrincipal extends javax.swing.JFrame {

    DefaultListModel modelo = new DefaultListModel();
    boolean estado;
    int idx;

    public frmPrincipal() {
        initComponents();
        this.lienzoAnimacion.init();
        this.lstPelotas.setModel(modelo);
        estado = true;
        idx = -1;
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzoAnimacion1 = new ClaseEsfera.lienzoAnimacion();
        btnDetener = new javax.swing.JButton();
        btnDetenerTodos = new javax.swing.JButton();
        btnDeseleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPelotas = new javax.swing.JList<>();
        lienzoAnimacion = new ClaseEsfera.lienzoAnimacion();

        javax.swing.GroupLayout lienzoAnimacion1Layout = new javax.swing.GroupLayout(lienzoAnimacion1);
        lienzoAnimacion1.setLayout(lienzoAnimacion1Layout);
        lienzoAnimacion1Layout.setHorizontalGroup(
            lienzoAnimacion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );
        lienzoAnimacion1Layout.setVerticalGroup(
            lienzoAnimacion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnDetener.setText("DETENER");
        btnDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerActionPerformed(evt);
            }
        });

        btnDetenerTodos.setText("DETENER TODOS");
        btnDetenerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerTodosActionPerformed(evt);
            }
        });

        btnDeseleccionar.setText("DESELECCIONAR");
        btnDeseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeseleccionarActionPerformed(evt);
            }
        });

        lstPelotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstPelotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstPelotas);

        lienzoAnimacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lienzoAnimacionMousePressed(evt);
            }
        });

        javax.swing.GroupLayout lienzoAnimacionLayout = new javax.swing.GroupLayout(lienzoAnimacion);
        lienzoAnimacion.setLayout(lienzoAnimacionLayout);
        lienzoAnimacionLayout.setHorizontalGroup(
            lienzoAnimacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );
        lienzoAnimacionLayout.setVerticalGroup(
            lienzoAnimacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeseleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(btnDetenerTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(btnDetener)
                .addGap(18, 18, 18)
                .addComponent(lienzoAnimacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lienzoAnimacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(btnDetener)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDetenerTodos)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeseleccionar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstPelotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstPelotasMouseClicked
        idx = this.lstPelotas.getSelectedIndex();
        if (idx >= 0) {
            if (this.lienzoAnimacion.getObjEsfera(idx).isRun()) {
                this.btnDetener.setText("DETENER");
            } else {
                this.btnDetener.setText("CORRER");
            }
            this.lienzoAnimacion.desMarcarEsferas();
            this.lienzoAnimacion.marcaEsfera(idx);
        }
    }//GEN-LAST:event_lstPelotasMouseClicked

    private void btnDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerActionPerformed
        if (idx >= 0) {
            if (this.lienzoAnimacion.getObjEsfera(idx).isRun()) {
                this.lienzoAnimacion.detenerEsfera(idx);
                this.btnDetener.setText("DETENER");
            } else {
                this.lienzoAnimacion.correrEsfera(idx);
                this.btnDetener.setText("CORRER");
            }
        }
    }//GEN-LAST:event_btnDetenerActionPerformed

    private void btnDeseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeseleccionarActionPerformed
        idx = -1;
        this.lstPelotas.clearSelection();
        this.lienzoAnimacion.desMarcarEsferas();
    }//GEN-LAST:event_btnDeseleccionarActionPerformed

    private void btnDetenerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerTodosActionPerformed
        if (estado) {
            this.lienzoAnimacion.detenerAnimacion();
            estado = false;
        } else {
            this.lienzoAnimacion.correrAnimacion();
            estado = true;
        }
    }//GEN-LAST:event_btnDetenerTodosActionPerformed

    private void lienzoAnimacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoAnimacionMousePressed
        this.lienzoAnimacion.addEsfera(evt.getX(), evt.getY(), 20,
                this.lienzoAnimacion.getWidth(), this.lienzoAnimacion.getHeight());
        modelo.addElement("Pelota: " + this.lienzoAnimacion.getUltimaEsfera().getId()
                + ", Color: ");
        System.out.println(this.lienzoAnimacion.getHeight());
    }//GEN-LAST:event_lienzoAnimacionMousePressed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeseleccionar;
    private javax.swing.JButton btnDetener;
    private javax.swing.JButton btnDetenerTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private ClaseEsfera.lienzoAnimacion lienzoAnimacion;
    private ClaseEsfera.lienzoAnimacion lienzoAnimacion1;
    private javax.swing.JList<String> lstPelotas;
    // End of variables declaration//GEN-END:variables
}
