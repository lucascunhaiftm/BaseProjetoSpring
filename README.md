# BaseProjetoSpring


Essa aplicação é a base de um projeto usando o Spring Boot Security, Spring Boot DevTools, Spring Data JPA e Spring Web.

### Instruções

* Em ```Run As -> Run Configurations -> Maven Build -> New Configuration``` faça:

  * Em Base directory selecione o diretório do projeto atual
  * Em Goals preencha com: ```clean package```
  * Selecione a opção "Skip Test" na caixa de seleção desta tela
  * Dê um nome para a configuração na parte superior da tela, por exemplo, ConfigMavenBuildApp
  * Basta clicar em "Apply" e depois em "Run"

Se tudo estiver certo, o Maven irá criar um executável jar na pasta "target".


* Em seguida, vamos executar o servidor local para comunicar com o nosso container posteriormente. Acesse ```Run As -> Run Configurations -> Java Application -> New Configuration``` faça:

  * Em Project deixe seu projeto atual
  * Em Main Class coloque: ```org.springframework.boot.devtools.RemoteSpringApplication```
  * Na aba arguments coloque ```http://localhost:[your-port]```. Exemplo:```http://localhost:8000```  
  * Dê um nome para a configuração na parte superior da tela,por exemplo, ConfigJavaAplicationApp. 
  * Basta clicar em "Apply" e depois em "Run"
  * Feito isso, estará rodando um servidor localmente que irá comunicar com o container realizando o "Live Reload", ou seja, refletindo as atualizaçãoes feitas no código localmente no container. 

* Abra o terminal e vamos criar a imagem e executá-la:

  * Gere a imagem com ```docker build -t [nome_da_imagem] .```. Exemplo: docker build -t minha_imagem .
    * O ponto serve para indicar onde está o Dockerfile, neste caso indicando que se encontra no presente diretório do terminal.
  * Execute o ambiente com: ```docker run -p [your-port]:8080 [name-for-your-image]```. Exemplo: docker run -p 8000:8080 minha_imagem
  * Vá em ```Run Configurations -> Java Application -> [Your-configuration-name]``` e clique em run
  * Tente modificar algo na sua aplicação que ative o live reload e veja no navegador ou console o resultado

### Notas

* No caso de fechar o container, a versão mais atualizada do .jar não estára na imagem do container. Pra atualizar, basta refazer o processo acima excluindo e recriando a imagem.

Preciso remover a anotação na classe AppBaseApplicaiton.ja

Com as novas classes agora podemos fazer uso do JPA. Mas nesse caso precisaremos ter um serviço de banco de dados, no nosso caso será Mysql. 
ALém de toda a configuração padrão que fizemos, agora vamos subir dois containers.

* Criaremos a imagem como de cosutme. Mas agora precisamos subir o container com mysql primeiro. 
* Para isso usaremos docker pull mysql:5.6 . COm isso teremos a imagem do mysql na máquina.
* Feito isso agora subiremos o container do docker com mysql:  docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=bancoapp -e MYSQL_USER=user -e MYSQL_PASSWORD=password -d mysql:5.6 
As configurações são asm mesmas do propreties
*Agora basta subir a aplicação mas precisaremos ligar o container da aplicação com o mysql, pois estamos em 2 containers diferentes
 docker run -p 8081:8080 --link mysql-container:mysql minhaimagem
 
 
