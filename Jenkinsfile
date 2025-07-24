pipeline {
    agent any

    environment {
        JAVA_HOME = tool name: 'JDK 17', type: 'jdk'
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

        stage('Set JAVA_HOME y PATH') {
            steps {
                script {
                    env.PATH = "${JAVA_HOME}\\bin;${env.PATH}"
                }
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
        failure {
            echo 'Fallaron las pruebas.'
        }
        success {
            echo 'Pruebas ejecutadas correctamente.'
        }
    }
}
