package mercadofacil.mercadofacil.Controller;

import jakarta.validation.Valid;
import mercadofacil.mercadofacil.Dto.ProdutoPostPutDto;
import mercadofacil.mercadofacil.Dto.ProdutoResponseDto;
import mercadofacil.mercadofacil.Service.ProdutoCrudPadraoService;
import mercadofacil.mercadofacil.Service.ProdutoCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoV1Controller {

    @Autowired
    ProdutoCrudService produtoCrudService;

    //ProdutoV1Controller(Service.ProdutoCrudPadraoService produtoCrudPadraoService) {
        //this.produtoCrudPadraoService = produtoCrudPadraoService;
    //}

    @PostMapping("")
    public ResponseEntity<ProdutoResponseDto> criarProduto(
            @RequestBody @Valid ProdutoPostPutDto produtoPostPutDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(produtoCrudService.criarProduto(produtoPostPutDto));
    }

    @GetMapping("")
    public ResponseEntity<List<ProdutoResponseDto>> buscarTodosProdutos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(produtoCrudService.buscarTodosProdutos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> atualizarProduto(
            @PathVariable Long id, @Valid @RequestBody ProdutoPostPutDto produtoPostPutDto){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(produtoCrudService.editarProduto(id, produtoPostPutDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProduto(
        @PathVariable Long id){
                produtoCrudService.removeProduto(id);
                return ResponseEntity.noContent().build();
        }


}
