pipeline{
	agent any
	
    stages {
        stage('Build'){
             steps {
				echo "start building......"
                bat "gradlew clean jacocoTestCoverageVerification"
             }
        }
		stage('Install') {
			steps {
				echo "start installing......"
			}
			
		}

    }

}