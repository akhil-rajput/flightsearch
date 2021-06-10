node{  
  stage('SCM checkout'){
    
   git:'https://github.com/akhil-rajput/flightsearch' 
   
  }
  
 stage ('Compile Stage') {
steps {
withMaven(maven : 'apache-maven-3.6.1') {
bat'mvn clean compile'
}
}
 }

}
