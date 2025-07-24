pipeline {
    agent any

    environment {
        JAVA_HOME = tool 'JDK 17'
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"  // Uso de \\ y ; para Windows
        TEST_CLASS = "runners.crearsorteo.RunnerCrearSorteo"
    }

    triggers {
        githubPush()
    }

    options {
        skipDefaultCheckout(true)
        ansiColor('xterm')
        timestamps()
    }

    stages {
        stage('Clonar código') {
            steps {
                git url: 'https://github.com/lSebastianGomezl/Demojenkins.git', branch: 'main'
            }
        }

        stage('Ejecutar pruebas específicas') {
            steps {
                ansiColor('xterm') {
                    bat "gradlew.bat clean test --tests \"%TEST_CLASS%\""
                }
            }
        }

        stage('Publicar reportes Serenity') {
            steps {
                publishHTML([
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'Reporte Serenity',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: true
                ])
            }
        }
    }

    post {
        always {
            script {
                junit '**/target/site/serenity/*.xml'
                archiveArtifacts artifacts: '**/target/site/serenity/**/*.*', fingerprint: true
            }
        }

    post {
        always {
            emailext (
                subject: "Resultado del job: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """Hola equipo,

    El job ${env.JOB_NAME} ha finalizado con estado: ${currentBuild.currentResult}.
    Ver detalles en: ${env.BUILD_URL}target/site/serenity/index.html
    """,
                to: 'sebastian.gomez@dcsas.com.co',
                attachLog: true
            )
        }
    }


        failure {
            echo 'Fallaron las pruebas.'
        }
        success {
            echo 'Pruebas ejecutadas correctamente.'
        }
    }

}
