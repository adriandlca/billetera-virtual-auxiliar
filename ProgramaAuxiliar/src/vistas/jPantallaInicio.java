package vistas;


import controladores.ValidadorCodigoActivador;
import controladores.ValidadorLogin;
import excepciones.ActivationFileReadException;
import excepciones.InvalidPINException;
import excepciones.LoadActivationFileException;
import excepciones.LoadUserFileException;
import javax.swing.JOptionPane;
import modelos.LeerArchivoActivador;
import modelos.LeerArchivoUsuario;

public class jPantallaInicio extends javax.swing.JFrame {
    //private String codigoActivador;
    public jPantallaInicio() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtnIngresar = new javax.swing.JButton();
        jtxtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(30, 30, 47));

        jbtnIngresar.setBackground(new java.awt.Color(63, 142, 252));
        jbtnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnIngresar.setText("Ingresar");
        jbtnIngresar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15));
        jbtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIngresarActionPerformed(evt);
            }
        });

        jtxtPassword.setBackground(new java.awt.Color(45, 45, 65));
        jtxtPassword.setForeground(new java.awt.Color(255, 255, 255));
        jtxtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 142, 252)));
        jtxtPassword.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INGRESE SU PIN:");

        jLabel3.setBackground(new java.awt.Color(30, 30, 47));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo2-213x213.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jbtnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIngresarActionPerformed

        String PINGuardado;
        try
        {
            //LEE EL ARCHIVO ACTIVADOR
            LeerArchivoActivador archivo = new LeerArchivoActivador();
            archivo.leerArchivo();

            //DETECTA EL DATO OBTENIDO DEL PIN
            ValidadorCodigoActivador validarActivador = new ValidadorCodigoActivador();
            try{
                //LEER ARCHIVO DEL USUARIO
                LeerArchivoUsuario usuario = new LeerArchivoUsuario();
                usuario.leerArchivo();
                PINGuardado = usuario.getPIN();
                try
                {
                    if(validarActivador.validarActivacion(archivo.getCodigoActivador())){
                        String PINIngresado = new String(jtxtPassword.getPassword()); //esta tachado porque getText() en password esta desfazado por temas de seguridad, pero funciona.
                        ValidadorLogin controlLogin = new ValidadorLogin(); // crea el controlador para valida los datos del login (que sean de 4 digitos)
                        try
                        {
                            if(controlLogin.validarPIN(PINGuardado,PINIngresado))
                            {
                                JPantallaAuxiliar PantallaAuxiliar = new JPantallaAuxiliar();
                                PantallaAuxiliar.setVisible(true);
                                this.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"PIN Incorrecto", "Error en la validacion", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        catch(InvalidPINException e)
                        {
                            JOptionPane.showMessageDialog(this, e.getMessage(), "Error de validacion", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                catch(ActivationFileReadException e)
                {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error de lectura", JOptionPane.ERROR_MESSAGE);
                }
            }catch(LoadUserFileException e){
                JOptionPane.showMessageDialog(this, e.getMessage(),"Error de carga del archivo", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(LoadActivationFileException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error de carga del archivo", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnIngresar;
    private javax.swing.JPasswordField jtxtPassword;
    // End of variables declaration//GEN-END:variables
}
