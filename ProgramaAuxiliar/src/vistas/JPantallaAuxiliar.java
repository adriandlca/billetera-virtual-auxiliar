package vistas;

import controladores.ControladorFiltro;
import controladores.ControladorTablaUpdate;
import excepciones.LoadUserFileException;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelos.EscribirArchivoTransacciones;
import modelos.LeerArchivoTransacciones;
import modelos.LeerArchivoUsuario;
import modelos.TransacribirArchivoUsuario;
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
        jtblTransacciones.getTableHeader().setBackground(new Color(207, 216, 220));
        jtblTransacciones.getTableHeader().setForeground(new Color(33, 33, 33));
        
        
        //Leer datos del archivo del usuario
        try{
            LeerArchivoUsuario datosUsuario = new LeerArchivoUsuario();
            datosUsuario.leerArchivo();
            user = new Usuario(datosUsuario.getNombre(),datosUsuario.getNumeroTelef(),datosUsuario.getSueldo(),datosUsuario.getPIN()); 
            //String nombre, int numeroTelef, double sueldo, String PIN
            jtxtNombre.setText(user.getNombre());
            jtxtNumero.setText(String.valueOf(user.getNumeroTelef()));
            jtxtSaldo.setText(String.valueOf("S/."+user.getSaldo()));
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
        ControladorTablaUpdate tablaTransacciones = new ControladorTablaUpdate(ModeloTabla , user.getTransacciones());
        tablaTransacciones.ActualizarTabla();
        

       //GENERA LA CONFIRMACIÓN SI DESEA CERRAR EL PROGRAMA, CASO SEA SI, ENTONCES SE IMPRIMIRÁ TODOS LOS ELEMENTOS DEL ARRAYLIST TRANSACCIONES A UN ARCHIVO LLAMADO "TRANSACCIONES";
       //MODIFICANDO EL COMPORTAMIENTO DEL BOTÓN CERRAR DE LA BARRA DE TÍTULO
       setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
       addWindowListener(new WindowAdapter(){
           @Override
           public void windowClosing(WindowEvent e){
               int opcion = JOptionPane.showConfirmDialog( JPantallaAuxiliar.this ,"¿Estas seguro/a que quieres salir?", "Confirmar salida",JOptionPane.YES_NO_OPTION);
               if(opcion == JOptionPane.YES_OPTION){
                   //REGISTRA LAS TRANSACCIONES  AL ARCHIVO "Transacciones.txt"
                   EscribirArchivoTransacciones archivoTransacciones = new EscribirArchivoTransacciones();
                   archivoTransacciones.EscribirArchivo(user.getTransacciones());
                   //ACTUALIZAR LOS DATOS DEL ARCHIVO "Usuario.db"
                   TransacribirArchivoUsuario archivoUsuario = new TransacribirArchivoUsuario();
                   archivoUsuario.EscribirArchivo(user);
                   System.exit(0);
               }
           }
       });
       setVisible(true);
       //FIN DE LA CONFIRMACIÓN
       
    }
    
    public JTable getJTabla(){
        return jtblTransacciones;
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

        fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jtxtNumero = new javax.swing.JTextField();
        jtxtSaldo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jbtnPagarPorTransaccion = new javax.swing.JButton();
        jbtnPagarPorNumero = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jcbxFiltro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblTransacciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Billetera Virtual Auxiliar");
        setBackground(new java.awt.Color(255, 255, 255));

        fondo.setBackground(new java.awt.Color(236, 239, 241));

        jPanel1.setBackground(new java.awt.Color(30, 30, 47));

        jLabel2.setBackground(new java.awt.Color(30, 30, 47));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Bienvenido,");

        jtxtNombre.setEditable(false);
        jtxtNombre.setBackground(new java.awt.Color(30, 30, 47));
        jtxtNombre.setFont(new java.awt.Font("Corbel Light", 1, 18)); // NOI18N
        jtxtNombre.setForeground(new java.awt.Color(240, 240, 240));
        jtxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtNombre.setText("Nombre");
        jtxtNombre.setBorder(null);
        jtxtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtxtNombre.setFocusable(false);
        jtxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNombreActionPerformed(evt);
            }
        });

        jtxtNumero.setEditable(false);
        jtxtNumero.setBackground(new java.awt.Color(30, 30, 47));
        jtxtNumero.setForeground(new java.awt.Color(255, 255, 255));
        jtxtNumero.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtxtNumero.setText("numero");
        jtxtNumero.setBorder(null);
        jtxtNumero.setFocusable(false);

        jtxtSaldo.setEditable(false);
        jtxtSaldo.setBackground(new java.awt.Color(30, 30, 47));
        jtxtSaldo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jtxtSaldo.setForeground(new java.awt.Color(255, 255, 255));
        jtxtSaldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtSaldo.setText("0.00");
        jtxtSaldo.setBorder(null);
        jtxtSaldo.setFocusable(false);

        jPanel2.setBackground(new java.awt.Color(45, 45, 65));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jbtnPagarPorTransaccion.setBackground(new java.awt.Color(63, 142, 252));
        jbtnPagarPorTransaccion.setForeground(new java.awt.Color(255, 255, 255));
        jbtnPagarPorTransaccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bank-icon.png"))); // NOI18N
        jbtnPagarPorTransaccion.setText("Transferencia");
        jbtnPagarPorTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPagarPorTransaccionActionPerformed(evt);
            }
        });

        jbtnPagarPorNumero.setBackground(new java.awt.Color(63, 142, 252));
        jbtnPagarPorNumero.setForeground(new java.awt.Color(255, 255, 255));
        jbtnPagarPorNumero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/phone-icon.png"))); // NOI18N
        jbtnPagarPorNumero.setText("Número");
        jbtnPagarPorNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPagarPorNumeroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pagar");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Por :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnPagarPorNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnPagarPorTransaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnPagarPorTransaccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnPagarPorNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22))
        );

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/phone-user-icon.png"))); // NOI18N
        jLabel4.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtNombre)
                            .addComponent(jtxtSaldo)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jtxtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(236, 239, 241));

        jcbxFiltro.setBackground(new java.awt.Color(63, 142, 252));
        jcbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Mas recientes al Más antiguo", "Mayor a menor transaccion", "Menor a Mayor Transaccion", "A-Z", "Z-A" }));
        jcbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxFiltroActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(33, 33, 33));
        jLabel5.setText("TRANSACCIONES");

        jtblTransacciones.setBackground(new java.awt.Color(255, 255, 255));
        jtblTransacciones.setForeground(new java.awt.Color(33, 33, 33));
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
        jtblTransacciones.setGridColor(new java.awt.Color(200, 200, 200));
        jtblTransacciones.setSelectionBackground(new java.awt.Color(204, 220, 255));
        jtblTransacciones.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jtblTransacciones);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPagarPorTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPagarPorTransaccionActionPerformed
        JPantallaPagarPorTranferencia PantallaPagarPorTransaccion = new JPantallaPagarPorTranferencia(this, ModeloTabla, contador);
        PantallaPagarPorTransaccion.setVisible(true);
    }//GEN-LAST:event_jbtnPagarPorTransaccionActionPerformed

    private void jbtnPagarPorNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPagarPorNumeroActionPerformed
        JPantallaPagarPorNumero PantallaPagarPorNumero = new JPantallaPagarPorNumero(this, ModeloTabla, contador);
        contador = PantallaPagarPorNumero.ActulizarContador();
        PantallaPagarPorNumero.setVisible(true);
    }//GEN-LAST:event_jbtnPagarPorNumeroActionPerformed

    private void jtxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNombreActionPerformed

    private void jcbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxFiltroActionPerformed
        /*ControladorFiltro filtro = new ControladorFiltro();
        switch(jcbxFiltro.getSelectedIndex()){
            case 0:
                
        }*/
    }//GEN-LAST:event_jcbxFiltroActionPerformed

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
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnPagarPorNumero;
    private javax.swing.JButton jbtnPagarPorTransaccion;
    private javax.swing.JComboBox<String> jcbxFiltro;
    private javax.swing.JTable jtblTransacciones;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtNumero;
    private javax.swing.JTextField jtxtSaldo;
    // End of variables declaration//GEN-END:variables
}
