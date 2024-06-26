# Conversor de Moedas

## Descrição
O **Conversor de Moedas** é uma aplicação simples em Java que permite aos usuários converter valores entre diferentes moedas utilizando a API de taxas de câmbio da ExchangeRate-API. O programa utiliza as bibliotecas HttpClient e Gson para fazer requisições HTTP e manipular dados JSON, respectivamente.

## Funcionalidades
- Conversão de valores entre moedas especificadas pelo usuário.
- Exibição de taxa de câmbio atualizada através da API ExchangeRate-API.

## Requisitos do Sistema
- Java Development Kit (JDK) 11 ou superior.
- Maven para construção e gerenciamento de dependências (opcional para build).

## Instalação e Execução

### Passo 1: Clonagem do Repositório
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### Passo 2: Compilação e Execução'

#### Compilação do Código-fonte:

Para compilar o código-fonte utilizando Maven, abra o terminal ou prompt de comando e execute o seguinte comando na raiz do projeto:
```bash
mvn clean install
```
Esse comando irá limpar o diretório de compilação (clean) e compilar o projeto (install). Certifique-se de que o Maven esteja instalado e configurado corretamente no seu sistema antes de executar este comando.

#### Execução do Programa:

Após compilar o projeto com sucesso, você pode executar o programa utilizando o seguinte comando:
```bash
java -cp target/classes org.example.Conversor
```
Este comando executa o programa Java especificando o caminho para o diretório de classes compiladas (target/classes) e a classe principal (org.example.Conversor).


## Instruções de Uso
Ao iniciar o programa, você verá um menu com opções numeradas:
```bash
**********************************************
Escolha uma opção:
1. Conversão de moeda
0. Sair
**********************************************
```
Para realizar uma conversão de moeda:

Selecione a opção 1.
Informe o valor a ser convertido.
Informe a moeda de origem (por exemplo, USD).
Informe a moeda de destino (por exemplo, EUR).
Após inserir os dados necessários, o programa calculará a conversão e exibirá o resultado no formato valor moeda_origem = valor_convertido moeda_destino.

Certifique-se de que seu ambiente de desenvolvimento tenha acesso à internet para realizar as consultas à API de taxas de câmbio durante a execução do programa.

## Exemplo de Uso
Conversão de 100 USD para EUR:
```bash
Informe o valor a ser convertido:
100
Informe a moeda de origem (por exemplo, USD):
USD
Informe a moeda de destino (por exemplo, EUR):
EUR
100.0 USD = 88.68 EUR
```
Saída esperada:
```bash
100.0 USD = 88.68 EUR
```
## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request com melhorias ou correções.
## Licença
Este projeto está licenciado sob a MIT License.
## Contato
Para mais informações, entre em contato via email: romario.luiz@gmail.com

