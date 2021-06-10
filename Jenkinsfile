node{
  tools{
        maven 'maven3'
    }
  stage('SCM checkout'){
    git: 'https://github.com/akhil-rajput/flightsearch'
    
  }
  
  
  stage('compile and package'){
    git: 'https://github.com/akhil-rajput/flightsearch'
    bat: 'mvn package'
    
  }
  
  stage('test'){
  
      
      bat:'mvn test -f flightsearch'
    
  }
}
