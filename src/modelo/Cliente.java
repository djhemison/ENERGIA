/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author Djhemison
 */
public class Cliente {

    private int id;
    private String nome;
    private String sexo;
    private String endereco;
    private int cep;
    private String bairro;
    private int cpf;
    private String nascimento;
    private String vencimento;
    private String unidade;
    private String email;
    private int kwh;
    private int valortotal;
    private String site;

    public Cliente(String nome, String sexo, String endereco, int cep, String bairro, int cpf, String nascimento, String vencimento, String unidade, String email, int kwh, int valortotal, String site) {
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cep = cep;
        this.bairro = bairro;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.vencimento = vencimento;
        this.unidade = unidade;
        this.email = email;
        this.kwh = kwh;
        this.valortotal = valortotal;
        this.site = site;
    }

    @Override
    public String toString() {
        return "Energia{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", endereco=" + endereco + ", cep=" + cep + ", bairro=" + bairro + ", cpf=" + cpf + ", nascimento=" + nascimento + ", vencimento=" + vencimento + ", unidade=" + unidade + ", email=" + email + ", kwh=" + kwh + ", valortotal=" + valortotal + ", site=" + site + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.sexo);
        hash = 29 * hash + Objects.hashCode(this.endereco);
        hash = 29 * hash + this.cep;
        hash = 29 * hash + Objects.hashCode(this.bairro);
        hash = 29 * hash + this.cpf;
        hash = 29 * hash + Objects.hashCode(this.nascimento);
        hash = 29 * hash + Objects.hashCode(this.vencimento);
        hash = 29 * hash + Objects.hashCode(this.unidade);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + this.kwh;
        hash = 29 * hash + this.valortotal;
        hash = 29 * hash + Objects.hashCode(this.site);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cep != other.cep) {
            return false;
        }
        if (this.cpf != other.cpf) {
            return false;
        }
        if (this.kwh != other.kwh) {
            return false;
        }
        if (this.valortotal != other.valortotal) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.vencimento, other.vencimento)) {
            return false;
        }
        if (!Objects.equals(this.unidade, other.unidade)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.site, other.site);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getKwh() {
        return kwh;
    }

    public void setKwh(int kwh) {
        this.kwh = kwh;
    }

    public int getValortotal() {
        return valortotal;
    }

    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

}
