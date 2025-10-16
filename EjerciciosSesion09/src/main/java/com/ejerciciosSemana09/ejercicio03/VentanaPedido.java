/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ejerciciosSemana09.ejercicio03;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author snowden
 */
public class VentanaPedido extends javax.swing.JFrame {

    private final List<Producto> listaProductos = new ArrayList<>();
    private final List<Cliente> listaClientes = new ArrayList<>();
    private final List<Personal> listaPersonal = new ArrayList<>();
    private final List<Producto> listaProductosFiltrados = new ArrayList<>();

    private Pedido pedidoActual;

    public VentanaPedido() {
        initComponents();
        inicializarDatos();
        configurarEventos();
        setLocationRelativeTo(null);
    }

    private void inicializarDatos() {
        listaProductos.addAll(DatosEstaticos.PRODUCTOS);
        listaProductosFiltrados.addAll(listaProductos);

        listaClientes.addAll(DatosEstaticos.CLIENTES);
        listaPersonal.addAll(DatosEstaticos.PERSONAL);

        for (Cliente c : listaClientes) {
            cboSeleccionarCliente.addItem(c.toString());
        }

        for (Personal p : listaPersonal) {
            cboSeleccionarPesonal.addItem(p.toString());
        }

        DefaultTableModel model = (DefaultTableModel) tblProductosLista.getModel();
        for (Producto p : listaProductos) {
            model.addRow(new Object[]{
                p.getNombre(),
                p.getCategoria().getTipo(),
                p.getPrecio(),
                p.getEstado()
            });
        }

        pedidoActual = new Pedido();
        pedidoActual.setDetalles(new ArrayList<>());
        pedidoActual.setFecha(new Date());
    }

    private void configurarEventos() {
        btnSeleccionarProducto.addActionListener(e -> agregarProducto());
        btnConfirmar.addActionListener(e -> confirmarPedido());
        btnSalir.addActionListener(e -> dispose());

        txtBuscarProducto.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                filtrarProductos(txtBuscarProducto.getText());
            }
        });
    }

    private void filtrarProductos(String texto) {
        DefaultTableModel model = (DefaultTableModel) tblProductosLista.getModel();
        model.setRowCount(0);
        listaProductosFiltrados.clear();

        for (Producto p : listaProductos) {
            if (p.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                listaProductosFiltrados.add(p);
            }
        }

        if (texto.isEmpty()) {
            listaProductosFiltrados.addAll(listaProductos);
        }

        actualizarTablaProductos(listaProductosFiltrados);
    }

    private void actualizarTablaProductos(List<Producto> productos) {
        DefaultTableModel model = (DefaultTableModel) tblProductosLista.getModel();
        model.setRowCount(0);
        for (Producto p : productos) {
            model.addRow(new Object[]{
                p.getNombre(),
                p.getCategoria().getTipo(),
                p.getPrecio(),
                p.getEstado()
            });
        }
    }

    private void agregarProducto() {
        int fila = tblProductosLista.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un producto primero.");
            return;
        }

        Producto producto = listaProductosFiltrados.get(fila);
        String cantStr = JOptionPane.showInputDialog(this, "Cantidad:");
        try {
            int cantidad = Integer.parseInt(cantStr);
            pedidoActual.agregarProducto(producto, cantidad, producto.getPrecio());
            actualizarMostrarProductos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida.");
        }
    }

    private void actualizarMostrarProductos() {
        txtMostrarProductos.setText("");
        double total = 0;
        for (PedidoDetalle d : pedidoActual.getDetalles()) {
            txtMostrarProductos.append(d.getProducto().getNombre()
                    + " x" + d.getCantidad() + " = S/ " + d.calcularSubtotal() + "\n");
            total += d.calcularSubtotal();
        }
        lblTotal.setText("Total: S/ " + total);
    }

    private void confirmarPedido() {
        int clienteIdx = cboSeleccionarCliente.getSelectedIndex();
        int personalIdx = cboSeleccionarPesonal.getSelectedIndex();

        if (clienteIdx <= 0 || personalIdx <= 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona cliente y personal válidos.");
            return;
        }
        pedidoActual.setCliente(listaClientes.get(clienteIdx - 1));
        pedidoActual.setAtendidoPor(listaPersonal.get(personalIdx - 1));
        pedidoActual.setEstado(true);

        double total = pedidoActual.calcularTotal();
        JOptionPane.showMessageDialog(this, "Pedido confirmado. Total: S/ " + total);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboSeleccionarCliente = new javax.swing.JComboBox<>();
        cboSeleccionarPesonal = new javax.swing.JComboBox<>();
        txtBuscarProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMostrarProductos = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductosLista = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnSeleccionarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Pedido");
        setBackground(new java.awt.Color(51, 51, 51));

        cboSeleccionarCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Cliente" }));

        cboSeleccionarPesonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Personal" }));

        jLabel2.setText("Buscar producto");

        txtMostrarProductos.setColumns(20);
        txtMostrarProductos.setRows(5);
        jScrollPane1.setViewportView(txtMostrarProductos);

        tblProductosLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Categoría", "Precio", "Estado"
            }
        ));
        jScrollPane2.setViewportView(tblProductosLista);

        lblTotal.setText("Total: S/");

        btnConfirmar.setText("Confirmar Pedido");

        btnSalir.setText("Saliir");

        btnSeleccionarProducto.setText("Agregar a pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboSeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(cboSeleccionarPesonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfirmar)
                        .addGap(39, 39, 39)
                        .addComponent(btnSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboSeleccionarPesonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboSeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnConfirmar)
                        .addComponent(btnSalir)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSeleccionarProducto))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VentanaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionarProducto;
    private javax.swing.JComboBox<String> cboSeleccionarCliente;
    private javax.swing.JComboBox<String> cboSeleccionarPesonal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblProductosLista;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextArea txtMostrarProductos;
    // End of variables declaration//GEN-END:variables
}
