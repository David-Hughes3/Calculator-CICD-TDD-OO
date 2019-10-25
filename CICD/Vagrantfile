# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure("2") do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.

  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://vagrantcloud.com/search.
  #config.vm.box = "ubuntu-18.04-desktop-gui"

  config.vm.define "jenkinsBox" do |jenkinsBox|
    jenkinsBox.vm.box = "bento/ubuntu-18.04"
    jenkinsBox.vm.provider "virtualbox" do |vb|
        vb.memory = "2048"
        vb.cpus = 2
    end
    jenkinsBox.vm.synced_folder "..", "/home/Calculator-CICD-TDD"
    jenkinsBox.vm.network "forwarded_port", guest: 8080, host: 8080
    jenkinsBox.vm.provision "shell", inline: <<-SHELL
        sudo apt-get update
        sudo apt-get -y install default-jre
        wget -q -O - https://pkg.jenkins.io/debian/jenkins-ci.org.key | sudo apt-key add -
        sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
        sudo apt-get update
        sudo apt -y install jenkins
        sudo systemctl start jenkins
        sudo apt-get install -y apache2
        sudo systemctl start apache2
        sudo apt-get install -y unzip
        sudo wget https://bin.equinox.io/c/4VmDzA7iaHb/ngrok-stable-linux-amd64.zip -P Downloads
        sudo unzip Downloads/ngrok-stable-linux-amd64.zip -d /usr/local/bin/ 
        sudo apt-get -y install jq
        sudo apt-get -y remove docker docker-engine docker.io
        sudo apt -y install docker.io
        sudo systemctl start docker
        sudo systemctl enable docker
        sudo cat /var/lib/jenkins/secrets/initialAdminPassword
        sudo usermod -aG docker jenkins
        sudo systemctl restart jenkins
   SHELL
   jenkinsBox.vm.provision "shell", run: 'always',  inline: <<-SHELL
        sudo systemctl start jenkins
        sudo systemctl start docker
  SHELL
  end
  
  
  
  # config.vm.define "agent" do |agent|
    # agent.vm.box = "bento/ubuntu-18.04"
    # agent.vm.provider "virtualbox" do |vb|
        # vb.memory = "512"
        # vb.cpus = 1
    # end
    # agent.vm.network "private_network", ip: "192.168.33.30"
    # agent.vm.provision "shell", inline: <<-SHELL
        # sudo apt-get update
        # sudo apt-get -y install default-jre
   # SHELL
  # end
  
  
  # Disable automatic box update checking. If you disable this, then
  # boxes will only be checked for updates when the user runs
  # `vagrant box outdated`. This is not recommended.
  # config.vm.box_check_update = false

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine. In the example below,
  # accessing "localhost:8080" will access port 80 on the guest machine.
  # NOTE: This will enable public access to the opened port
  # config.vm.network "forwarded_port", guest: 80, host: 8080

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine and only allow access
  # via 127.0.0.1 to disable public access
  # config.vm.network "forwarded_port", guest: 80, host: 8080, host_ip: "127.0.0.1"

  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
  # config.vm.network "private_network", ip: "192.168.33.10"

  # Create a public network, which generally matched to bridged network.
  # Bridged networks make the machine appear as another physical device on
  # your network.
  # config.vm.network "public_network"

  # Share an additional folder to the guest VM. The first argument is
  # the path on the host to the actual folder. The second argument is
  # the path on the guest to mount the folder. And the optional third
  # argument is a set of non-required options.
  # config.vm.synced_folder "../data", "/vagrant_data"

  # Provider-specific configuration so you can fine-tune various
  # backing providers for Vagrant. These expose provider-specific options.
  # Example for VirtualBox:
  #
  # config.vm.provider "virtualbox" do |vb|
  #   # Display the VirtualBox GUI when booting the machine
  #   vb.gui = true
  #
  #   # Customize the amount of memory on the VM:
  #   vb.memory = "1024"
  # end
  #
  # View the documentation for the provider you are using for more
  # information on available options.

  # Enable provisioning with a shell script. Additional provisioners such as
  # Puppet, Chef, Ansible, Salt, and Docker are also available. Please see the
  # documentation for more information about their specific syntax and use.
  # config.vm.provision "shell", inline: <<-SHELL
  #   sudo apt-get -y install gedit
  #   sudo apt -y install default-jre
   #  wget -q -O - https://pkg.jenkins.io/debian/jenkins.io.key | sudo apt-key add -
   #  sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
   #  sudo apt update
   #  sudo apt -y install jenkins
  ##   sudo systemctl start jenkins
  # SHELL
end
