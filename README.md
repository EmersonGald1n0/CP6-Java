Checkpoint 6 – Domain Driven Design

1.Crie em seu banco de dados Oraclea tabela filmesconforme mostrado abaixo:(1ponto):create table filmes (codigo varchar(5) primary key, titulo varchar(35), genero varchar(8), produtora varchar(15))

2.Crie um projeto em Java para acessar a tabela no banco de dados da questãoanterior, siga orientações:(9pontos):Utilize JavaSE-1.8e registre driver jdbcda versão correspondente.Utilize desenvolvimento em camadas MVCem conjunto com o design patternsDAO.Implemente uma Interfacee Classesnecessárias no pacote model.Implemente a Classenecessárias no pacote controller.Implemente a Classeda janela principalcom barra de menu no pacote view,conforme imagem de referência:

![image](https://user-images.githubusercontent.com/101108016/200583466-8ac708ec-ce27-446e-bd5f-efec6dfaea17.png)
