#language:pt

@validarLogin
Funcionalidade: Validar login

	Como um usuario do sistema
	Eu quero logar no site da loja
	Para que eu possa realizar compras

Contexto:
	  Dado que o usuario esteja no site
  	Quando clicar no icone user

@testPositivo
  Cenario: Deve logar com sucesso
 	  E preencher o username "johnatas"
  	E preencher o password "Oicara10"
  	E clicar no botao entrar
 		Entao usuario e logado com sucesso
   	
@testNegativo
  Cenario: Nao deve logar usuario nao cadastrado
 	  E preencher o username "johnata"
  	E preencher o password "Oicara20"
  	E clicar no botao entrar
 		Entao usuario nao deve ser logado
  	