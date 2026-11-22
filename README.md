# 🎮 InfiniteSprint

**InfiniteSprint** é um jogo desenvolvido em Java utilizando o framework **libGDX**, como projeto de desenvolvimento de jogos da equipe Lepus Studio.

O projeto busca combinar elementos de jogos de corrida infinita (*Endless Runner*) com desafios e mecânicas interativas, proporcionando uma experiência dinâmica ao jogador.

## 📖 Sobre o jogo

InfiniteSprint é um jogo ambientado em um cenário escolar, no qual o jogador precisa avançar pelo ambiente, superar obstáculos e tomar decisões durante o percurso.

A proposta inclui elementos como:

- Seleção entre personagens disponíveis.
- Exploração de corredores e ambientes escolares.
- Rotas alternativas com desafios relacionados à matemática, física e informática.
- Desafios com limite de tempo.
- Aumento progressivo da velocidade, tornando a jogabilidade mais desafiadora conforme o jogador avança.

O jogo está em desenvolvimento e suas mecânicas poderão receber alterações e melhorias durante o processo de implementação.

## 🛠️ Tecnologias utilizadas

| Tecnologia | Função |
|---|---|
| Java | Linguagem principal de programação |
| libGDX | Framework utilizado para o desenvolvimento do jogo |
| LWJGL 3 | Backend responsável pela execução desktop |
| Gradle | Gerenciamento de dependências e construção do projeto |
| GDX-Liftoff | Ferramenta utilizada para gerar a estrutura inicial do projeto |
| Eclipse IDE | Ambiente de desenvolvimento utilizado pela equipe |
| Git e GitHub | Controle de versão e hospedagem do código |

### Versões e requisitos

- **GDX-Liftoff:** 1.14.2.3 (gerador do projeto).
- **libGDX:** 1.14.2 (versão padrão da geração do projeto; conferir configuração atual).
- **Gradle:** 9.8.0 (versão padrão do Wrapper dessa geração).
- **Java JDK:** 17 ou superior para executar o Gradle.
- **Java recomendado:** JDK 21.

> Observação: a versão efetivamente utilizada pelo projeto é determinada pelos arquivos de configuração do Gradle. Para conferir, consulte `gradle.properties`, `build.gradle` e `gradle/wrapper/gradle-wrapper.properties`.

## 📁 Estrutura do projeto

O projeto utiliza uma estrutura modular baseada em Gradle.

```text
InfiniteSprint/
│
├── assets/
│   └── Arquivos gráficos, sonoros e demais recursos do jogo
│
├── core/
│   └── src/
│       └── main/
│           └── java/
│               └── br/edu/ifce/infinitesprint/
│                   └── Main.java
│
├── lwjgl3/
│   └── src/
│       └── main/
│           └── java/
│               └── Launcher desktop
│
├── gradle/
│   └── wrapper/
│
├── build.gradle
├── settings.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
├── .gitignore
└── README.md
```

### Descrição dos módulos

- **core:** contém a lógica principal do jogo, suas classes, mecânicas e funcionalidades. É onde fica a maior parte do desenvolvimento.
- **lwjgl3:** contém a implementação responsável por iniciar e executar o jogo em computadores utilizando o backend LWJGL 3.
- **assets:** armazena os recursos utilizados pelo jogo, como imagens, texturas, fontes e arquivos de áudio.
- **gradle:** contém os arquivos do Gradle Wrapper, que permitem executar as tarefas de construção do projeto sem instalar manualmente uma versão específica do Gradle.

O módulo `core` é compartilhado com os diferentes backends, permitindo reutilizar a lógica principal do jogo em plataformas compatíveis.

## 💻 Como executar o projeto

### 1. Requisitos gerais

Antes de executar o projeto, é necessário instalar:

1. **Java JDK 17 ou superior.** Recomenda-se o JDK 21.
2. Um sistema operacional compatível com a plataforma desejada.
3. Conexão com a internet na primeira execução, para que o Gradle possa baixar as dependências necessárias.

O JDK pode ser obtido por meio do Eclipse Temurin:

https://adoptium.net/

Para verificar se o Java está instalado corretamente, abra o terminal e execute:

```bash
java -version
```

Para verificar o compilador:

```bash
javac -version
```

Ambos devem apresentar uma versão compatível com o ambiente do projeto.

**Não é necessário instalar o Gradle separadamente**, pois o projeto já possui o Gradle Wrapper (`gradlew` e `gradlew.bat`).

### 2. Baixando o projeto

Clone o repositório:

```bash
git clone https://github.com/SEU-USUARIO/InfiniteSprint.git
```

Entre na pasta:

```bash
cd InfiniteSprint
```

Substitua `SEU-USUARIO` pelo nome de usuário responsável pelo repositório no GitHub.

### 3. Executando no Windows

O Windows utiliza o arquivo `gradlew.bat`, presente na raiz do projeto.

Abra o Prompt de Comando ou PowerShell dentro da pasta do projeto e execute:

```bash
gradlew.bat lwjgl3:run
```

O Gradle irá verificar as dependências, compilar os módulos necessários e iniciar o jogo.

### 4. Executando no Linux

No Linux, o arquivo utilizado é `gradlew`.

Abra o terminal na raiz do projeto e execute:

```bash
chmod +x gradlew
```

Esse comando concede permissão de execução ao Gradle Wrapper.

Em seguida:

```bash
./gradlew lwjgl3:run
```

O Gradle realizará a compilação e iniciará o jogo.

### 5. Executando no macOS

O backend LWJGL 3 também permite executar a versão desktop no macOS.

Com o JDK instalado, abra o terminal na pasta do projeto e execute:

```bash
chmod +x gradlew
./gradlew lwjgl3:run
```

O suporte nativo depende da arquitetura do computador e das bibliotecas compatíveis disponibilizadas pelo LWJGL.

## 📱 Compatibilidade com iOS

O libGDX possui suporte ao desenvolvimento para iOS, mas essa plataforma exige uma configuração específica.

**Importante: a versão atual do InfiniteSprint possui os módulos `core` e `lwjgl3`, não incluindo ainda um módulo específico para iOS. Portanto, a execução nativa em iPhones e iPads não está configurada nesta versão do projeto.**

Para adicionar esse suporte futuramente, será necessário:

1. Adicionar um backend de iOS, como o RoboVM.
2. Configurar as dependências e o módulo específico para iOS.
3. Utilizar um computador com macOS.
4. Instalar o Xcode e suas ferramentas de desenvolvimento.
5. Configurar os certificados e perfis de assinatura necessários para executar ou distribuir o aplicativo em dispositivos iOS.

A compilação nativa para iOS depende do Xcode, que está disponível exclusivamente no macOS.

### Compatibilidade Java no iOS

O backend RoboVM possui restrições de compatibilidade diferentes da versão desktop. Ele limita os recursos da linguagem Java ao nível 8 e não disponibiliza APIs posteriores ao Java 7 nesse contexto.

Por isso, uma futura implementação para iOS deverá considerar essas limitações na escolha dos recursos utilizados no módulo compartilhado.

Documentação oficial: https://libgdx.com/wiki/

## 🖥️ Executando pelo Eclipse IDE

Também é possível abrir e executar o projeto pelo Eclipse.

1. Instale o Eclipse IDE com suporte a Java.
2. Certifique-se de que o JDK 17 ou superior está configurado.
3. Abra o Eclipse.
4. Selecione **File → Import**.
5. Escolha **Gradle → Existing Gradle Project**.
6. Selecione a pasta raiz do InfiniteSprint.
7. Finalize a importação e aguarde o Gradle baixar as dependências.

O Eclipse poderá apresentar os módulos `InfiniteSprint-core`, `InfiniteSprint-lwjgl3` e o projeto principal separadamente no workspace. Isso faz parte da organização da importação Gradle e não significa que sejam repositórios independentes.

Para executar pelo Eclipse, utilize a tarefa Gradle:

```text
lwjgl3 → Tasks → application → run
```

Essa é a forma recomendada de executar o jogo pelo ambiente de desenvolvimento.

## ⚙️ Dependências e gerenciamento

O projeto utiliza o Gradle para administrar automaticamente as bibliotecas necessárias.

Na primeira execução, o Gradle poderá baixar:

- Bibliotecas do libGDX.
- Dependências do LWJGL 3.
- Bibliotecas nativas específicas do sistema operacional.
- Outras dependências declaradas nos arquivos de configuração.

As versões das bibliotecas são definidas nos arquivos Gradle do projeto, evitando a necessidade de instalação manual de cada dependência.

## 🔗 Links úteis

- [Repositório oficial do libGDX](https://github.com/libgdx/libgdx)
- [Documentação oficial do libGDX](https://libgdx.com/wiki/)
- [GDX-Liftoff](https://github.com/libgdx/gdx-liftoff)
- [Gradle](https://gradle.org/)
- [Eclipse IDE](https://eclipseide.org/)
- [Java / Eclipse Temurin](https://adoptium.net/)

## 👥 Equipe

**Lepus Studio**

Projeto desenvolvido com o objetivo de aplicar conhecimentos de programação Java, orientação a objetos, desenvolvimento de jogos e trabalho colaborativo.

---

*InfiniteSprint — Em desenvolvimento.*
