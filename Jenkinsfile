pipeline {
    agent any

    environment {
        JAVA_HOME = tool 'JDK 17'  // Usa exactamente el nombre que configuraste en Jenkins
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
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

        stage('Instalar dependencias') {
            steps {
                sh './gradlew dependencies'
            }
        }

        stage('Ejecutar pruebas') {
            steps {
                sh './gradlew clean test'
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
