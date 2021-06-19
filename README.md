# Microsservico Produto
## Agora será descrito como rodar esse projeto localmente

- [x] Faça o download de uma IDE de sua preferência exemplificaremos com a IDE Eclipse;
* Faça o download do Java superior a versão 8 do java;
```
  https://openjdk.java.net/
```
* Faça o download do Maven;
```
  https://maven.apache.org/
```
* Após ter o Java e o Maven instalados clone o projeto;
```
  git clone https://github.com/Mateus-GS/microservico-produto.git
```
* Agora atualize as dependências do  Maven dentro da IDE para ele baixar as dependências para você.
* Agora crie uma tabela na AWS no DynamoDB com o nome "produto" .
* Crie um arquivo "application.properties" as as seguintes informações
```
  amazon.aws.accesskey={Sua accesskey}
  amazon.aws.secretkey={Sua secretkey}
```
* Adicione VM arguments utilizando essa estrutura:
```
  -Dspring.config.location={caminho da usa pasta para o application.properties}
```
 * Procure no canto superior da IDE Eclipse por RUN.
 * Ao clicar selecione a opção RUN CONFIGURATION.
 * Ao entrar, procure por ARGUMENTS no canto superior direito.
 * E adicione no  VM arguments a estrutura:
 ```
   -ea -Dspring.config.location={caminho da usa pasta para o application.properties}
 ```
