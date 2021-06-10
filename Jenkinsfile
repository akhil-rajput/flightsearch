node{  
  stage('SCM checkout'){
    
   git:'https://github.com/akhil-rajput/flightsearch' 
   
  }

stage ('Testing Stage') {
steps {
withMaven(maven: 'apache-maven-3.8.1') {
bat'mvn test'
}
}
}
