# GIT Commands

Note: Make sure you have Git account on platforms which hosts Git repos like GitHub or GitLab.

## Configure your git account in your local machine

- Download and install Git from 
    
        https://git-scm.com/download/win

- Or if on mac install using homebrew as:

        brew install git

- Configure Your Username and Email 
  - Git uses your username and email address to associate commits with your identity. Set these globally for all repositories

        git config --global user.name "Your Name"
        git config --global user.email "your.email@example.com"

- To verify that your configuration is set correctly, use the following command: 
  - This will display the current configuration, including your username and email.
          git config --list
  

- Set Up SSH Keys
  - Using SSH keys is a secure way to authenticate with Git servers like GitHub, GitLab, or Bitbucket.
  - Generate an SSH Key:
    - Open a terminal and enter the following command (replace “your_email@example.com” with your email address):
      
            ssh-keygen -t ed25519 -C "your_email@example.com" or
            ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
  
    - When prompted, press Enter to accept the default file location and name. You can also choose a passphrase for added security. 
    - Add Your SSH Key to the SSH Agent:
    - Start the SSH agent in the background:
        
            eval "$(ssh-agent -s)"
    
    - Add your SSH key to the SSH agent:
        
            ssh-add ~/.ssh/id_ed25519
            Replace id_ed25519 with id_rsa if you used the RSA algorithm.

# Local project to a new GitHub repository

## Initialize Git in Your Local Project Directory
    cd /path/to/your/local/project
    git init

## Add Your Project Files to the Git Repository
    git add .
    
## Commit Your Changes
    git commit -m "Initial commit"

## Create a New Repository on GitHub:
    - Go to GitHub and create a new repository.
    - Do not initialize the repository with a README, .gitignore, or License. You can add those later.

## Add the Remote URL to Your Local Git Repository
    git remote add origin https://github.com/your-username/your-repository-name.git

## Push Your Local Repository to GitHub
    git push -u origin master
  



