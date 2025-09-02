# C14-Projetos

### Gerenciamento de Dependências e Git

- Projeto feito em Java com foco no entendimento das ferramentas de gerenciamento de dependências com maven e versionamento utilizando git.
- Dependência utilizada: commons-io: 2.20.0
- Passos para configuração deste projeto:

1) Possuir uma IDE da linguagem Java para rodar programas em Java (Desenvolvimento);
2) Criar um projeto Maven (algumas IDEs como o IntelliJ já têm integração com o Maven e podem criar, mas se não houver será necessário instalar o Maven e inserir o caminho no PATH);
3) No arquivo 'pom.xml', adicione a dependência do commons-io presente no mavenRepositories dentro de 'dependencies';
4) Para execução da build (transformar o projeto em .jar), é necessário rodar 'mvn package'.

### Resolução de Conflitos de Merge

Simulação de conflito no arquivo `app.py`:
- Branch `roberta` mudou a linha para `"Oi Roberta"`.
- Branch `zeca` mudou a linha para `"Oi Zeca"`.

O conflito foi resolvido unindo as duas mensagens:
```Java
FileUtils.writeStringToFile(new File("mensagem.txt"), "Oi Roberta e Oi Zeca", StandardCharsets.UTF_8);

### Testes Unitários

- Para fazer os testes unitários, foi-se necessária a implementação de subdivisões do método geral da classe AddPdf em submétodos úteis para os testes criados;
- Os métodos foram desenvolvidos na classe addPDFTest e contam com 14 testes diferentes.

### Resolução de Conflitos de Merge

- O conflito foi resolvido ao unir todos os métodos e remover os conflitos de merge pelo pull request;
- Como as classes já existiam, não houveram problemas de merge neste sentido.
