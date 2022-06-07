**SAE 2.01, TEAM COMCOMBRE**

Dans ce README, nous allons essayer de résumer rapidement tout ce que nous avons fait lors de cette SAE, afin de vous faciliter la compréhension du code
(Nous n'aurons peut-être pas le temps de tout expliquer ici)

## Interface :

Notre interface peut se découper en trois fenêtres (notez le mot "fenêtre, car une fenêtre séparée ouvre effectivement)

## DAO :
Le DAO est l'un des points forts de notre projet. Nous disposons de 3 DAO : JPA, JPA_MEMORY, et TEST
- JPA est le DAO utilisé officiellement par l'application lors de son exécution par un utilisateur
Les classes de ce DAO se trouvent dans le package `dao.jpa`
- JPA_MEMORY est un DAO très similaire à JPA (il se sert des mêmes classes), à l'exception qu'il utilise une autre PersistenceUnit (voir persistence.xml) afin de faire une base de données en mémoire, qui est utilisée lors du test backend (voir BackendTest.java)
Les classes de ce DAO sont les mêmes que le DAO JPA
- TEST est un DAO ne reposant sur aucune base de données, les méthodes DAO crééent et renvoient eux-mêmes les données. ce DAO est utilisé pour le test de l'interface utilisateur (afin de ne pas le coupler à une base de données)
Les classes de ce DAO se trouvent dans le package `dao.test`

## Tests :
Comme dit précédemment, les tests de l'application sont séparés en deux parties : Backend, et Application
- Les tests Backend servent à tester le DAO de manière isolée de l'application. Nous testons la structure du DAO, mais également les requêtes SQL faites.
- Les tests d'Application servent à tester l'application, certains sont isolés du DAO, et d'autres utilisent le DAO TEST afin d'être encore découplés de la base de données.