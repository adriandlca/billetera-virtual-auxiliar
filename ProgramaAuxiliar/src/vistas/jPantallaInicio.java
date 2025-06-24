package vistas;


import controladores.ControladorActivador;
import controladores.ControladorLogin;
import excepciones.ActivationFileReadException;
import excepciones.InvalidPINException;
import excepciones.LoadActivationFileException;
import excepciones.LoadUserFileException;
import javax.swing.JOptionPane;
import modelos.LeerArchivoActivador;
import modelos.LeerArchivoUsuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP SUPPORT
 */
public class jPantallaInicio extends javax.swing.JFrame {
    //private String codigoActivador;
    public jPantallaInicio() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxtPassword = new javax.swing.JPasswordField();
        jbtnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("INGRESE SU PIN:");

        jtxtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jbtnIngresar.setText("Ingresar");
        jbtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jbtnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIngresarActionPerformed

        
        try{
            LeerArchivoUsuario usuario = new LeerArchivoUsuario();
            usuario.leerArchivo();
        }catch(LoadUserFileException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        try
        {
            //LEE EL ARCHIVO ACTIVADOR
            LeerArchivoActivador archivo = new LeerArchivoActivador();
            archivo.leerArchivo();
            //LEE ARCHIVO DEL USUARIO
            
            
            
            //DETECTA EL DATO OBTENIDO DEL PIN
            ControladorActivador controlActivador = new ControladorActivador();
            try
            {
                if(controlActivador.validarActivacion(archivo.getCodigoActivador())){
                    String PINIngresado = new String(jtxtPassword.getPassword()); //esta tachado porque getText() en password esta desfazado por temas de seguridad, pero funciona.
                    ControladorLogin controlLogin = new ControladorLogin();
                    try
                    {
                        if(controlLogin.validarPIN(PINIngresado))
                        {
                            JPantallaAuxiliar PantallaAuxiliar = new JPantallaAuxiliar();
                            PantallaAuxiliar.setVisible(true);
                            this.dispose();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this,"PIN Incorrecto");
                        }
                    }
                    catch(InvalidPINException e)
                    {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }
            catch(ActivationFileReadException e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }   
        }
        catch(LoadActivationFileException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_jbtnIngresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jPantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jPantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jPantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jPantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jPantallaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtnIngresar;
    private javax.swing.JPasswordField jtxtPassword;
    // End of variables declaration//GEN-END:variables
}
