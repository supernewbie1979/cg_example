pipeline{
	agent any
	
    stages {
        stage('Build'){
             steps {
			    echo "${env.BRANCH_NAME}"
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