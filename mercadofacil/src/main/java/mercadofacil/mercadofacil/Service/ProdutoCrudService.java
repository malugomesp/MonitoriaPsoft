package mercadofacil.mercadofacil.Service;

import mercadofacil.mercadofacil.Dto.ProdutoPostPutDto;
import mercadofacil.mercadofacil.Dto.ProdutoResponseDto;

import java.util.List;

public interface ProdutoCrudService {
    ProdutoResponseDto criarProduto(ProdutoPostPutDto produtoPostPutDto);
    ProdutoResponseDto editarProduto(Long id, ProdutoPostPutDto produtoPostPutDto);
    void removeProduto(Long id);
    List<ProdutoResponseDto> buscarTodosProdutos();
}
