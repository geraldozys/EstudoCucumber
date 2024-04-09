#language: pt


Funcionalidade: Realizar login
  
  Como um usuário
  Gostaria de realizar o login
  Para que possa acessar a plataforma de compras
  
Contexto:
	Dado que desejo realizar o login

Esquema do Cenario: 
	Quando adiciono o login "<login>"
	Então o sistema deverá fazer o login com sucesso
	
Exemplos: 
      | login                   |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |
      | error_user              |
      | visual_user             |
