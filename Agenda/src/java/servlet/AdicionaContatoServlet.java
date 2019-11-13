package servlet;

import dao.ContatoDao;
import entity.Contato;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
    
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        log("Iniciando a servlet");
    }
    public void destroy(){
        super.destroy();
        log("Destruindo a servlet");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        
        // Pegando os parametros do request
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataTexto = request.getParameter("dataNascimento");
        Calendar dataNascimento = null;

        try {
            // Realizando a conversao da data
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch(ParseException e) {
            out.println("Erro de conversão de data");
            e.printStackTrace();
        }

        // Monta um objeto concreto
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);
        contato.setDataNascimento(dataNascimento);

        // Salva o contato
        ContatoDao dao = new ContatoDao();
        dao.adiciona(contato);

        // imprime o nome do contato que foi adicionado
        out.println("<html>");
        out.println("<body>");
        out.println("Contato " + contato.getNome() + " adicionado com sucesso!");
        out.println("</body>");
        out.println("</html>");
    }
}
