node{  
  stage('SCM checkout'){
    
   git:'https://github.com/akhil-rajput/flightsearch' 
   
  }
stage ('Compile Stage') {
steps {
withMaven(maven-3: 'apache-maven-3.8.1') {
bat'mvn clean compile'
}
}
}
stage ('Testing Stage') {
steps {
withMaven(maven-3: 'apache-maven-3.8.1') {
bat'mvn test'
}
}
