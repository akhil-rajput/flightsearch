node{  
  stage('SCM checkout'){
    
   git:'https://github.com/akhil-rajput/flightsearch' 
   
  }
  
 stage ('Compile Stage') {

bat'mvn clean compile'


 }
  stage{
bat'mvn test flightsearch'
}

}
