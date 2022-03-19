package clientes;

public abstract class Cliente
{
    protected String nome;
    protected String email;
    protected String senha;

    public Cliente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String toStringCsv()
    {
        return nome + ";" + email + ";" + senha;
    }

    public String toString()
    {
        return "Nome: " + nome +
                " | Email: " + email +
                " | Senha: " + senha;
    }




    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
