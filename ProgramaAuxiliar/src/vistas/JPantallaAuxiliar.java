package vistas;

import controladores.ControladorTablaUpdate;
import excepciones.LoadActivationFileException;
import excepciones.LoadUserFileException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelos.EscribirArchivoTransacciones;
import modelos.LeerArchivoTransacciones;
import modelos.LeerArchivoUsuario;
import modelos.Usuario;


public class JPantallaAuxiliar extends javax.swing.JFrame {
    
    DefaultTableModel ModeloTabla;
    String[] cabecera = {"N°","Numero/Transacción","Fecha","Descripcion","Cantidad"};
    String[][] data={};
    private Usuario user;
    int contador = 0;
    
    //ESTE CONTRUCTOR ES PARA EVITAR ERRORES
    
    public JPantallaAuxiliar() {
        initComponents();
        setLocationRelativeTo(null);
        //carga la tabla
        ModeloTabla =  new DefaultTableModel(data,cabecera);
        jtblTransacciones.setModel(ModeloTabla);
        
        
        //Leer datos del archivo del usuario
        try{
            LeerArchivoUsuario datosUsuario = new LeerArchivoUsuario();
            datosUsuario.leerArchivo();
            user = new Usuario(datosUsuario.getNombre(),datosUsuario.getNumeroTelef(),datosUsuario.getSueldo(),datosUsuario.getPIN()); 
            //String nombre, int numeroTelef, double sueldo, String PIN
            jtxtNombre.setText(user.getNombre());
            jtxtNumero.setText(String.valueOf(user.getNumeroTelef()));
            jtxtSaldo.setText(String.valueOf(user.getSaldo()));
        }catch(LoadUserFileException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        //LEER ARCHIVO TRANSACCIONES
        try{
            LeerArchivoTransacciones ArchivoTransacciones = new LeerArchivoTransacciones();
            ArchivoTransacciones.leerArchivo(user);
        }catch(Exception e){
             JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        //CARGA LOS DATOS DEL ARCHIVO TRANSACCIONES QUE SE CREÓ AL CERRAR EL PROGRAMA
        ControladorTablaUpdate tablaTransacciones = new ControladorTablaUpdate();
        for(int i=0;i<user.getTransacciones().size();i++){
            tablaTransacciones.ActualizarTabla(ModeloTabla, user.getTransacciones().get(i), i);
            contador = i+1;
        }

       //GENERA LA CONFIRMACIÓN SI DESEA CERRAR EL PROGRAMA, CASO SEA SI, ENTONCES SE IMPRIMIRÁ TODOS LOS ELEMENTOS DEL ARRAYLIST TRANSACCIONES A UN ARCHIVO LLAMADO "TRANSACCIONES";
       //MODIFICANDO EL COMPORTAMIENTO DEL BOTÓN CERRAR DE LA BARRA DE TÍTULO
       setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
       addWindowListener(new WindowAdapter(){
           @Override
           public void windowClosing(WindowEvent e){
               int opcion = JOptionPane.showConfirmDialog( JPantallaAuxiliar.this ,"¿Estas seguro/a que quieres salir?", "Confirmar salida",JOptionPane.YES_NO_OPTION);
               if(opcion == JOptionPane.YES_OPTION){
                   EscribirArchivoTransacciones archivoTransacciones = new EscribirArchivoTransacciones();
                   archivoTransacciones.EscribirArchivo(user.getTransacciones());
                   System.exit(0);
               }
           }
       });
       setVisible(true);
       //FIN DE LA CONFIRMACIÓN
       
    }
    
    
    public Usuario getUsuario(){
        return user;
    }
    
    public JTextField getTextFieldSaldo(){
        return jtxtSaldo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jtxtNumero = new javax.swing.JTextField();
        jtxtSaldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbtnPagarPorNumero = new javax.swing.JButton();
        jbtnPagarPorTransaccion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblTransacciones = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BILLITERA VIRTUAL AUXILIAR");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Número de telf.");

        jtxtSaldo.setText("0.00");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Saldo:");

        jbtnPagarPorNumero.setText("Pagar por Número");
        jbtnPagarPorNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPagarPorNumeroActionPerformed(evt);
            }
        });

        jbtnPagarPorTransaccion.setText("Pagar por transaccion");
        jbtnPagarPorTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPagarPorTransaccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtNumero)
                            .addComponent(jtxtSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jbtnPagarPorNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnPagarPorTransaccion, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNombre)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jbtnPagarPorNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnPagarPorTransaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jtblTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblTransacciones);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtro", "Mas antiguo", "Mas reciente", "Mayor a menor transaccion", "Menor a Mayor Transaccion", "A-Z", "Z-A" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("TRANSACCIONES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPagarPorNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPagarPorNumeroActionPerformed
        JPantallaPagarPorNumero PantallaPagarPorNumero = new JPantallaPagarPorNumero(this, ModeloTabla, contador);
        contador = PantallaPagarPorNumero.ActulizarContador();
        PantallaPagarPorNumero.setVisible(true);
    }//GEN-LAST:event_jbtnPagarPorNumeroActionPerformed

    private void jbtnPagarPorTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPagarPorTransaccionActionPerformed
        JPantallaPagarPorTranferencia PantallaPagarPorTransaccion = new JPantallaPagarPorTranferencia(this, ModeloTabla, contador);
        PantallaPagarPorTransaccion.setVisible(true);
    }//GEN-LAST:event_jbtnPagarPorTransaccionActionPerformed

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
            java.util.logging.Logger.getLogger(JPantallaAuxiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPantallaAuxiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPantallaAuxiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPantallaAuxiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPantallaAuxiliar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnPagarPorNumero;
    private javax.swing.JButton jbtnPagarPorTransaccion;
    private javax.swing.JTable jtblTransacciones;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtNumero;
    private javax.swing.JTextField jtxtSaldo;
    // End of variables declaration//GEN-END:variables
}
