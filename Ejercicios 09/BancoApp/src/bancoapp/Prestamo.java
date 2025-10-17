package bancoapp;

import java.time.LocalDate;

public class Prestamo {
    private int idPrestamo;
    private double importe;
    private LocalDate fecha;
    private Cliente cliente;

    public Prestamo(int idPrestamo, double importe, LocalDate fecha, Cliente cliente) {
        this.idPrestamo = idPrestamo;
        this.importe = importe;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public int getIdPrestamo() { return idPrestamo; }
    public double getImporte() { return importe; }
    public LocalDate getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }

    @Override
    public String toString() {
        return String.format("Préstamo %d | %.2f | %s | Cliente: %s %s",
                idPrestamo, importe, fecha.toString(),
                cliente.getNombres(), cliente.getApellidos());
    }
}
