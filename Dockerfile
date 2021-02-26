FROM openjdk 
#será usada uma imagem chamada openjdk que contém o básico para rodar aplicaçẽos java

WORKDIR /app 
#define que o diretŕio base de tabalho será o /app

COPY target/appBase-0.0.1-SNAPSHOT.jar /app/meuapp.jar 
#copia o .jar gerado pelo Maven localmente para o container renomeando para meuapp.jar

ENTRYPOINT ["java", "-jar", "meuapp.jar"] 
#executa o nosso app por meio do executável .jar 