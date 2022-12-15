enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

data class Usuario(val nomeUsuario: String, val matriculaUsuario: String) {
    override fun toString(): String {
        return "$nomeUsuario (matrícula $matriculaUsuario)"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    override fun toString(): String {
        return "$nome (Duração: $duracao)"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }

    override fun toString(): String {
        //  return "Formação: $nome\nConteúdo educacional: $conteudos\nNível: $nivel\nAlunos
        // inscritos na formação: $inscritos"
        return """
        Formação: $nome
        Conteúdo educacional: $conteudos
        Duração do conteúdo: 
        Nível: $nivel
        Alunos inscritos na Formação: $inscritos
        """.trimIndent()
    }
}

fun generateMatricula(): String {
    return (1000..10000).random().toString()
}

fun main() {
    //  TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de
    // evoluí-las.")
    //  TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em
    // questão.")
    //
    //
    val emilly = Usuario("Emilly", generateMatricula())
    val paulo = Usuario("Paulo", generateMatricula())
    val juliano = Usuario("Juliano", generateMatricula())
    val maria = Usuario("Maria", generateMatricula())
    val ingrid = Usuario("Ingrid", generateMatricula())
    val joao = Usuario("João", generateMatricula())
    val pedro = Usuario("Pedro", generateMatricula())

    val conteudoEducacionalAngular = ConteudoEducacional("Angular Developer", 36)
    val conteudoEducacionalTypeScript =
        ConteudoEducacional("TypeScript Fullstack Developer", 44)
    val conteudoEducacionalReact = ConteudoEducacional("React Developer", 34)
    val conteudoEducacionalJava = ConteudoEducacional("Java", 150)
    val conteudoEducacionalKotlin = ConteudoEducacional("Kotlin", 120)
    val conteudoEducacionalSpring = ConteudoEducacional("Spring Framework", 100)
    val conteudoEducacionalFlutter = ConteudoEducacional("Flutter", 90)

    val formacaoJava =
        Formacao("Java Developer", listOf(conteudoEducacionalJava), Nivel.INTERMEDIARIO)
    val formacaoReact =
        Formacao("React Developer", listOf(conteudoEducacionalReact), Nivel.INTERMEDIARIO)
    val formacaoKotlin =
        Formacao("Kotlin Developer", listOf(conteudoEducacionalKotlin), Nivel.BASICO)
    val formacaoTypeScript =
        Formacao(
            "TypeScript Developer",
            listOf(conteudoEducacionalTypeScript),
            Nivel.INTERMEDIARIO
        )
    val formacaoSpring =
        Formacao(
            "Spring Framework Developer",
            listOf(conteudoEducacionalSpring),
            Nivel.INTERMEDIARIO
        )
    val formacaoWeb =
        Formacao(
            "Web Developer",
            listOf(
                conteudoEducacionalAngular,
                conteudoEducacionalTypeScript,
                conteudoEducacionalReact
            ),
            Nivel.AVANCADO
        )
    val formacaoFlutter =
        Formacao("Flutter Developer", listOf(conteudoEducacionalFlutter), Nivel.BASICO)

    formacaoJava.matricular(emilly)
    formacaoWeb.matricular(emilly, juliano, maria)
    formacaoKotlin.matricular(joao, pedro)
    formacaoReact.matricular(ingrid, paulo)
    formacaoTypeScript.matricular(juliano, paulo)
    formacaoFlutter.matricular(maria, pedro)

    println(formacaoJava)
    println("\n----------------------\n")
    println(formacaoWeb)
    println("\n----------------------\n")
    println(formacaoKotlin)
    println("\n----------------------\n")
    println(formacaoReact)
    println("\n----------------------\n")
    println(formacaoTypeScript)
    println("\n----------------------\n")
    println(formacaoFlutter)
    println("\n----------------------\n")
}