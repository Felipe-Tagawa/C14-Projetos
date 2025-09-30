# C14-Projetos

### Gerenciamento de Dependências e Git

- Projeto realizado por Felipe Tagawa Reis e Beatriz Vaz Pedroso

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
```
### Testes Unitários

- Para fazer os testes unitários, foi-se necessária a implementação de subdivisões do método geral da classe AddPdf em submétodos úteis para os testes criados;
- Os métodos foram desenvolvidos na classe addPDFTest e contam com 14 testes diferentes;
- Há a descrição dos testes criados nos comentários do pull request.

### Resolução de Conflitos de Merge

- O conflito foi resolvido ao unir todos os métodos e remover os conflitos de merge pelo pull request;
- Como as classes já existiam, não houveram problemas de merge neste sentido.

### Jobs

- Build feita a partir do Github Actions, em que o pipeline foi desenvolvido, foi preciso clonar o repositório, especificar a versão do java e de onde ele será distribuído(Temurin);
- Test: suíte de teste foi implementado para fazer parte do pipeline; artefato (relatório de teste(report)) é gerado pelo name 'Upload test report' com 'upload-artifact@v4' como 'uses';
- Notification: e-mail do criador do repositório recebe a notificação a partir da variável de ambiente do repositório Email_Destino.
