package clientes;

import java.util.ArrayList;
import java.util.List;

public class ClienteEmpresarial extends Cliente
{
    private String cnpj;
    private String nomeFantasia;

    public ClienteEmpresarial(String email, String senha, String nome, String cnpj, String nomeFantasia)
    {
        super(email, senha, nome);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }


    @Override
    public String toString()
    {
        return super.toString() +
                " | Cnpj: " + cnpj +
                " | Nome fantasia: " + nomeFantasia;
    }

    @Override
    public String toStringCsv()
    {
        return super.toStringCsv() + ";" + cnpj + ";" + nomeFantasia;
    }





    public String getCnpj() {
        return cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

}
