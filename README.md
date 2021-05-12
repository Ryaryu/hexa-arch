Este é um exemplo de projeto com arquitetura Hexagonal.
1. Projetos básicos:

    * O projeto "hexa-arch" possui as dependências básicas dos projetos.
    * O projeto "hexa-domain" possui todas as regras de negócio, além de criar a
interface port que vai ser usada pelos adapters.
    * O projeto "hexa-spring" possui as dependências básicas para startar esse projeto com um projeto spring.
    * O projeto "hexa-test" que é responsável por testar os módulos

2. Adapters:
    * Dentro de "hexa-spring", temos vários projetos
      * boostarter: Responsável por amarrar as pontas dos projetos na arquitetura spring-boot
      * db-local: Responsável por implementar a conexão com o banco H2
      * rabbit: Responsável por implementar a integração com RabbitMQ
      * scheduler: Responsável por implementar a integração com o @Scheduler do spring
      * ws: Responsável por implementar a integração com o Spring MVC
    
A estrutura de build se utiliza de **profiles** do Maven. Cada um dos adapters tem um
profile específico, e o projeto **hexa-spring-boostarter** adiciona a dependência correta
de acordo com o profile escolhido. Dessa forma, se quisermos construir esse projeto
usando apenas os adapters de **banco** e de **ws**, podemos executar o seguinte comando maven:

    mvn clean package -P web,local

Com essa experiência básica de criação desse projeto podemos dizer que de fato a regra de negócio fica separada do framework.
Mas temos **muitas** desvantagens. A mais óbvia é que perdemos grande parte das facilidades
que o framework dá, e se você precisar de fato utilizar essas facilidades você vai ter que
**duplicar código**. 

Por exemplo, pra evitar de ter que registrar os beans de negócio
manualmente numa classe `@Configuration`, como normalmente é feito em arquiteturas hexagonais,
eu tiver que criar uma anotação própria `@Domain` e fazer o spring reconhecer ela.
Porém nem sempre é possível fazer esse tipo de gambiarra, e no caso do `@Transactional`,
que é uma anotação de método, você acaba tendo que utilizar gambiarras feias pra ter
um código mais limpo. Por exemplo, pra poder utilizar transações, eu codifiquei de 2 maneiras:
uma usando ports e outra usando proxies. A metodologia usando ports admite que a
transação é parte da regra de negócio, então não tem problema criar um port. Porém,
se a sua aplicação se conectar a mais de um banco de dados, você vai ter que criar o
bean da sua classe manualmente para poder dizer de qual banco a transação vai ser criada.
Utilizando um proxy, eu faço uma classe que tem como propósito delegar as chamadas
pra classe real implementada no domínio, e nas chamadas que precisam de transação, 
o proxy adiciona um `@Transacion` antes de fazer a chamada. A desvantagem desse método
é que você vai "implementar" regra de negócio dentro do adapter (já que é o adapter que
entende a anotação `@Transaction`). Temos que ver qual seria a regra mais útil/correta.
Lembrando que esse é apenas um exemplo de problemática que podemos ter ao deixar a
regra de negócio agnóstica em relação ao framework.

Uma vantagem interessante no quesito de ProjectBuilder é que como está tudo separado agora,
não há necessidade de vários maven-archetypes como nós temos hoje; basta o archetype básico,
com o domain e test, e adicionarmos funções pra o maven criar os adapters dentro do projeto.
Por exemplo, pra criar um adapter de rabbit no projeto, poderíamos executar esse comando:

    mvn project-builder:rabbitmq

Na raiz do projeto e o mesmo criaria o adapter de rabbit, parecido com o que Quarkus já 
faz hj em dia.