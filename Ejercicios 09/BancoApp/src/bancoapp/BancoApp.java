package bancoapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class BancoApp {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();
    private JFrame frame;
    private DefaultListModel<Cliente> modelClientes = new DefaultListModel<>();
    private DefaultListModel<Prestamo> modelPrestamos = new DefaultListModel<>();
    private JComboBox<Cliente> comboClientesParaPrestamo = new JComboBox<>();
    private int nextClienteId = 1;
    private int nextPrestamoId = 1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BancoApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame("Banco - Clientes y Préstamos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Clientes", createClientesPanel());
        tabs.addTab("Préstamos", createPrestamosPanel());

        frame.getContentPane().add(tabs);
        frame.setVisible(true);
    }

    private JPanel createClientesPanel() {
        JPanel p = new JPanel(new BorderLayout(10,10));
        p.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel form = new JPanel(new GridLayout(5,2,6,6));
        JTextField tfApellidos = new JTextField();
        JTextField tfNombres = new JTextField();
        JTextField tfDireccion = new JTextField();
        JTextField tfTelefono = new JTextField();

        form.add(new JLabel("Apellidos:")); form.add(tfApellidos);
        form.add(new JLabel("Nombres:")); form.add(tfNombres);
        form.add(new JLabel("Dirección:")); form.add(tfDireccion);
        form.add(new JLabel("Teléfono:")); form.add(tfTelefono);

        JButton btnAgregarCliente = new JButton("Agregar Cliente");
        form.add(new JLabel());
        form.add(btnAgregarCliente);

        JList<Cliente> listClientes = new JList<>(modelClientes);
        JScrollPane spClientes = new JScrollPane(listClientes);

        p.add(form, BorderLayout.NORTH);
        p.add(spClientes, BorderLayout.CENTER);

        btnAgregarCliente.addActionListener(e -> {
            String apellidos = tfApellidos.getText().trim();
            String nombres = tfNombres.getText().trim();
            if (apellidos.isEmpty() || nombres.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Apellidos y nombres son obligatorios.");
                return;
            }
            Cliente c = new Cliente(nextClienteId++, apellidos, nombres, tfDireccion.getText(), tfTelefono.getText());
            clientes.add(c);
            modelClientes.addElement(c);
            comboClientesParaPrestamo.addItem(c);
            tfApellidos.setText(""); tfNombres.setText(""); tfDireccion.setText(""); tfTelefono.setText("");
        });

        return p;
    }

    private JPanel createPrestamosPanel() {
        JPanel p = new JPanel(new BorderLayout(10,10));
        p.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel form = new JPanel(new GridLayout(4,2,6,6));
        JTextField tfImporte = new JTextField();
        JTextField tfFecha = new JTextField();

        form.add(new JLabel("Cliente:")); form.add(comboClientesParaPrestamo);
        form.add(new JLabel("Importe:")); form.add(tfImporte);
        form.add(new JLabel("Fecha (YYYY-MM-DD):")); form.add(tfFecha);

        JButton btnAgregarPrestamo = new JButton("Agregar Préstamo");
        form.add(new JLabel()); form.add(btnAgregarPrestamo);

        JList<Prestamo> listPrestamos = new JList<>(modelPrestamos);
        JScrollPane spPrestamos = new JScrollPane(listPrestamos);

        p.add(form, BorderLayout.NORTH);
        p.add(spPrestamos, BorderLayout.CENTER);

        btnAgregarPrestamo.addActionListener(e -> {
            Cliente cliente = (Cliente) comboClientesParaPrestamo.getSelectedItem();
            if (cliente == null) {
                JOptionPane.showMessageDialog(frame, "Primero agrega un cliente.");
                return;
            }
            try {
                double importe = Double.parseDouble(tfImporte.getText().trim());
                LocalDate fecha = LocalDate.parse(tfFecha.getText().trim());
                Prestamo pr = new Prestamo(nextPrestamoId++, importe, fecha, cliente);
                prestamos.add(pr);
                modelPrestamos.addElement(pr);
                tfImporte.setText(""); tfFecha.setText("");
            } catch (NumberFormatException | DateTimeParseException ex) {
                JOptionPane.showMessageDialog(frame, "Verifica el formato de importe y fecha.");
            }
        });

        return p;
    }
}
