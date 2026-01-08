# Gerenciador de produtos eletronicos 

OBS: INICIA EM APP/ MAIN

1. OBJETIVO DO SISTEMA
O sistema tem como objetivo gerenciar produtos eletrônicos para o vendedor,
sem que ele precise ficar se conectando diretamente no site, assim permitindo
o cadastro, visualização, alteração e exclusão de registros,
utilizando interface gráfica em Java Swing e armazenamento permanente( arquivo dat).
Cada vendedor(Login) possui seus próprios produtos e histórico, que são
recuperados automaticamente após o login.


2.HERANÇA E POLIMORFISMO
O sistema utiliza herança através da classe abstrata Produto, da qual
derivam Sensor, Microcontrolador e Prototipagem. O polimorfismo é aplicado
ao manipular os produtos pela referência Produto.

3. TECNOLOGIAS UTILIZADAS
- Java SE
- Java Swing (interface gráfica)
- Java Collections (List, ArrayList)
- Serialização de objetos (ObjectInputStream e ObjectOutputStream)

4. ESTRUTURA DO PROJETO ( Package)

model: define as classe importantes para o funcionamento do programa
- Produto (classe abstrata):
  Define os atributos e métodos comuns aos produtos eletrônicos.
- Sensor, Microcontrolador e Prototipagem:
  Classes que herdam de Produto e implementam os seus comportamentos.
- Vendedor:
  Representa o usuário do sistema, contendo lista de produtos e histórico
  de operações. Implementa Serializable.
- tipoProduto:
  Usa as classes do tipo de produto para classficar os Produtos.
- Transacao:
  Responsavel por criar as informações usadas no historico.

persitence:
  garante que as informações fiquem no programa msm depois de fechar ele
- VendedorArquivo: Cria as listas e guarda as informações de acordo com o login.

repository:
- VendedorRepository:
  Responsável pelo login do vendedor, controle dos vendedores cadastrados
  e persistência dos dados no arquivo vendedores.dat.
- HistoricoRepository:
  Responsavel por criar a sessão do Historico e usa as informaçãos de transação.

view: Interface grafica
- DashboardView:
  Tela principal do sistema  e interface grafica e navegação entre as telas.
- FormProdutoView:
  Tela de cadastro( formulario) de produtos utilizando polimorfismo.
- VitrineView:
  Exibe os produtos em formato de cards, permitindo remoção de quantidade
  e exclusão automática quando a quantidade chega a zero.
- HistoricoView:
  Exibe o histórico de operações realizadas pelo vendedor.
- AreaVendedorView:
  Área com informações do vendedor e exportação de dados.

5. FUNCIONALIDADES

Cadastrar:
- Cadastro de produtos eletrônicos por tipo.
- Produto associado ao vendedor logado.

Visualizar:
- Produtos visíveis na vitrine.
- Histórico de operações sempre visível no menu lateral.

Alterar:
- Alteração da quantidade dos produtos.
- Registro automático no histórico.

Excluir:
- Produto removido automaticamente quando a quantidade atinge zero.

6. ARMAZENAMENTO PERMANENTE
Os dados são armazenados no arquivo vendedores.dat por meio de serialização.
Ao reiniciar o programa, os dados do vendedor são recuperados automaticamente
conforme o login informado.

7. FLUXO DE FUNCIONAMENTO
1. O sistema solicita o login do vendedor.
2. Verifica se o vendedor já existe.
3. Carrega produtos e histórico associados ao login.
4. Permite o gerenciamento dos produtos pela interface gráfica.
5. Salva automaticamente os dados após cada alteração.
