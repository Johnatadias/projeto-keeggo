#language:pt

@validarCadastro
Funcionalidade: Validar cadastro

	Como um usuario do sistema
	Eu quero me cadastrar no site da loja
	Para que eu possa realizar compras

Contexto:
	  Dado que o usuario esteja no site
  	Quando clicar no icone user
  	E clicar em create new account

@testPositivo
  Cenario: Deve cadastrar um novo usuario com sucesso
 	  E preencher o campo username "johnatas"
  	E preencher o campo email "a@a.com"
  	E preencher o campo password "Oicara10"
  	E preencher o campo confirm password "Oicara10"
  	E preencher o campo firt name "johnata"
  	E preencher o campo last name "dias"
  	E preencher o campo phone number "1234-1234"
  	E selecionar o pais "Brazil" no campo country
  	E preencher o campo city "Sao paulo"
  	E preencher o campo address "Rua xy, 182"
  	E preencher o campo state "SP"
  	E preencher o campo postal code "02309-030"
  	E aceitar os termos de uso
  	E clicar no botao register
 		Entao usuario e cadastrado com sucesso
   	
@testNegativo
  Cenario: Nao deve cadastrar usuario existente
   	E preencher o campo username "johnatas"
  	E preencher o campo email "a@a.com"
  	E preencher o campo password "Oicara10"
  	E preencher o campo confirm password "Oicara10"
  	E preencher o campo firt name "johnata"
  	E preencher o campo last name "dias"
  	E preencher o campo phone number "1234-1234"
  	E selecionar o pais "Brazil" no campo country
  	E preencher o campo city "Sao paulo"
  	E preencher o campo address "Rua xy, 182"
  	E preencher o campo state "SP"
  	E preencher o campo postal code "02309-030"
  	E aceitar os termos de uso
  	E clicar no botao register
  	Entao usuario nao e cadastrado
  	