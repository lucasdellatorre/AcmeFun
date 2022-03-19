package acessos;

import clientes.Cliente;
import entretenimento.Entretenimento;

public class Acesso
{
    private String data;
    private String hora;
    private Cliente cliente;
    private Entretenimento entretenimento;

    public Acesso(String data, String hora, Cliente cliente, Entretenimento entretenimento) {
        this.data = data;
        this.hora = hora;
        this.cliente = cliente;
        this.entretenimento = entretenimento;
    }

    public Entretenimento getEntretenimento() {
        return entretenimento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }
}
