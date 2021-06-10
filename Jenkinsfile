node{
  
  stage('SCM checkout'){
    git: 'https://github.com/akhil-rajput/flightsearch'
    
  }
  

   stage("Maven Build"){
            steps{
                bat :'mvn clean package'
            }
        }
  
 
}
