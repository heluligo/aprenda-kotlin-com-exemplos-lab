enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Aluno(val nome: String, val id: Long)

data class Cursos(val nome: String, val stack: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<Cursos>, val nivel: Nivel) {
    val inscritos = mutableListOf<Aluno>()
        infix fun matricular(aluno: Aluno) { inscritos.add(aluno) }

            fun matricular(vararg alunos: Aluno){
                for(aluno in alunos)
                    inscritos.add(aluno)
            }

            fun mostrarConteudos(){
                for(conteudo in conteudos)
                    println(conteudo.nome)
            }

            fun mostrarInscritos(){
                for(inscrito in inscritos)
                    println(inscrito.nome)
            }
        }

        fun main() {
        val helder = Aluno("Helder", 1L)
        val denise = Aluno("Denise", 2L)
        val marcelo = Aluno("João Marcelo", 3L)
        val rhoanny = Aluno("Rhoanny", 4L)


        val listaConteudos: List<Cursos> = listOf(
            Cursos("Crie um app mobile","Android nativo"),
            Cursos("Android com Kotlin - criando um app","Kotlin"),
            Cursos("Boas práticas para criação de telas","Android nativo"),
            Cursos("Kotlin - comunicação com Web API","Kotlin"))
        val androidMobile = Formacao("Android Mobile", listaConteudos, Nivel.BASICO)

        androidMobile?.let{
            androidMobile.matricular(denise, marcelo, rhoanny, helder)
        }
        
        println("Formação: ${androidMobile.nome}\n\t\tConteúdos:")        
        androidMobile.mostrarConteudos()
        println(" ")
        println("\t\tInscritos:")
        androidMobile.mostrarInscritos()
    }