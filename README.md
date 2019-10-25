# Calculator with OOA/OOD/OOP and CICD and TDD

CS5800 Lab3


CICD folder contains Vagrantfile and Jenkinsfile for running a CICD pipeline

Setup for Jenkins-Vagrant box
1. from dir Calculator-CICD-TDD/CICD/ run command "$vagrant up"
2. navigate to "localhost:8080" from host computer once box is running
    - should see jenkins setup
3. "sudo cat /var/lib/jenkins/secrets/initialAdminPassword" in the vagrant box or get the password from the step 1 console output
When inside of jenkins
1. New item -> Name=Calculator, Pipeline
2. Under Pipeline: Select Pipeline script from SCM, Git, Repository URL = /home/Calculator-CICD-TDD, Script Path CICD/Jenkinsfile
3. Manage Jenkins > Manage Plugins > Available > search ocean > Install Ocean Blue
4. Open Ocean Blue 
5. Select Calculator

optional setup for github webhook
1. use ngrok.sh to create web url for vagrant box's localhost:8080
2. in the repository settings in github, add the ngrok url to a webhook
3. also set up credentials using a github password token in jenkins
