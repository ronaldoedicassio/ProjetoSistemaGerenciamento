# ProjetoSistemaGerenciamento
 
 Projeto elaborado para estudos em grupo para colocar em prática a teoria de sala de aula
 
 ##Projeto##
 Uma instituição de ensino contratou sua equipe para desenvolver uma aplicação para gerir o sistema de alocação de seus professores. Esta instituição possui diversos departamentos. Cada departamento faz parte de uma área: 
 - Humanas, 
 - Exatas ou
 - Biológicas.
 
O PO ( product owner ) afirma que gostaria de uma aplicação para gerenciar o cadastro de seus professores em departamentos e associa los as suas respectivas disciplinas

FUNCIONALIDADES
1. Realizar o cadastro dos departamentos pelo sistema administrativo
1.1. Um departamento possui as seguintes informações:
1.1.1. Nome
1.1.2. Área
1.1.3. Sigla
1.2. Um departamento possui as seguintes regras:
1.2.1. O nome do departamento não pode ser vazio e deve ter pelo menos dois caracteres
1.2.2. Não podem existir dois departamentos com o mesmo nome em uma mesma área
1.2.3. A sigla do departamento não pode ser igual a sigla de nenhum outro item que possua sigla, como outros cursos ou departamentos.

2. Realizar o cadastro do curso
2.1. Um curso possui as seguintes
2.1.1. Nome
2.1.2. Departamento
2.1.3. Sigla
2.2.
Um curso possui as seguintes regras:
2.2.1 O nome do curso não pode ser vazio e deve ter pelo menos dois caracteres
2.2.2. Não podem existir dois cursos com o mesmo nome no mesmo departamento
2.2.3. A sigla do curso não pode ser igual a sigla de nenhum outro item que possua sigla, como outros cursos ou departamentos.

3.Realizar o cadastro do professor
3.1. Um professor possui as seguintes informações:
3.1.1. Nome
3.1.2. CPF
3.1.3. Departamento

3.2. Um professor possui as seguintes regras:
3.2.1. O nome do professor não pode ser vazio e deve ter pelo menos dois caracteres
3.2.2. O nome do professor não pode ser vazio e deve ter pelo menos dois caracteres.
3.2.3. Não podem existir dois professores com o mesmo CPF

4.Realizar o cadastro de um coordenador
4.1. Um coordenador é um professor
4.2. Um coordenador tem, além das informações que todo professor tem, as seguintes informações
4.2.1. Cursos coordenados

4.3. Um coordenador tem, além das regras que todo professor tem, as seguintes regras:
4.3.1. Sempre deve se adicionar o texto “Coord. ” antes do nome de um coordenador.
4.3.2. Os cursos coordenados pelo coordenador devem ser do mesmo departamento ao qual ele faz parte.

5.1. Uma alocação possui as seguintes informações:
5.1.1. Professor
5.1.2. Curso
5.1.3 Dia da Semana
5.1.4. Horário

5.2. Uma alocação possui as seguintes regras:
5.2.1. Não podem existir dois cadastros de alocação com mesmo professor e curso
5.2.2. Não podem existir dois cadastros de alocação com mesmo professor, dia da semana e horário
