package dao;

import entity.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDao {
    private Connection connection;
    
    public ContatoDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Contato contato){
        try {

            // Query
            String sql = "insert into contatos(nome, email, endereco, dataNascimento) values(?, ?, ?, ?)";

            // Prepara a insercao
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            // Seta valores
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            java.sql.Date dataParaGravar = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
            stmt.setDate(4, dataParaGravar);

            // Executa
            stmt.execute();

            stmt.close();
            connection.close();
        } catch(SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<Contato> getLista(){
        String sql = "select * from contatos";
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<Contato> contatos = new ArrayList<Contato>();

            while(rs.next()){
                // Criando o objeto Contato
                Contato contato = new Contato();

                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setDataNascimento(Calendar.getInstance());

                // Adicionando o objeto a lista
                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            //connection.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{

        }
    }
}
