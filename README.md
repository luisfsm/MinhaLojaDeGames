# MinhaLojaDeGames
## Exercício Proposto pela Generarion

Atividade CRUD Back-end minhaLojaDeGames.

Construa um back-end para uma loja de games onde ele tenha a capacidade de
manipular os dados dos Produtos e usuários da loja.

## Parte 1 criação da tabela Categoria.

1. Camada de model com o nome de Categoria com os seus atributos.

2. Uma camada de repository com o nome CategoriaRepository (com a
capacidade de se comunicar com o banco de dados mysql).

3. Uma camada de Controller com o nome de CategoriaController Com 5
endpoints:
<ul>
  <li>findAllCategoria = um endPoint com a capacidade de trazer todas as categorias.</li>
  <li>findByIDCategoria = um endPoint com a função de trazer uma única categoria por id.</li>
  <li>findByDescricaoCategoria = um endPoint com a função de trazer uma categoria turma por Descricao.</li>
  <li>postCategoria = um endPoint com a função de gravar uma nova categoria no banco de dados.</li>
  <li> putCategoria = um endPoint com a função de atualizar dados de uma categoria.</li>
  <li>deleteCategoria = um endPoint com a função de apagar uma categoria dobanco de dados).</li>
</ul>

## Parte 2 relacionamento com a tabela Produto.

1. Camada de model com o nome de Produto com os seus atributos.
2. Crie um relacionamento de um para muitos/muitos para um, para essas models (uma categoria para muitos produtos e muitos produtos para umacategoria)
IMPORTANTE: Não esqueça de colocar as anotações corretamente para o relacionamento e inibir recursividade através da anotação @JsonIgnoreProperties.
4. Uma camada de repository com o nome ProdutoRepository (com a capacidade de se comunicar com o banco de dados mysql).
5. Uma camada de Controller com o nome de ProdutoController Com 5  endpoints:
<ul>
  <li>findAllProduto = um endPoint com a capacidade de trazer todos os Produtos .</li>
  <li>findByIDProduto = um endPoint com a função de trazer uma único Produto por id.</li>
  <li>findByDescricaoTitulo = um endPoint com a função de trazer um único Produto por Titulo.</li>
  <li>postProduto = um endPoint com a função de gravar um novo Produto no banco de dados.</li>
  <li> putProduto = um endPoint com a função de atualizar dados de um Produto .</li>
  <li>deleteProduto = um endPoint com a função de apagar um Produto do banco de dados).
</li>
</ul>
