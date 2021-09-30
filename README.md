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
  <li>findAllCategoria = um endPoint com a capacidade de trazer todas as categorias.<\li>
  <li>findByIDCategoria = um endPoint com a função de trazer uma única categoria por id.</li>
  <li>findByDescricaoCategoria = um endPoint com a função de trazer uma categoria turma por Descricao.<\li>
  <li>postCategoria = um endPoint com a função de gravar uma nova categoria no banco de dados.<\li>
  <li> putCategoria = um endPoint com a função de atualizar dados de uma categoria.<\li>
  <li>deleteCategoria = um endPoint com a função de apagar uma categoria dobanco de dados).<\li>
</ul>

## Parte 2 relacionamento com a tabela Produto.

1. Camada de model com o nome de Produto com os seus atributos.
2. Crie um relacionamento de um para muitos/muitos para um, para essas models (uma categoria para muitos produtos e muitos produtos para umacategoria)
IMPORTANTE: Não esqueça de colocar as anotações corretamente para o relacionamento e inibir recursividade através da anotação @JsonIgnoreProperties.
4. Uma camada de repository com o nome ProdutoRepository (com a capacidade de se comunicar com o banco de dados mysql).
5. Uma camada de Controller com o nome de ProdutoController Com 5  endpoints:
<ul>
  <li>findAllProduto = um endPoint com a capacidade de trazer todos os Produtos .<\li>
  <li>findByIDProduto = um endPoint com a função de trazer uma único Produto por id.</li>
  <li>findByDescricaoTitulo = um endPoint com a função de trazer um único Produto por Titulo.</li>
  <li>postProduto = um endPoint com a função de gravar um novo Produto no banco de dados.</li>
  <li> putProduto = um endPoint com a função de atualizar dados de um Produto .</li>
  <li>deleteProduto = um endPoint com a função de apagar um Produto do banco de dados).
</li>
</ul>

## Resolução 
<ul>
  <li>Scrpt Sql caso queira ter um banco de dados populado . <a href="https://github.com/luisfsm/MinhaLojaDeGames/tree/master/Back-end/Scripts_sql"> Click aqui </a> </li>
  <li>Arquivo Json para o Postman com os request Methods da Api. <a href="https://github.com/luisfsm/MinhaLojaDeGames/tree/master/Back-end/postman_config"> Click aqui </a>  </li>
</ul>

## Parte 1 - Categoria

### End-point Padrão ("/categoria")


<ol>
  <li>End-point getAllCategoria : ("/") //Traz todos as categorias do banco de dados<\li>
  <li>End-point getByIdCategoria : ("/{id}") retorna a categoria cadastrada de acordo com o {id}<\li>
  <li>End-point getAllContainingCategoria : ("/listcategoria/{categoria}") //Filtra o retorno de acordo com o {categoria}<\li>
  <li>End-point getAllContaingPlataforma : ("/plataforma/{plataforma}") //Filtra o retorno de acordo com o  {plataforma}<\li>
  <li>End-point getAllContainingPlataforma : ("/distribuidora/{distribuidora}") //Filtra o retorno de acordo com o {distribuidora}<\li>
  <li>End-point postCategoria : ("/") //Irá inserir uma nova categoria no banco de dados, passando o Json pelo corpo da requisição.
      exemplo json : { "distribuidora": "KONAMI","plataforma":"'PS4-XBOX-SWITCH'","categoria":"EASPORTS"}<\li>
  <li> End-point putCategoria : ("/") //Irá atualizar uma categoria já existente passando um arquivo .json no corpo da requisição .
      exemplo Json : {"id": 2,"distribuidora": "KONAMI","plataforma":"'PS4-XBOX-SWITCH'","categoria":"EASPORTS"<\li>
   <li>End-point deleteCategoria : ("/{id}") //irá excluir a categoria do banco de dados pelo {id}<\li>
</ol>
     
## Parte 2 - Produtos
### End-point Padrão ("/produto")
     
<ol>
  <li>End-point getAllProdutos : ("/") //Traz todos os produtos cadastrados <\li>
  <li>End-point getProdutoById : ("/{id}") <\li>// Retorna o produto pelo {id}
  <li>End-point getAllProdutoContaining : ("/filter/{produto}") //Filtra o retorno de acordo com o {produto} <\li>
  <li>End-point postProduto : ("/") //Irá inserir uma novo produto no banco de dados, passando o Json pelo corpo da requisição. exemplo:  { "produto": "Horizon zero down", "preco": 250.0,"estoqueProduto": 0 }<\li>
  <li>End-point putProduto : ("/") //Irá atualizar uma categoria já existente passando um arquivo .json no corpo da requisição. exemplo:  { "id" : 1, "produto": "Horizon zero down", "preco": 250.0,"estoqueProduto": 0 } <\li>
  <li>End-point deleteProduto : ("/{id}") //irá excluir o produto do banco de dados pelo {id}<\li>
  <li>End-point getProdutosEstoquePositivo : ("/estoque/positivo") //Irá retornar os produtos com estoque > 0<\li>
  <li>End-point getProdutosEstoqueNegativo : ("/estoque/negativo") //Irá retornar os produtos com estoque <=0<\li>
<\ol>
