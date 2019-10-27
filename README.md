# Calculator with OOA/OOD/OOP and CICD and TDD

## CS5800 Lab3
In this Lab you will build a calculator program that can:
1. Add +
2. Subtract -
3. Multiply *
4. Divide /
5. Modulus(Remainder) %

### Steps:
1. Go through the steps of OOA to analyze the project
2. Go through the steps of OOD to design the project
3. Setup your CI/CD pipeline
4. Start OOP using TDD!

## CICD folder contains Vagrantfile and Jenkinsfile for running a CICD pipeline

Setup for Jenkins-Vagrant box
1. from dir run command "$vagrant up"
2. navigate to "localhost:8080" from host computer once box is running
    - should see jenkins setup
3. "sudo cat /var/lib/jenkins/secrets/initialAdminPassword" in the vagrant box or get the password from the step 1 console output
4. change permission of deliver.sh script: "$sudo chmod 777 /home/Calculator-CICD-TDD/jenkins/scripts/devliver.sh"
When inside of jenkins
1. New item -> Name=Calculator, Pipeline
2. Under Pipeline: Select Pipeline script from SCM, Git, Repository URL = /home/Calculator-CICD-TDD, Script Path CICD/Jenkinsfile
3. Manage Jenkins > Manage Plugins > Available > search ocean > Install Ocean Blue
4. Open Ocean Blue 
5. Select Calculator

Note: version 1.31 of a plugin called Durable-Task is broken at this time and causes script commands in pipelines to hang
https://issues.jenkins-ci.org/browse/JENKINS-59907?jql=text%20~%20durable-task%20ORDER%20BY%20created%20DESC

Note2: It is important to commit files with proper permissions
"git update-index --chmod=+x jenkins/scripts/deliver.sh"

optional setup for github webhook
1. use ngrok.sh to create web url for vagrant box's localhost:8080
2. in the repository settings in github, add the ngrok url to a webhook
3. also set up credentials using a github password token in jenkins
