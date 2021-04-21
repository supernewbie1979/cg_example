pipeline{
	agent any
	
    stages {
        stage('Build'){
             steps {
                bat "git clone https://github.com/supernewbie1979/cg_example.git"
                bat "gradlew assembleRelease"
             }
        }
        stage('install') {
            steps {
                bat "mvn install -"
            }
        }

    }

}