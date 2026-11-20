# Infinite Sprint

Jogo 2D em **pixel art** desenvolvido em **Java** com a biblioteca **LibGDX** (backend LWJGL3, plataforma Desktop).
Projeto acadêmico do IFCE.

Você explora salas de aula, responde a uma pergunta contra o relógio, foge do professor por um corredor e por uma floresta, coleta moedas e destrava o portão final com uma senha.

---

## Sumário

1. [Como o jogo funciona](#1-como-o-jogo-funciona)
2. [Controles](#2-controles)
3. [Ferramentas necessárias](#3-ferramentas-necessárias)
4. [Passo a passo para rodar (qualquer máquina)](#4-passo-a-passo-para-rodar-qualquer-máquina)
5. [Abrindo na IDE](#5-abrindo-na-ide)
6. [Gerar um .jar executável](#6-gerar-um-jar-executável)
7. [Estrutura do projeto](#7-estrutura-do-projeto)
8. [Como personalizar](#8-como-personalizar)
9. [Problemas comuns](#9-problemas-comuns)

---

## 1. Como o jogo funciona

1. **Menu principal:** só a opção **JOGAR**.
2. **Seleção de salas:** duas portas.
   - **Porta 1 — Sala de Física:** o jogador anda até a única cadeira livre, senta e responde a uma pergunta de 5 alternativas em 5 segundos. Acertando ou errando, o professor reage e a corrida começa.
   - **Porta 2 — Sala de Programação:** o jogador vai até o computador do professor, vê uma sequência de diálogos e a perseguição começa.
3. **Corredor da escola (20 s):** visão lateral, com obstáculos de pular e de agachar.
4. **Floresta (20 s):** cenário contínuo com parallax e obstáculos próprios.
5. **Portão final:** teclado numérico na tela, senha de 4 dígitos.
6. **Tela de vitória:** mostra o total de moedas coletadas.

As moedas formam trajetórias que indicam o caminho (fileiras, arcos e linhas rente ao chão) e acumulam entre as duas corridas.

---

## 2. Controles

| Contexto | Tecla | Ação |
|---|---|---|
| Menus e seleção de portas | `A` / `D` ou mouse | Escolher a porta |
| Menus | `ENTER` ou clique | Confirmar |
| Salas de aula (visão de cima) | `W` `A` `S` `D` | Andar |
| Salas de aula | `ENTER` | Sentar / usar o computador / avançar diálogo |
| Pergunta | `W` / `S` | Navegar entre as alternativas |
| Pergunta | `ENTER` | Confirmar a resposta |
| Corrida (visão lateral) | `D` (segurar) | Correr mais rápido |
| Corrida | `W` | Pular |
| Corrida | `S` | Agachar |
| Portão final | `W` `A` `S` `D` | Mover a seleção no teclado numérico |
| Portão final | `ENTER` | Selecionar o número (`<` apaga, `C` limpa) |
| Qualquer etapa jogável | `ESC` | Abrir/fechar a pausa |

---

## 3. Ferramentas necessárias

Você só precisa instalar **duas coisas**. O Gradle e o LibGDX **não precisam ser instalados**: o projeto traz o *Gradle Wrapper* (`gradlew`) e baixa as dependências sozinho.

| Ferramenta | Versão | Para quê | Onde baixar |
|---|---|---|---|
| **JDK** (Java Development Kit) | **17 ou mais novo** (21 recomendado) | Compilar e executar o jogo | [adoptium.net](https://adoptium.net) (Eclipse Temurin) |
| **Git** | qualquer versão recente | Baixar o projeto | [git-scm.com](https://git-scm.com/downloads) |

Também é preciso:

- **Internet na primeira execução**, para o Gradle baixar o LibGDX e suas dependências.
- **Placa de vídeo/driver com suporte a OpenGL 2.0 ou superior** (qualquer computador recente atende).
- Uma **IDE é opcional** (Eclipse, IntelliJ IDEA ou VS Code). Dá para rodar só pelo terminal.

### Instalando o JDK

**Windows**
1. Baixe o instalador `.msi` do Temurin 21 em [adoptium.net](https://adoptium.net).
2. Na instalação, marque as opções **"Set JAVA_HOME variable"** e **"Add to PATH"**.
3. Feche e abra o terminal de novo.

**macOS**
```
brew install --cask temurin@21
```

**Linux (Ubuntu/Debian)**
```
sudo apt update
sudo apt install openjdk-21-jdk
```

### Conferindo a instalação

Abra um terminal (PowerShell, Git Bash, Terminal) e rode:

```
java -version
git --version
```

O `java -version` deve mostrar a versão 17 ou superior. Se aparecer um erro de comando não encontrado, o JDK não está no `PATH` (veja a seção [Problemas comuns](#9-problemas-comuns)).

---

## 4. Passo a passo para rodar (qualquer máquina)

### Passo 1 — Baixar o projeto
```
git clone https://github.com/LepusStudio/03-Infinite-Sprint.git
cd 03-Infinite-Sprint
```

### Passo 2 — Executar o jogo

**Windows (PowerShell ou Prompt de Comando)**
```
.\gradlew.bat lwjgl3:run
```

**Windows (Git Bash), Linux e macOS**
```
./gradlew lwjgl3:run
```

Na primeira vez, o Gradle baixa o que precisa e pode levar alguns minutos. Quando terminar, a janela do jogo abre.

### Passo 3 (somente Linux e macOS) — Permissão do `gradlew`
Se aparecer `Permission denied`, rode uma vez:
```
chmod +x gradlew
```

### Observações por sistema
- **macOS:** o projeto já inclui o `StartupHelper`, que aplica a opção `-XstartOnFirstThread` automaticamente. Não é preciso configurar nada.
- **Linux:** se a janela não abrir por falta de bibliotecas gráficas, instale os drivers de vídeo da sua distribuição (Mesa/NVIDIA) e `libgl1`.
- **Windows:** se o antivírus ou o firewall bloquear o download das dependências, libere o acesso do Java à rede.

---

## 5. Abrindo na IDE

Importe sempre a **pasta raiz** (a que contém `build.gradle`, `settings.gradle` e `gradlew`), como **projeto Gradle**.

### Eclipse
1. Use o **Eclipse IDE for Java Developers** (já traz o Buildship, o plugin do Gradle).
2. `File > Import > Gradle > Existing Gradle Project`.
3. Selecione a pasta raiz do projeto e clique em `Finish`. Aguarde o Gradle terminar o download.
4. Abra a view `Window > Show View > Other... > Gradle > Gradle Tasks`.
5. Dê duplo clique em `lwjgl3 > application > run`.

Se preferir criar uma configuração própria: `Run > Run Configurations... > Gradle Task`, com **Gradle Tasks** = `lwjgl3:run` e **Working Directory** = a pasta raiz. O campo *Name* não aceita o caractere `:`, então use um nome como `Rodar Infinite Sprint`.

### IntelliJ IDEA
1. `File > Open` e selecione a pasta raiz (o arquivo `build.gradle`).
2. Aguarde a sincronização do Gradle.
3. Abra a janela **Gradle** e execute `lwjgl3 > Tasks > application > run`.

### VS Code
1. Instale o *Extension Pack for Java* e a extensão *Gradle for Java*.
2. Abra a pasta raiz e use o painel **Gradle** para executar `lwjgl3 > application > run`.

> Em qualquer IDE, confirme que o **projeto usa um JDK 17+** e que a codificação dos arquivos é **UTF-8**. O código tem acentos.

---

## 6. Gerar um .jar executável

```
./gradlew lwjgl3:jar
```

O arquivo é criado em `lwjgl3/build/libs/`. Para executar:

```
java -jar lwjgl3/build/libs/NOME-DO-ARQUIVO.jar
```

(Substitua `NOME-DO-ARQUIVO.jar` pelo nome gerado na pasta. No macOS, acrescente `-XstartOnFirstThread` ao comando.)

---

## 7. Estrutura do projeto

```
03-Infinite-Sprint/
├── build.gradle, settings.gradle, gradlew, gradlew.bat   # Gradle e wrapper
├── core/                                                 # TODO o código do jogo
│   └── src/main/java/br/edu/ifce/infinitesprint/
├── lwjgl3/                                               # Apenas o launcher Desktop
│   └── src/main/java/br/edu/ifce/infinitesprint/lwjgl3/
└── assets/                                               # Recursos (o jogo não depende de imagens)
```

### Classes principais (módulo `core`, pacote `br.edu.ifce.infinitesprint`)

| Área | Classes |
|---|---|
| Núcleo | `Main`, `BaseScreen`, `Gfx`, `Teclado`, `Cores` |
| Menus | `MenuPrincipalScreen`, `SelecaoSalaScreen`, `PauseMenu` |
| Salas | `SalaBaseScreen`, `SalaAulaScreen`, `SalaProgramacaoScreen`, `Jogador`, `Mobiliario` |
| Perguntas | `Pergunta`, `GerenciadorPerguntas`, `PerguntaPainel` |
| Diálogos | `RoteiroProgramacao`, `LinhaDialogo`, `DialogoBox` |
| Corridas | `CorridaBaseScreen`, `CorridaScreen`, `FlorestaScreen`, `Corredor`, `Obstaculo`, `Moeda`, `SistemaMoedas` |
| Cenários | `Cenario`, `CenarioCorredor`, `CenarioFloresta` |
| Final | `PortaoFinalScreen`, `VitoriaScreen` |
| Gráficos provisórios | `Sprites` |

Pontos de arquitetura:
- Cada tela é um `Screen` do LibGDX. A `BaseScreen` cuida de pausa, fade e viewport (`FitViewport` 640x360).
- As duas corridas compartilham a lógica em `CorridaBaseScreen`; cada uma só informa o cenário e a próxima tela.
- Ao abrir a pausa, o `atualizar()` da tela deixa de ser chamado, então temporizadores, obstáculos e moedas ficam congelados.

---

## 8. Como personalizar

- **Adicionar perguntas:** edite `carregarPadrao()` em `GerenciadorPerguntas` ou chame `adicionar(new Pergunta(...))`. Cada pergunta precisa de exatamente 5 alternativas.
- **Mudar a história da Sala de Programação:** edite só a classe `RoteiroProgramacao`.
- **Ajustar dificuldade:** velocidade, espaçamento de obstáculos e padrões de moedas ficam em `CorridaBaseScreen`; gravidade e altura do pulo ficam em `Corredor`.
- **Trocar os gráficos provisórios por sprites reais:** os personagens e cenários são desenhados por código (retângulos coloridos). Para usar spritesheets, substitua o corpo dos métodos de `Sprites`, `CenarioCorredor` e `CenarioFloresta`, mantendo as assinaturas.
- **Usar as moedas numa loja:** `SistemaMoedas` já tem o método `gastar(int)`.

---

## 9. Problemas comuns

| Sintoma | Causa provável | Solução |
|---|---|---|
| `java` ou `javac` não é reconhecido | JDK fora do `PATH` | Reinstale marcando "Add to PATH", ou configure `JAVA_HOME` e reabra o terminal |
| `Unsupported class file major version` ou erro de versão do Java | JDK antigo | Instale o JDK 17 ou superior e confira com `java -version` |
| `Permission denied` ao rodar `./gradlew` | Arquivo sem permissão de execução | `chmod +x gradlew` |
| Gradle não baixa dependências | Sem internet, proxy ou firewall | Verifique a conexão e libere o Java na rede |
| Janela abre e fecha na hora, ou erro de OpenGL | Driver de vídeo desatualizado | Atualize o driver da placa de vídeo |
| Acentos aparecendo errados no código | Codificação diferente de UTF-8 | Configure a IDE para UTF-8 |
| Classes não reconhecidas na IDE | Projeto não importado como Gradle | Importe a pasta raiz como projeto Gradle e atualize (`Refresh Gradle Project`) |
| Textos sem acento dentro do jogo | A fonte padrão não tem os glifos acentuados | Comportamento esperado: o jogo remove os acentos automaticamente |

---

## Créditos

Desenvolvido pela equipe **Lepus Studio** como projeto acadêmico do IFCE.
Construído com [LibGDX](https://libgdx.com/).
