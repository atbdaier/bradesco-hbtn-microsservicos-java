# bradesco-hbtn-microsservicos-java

Repositório de exemplos de Spring Boot usado nas aulas/exercícios.

## Estrutura importante

- `0x01/spring_boot_1/demo/` — aplicação Spring Boot de exemplo (código em `src/main/java/com/example/demo`).

## Pré-requisitos

- Java 17 (ou versão compatível com o projeto).
- Apache Maven (ou usar Maven Wrapper se disponível).

Certifique-se que `JAVA_HOME` aponta para a instalação do JDK e que `mvn` está no `PATH`.

## Como buildar (cmd.exe no Windows)

No prompt do Windows, execute a partir da raiz do projeto (onde este `README.md` está):

```cmd
cd /d D:\DEV\Repositorios\bradesco-hbtn-microsservicos-java\0x01\spring_boot_1
mvn -DskipTests package
```

O jar do módulo `demo` ficará em `demo\target\demo-0.0.1-SNAPSHOT.jar`.

Para executar diretamente:

```cmd
java -jar demo\target\demo-0.0.1-SNAPSHOT.jar
```

Ou use o plugin Spring Boot:

```cmd
mvn -f demo\pom.xml spring-boot:run
```

## Importar/usar o módulo `demo`

Opções comuns:

1. Multi-módulo (recomendado quando o código vive no mesmo repositório)
   - Crie um `pom.xml` pai no diretório `0x01/spring_boot_1` com `<packaging>pom</packaging>` e liste `<module>demo</module>`.
   - No `demo/pom.xml` configure o bloco `<parent>` apontando para o POM pai.
   - Build: `mvn -DskipTests package` no diretório do pai — todos os módulos serão construídos.

2. Dependência local (projeto separado)
   - No diretório do projeto que será importado, rode:

```cmd
cd /d caminho\para\projeto-importado
mvn clean install
```

   - Isso instala o artefato no repositório local (`~/.m2/repository`) e você pode referenciá-lo com `<dependency>` no `pom.xml` consumidor.

3. Importar no IDE
   - IntelliJ: File > Open... > selecione a pasta do projeto (ou `pom.xml`) e importe como Maven Project.
   - Eclipse: File > Import > Existing Maven Projects.

## Notas sobre este repositório (alterações recentes)

- Adicionei um `pom.xml` em `0x01/spring_boot_1/demo/pom.xml` para transformar o módulo `demo` em um projeto Maven.
- Corrigi uma verificação em `MessageResource.login(...)` (`password.isEmpty()` em vez de `user.isEmpty()` repetido).
- Adicionei `SecurityConfig` para permitir acesso aos endpoints durante desenvolvimento.

## Sugestões / próximos passos

- Adicionar Maven Wrapper (`mvnw`) para evitar dependência de instalação de Maven no ambiente do colaborador.
- Criar um `pom.xml` pai caso queira construir vários módulos juntos.
- Adicionar um `application.properties` com configurações (porta, profile, etc.) e testes unitários.

Se quiser, eu posso:
- Criar o `pom.xml` pai e atualizar `demo/pom.xml` automaticamente (multi-módulo); ou
- Gerar o Maven Wrapper aqui (precisa que `mvn` esteja disponível para executar o comando de bootstrap), ou
- Criar um `README.md` específico dentro de `0x01/spring_boot_1/demo` com instruções mais detalhadas.

