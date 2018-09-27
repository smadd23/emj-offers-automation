pipeline {
  agent any
  environment {
	APP_NAME="emju-preview"
 	MACHINE_NAME = "emju-preview"   
        ToEmail = ""	
	emaillist = ""
        committerEmail=""
     }
  /*Branches enabled with CICD currently
    master, hotfix, release* 
  */
  stages {
  	  stage ("SCM Checkout") {
		when {
	       expression{
	          BRANCH_NAME == 'master' || BRANCH_NAME ==~ /release.*/ || BRANCH_NAME ==~ /hotfix.*/  || BRANCH_NAME ==~ /devops.*/  
	        }
	    }	
      steps{
        script{
          
          try {
				echo "=====>***********  Triggered from ${BRANCH_NAME} *************<========"
		  	        committerEmail = sh (script: 'git --no-pager show -s --format=\'%ae\'', returnStdout: true).trim()

				/*Clone the email list  - Create a corresponding branch in emju-devops-emaillist if CICD is applied to 
				  any new projects */
				 def REPO_NAME=scm.getUserRemoteConfigs()[0].getUrl().tokenize('/')[3].split("\\.")[0]
				dir('devops-emaillist') {
				
				git branch: "${REPO_NAME}", url: 'https://00a11edcd786aadcf0909529599ce090aaa55be3@github.com/J4U-Nimbus/emju-devops-emaillist.git'
				   
                }
            emaillist = readFile "${workspace}/devops-emaillist/email-list.txt"
            emaillist = emaillist.trim()
           }        
          catch(Exception err){
          currentBuild.result = 'FAILURE'
          throw err
          echo "******!!! Job skipped due to invalid branch ${BRANCH_NAME}******"
        }
      }
    }
  }	
      stage('feature-bugfix-SonarAnalysis') {
		when {
	       expression{
	          BRANCH_NAME ==~ /feature.*/ || BRANCH_NAME ==~ /bugfix.*/
			  }
	    }
      steps {
        script {
            try {
                def scannerHome = tool 'SONAR_SCANNER';
                
                withSonarQubeEnv('Sonar') {
					sh "mvn clean test"
                    //sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectVersion=1.0 -Dsonar.projectKey=${APP_NAME} -Dsonar.language=java -Dsonar.sources=. -Dsonar.dynamicAnalysis=reuseReports"
					sh "mvn sonar:sonar"
                }
            } catch (Exception err) {                
                currentBuild.result = 'FAILURE'
                emailext (mimeType: 'text/html',
				body: '''<html><table>
				<tr><th>Project Name:</th><td>$JOB_NAME</td></tr> 
				<tr><th>Build Number:</th><td>$BUILD_NUMBER</td></tr> 
				<tr><th>Build URL:</th><td><a href = "$BUILD_URL">JOB-Build-URL</a></td></tr> 
				<tr><th>Commit SHA:</th><td>${CHANGES, format="%r"}</td></tr> 
				<tr><th>Commit Name:</th><td>${CHANGES, format="%a"}</td></tr> 
				<tr><th>Commit Message:</th><td>${CHANGES, format="%m"}</td></tr>
				<tr><th>Jenkins Console Output:</th><td><div style="width: 750px; height: 250px; overflow-y: scroll;"><p>${BUILD_LOG, maxLines=1000, escapeHtml=false}</p></div></td></tr> 
				</table> </body> </html>''', 
				subject: 'FAILURE ${JOB_NAME} - ${BUILD_NUMBER} is Failed at SonarQube Analysis ',
				to: "${committerEmail}")
                throw err
            } 
        finally {sleep 10}			
  
        } 
      }
    }
    stage('feature-bugfix-SonarQube Quality Gatekeeper') {
		when {
	       expression{
	          BRANCH_NAME ==~ /feature.*/ || BRANCH_NAME ==~ /bugfix.*/
	        }
	    }
      steps {
        script {
         try {
            timeout(time:1,unit:'MINUTES'){
                def qualitygate = waitForQualityGate()
                if (qualitygate.status != "OK") {
                error "Pipeline aborted due to quality gate coverage failure: ${qualitygate.status}"
                }
            }
        } catch (Exception err) {
            currentBuild.result = 'FAILURE' 
				emailext (mimeType: 'text/html',
				body: '''<html><table>
				<tr><th>Project Name:</th><td>$JOB_NAME</td></tr> 
				<tr><th>Build Number:</th><td>$BUILD_NUMBER</td></tr> 
				<tr><th>Build URL:</th><td><a href = "$BUILD_URL">JOB-Build-URL</a></td></tr> 
				<tr><th>Commit SHA:</th><td>${CHANGES, format="%r"}</td></tr> 
				<tr><th>Commit Name:</th><td>${CHANGES, format="%a"}</td></tr> 
				<tr><th>Commit Message:</th><td>${CHANGES, format="%m"}</td></tr>
				<tr><th>Jenkins Console Output:</th><td><div style="width: 750px; height: 250px; overflow-y: scroll;"><p>${BUILD_LOG, maxLines=1000, escapeHtml=false}</p></div></td></tr> 
				</table> </body> </html>''', 
				subject: 'FAILURE ${JOB_NAME} - ${BUILD_NUMBER} is Failed at SonarQube Quality Gatekeeper',
				to: "${committerEmail}")		  
          throw err 
          }
       }
     }
    }

    stage('feature-bugfix-Build Project') {
		when {
	       expression{
	          BRANCH_NAME ==~ /feature.*/ || BRANCH_NAME ==~ /bugfix.*/
	        }
	    }	
       steps {
            script {			
             try {
		     
				def pom = readMavenPom file: 'pom.xml'				
				env.pomversion = pom.version					
			 	env.appname = "$APP_NAME"		
										
			    sh "mvn clean compile test"
            
								
              } catch(Exception err) {
			    currentBuild.result = 'FAILURE'
				emailext (mimeType: 'text/html',
				body: '''<html><table>
				<tr><th>Project Name:</th><td>$JOB_NAME</td></tr> 
				<tr><th>Build Number:</th><td>$BUILD_NUMBER</td></tr> 
				<tr><th>Build URL:</th><td><a href = "$BUILD_URL">JOB-Build-URL</a></td></tr> 
				<tr><th>Commit SHA:</th><td>${CHANGES, format="%r"}</td></tr> 
				<tr><th>Commit Name:</th><td>${CHANGES, format="%a"}</td></tr> 
				<tr><th>Commit Message:</th><td>${CHANGES, format="%m"}</td></tr>
				<tr><th>Jenkins Console Output:</th><td><div style="width: 750px; height: 250px; overflow-y: scroll;"><p>${BUILD_LOG, maxLines=1000, escapeHtml=false}</p></div></td></tr> 
				</table> </body> </html>''', 
				subject: 'FAILURE ${JOB_NAME} - ${BUILD_NUMBER} is Failed at Build Project & Artifactory Push ',
				to: "${committerEmail}")
                throw err
			  }
		 }
       }  
     } 
    stage('SonarQube Analysis') {
		when {
	       expression{
	          BRANCH_NAME == 'master' || BRANCH_NAME ==~ /release.*/ || BRANCH_NAME ==~ /hotfix.*/  || BRANCH_NAME ==~ /devops.*/ 
	        }
	    }
      steps {
        script {
            try {
                def scannerHome = tool 'SONAR_SCANNER';
                
                withSonarQubeEnv('Sonar') {
					sh "mvn clean test"
                    //sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectVersion=1.0 -Dsonar.projectKey=${APP_NAME} -Dsonar.language=java -Dsonar.sources=. -Dsonar.dynamicAnalysis=reuseReports"
					sh "mvn sonar:sonar"
                }
            } catch (Exception err) {                
                currentBuild.result = 'FAILURE'
                emailext (mimeType: 'text/html',
				body: '''<html><table>
				<tr><th>Project Name:</th><td>$JOB_NAME</td></tr> 
				<tr><th>Build Number:</th><td>$BUILD_NUMBER</td></tr> 
				<tr><th>Build URL:</th><td><a href = "$BUILD_URL">JOB-Build-URL</a></td></tr> 
				<tr><th>Commit SHA:</th><td>${CHANGES, format="%r"}</td></tr> 
				<tr><th>Commit Name:</th><td>${CHANGES, format="%a"}</td></tr> 
				<tr><th>Commit Message:</th><td>${CHANGES, format="%m"}</td></tr>
				<tr><th>Jenkins Console Output:</th><td><div style="width: 750px; height: 250px; overflow-y: scroll;"><p>${BUILD_LOG, maxLines=1000, escapeHtml=false}</p></div></td></tr> 
				</table> </body> </html>''', 
				subject: 'FAILURE ${JOB_NAME} - ${BUILD_NUMBER} is Failed at SonarQube Analysis ',
				to: "${committerEmail},${emaillist}")
                throw err
            } 
        finally {sleep 10}			
  
        } 
      }
    }
    stage('SonarQube Quality Gatekeeper') {
		when {
	       expression{
	          BRANCH_NAME == 'master' || BRANCH_NAME ==~ /release.*/ || BRANCH_NAME ==~ /hotfix.*/  || BRANCH_NAME ==~ /devops.*/ 
	        }
	    }
      steps {
        script {
         try {
            timeout(time:1,unit:'MINUTES'){
                def qualitygate = waitForQualityGate()
                if (qualitygate.status != "OK") {
                error "Pipeline aborted due to quality gate coverage failure: ${qualitygate.status}"
                }
            }
        } catch (Exception err) {
            currentBuild.result = 'FAILURE' 
				emailext (mimeType: 'text/html',
				body: '''<html><table>
				<tr><th>Project Name:</th><td>$JOB_NAME</td></tr> 
				<tr><th>Build Number:</th><td>$BUILD_NUMBER</td></tr> 
				<tr><th>Build URL:</th><td><a href = "$BUILD_URL">JOB-Build-URL</a></td></tr> 
				<tr><th>Commit SHA:</th><td>${CHANGES, format="%r"}</td></tr> 
				<tr><th>Commit Name:</th><td>${CHANGES, format="%a"}</td></tr> 
				<tr><th>Commit Message:</th><td>${CHANGES, format="%m"}</td></tr>
				<tr><th>Jenkins Console Output:</th><td><div style="width: 750px; height: 250px; overflow-y: scroll;"><p>${BUILD_LOG, maxLines=1000, escapeHtml=false}</p></div></td></tr> 
				</table> </body> </html>''', 
				subject: 'FAILURE ${JOB_NAME} - ${BUILD_NUMBER} is Failed at SonarQube Quality Gatekeeper',
				to: "${committerEmail},${emaillist}")		  
          throw err 
          }
       }
     }
    }

    stage('Build Project & Artifactory Push') {
		when {
	       expression{
	          BRANCH_NAME == 'master' || BRANCH_NAME ==~ /release.*/ || BRANCH_NAME ==~ /hotfix.*/  || BRANCH_NAME ==~ /devops.*/ 
	        }
	    }	
       steps {
            script {			
             try {
		     
				def pom = readMavenPom file: 'pom.xml'				
				env.pomversion = pom.version					
			 	env.appname = "$APP_NAME"		
						
				//Push to Artifactory
	            def server = Artifactory.server "http://albertsons-binrepo-dev.westus.cloudapp.azure.com/artifactory"
	            def rtMaven = Artifactory.newMavenBuild()
				rtMaven.tool = 'MAVEN_3.3.9'			// Tool name from Jenkins configuration
				rtMaven.opts = "-Denv=dev"
				if(BRANCH_NAME == 'master'){
				  rtMaven.deployer releaseRepo:'libs-release-local/development', server: server
				}
				else if (BRANCH_NAME ==~ /release.*/){
				  rtMaven.deployer releaseRepo:'libs-release-local/release', server: server
				}
				else if (BRANCH_NAME ==~ /hotfix.*/){
				  rtMaven.deployer releaseRepo:'libs-release-local/production', server: server
				}
				rtMaven.deployer.deployArtifacts = true
				
			
			    def buildInfo = rtMaven.run pom: 'pom.xml', goals: 'clean package install'
                
				server.publishBuildInfo buildInfo
				
				def dependprops1 = readJSON file:'target/classes/git.properties'
			    ToEmail = dependprops1["git.commit.user.email"]
								
              } catch(Exception err) {
			    currentBuild.result = 'FAILURE'
				emailext (mimeType: 'text/html',
				body: '''<html><table>
				<tr><th>Project Name:</th><td>$JOB_NAME</td></tr> 
				<tr><th>Build Number:</th><td>$BUILD_NUMBER</td></tr> 
				<tr><th>Build URL:</th><td><a href = "$BUILD_URL">JOB-Build-URL</a></td></tr> 
				<tr><th>Commit SHA:</th><td>${CHANGES, format="%r"}</td></tr> 
				<tr><th>Commit Name:</th><td>${CHANGES, format="%a"}</td></tr> 
				<tr><th>Commit Message:</th><td>${CHANGES, format="%m"}</td></tr>
				<tr><th>Jenkins Console Output:</th><td><div style="width: 750px; height: 250px; overflow-y: scroll;"><p>${BUILD_LOG, maxLines=1000, escapeHtml=false}</p></div></td></tr> 
				</table> </body> </html>''', 
				subject: 'FAILURE ${JOB_NAME} - ${BUILD_NUMBER} is Failed at Build Project & Artifactory Push ',
				to: "${committerEmail},${emaillist}")
                throw err
			  }
		 }
       }  
     } 
	 

    stage('Dev Deployment'){
		when {
	       expression{
	          BRANCH_NAME == 'master' || BRANCH_NAME == 'devops' 
	        }
	    }	
        steps{
            script{
                try{
                    def dependprops = readJSON file:'target/classes/git.properties'
			        def var1= dependprops["git.build.version"]
			        //env.xname = sh (script: "basename ${workspace}/target/*.jar .jar",returnStdout:true).trim()
                    pushToCloudFoundry cloudSpace: 'emju-preview', credentialsId: 'bdf636d8-ebc7-4f67-a436-1b6f3d32f710', manifestChoice: [appName: 'offers', appPath: '', buildpack: '', command: '', domain: '', hostname: 'offers', instances: '2', memory: '1024', noRoute: 'false', stack: '', timeout: '60', value: 'jenkinsConfig'], organization: 'karthik', selfSigned: 'true', target: 'https://api.system.sb.stratus.albertsons.com'
                }
                catch(Exception err) {
                currentBuild.result = 'FAILURE'
				emailext (mimeType: 'text/html',
				body: '''<html><table>
				<tr><th>Project Name:</th><td>$JOB_NAME</td></tr> 
				<tr><th>Build Number:</th><td>$BUILD_NUMBER</td></tr> 
				<tr><th>Build URL:</th><td><a href = "$BUILD_URL">JOB-Build-URL</a></td></tr> 
				<tr><th>Commit SHA:</th><td>${CHANGES, format="%r"}</td></tr> 
				<tr><th>Commit Name:</th><td>${CHANGES, format="%a"}</td></tr> 
				<tr><th>Commit Message:</th><td>${CHANGES, format="%m"}</td></tr>
				<tr><th>Jenkins Console Output:</th><td><div style="width: 750px; height: 250px; overflow-y: scroll;"><p>${BUILD_LOG, maxLines=1000, escapeHtml=false}</p></div></td></tr> 
				</table> </body> </html>''', 
				subject: 'FAILURE ${JOB_NAME} - ${BUILD_NUMBER} is Failed at Dev Deployment ',
				to: "${committerEmail},${emaillist}")
                throw err
                }
            }
        }        	
    }
    stage('QA Artifactory Promotion') {
		when {
	       expression{
	          BRANCH_NAME == 'master' || BRANCH_NAME == 'devops' 
	        }
	    }	
       steps {
            script {			
				try {
					def dependprops = readJSON file:'target/classes/git.properties'
					def var1= dependprops["git.build.version"]
					env.vars = "$var1"
					
					dir ('artifacts') {
								
					def devserver = Artifactory.server "http://albertsons-binrepo-dev.westus.cloudapp.azure.com/artifactory"
					def downloadSpec ='''{
                        "files":[
                        {
                         "pattern":"libs-release-local/development/com/safeway/emju-preview/${vars}/",
                         "target":"${workspace}/artifacts/",
						 "flat": "true",
                         "recursive":"false"
                        }
                        ]
                        }'''                                        
					def buildInfo1 = devserver.download spec: downloadSpec		
					
					
					
					def server = Artifactory.server "http://albertsons-binrepo-dev.westus.cloudapp.azure.com/artifactory"       
					def uploadSpec ='''{
                        "files":[
                        {
                         "pattern":"${workspace}/artifacts/",
                         "target":"libs-release-local/qualityassurance/com/safeway/emju-preview/${vars}/",
                         "recursive":"false"
                        }
                        ]
                        }'''                    
                    def buildInfo2 = server.upload spec: uploadSpec
					}
						
              } catch(Exception err) {
                currentBuild.result = 'FAILURE'
				emailext (mimeType: 'text/html',
				body: '''<html><table>
				<tr><th>Project Name:</th><td>$JOB_NAME</td></tr> 
				<tr><th>Build Number:</th><td>$BUILD_NUMBER</td></tr> 
				<tr><th>Build URL:</th><td><a href = "$BUILD_URL">JOB-Build-URL</a></td></tr> 
				<tr><th>Commit SHA:</th><td>${CHANGES, format="%r"}</td></tr> 
				<tr><th>Commit Name:</th><td>${CHANGES, format="%a"}</td></tr> 
				<tr><th>Commit Message:</th><td>${CHANGES, format="%m"}</td></tr>
				<tr><th>Jenkins Console Output:</th><td><div style="width: 750px; height: 250px; overflow-y: scroll;"><p>${BUILD_LOG, maxLines=1000, escapeHtml=false}</p></div></td></tr> 
				</table> </body> </html>''', 
				subject: 'FAILURE ${JOB_NAME} - ${BUILD_NUMBER} is Failed at QA Artifactory Promotion',
				to: "${committerEmail},${emaillist}")
                throw err
			  }
		 }
       }  
     } 									
				
  }

    post {
	        success{             // Publish report and delete workspace before we finish!	
	            junit 'target/surefire-reports/*.xml'
	            jacoco()
                deleteDir()
	            echo "completed"
            }
			failure{
			    echo "Failed"
			 	deleteDir()
			}
        }
}
