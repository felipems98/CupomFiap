package br.com.fiap.Ocr.Controller;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.Ocr.Dto.ResponseDataDto;

@RestController
@RequestMapping("EnviarImagem")
public class ProcessController {
    //reading
    @PostMapping
    public ResponseDataDto ReceiveImagemToProcess(@RequestParam("imageFile")MultipartFile ImagFile){

        return null;

    }
    
    
    @GetMapping("{id}")
    public ResponseDataDto buscarPorId(@PathVariable int id) {
       List<ResponseDataDto> livroDTOList = new ArrayList<>();
       ResponseDataDto livroDTO = new ResponseDataDto();
       livroDTO.setId(1);
       livroDTO.setTitulo("Aprenda Spring");
       livroDTO.setDescricao("Passo a passo com Spring Framework");
       livroDTO.setDataDePublicacao(new Date(id));
       livroDTO.setIsbn("938472389472393482");
       livroDTO.setPreco(BigDecimal.valueOf(20.4));
       livroDTOList.add(livroDTO);
       ResponseDataDto livroDTO1 = new ResponseDataDto();
       livroDTO1.setId(2);
       livroDTO1.setTitulo("Java");
       livroDTO1.setDescricao("Tudo sobre Java");
       livroDTO1.setDataDePublicacao(new Date(id));
       livroDTO1.setIsbn("9548675464588");
       livroDTO1.setPreco(BigDecimal.valueOf(15.3));
       livroDTOList.add(livroDTO1);
       switch(id) {
           case 1:
               return livroDTO;
           case 2:
               return livroDTO1;
           default:
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
               "Livro não encontrado");
       }
    }

}
