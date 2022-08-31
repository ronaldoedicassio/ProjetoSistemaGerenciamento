# ProjetoSistemaGerenciamento
 
 Projeto elaborado para estudos em grupo para colocar em prática a teoria de sala de aula
 
 Projeto
 
 Uma instituição de ensino contratou sua equipe para desenvolver uma aplicação para gerir o sistema de alocação de seus professores. Esta instituição possui diversos departamentos. Cada departamento faz parte de uma área: 
 - Humanas, 
 - Exatas ou
 - Biológicas.
 
O PO ( product owner ) afirma que gostaria de uma aplicação para gerenciar o cadastro de seus professores em departamentos e associa los as suas respectivas disciplinas

FUNCIONALIDADES
1. Realizar o cadastro dos departamentos pelo sistema administrativo
   Um departamento possui as seguintes informações:
   - Nome
   - Área
   - Sigla
   
   Um departamento possui as seguintes regras:
   - O nome do departamento não pode ser vazio e deve ter pelo menos dois caracteres
   - Não podem existir dois departamentos com o mesmo nome em uma mesma área
   - A sigla do departamento não pode ser igual a sigla de nenhum outro item que possua sigla, como outros cursos ou departamentos.

2. Realizar o cadastro do curso
   Um curso possui as seguintes informações
   - Nome
   - Departamento
   - Sigla

   Um curso possui as seguintes regras:
   - O nome do curso não pode ser vazio e deve ter pelo menos dois caracteres
   - Não podem existir dois cursos com o mesmo nome no mesmo departamento
   - A sigla do curso não pode ser igual a sigla de nenhum outro item que possua sigla, como outros cursos ou departamentos.

3. Realizar o cadastro do professor
   Um professor possui as seguintes informações:
   - Nome
   - CPF
   - Departamento

   Um professor possui as seguintes regras:
   - O nome do professor não pode ser vazio e deve ter pelo menos dois caracteres
   - O nome do professor não pode ser vazio e deve ter pelo menos dois caracteres.
   - Não podem existir dois professores com o mesmo CPF

4. Realizar o cadastro de um coordenador
   - Um coordenador é um professor
   - Um coordenador tem, além das informações que todo professor tem, as seguintes informações
   - Cursos coordenados

   Um coordenador tem, além das regras que todo professor tem, as seguintes regras:
   - Sempre deve se adicionar o texto “Coord. ” antes do nome de um coordenador.
   - Os cursos coordenados pelo coordenador devem ser do mesmo departamento ao qual ele faz parte.

5. Uma alocação possui as seguintes informações:
   - Professor
   - Curso
   - Dia da Semana
   - Horário

   Uma alocação possui as seguintes regras:
   - Não podem existir dois cadastros de alocação com mesmo professor e curso
   - Não podem existir dois cadastros de alocação com mesmo professor, dia da semana e horário
