package br.com.fiap.demo.Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.demo.Dto.LivroDto;

@RestController
@RequestMapping("livros")
public class LivrariaController {
    //reading
    @GetMapping
    public List<LivroDto> listarLivros() throws IOException {

        //String prg = "import sys";
          
        Process p = Runtime.getRuntime().exec("C:/Users/felip/Documents/Projeto Sprint/spring/demo/src/main/python/Demo.py");
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String ret = in.readLine();
        System.out.println("value is : "+ret);

        //String command = "python /c start python path\\to\\script\\script.py";
        //Process p = Runtime.getRuntime().exec("teste");

        LivroDto Livro = new LivroDto();
        Livro.setIsbn("13818641947654189714");
        Livro.setTitulo("Spring");
        Livro.setPreco(BigDecimal.valueOf(70.50));
        Livro.setAutor("Zezinho");
        List<LivroDto> ListaDeLivros = new ArrayList<>();
        ListaDeLivros.add(Livro);
        
        return ListaDeLivros;
    }


}
