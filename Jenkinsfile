pipeline { 

    environment { 

        registry = "nadia9888/docimage" 

        registryCredential = 'nadiaoumaya' 

        dockerImage = '' 

    }

    agent any 

    stages { 
        stage('email'){
			steps{
			mail bcc: '', body: 'build_success', cc: '', from: '', replyTo: '', subject: 'jenkins', to: 'nadia.oumaya@esprit.tn'
			}
		}
       

             stage( 'Checkout  GIT' ){
                       steps{
                          echo 'Pulling ... ';
                              git branch:  'master' ,
                              url :'https://github.com/nadiaoumaya98/nediaoumaya'
                    }
             }

            stage("Test,Build"){
               steps{

                   bat "mvn clean install"
                    }

                  }

              stage("package"){
               steps{

                   bat "mvn package"
                    }

                  }
                  
               stage("Sonar"){
               steps{

                   bat "mvn sonar:sonar"
                    }

                  }
                  
                stage("Nexus"){
               steps{

                   bat "mvn deploy"
                    }

                  }
           
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

      

        stage('Building our image') { 

            steps { 

                script { 

                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 

                }

            } 

        }

        stage('Deploy our image') { 

            steps { 

                script { 

                    docker.withRegistry( '', registryCredential ) { 

                        dockerImage.push() 

                    }

                } 

            }

        } 

        stage('Cleaning up') {
            steps {
                bat "docker rmi $registry:$BUILD_NUMBER"
                    }
                }
   
    }

}
