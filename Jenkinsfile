pipeline{
	agent any
	
    stages {
        stage('Build'){
             steps {
				echo "start building......"
                bat "git clone https://github.com/supernewbie1979/cg_example.git"
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