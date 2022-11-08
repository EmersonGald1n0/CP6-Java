Checkpoint 6 – Domain Driven Design

1.Crie em seu banco de dados Oraclea tabela filmes: (1ponto):
create table filmes (codigo varchar(5) primary key, titulo varchar(35), genero varchar(8), produtora varchar(15))

2.Crie um projeto em Java para acessar a tabela no banco de dados da questão anterior, siga orientações:(9pontos): 
Utilize JavaSE-1.8 e registre driver jdbcd a versão correspondente. Utilize desenvolvimento em camadas MVC em conjunto com o design patterns DAO.
Implemente uma Interface e Classes necessárias no pacote model. Implemente a Classe necessárias no pacote controller. Implemente a Classe da janela principal com barra de menu no pacote view, conforme imagem de referência:

![image](https://user-images.githubusercontent.com/101108016/200583466-8ac708ec-ce27-446e-bd5f-efec6dfaea17.png)
