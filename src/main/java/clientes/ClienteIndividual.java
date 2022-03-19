package clientes;

public class ClienteIndividual extends Cliente
{
    private String cpf;
    private String emailEmpresaVinculada;

    public ClienteIndividual(String email, String senha, String nome, String cpf, String emailEmpresaVinculada)
    {
        super(email, senha, nome);
        this.cpf = cpf;
        this.emailEmpresaVinculada = emailEmpresaVinculada;
    }

    public String toStringCsv()
    {
        return super.toStringCsv() + ";" + getCpf() + ";" + getEmailEmpresaVinculada();
    }

    @Override
    public String toString()
    {
        return super.toString() +
                " | Cpf: " + cpf +
                " | Id empresa vinculada: " + emailEmpresaVinculada;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmailEmpresaVinculada() {
        return emailEmpresaVinculada;
    }
}
