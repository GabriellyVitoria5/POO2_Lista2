# Exercícios da Lista 2 - POO2

Questão 1) – Qual o padrão de projeto é mais adequado para ser usado no desenvolvimento deste sistema?
Como o sistema permite modificar dinamicamente o aspecto das palavras, o padrão Decorador pode ser uma boa opção para ser usada na implementação do sistema descrito. Isso se deve pelo fato de que um dos objetivos desse padrão é atribuir responsabilidade aos objetos em tempo de execução, além de utilizar a capacidade da herança de forma mais flexível, podendo herdar uma subclasse dinamicamente ou não dependendo da execução da aplicação.
O problema é semelhante com o exemplo dado em sala da pizza. Da mesma forma que a pizza pode receber diferentes sabores dependendo da escolha do cliente, o texto pode receber diferentes aspectos, sendo um texto normal, negrito, itálico ou uma combinação deles. 

Questão 2) Implemente as classes que permitem representar o texto completo, as palavras, respectivas modificações gráficas. Implemente uma aplicação que ilustre o comportamento, representando as características graficas.
O código dessa questão está disponível em: Lista2_Q2

Questão 3) Faça a implementação de um jogo com um poder básico e mais três poderes que melhoram este poder básico. 
O sistema pede a implementação de um padrão de projeto que consiga adicionar poderes ao ataque do personagem em tempo de execução, obtendo a flexibilidade de extensão da aplicação sem modificar o código. Por conta das palavras-chave tempo de execução, logo pensei no Decorator, que foi padrão utilizado para implementar o problema proposto.
Ao final, o código ficou da seguinte forma: um jogador possui um ataque básico com 10 de dano, mas é possível escolher um ou mais poderes para complementar o seu ataque: fogo, água e grama. Cada poder acrescenta, respectivamente, 7, 4 e 3 de dado ao ataque base. Então, antes de usar o ataque de fato, o jogador precisa criar a combinação de ataques desejada (ou escolher usar apenas o ataque base), selecionar o ataque desejado e então realizar o ataque com o método usePower().
O código está disponível em: Lista2_Q3 
